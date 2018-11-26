package zqx.rj.com.base.mvp;

import android.support.annotation.StringRes;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.base
 * 文件名：  BaseView
 * 创建者：  ZQX
 * 创建时间：2018/6/27 13:21
 * 描述：    TODO
 */

public interface BaseView {

    /**
     *   显示 loading
     */
    void showLoading();

    /**
     *   隐藏 loading
     */
    void hideLoading();


    void showError(@StringRes int str);
}
