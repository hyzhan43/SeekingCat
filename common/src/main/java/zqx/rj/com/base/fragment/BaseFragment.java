package zqx.rj.com.base.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jph.takephoto.app.TakePhotoFragment;

import butterknife.ButterKnife;
import zqx.rj.com.utils.DialogBuilder;
import zqx.rj.com.utils.ToastUtil;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.fragment
 * 文件名：  BaseFragment
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:43
 * 描述：    TODO
 */

public abstract class BaseFragment extends TakePhotoFragment {

    protected View mRoot;

    protected Dialog mLoading;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRoot = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, mRoot);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoading = new DialogBuilder(getActivity()).build();


        initView(mRoot);
        initData();
    }

    public void initData() {
    }

    public void initView(View view) {

    }

    // toast 显示
    public void toast(String str) {
        ToastUtil.show(getActivity(), str);
    }

    public abstract int getLayoutId();
}
