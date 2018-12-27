package zqx.rj.com.seekingcat.common.goods.model.helper;

import java.util.List;

import io.reactivex.Observable;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.common.goods.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.presenter.HomePresenter;
import zqx.rj.com.utils.RxScheduler;

/**
 * author:  HyZhan
 * create:  2018/12/13 11:46
 * desc:    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static void getMyPublish(int page, Integer state, Callback<PageRsp<GoodsRsp>> callback) {

        Observable<BaseResponse<PageRsp<GoodsRsp>>> observable = null;
        switch (state) {
            case GoodsRsp.GOODS_ALL:
                observable = apiHelper().getMyPublish(page);
                break;
            case GoodsRsp.GOODS_FOUND:
                observable = apiHelper().getFound(page);
                break;
            case GoodsRsp.GOODS_NOT_FOUND:
                observable = apiHelper().getUnFound(page);
                break;
        }

        if (observable != null) {
            observable.compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                    .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
        }
    }

    public static void getFollow(int page, Callback<PageRsp<GoodsRsp>> callback) {
        apiHelper().getFollow(page)
                .compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
    }

    public static void getGoods(int type, int page, final Callback<PageRsp<GoodsRsp>> callback) {

        Observable<BaseResponse<PageRsp<GoodsRsp>>> observable = null;

        switch (type) {
            case HomePresenter.ALL:
                observable = apiHelper().getAllGoods(page);
                break;
            case HomePresenter.SEEK:
                observable = apiHelper().getSeekGoods(page);
                break;
            case HomePresenter.LOSE:
                observable = apiHelper().getLoseGoods(page);
                break;
        }

        if (observable != null) {
            observable.compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                    .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
        }
    }

    public static void getGoodsDetail(int id, final Callback<GoodsRsp> callback) {
        apiHelper().getGoodsDetail(id)
                .compose(RxScheduler.<BaseResponse<GoodsRsp>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<GoodsRsp>>(callback));
    }

    // 发起关注
    public static void followGoods(int id, final Callback<BaseResponse> callback) {
        apiHelper().followGoods(id)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }

    // 取消关注
    public static void unFollowGoods(int id, final Callback<BaseResponse> callback) {
        apiHelper().unFollowGoods(id)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }

    // 批量取消关注
    public static void deleteFollow(List<Integer> goodsIdList, final Callback<BaseResponse> callback) {
        apiHelper().deleteFollow(goodsIdList)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }

    // 找到物品/失主
    public static void foundGoods(int goodsId, Callback<BaseResponse> callback) {
        apiHelper().foundGoods(goodsId)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }

    // 删除用户发布
    public static void deleteMyPublishGoods(int goodsId, Callback<BaseResponse> callback) {
        apiHelper().deletePublishGoods(goodsId)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }
}
