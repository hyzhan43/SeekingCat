package zqx.rj.com.seekingcat.home.model.helper;

import io.reactivex.Observable;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.presenter.GoodsPresenter;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:07
 * desc：    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static void getGoods(int type, int page, final Callback<PageRsp<GoodsRsp>> callback) {

        Observable<BaseResponse<PageRsp<GoodsRsp>>> observable = null;

        switch (type) {
            case GoodsPresenter.ALL:
                observable = apiHelper().getAllGoods(page);
                break;
            case GoodsPresenter.SEEK:
                observable = apiHelper().getSeekGoods(page);
                break;
            case GoodsPresenter.LOSE:
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

    public static void unFollowGoods(int id, final Callback<BaseResponse> callback) {
        apiHelper().unFollowGoods(id)
                .compose(RxScheduler.<BaseResponse>ioToMain())
                .subscribe(new BaseObserver<BaseResponse>(callback));
    }
}
