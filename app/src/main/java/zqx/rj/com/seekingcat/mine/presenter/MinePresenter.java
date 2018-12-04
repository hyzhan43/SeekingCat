package zqx.rj.com.seekingcat.mine.presenter;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.seekingcat.mine.contract.MineContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.seekingcat.mine.model.helper.MineHelper;

/**
 * author：  HyZhan
 * create：  2018/12/4 15:01
 * desc：    TODO
 */
public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter, Callback<UserInfoRsp> {

    public MinePresenter(MineContract.View view) {
        super(view);
    }


    @Override
    public void getUserInfo() {
        MineHelper.getUserInfo(this);
    }

    @Override
    public void onSuccess(UserInfoRsp userInfoRsp) {
        if (isViewAttach()){
            getView().getUserInfoSuccess(userInfoRsp);
        }
    }

    @Override
    public void onFail(String msg) {
        if (isViewAttach()){
            getView().showError(msg);
        }
    }
}
