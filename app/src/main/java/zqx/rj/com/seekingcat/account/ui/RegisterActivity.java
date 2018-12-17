package zqx.rj.com.seekingcat.account.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.RegisterContract;
import zqx.rj.com.seekingcat.account.presenter.RegisterPresenter;

public class RegisterActivity extends MvpActivity<RegisterContract.Presenter>
        implements RegisterContract.View {

    @BindView(R.id.tie_account)
    TextInputEditText mTieAccount;

    @BindView(R.id.tie_password)
    TextInputEditText mTiePassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterContract.Presenter bindPresenter() {
        return new RegisterPresenter(this);
    }

    @OnClick(R.id.btn_login)
    void onRegisterClick() {
        mPresenter.register(mTieAccount.getText().toString(),
                mTiePassword.getText().toString());
    }

    @OnClick(R.id.tv_login)
    void onLoginClick() {
        startActivity(LoginActivity.class);
        finish();
    }

    /**
     * 注册 成功
     */
    @Override
    public void registerSuc() {
        toast(getString(R.string.register_suc));

        // 跳转到 LoginActivity
        Bundle bundle = new Bundle();
        bundle.putString("account", mTieAccount.getText().toString());
        bundle.putString("password", mTiePassword.getText().toString());
        startActivity(LoginActivity.class, bundle);
    }
}
