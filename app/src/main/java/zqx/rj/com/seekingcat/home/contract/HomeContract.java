package zqx.rj.com.seekingcat.home.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

public interface HomeContract {

    interface Presenter extends BaseContract.Presenter {
        void getGoods(int type, int page);
    }

    interface View extends BaseContract.View {
        void getGoodsSucceed(PageRsp<GoodsRsp> pageRsp);
    }
}
