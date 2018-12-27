package zqx.rj.com.seekingcat.mine.contract;

import java.util.List;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;

/**
 * author:  HyZhan
 * create:  2018/12/18 14:13
 * desc:    TODO
 */
public interface FollowContract {

    interface Presenter extends BaseContract.Presenter {
        void getFollow(int page);

        void deleteMyFollow(List<Integer> goodsIdList);
    }

    interface View extends BaseContract.View {
        void getFollowSuc(PageRsp<GoodsRsp> pageRsp);

        void deleteSuc();
    }
}
