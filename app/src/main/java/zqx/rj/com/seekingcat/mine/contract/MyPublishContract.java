package zqx.rj.com.seekingcat.mine.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/18 14:13
 * desc:    TODO
 */
public interface MyPublishContract {

    interface Presenter extends BaseContract.Presenter {
        void getMyPublish(int page);
    }

    interface View extends BaseContract.View {
        void getMyPublishSuc(PageRsp<GoodsRsp> pageRsp);
    }
}
