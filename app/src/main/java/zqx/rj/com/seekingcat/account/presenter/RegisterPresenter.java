package zqx.rj.com.seekingcat.account.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.account.RegisterContract;
import zqx.rj.com.seekingcat.account.model.helper.AccountHelper;

/**
 * author：  HyZhan
 * create：  2018/12/17 21:14
 * desc：    TODO
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter, Callback<BaseResponse> {

    public RegisterPresenter(RegisterContract.View view) {
        super(view);
    }

    @Override
    public void register(String account, String password) {
        AccountHelper.register(account, password, this);
    }

    @Override
    public void onSuccess(BaseResponse response) {
        if (isViewAttach()){
            getView().registerSuc();
        }
    }

    @Override
    public void onFail(String msg) {
        if (isViewAttach()){
            getView().showError(msg);
        }
    }
}
