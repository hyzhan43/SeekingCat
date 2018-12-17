package zqx.rj.com.seekingcat.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.seekingcat.MainActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.LoginContract;
import zqx.rj.com.seekingcat.account.presenter.LoginPresenter;
import zqx.rj.com.utils.Preferences;

public class LoginActivity extends MvpActivity<LoginContract.Presenter>
        implements LoginContract.View {

    @BindView(R.id.tie_account)
    TextInputEditText mTieAccount;

    @BindView(R.id.tie_password)
    TextInputEditText mTiePassword;

    @Override
    protected LoginContract.Presenter bindPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected void initView() {
        super.initView();

        // 获取 register 成功 传递过来的
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("bundle");
            if (bundle != null) {
                String account = bundle.getString("account");
                String password = bundle.getString("password");

                mTieAccount.setText(account);
                mTiePassword.setText(password);
            }
        }
    }

    /**
     * 登录
     */
    @OnClick(R.id.btn_login)
    void onLoginClick() {

        String account = mTieAccount.getText().toString();
        String password = mTiePassword.getText().toString();

        mPresenter.login(account, password);
    }

    /**
     * 注册
     */
    @OnClick(R.id.tv_register)
    void onRegisterClick() {
        startActivity(RegisterActivity.class);
        finish();
    }

    @Override
    public void loginSuccess(String token) {
        // 存储 token
        Preferences.putString(Constants.TOKEN, token);
        // 标记已经登录
        Preferences.putBoolean(Constants.IS_LOGIN, true);

        startActivity(MainActivity.class);
        finish();
    }

}
