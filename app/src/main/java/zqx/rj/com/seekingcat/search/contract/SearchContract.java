package zqx.rj.com.seekingcat.search.contract;

import java.util.List;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/12 14:52
 * desc:    TODO
 */
public interface SearchContract {

    interface Presenter extends BaseContract.Presenter {
        void searchGoods(int page, String keyword);
    }

    interface View extends BaseContract.View {
        void searchSuccess(PageRsp<GoodsRsp> pageRsp);
    }
}
