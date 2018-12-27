package zqx.rj.com.base.mvp;

import zqx.rj.com.base.activity.BaseActivity;

public abstract class MvpActivity<T extends BaseContract.Presenter>
        extends BaseActivity implements BaseContract.View {

    protected T mPresenter;

    @Override
    protected void initBefore() {
        super.initBefore();
        mPresenter = bindPresenter();
    }

    protected abstract T bindPresenter();

    @Override
    public void showLoading() {
        mLoading.show();
    }

    @Override
    public void hideLoading() {
        mLoading.hide();
    }

    @Override
    public void showError(int str) {
        toast(getString(str));
        mLoading.dismiss();
    }

    @Override
    public void showError(String str) {
        toast(str);
        mLoading.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
