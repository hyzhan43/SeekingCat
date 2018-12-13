package zqx.rj.com.seekingcat.common.goods.model.helper;

import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.RxScheduler;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:46
 * desc:    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static void getMyPublish(int page, Callback<PageRsp<GoodsRsp>> callback) {
        apiHelper().getMyPublish(page)
                .compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
    }

    public static void getFollow(int page, Callback<PageRsp<GoodsRsp>> callback) {
        apiHelper().getFollow(page)
                .compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
    }
}
