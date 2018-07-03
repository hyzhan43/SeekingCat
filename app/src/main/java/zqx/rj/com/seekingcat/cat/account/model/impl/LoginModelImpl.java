package zqx.rj.com.seekingcat.cat.account.model.impl;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zqx.rj.com.seekingcat.base.mvp.BaseModel;
import zqx.rj.com.seekingcat.cat.account.model.ILoginModel;
import zqx.rj.com.seekingcat.cat.account.model.response.LoginResponse;
import zqx.rj.com.seekingcat.cat.account.presenter.impl.LoginPresenter;
import zqx.rj.com.seekingcat.common.http.api.ApiService;
import zqx.rj.com.seekingcat.common.http.retrofit.RetrofitFactory;
import zqx.rj.com.seekingcat.common.http.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.utils.Log;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.cat.account.model.impl
 * 文件名：  LoginModelImpl
 * 创建者：  ZQX
 * 创建时间：2018/6/29 18:19
 * 描述：    TODO
 */

public class LoginModelImpl extends BaseModel implements ILoginModel {

    private LoginPresenter mLoginPresenter;

    public LoginModelImpl(LoginPresenter presenter) {
        mLoginPresenter = presenter;
    }

    @Override
    public void login(String phone, String password) {

        RetrofitFactory.getInstance()
                .create(ApiService.class)
                .getLogin(phone, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LoginResponse>(){
                    @Override
                    public void onNext(LoginResponse response) {
                        Log.d("3333333333");
                        response.setCode(LOGIN_SUC);
                        mLoginPresenter.onLoginResponse(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("4444444" + e);
                        LoginResponse loginResponse = new LoginResponse();
                        loginResponse.setCode(LOGIN_FAIL);
                        loginResponse.setMessage(e.toString());
                        mLoginPresenter.onLoginResponse(loginResponse);
                    }
                });
    }

    @Override
    public void register(String phone, String password) {

    }
}
