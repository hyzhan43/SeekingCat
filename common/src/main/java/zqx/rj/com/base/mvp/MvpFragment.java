package zqx.rj.com.base.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import zqx.rj.com.base.fragment.BaseFragment;

/**
 * author：  HyZhan
 * create：  2018/11/28 19:06
 * desc：    TODO
 */
public abstract class MvpFragment<T extends BaseContract.Presenter>
        extends BaseFragment implements BaseContract.View {

    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = bindPresenter();
    }

    protected abstract T bindPresenter();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showError(int str) {
        toast(getString(str));
    }

    @Override
    public void showError(String str) {
        toast(str);
    }

}
