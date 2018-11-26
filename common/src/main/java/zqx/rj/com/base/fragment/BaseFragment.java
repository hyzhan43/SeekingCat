package zqx.rj.com.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.fragment
 * 文件名：  BaseFragment
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:43
 * 描述：    TODO
 */

public abstract class BaseFragment extends Fragment {

    protected View mRoot;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRoot == null) {
            View viewContent = inflater.inflate(getLayoutId(), container, false);

            ButterKnife.bind(this, viewContent);
            initView(viewContent);
            mRoot = viewContent;

        } else {
            if (mRoot.getParent() != null) {
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    protected abstract void initView(View viewContent);

    public abstract int getLayoutId();
}
