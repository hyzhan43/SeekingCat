package zqx.rj.com.seekingcat.account.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.account.contract.RegisterContract;
import zqx.rj.com.seekingcat.account.model.helper.AccountHelper;

/**
 * author：  HyZhan
 * create：  2018/12/17 21:14
 * desc：    TODO
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View>
        implements RegisterContract.Presenter {

    public RegisterPresenter(RegisterContract.View view) {
        super(view);
    }

    @Override
    public void register(String account, String password) {

        if (isViewAttach()) {
            getView().showLoading();
            AccountHelper.register(account, password, new Callback<BaseResponse>() {
                @Override
                public void onSuccess(BaseResponse baseResponse) {
                    getView().registerSuc();
                }

                @Override
                public void onFail(String msg) {
                    getView().showError(msg);
                }
            });
        }
    }
}
