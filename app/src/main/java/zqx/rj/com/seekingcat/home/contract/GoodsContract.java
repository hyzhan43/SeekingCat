package zqx.rj.com.seekingcat.home.contract;

import zqx.rj.com.base.mvp.BaseContract;

public interface GoodsContract {

    interface Presenter extends BaseContract.Presenter {
        void requestAllGoods(int page);
    }

    interface View<T> extends BaseContract.View<T> {

    }
}
