package zqx.rj.com.seekingcat.cat.account.view.impl;

import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import zqx.rj.com.seekingcat.R;
import zqx.rj.com.seekingcat.R2;
import zqx.rj.com.seekingcat.base.activity.BaseActivity;
import zqx.rj.com.seekingcat.base.mvp.BasePresenter;
import zqx.rj.com.seekingcat.cat.account.view.ILoginView;

public class LoginActivity extends BaseActivity implements ILoginView{

    @BindView(R2.id.account_btn_login)
    Button mLogin;

    @OnClick(R2.id.account_btn_login)
    void onLoginClick(){
        toast("hello ");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(int code, String msg) {

    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }
}
