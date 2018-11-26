package zqx.rj.com.seekingcat.account.view;

import zqx.rj.com.base.mvp.BaseView;
import zqx.rj.com.model.entity.account.User;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.account.view
 * 文件名：  ILoginView
 * 创建者：  ZQX
 * 创建时间：2018/6/28 16:48
 * 描述：    TODO
 */

public interface ILoginView<T> extends BaseView {

    void loginSuccess(User data);

    void loginFail(String msg);

}
