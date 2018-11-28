package zqx.rj.com.seekingcat.account.ui;

import android.support.design.widget.TextInputEditText;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.base.mvp.MvpActivity;
import zqx.rj.com.seekingcat.account.model.bean.LoginRsp;
import zqx.rj.com.seekingcat.MainActivity;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.account.LoginContract;
import zqx.rj.com.seekingcat.account.presenter.LoginPresenter;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.utils.Preferences;
import zqx.rj.com.utils.ToastUtil;

public class LoginActivity extends MvpActivity<LoginRsp, LoginContract.Presenter>
        implements LoginContract.View<LoginRsp> {

    @BindView(R.id.tie_account)
    TextInputEditText mTieAccount;

    @BindView(R.id.tie_password)
    TextInputEditText mTiePassword;

    @Override
    protected LoginContract.Presenter bindPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 登录
     */
    @OnClick(R.id.btn_login)
    void onLoginClick() {

        String account = mTieAccount.getText().toString();
        String password = mTiePassword.getText().toString();

        mPresenter.requestLogin(account, password);
    }

    /**
     * 注册
     */
    @OnClick(R.id.tv_register)
    void onRegisterClick() {
        ToastUtil.show(this, "注册");
    }

    @Override
    public void success(LoginRsp data) {

        // 存储 token
        Preferences.putString(Constants.TOKEN, data.getToken());

        startActivity(MainActivity.class);
        finish();
    }
}
