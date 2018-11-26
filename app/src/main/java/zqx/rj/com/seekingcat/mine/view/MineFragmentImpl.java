package zqx.rj.com.seekingcat.mine.view;

import android.view.View;

import zqx.rj.com.seekingcat.R;
import zqx.rj.com.base.fragment.BaseFragment;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.mine.view
 * 文件名：  MineFragmentImpl
 * 创建者：  ZQX
 * 创建时间：2018/7/10 14:07
 * 描述：    TODO
 */

public class MineFragmentImpl extends BaseFragment {

    public static MineFragmentImpl getInstance() {
        return new MineFragmentImpl();
    }

    @Override
    protected void initView(View viewContent) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
