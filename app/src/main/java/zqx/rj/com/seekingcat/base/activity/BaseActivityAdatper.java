package zqx.rj.com.seekingcat.base.activity;

import zqx.rj.com.seekingcat.base.mvp.BasePresenter;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.activity
 * 文件名：  BaseActivityAdatper
 * 创建者：  ZQX
 * 创建时间：2018/6/27 16:59
 * 描述：    TODO
 */

public abstract class BaseActivityAdatper extends BaseActivity{

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }
}
