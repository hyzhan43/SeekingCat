package zqx.rj.com.seekingcat.account.presenter.impl;

import android.text.TextUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zqx.rj.com.data.helper.AccountHelper;
import zqx.rj.com.model.entity.account.User;
import zqx.rj.com.net.error.ErrorException;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.presenter.ILoginPresenter;
import zqx.rj.com.seekingcat.account.view.ILoginView;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.account.presenter
 * 文件名：  LoginPresenterImpl
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:11
 * 描述：    登录 Presenter
 */

public class LoginPresenterImpl extends ILoginPresenter {

    public LoginPresenterImpl() {
    }


    @Override
    public void requestLogin(String phone, String password) {

        if (!isViewAttach()) {
            return;
        }

        final ILoginView mLoginView = (ILoginView) getView();
        mLoginView.showLoading();
        AccountHelper.login(phone, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<User>() {
                    @Override
                    public void onNext(User user) {
                        mLoginView.loginSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ErrorException) {
                            mLoginView.loginFail(e.getMessage());
                        } else {
                            mLoginView.showError(R.string.network_fail);
                        }
                    }
                });
    }

    @Override
    public boolean checkAccountAndPwd(String phone, String password) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            getView().showError(R.string.login_tip);
            return false;
        }
        return true;
    }
}
