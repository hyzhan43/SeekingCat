package zqx.rj.com.seekingcat.cat.account.view;

import zqx.rj.com.seekingcat.base.mvp.BaseView;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.view
 * 文件名：  ILoginView
 * 创建者：  ZQX
 * 创建时间：2018/6/28 16:48
 * 描述：    TODO
 */

public interface ILoginView<T> extends BaseView {

    void loginSuccess(int code, T data);

    void loginFail(String msg);
}
