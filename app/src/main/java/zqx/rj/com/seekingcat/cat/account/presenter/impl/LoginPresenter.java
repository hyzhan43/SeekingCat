package zqx.rj.com.seekingcat.cat.account.presenter.impl;

import zqx.rj.com.seekingcat.base.mvp.IBaseView;
import zqx.rj.com.seekingcat.cat.account.presenter.ILoginPresenter;
import zqx.rj.com.seekingcat.cat.account.view.ILoginView;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.presenter
 * 文件名：  LoginPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/28 17:11
 * 描述：    TODO
 */

public class LoginPresenter implements ILoginPresenter{

    private IBaseView mLoginView;

    @Override
    public void requestLogin(String phone, String password) {
        // TODO 网络请求
    }

    @Override
    public void attachView(IBaseView view) {
        this.mLoginView = view;
    }

    @Override
    public void detachView() {
        if (mLoginView != null){
            mLoginView = null;
        }
    }
}
