package zqx.rj.com.seekingcat.publish.contract;

import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.seekingcat.publish.model.entity.request.GoodsModel;

/**
 * author：  HyZhan
 * create：  2018/11/30 15:32
 * desc：    TODO
 */
public interface PublishContract {

    interface Presenter extends BaseContract.Presenter{
        void publishGoods(GoodsModel goodsModel);
    }

    interface View extends BaseContract.View{
        void onPublish();

        void publishSuccess();
    }
}
