package zqx.rj.com.seekingcat.common.goods.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:12
 * desc:    TODO
 */
public interface GoodsContract {

    interface Presenter extends BaseContract.Presenter {
        void getMyPublish(int page);

        void getFollow(int page);
    }

    interface View extends BaseContract.View {
        void getMyPublishSuc(PageRsp<GoodsRsp> pageRsp);

        void getFollowSuc(PageRsp<GoodsRsp> pageRsp);
    }
}
