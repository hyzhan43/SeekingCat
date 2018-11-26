package zqx.rj.com.seekingcat.home.view;

import android.view.View;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.base.fragment.BaseFragment;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.home.view
 * 文件名：  HomeFragment
 * 创建者：  ZQX
 * 创建时间：2018/7/10 14:15
 * 描述：    TODO
 */

public class HomeFragment extends BaseFragment {

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    @Override
    protected void initView(View viewContent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
