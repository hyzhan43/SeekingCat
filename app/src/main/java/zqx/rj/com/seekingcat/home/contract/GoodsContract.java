package zqx.rj.com.seekingcat.home.contract;

import java.util.List;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;

public interface GoodsContract {

    interface Presenter extends BaseContract.Presenter {
        void requestGoods(int type, int page);
    }

    interface View extends BaseContract.View {
        void onGetGoodsSucceed(PageRsp<List<GoodsRsp>> pageRsp);
    }
}
