package zqx.rj.com.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.account.LoginRsp;
import zqx.rj.com.utils.ToastUtil;

public abstract class MvpActivity<Data, T extends BaseContract.Presenter>
        extends BaseActivity implements BaseContract.View<Data> {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = bindPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract T bindPresenter();

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int str) {
        ToastUtil.show(getString(str));
    }

    @Override
    public void showError(String str) {
        ToastUtil.show(str);
    }
}
