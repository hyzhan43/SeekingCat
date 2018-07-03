package zqx.rj.com.seekingcat.cat.account.presenter.impl;

import java.lang.ref.WeakReference;

import zqx.rj.com.seekingcat.base.mvp.BaseView;
import zqx.rj.com.seekingcat.cat.account.model.ILoginModel;
import zqx.rj.com.seekingcat.cat.account.model.impl.LoginModelImpl;
import zqx.rj.com.seekingcat.cat.account.model.response.LoginResponse;
import zqx.rj.com.seekingcat.cat.account.presenter.ILoginPresenter;
import zqx.rj.com.seekingcat.cat.account.view.ILoginView;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.presenter
 * 文件名：  LoginPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:11
 * 描述：    TODO
 */

public class LoginPresenter<T> extends ILoginPresenter {

    private ILoginView mLoginView;
    private WeakReference<BaseView> mViewRef;
    private ILoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModelImpl(this);
    }

    @Override
    public void requestLogin(String phone, String password) {

        mLoginView.showLoading();
        mLoginModel.login(phone, password);
    }

    public void onLoginResponse(LoginResponse response) {

        switch (response.getCode()) {
            case ILoginModel.LOGIN_SUC:
                mLoginView.loginSuccess(response.getCode(), response.getData());
                break;

            case ILoginModel.LOGIN_FAIL:
                mLoginView.loginFail(response.getMessage());
                break;
        }

        mLoginView.hideLoading();
    }


    @Override
    public void attachView(BaseView view) {
//        this.mLoginView = (ILoginView) view;
        mViewRef = new WeakReference<>(view);
        this.mLoginView = (ILoginView) mViewRef.get();
    }

    @Override
    public void detachView() {
        if (mLoginView != null) {
            mLoginView = null;
        }

        if (mViewRef != null){
            mViewRef.clear();
        }
    }
}
