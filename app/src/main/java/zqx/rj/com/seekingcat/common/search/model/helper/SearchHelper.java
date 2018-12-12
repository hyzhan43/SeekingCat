package zqx.rj.com.seekingcat.common.search.model.helper;

import java.util.List;

import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.RxScheduler;

/**
 * author:  HyZhan
 * create:  2018/12/12 15:50
 * desc:    TODO
 */
public class SearchHelper extends BaseHelper {

    public static void search(int page, String keyword, Callback<PageRsp<GoodsRsp>> callback) {
        apiHelper().search(page, keyword)
                .compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<PageRsp<GoodsRsp>>>(callback));
    }
}

