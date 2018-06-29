package zqx.rj.com.seekingcat.cat.account.presenter;

import zqx.rj.com.seekingcat.base.mvp.BasePresenter;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.presenter
 * 文件名：  ILoginPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:12
 * 描述：    TODO
 */

public interface ILoginPresenter extends BasePresenter{

    /**
     *  请求登录
     * @param phone
     * @param password
     */
    void requestLogin(String phone, String password);
}
