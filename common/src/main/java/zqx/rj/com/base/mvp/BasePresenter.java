package zqx.rj.com.base.mvp;

import android.view.View;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.base
 * 文件名：  BasePresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/27 13:21
 * 描述：    TODO
 */

public abstract class BasePresenter{

    public abstract void attachView(BaseView view);

    public abstract void detachView();
}
