package zqx.rj.com.seekingcat.home.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

/**
 * author：  HyZhan
 * create：  2018/12/7 19:06
 * desc：    TODO
 */
public interface GoodsDetailContract {

    interface Presenter extends BaseContract.Presenter {
        void requestGoodsDetail(int id);

        void follow(int id);

        void unFollow(int id);
    }

    interface View extends BaseContract.View {
        void loadGoodsDetailSuccess(GoodsRsp goodsRsp);

        void followSuccess();

        void unFollowSuccess();
    }
}
