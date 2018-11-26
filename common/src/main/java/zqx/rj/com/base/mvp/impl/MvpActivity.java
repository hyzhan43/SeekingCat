package zqx.rj.com.base.mvp.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.base.mvp.BaseView;

public abstract class MvpActivity<T extends BasePresenter> extends BaseActivity
        implements BaseView {

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
}
