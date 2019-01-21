package zqx.rj.com.seekingcat.account.contract;

import zqx.rj.com.base.mvp.BaseContract;

/**
 * author：  HyZhan
 * create：  2018/12/17 21:15
 * desc：    TODO
 */
public interface RegisterContract {

    interface Presenter extends BaseContract.Presenter {

        void register(String account, String password);
    }

    interface View extends BaseContract.View {
        void registerSuc();
    }
}
