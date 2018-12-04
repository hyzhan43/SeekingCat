package zqx.rj.com.seekingcat.mine.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;

/**
 * author：  HyZhan
 * create：  2018/12/4 15:00
 * desc：    TODO
 */
public interface MineContract {

    interface Presenter extends BaseContract.Presenter {
        void getUserInfo();
    }

    interface View extends BaseContract.View {
        void getUserInfoSuccess(UserInfoRsp userInfoRsp);
    }
}
