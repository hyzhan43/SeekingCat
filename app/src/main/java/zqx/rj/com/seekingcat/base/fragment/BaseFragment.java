package zqx.rj.com.seekingcat.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.fragment
 * 文件名：  BaseFragment
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:43
 * 描述：    TODO
 */

public abstract class BaseFragment extends Fragment {

    private View mViewContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mViewContent = inflater.inflate(getContentView(), container, false);

        ButterKnife.bind(this, mViewContent);

        initContentView(mViewContent);

        return mViewContent;
    }

    protected abstract void initContentView(View viewContent);

    public abstract int getContentView();
}
