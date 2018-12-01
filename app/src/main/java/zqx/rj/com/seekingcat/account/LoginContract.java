package zqx.rj.com.seekingcat.account;

import zqx.rj.com.base.mvp.BaseContract;

public interface LoginContract {

    interface Presenter extends BaseContract.Presenter {

        void requestLogin(String phone, String password);

        boolean checkAccountAndPwd(String phone, String password);
    }

    interface View extends BaseContract.View {
        void loginSuccess(String token);
    }
}
