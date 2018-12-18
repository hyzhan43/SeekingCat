package zqx.rj.com.seekingcat.account.presenter;

import android.text.TextUtils;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.LoginContract;
import zqx.rj.com.seekingcat.account.model.bean.LoginRsp;
import zqx.rj.com.seekingcat.account.model.helper.AccountHelper;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter{

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login(String phone, String password) {

        if (!checkAccountAndPwd(phone, password))
            return;

        if (isViewAttach()){
            getView().showLoading();
            AccountHelper.login(phone, password, new Callback<LoginRsp>() {
                @Override
                public void onSuccess(LoginRsp loginRsp) {
                    getView().loginSuccess(loginRsp.getToken());
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }

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
