package zqx.rj.com.seekingcat.home.model.helper;

import java.util.List;

import zqx.rj.com.constants.Constants;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:07
 * desc：    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static void getAllGoods(int page, final Callback<PageRsp<List<GoodsRsp>>> callback) {
        apiHelper().getAllGoods(page)
                .compose(RxScheduler.<BaseResponse<PageRsp<List<GoodsRsp>>>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<PageRsp<List<GoodsRsp>>>>() {
                    @Override
                    public void onNext(BaseResponse<PageRsp<List<GoodsRsp>>> response) {
                        if (response.getCode() == BaseResponse.REQUEST_SUC) {
                            callback.onSuccess(response.getData());
                        } else {
                            callback.onFail(response.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        callback.onFail(Constants.NETWORK_ERROR);
                    }
                });
    }
}
