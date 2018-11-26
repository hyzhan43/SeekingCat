package zqx.rj.com.seekingcat.account.view.impl;

import android.support.design.widget.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.impl.MvpActivity;
import zqx.rj.com.model.entity.account.User;
import zqx.rj.com.seekingcat.MainActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.presenter.impl.LoginPresenterImpl;
import zqx.rj.com.seekingcat.account.view.ILoginView;

public class LoginActivity extends MvpActivity<LoginPresenterImpl> implements ILoginView {

    @BindView(R.id.account_phone)
    TextInputEditText mPhone;

    @BindView(R.id.account_password)
    TextInputEditText mPassword;


    @OnClick(R.id.account_btn_login)
    void onLoginClick() {

        String account = mPhone.getText().toString();
        String password = mPassword.getText().toString();

        if (mPresenter.checkAccountAndPwd(account, password)) {
            mPresenter.requestLogin(account, password);
        }
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showError(int str) {

    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenterImpl bindPresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void loginSuccess(User user) {

        hideLoading();

        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void loginFail(String msg) {
        hideLoading();
    }
}
