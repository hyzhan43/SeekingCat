package zqx.rj.com.seekingcat.cat.account.view.impl;

import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.R2;
import zqx.rj.com.seekingcat.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.cat.account.model.entity.User;
import zqx.rj.com.seekingcat.cat.account.presenter.impl.LoginPresenter;
import zqx.rj.com.seekingcat.cat.account.view.ILoginView;
import zqx.rj.com.seekingcat.common.utils.Log;

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView{

    @BindView(R2.id.account_btn_login)
    Button mLogin;

    @OnClick(R2.id.account_btn_login)
    void onLoginClick(){

        // TODO 获取账号密码
        mPresenter.requestLogin("123", "123");
    }

    @Override
    public void showLoading() {
        Log.d("LST", "显示进度条");
    }

    @Override
    public void hideLoading() {
        Log.d("LST", "隐藏进度条");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter bindPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }


    @Override
    public void loginSuccess(int code, Object data) {
        User user = (User) data;
        toast(code + "--" + user.getPhone());
    }

    @Override
    public void loginFail(String msg) {
        Log.d("LST", "error = " + msg);
    }
}
