package zqx.rj.com.seekingcat.account.presenter;

import zqx.rj.com.base.mvp.impl.BasePresenterImpl;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.account.presenter
 * 文件名：  ILoginPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:12
 * 描述：    TODO
 */

public abstract class ILoginPresenter extends BasePresenterImpl {

    /**
     * 请求登录
     */
    public abstract void requestLogin(String phone, String password);

    /**
     *  检查账号密码
     */
    public abstract boolean checkAccountAndPwd(String phone, String password);
}
