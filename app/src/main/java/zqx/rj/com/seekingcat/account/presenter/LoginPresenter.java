package zqx.rj.com.seekingcat.account.presenter;

import android.text.TextUtils;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.seekingcat.account.model.helper.AccountHelper;
import zqx.rj.com.seekingcat.account.model.bean.LoginRsp;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.LoginContract;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.account.presenter
 * 文件名：  LoginPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:11
 * 描述：    登录 Presenter
 */

public class LoginPresenter extends BasePresenter implements LoginContract.Presenter {

    @Override
    public void requestLogin(String phone, String password) {

        if (!checkAccountAndPwd(phone, password))
            return;

        if (!isViewAttach())
            return;

        AccountHelper.login(phone, password)
                .subscribe(new BaseObserver<LoginRsp>(getView()));
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
