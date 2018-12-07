package zqx.rj.com.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kingja.loadsir.callback.SuccessCallback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import zqx.rj.com.base.activity.BaseActivity;
import zqx.rj.com.callback.LoadingCallback;

public abstract class MvpActivity<T extends BaseContract.Presenter>
        extends BaseActivity implements BaseContract.View {

    protected T mPresenter;
    protected LoadService loadService;

    @Override
    protected void initBefore() {
        super.initBefore();
        mPresenter = bindPresenter();

        // 注册 LoadSir
        loadService = LoadSir.getDefault().register(this);
    }

    protected abstract T bindPresenter();

    @Override
    public void showLoading() {
        loadService.showCallback(LoadingCallback.class);
    }

    @Override
    public void hideLoading() {
        loadService.showCallback(SuccessCallback.class);
    }

    @Override
    public void showError(int str) {
        toast(getString(str));
    }

    @Override
    public void showError(String str) {
        toast(str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
