package zqx.rj.com.seekingcat.home.model.helper;

import java.util.List;

import io.reactivex.Observable;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.seekingcat.home.presenter.GoodsPresenter;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:07
 * desc：    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static void getGoods(int type, int page, final Callback<PageRsp<List<GoodsRsp>>> callback) {

        Observable<BaseResponse<PageRsp<List<GoodsRsp>>>> observable = null;

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
            observable.compose(RxScheduler.<BaseResponse<PageRsp<List<GoodsRsp>>>>ioToMain())
                    .subscribe(new BaseObserver<BaseResponse<PageRsp<List<GoodsRsp>>>>(callback));
        }
    }

    public static void getGoodsDetail(int id, final Callback<GoodsRsp> callback) {
        apiHelper().getGoodsDetail(id)
                .compose(RxScheduler.<BaseResponse<GoodsRsp>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<GoodsRsp>>(callback));
    }
}
