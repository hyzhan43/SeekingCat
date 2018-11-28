package zqx.rj.com.seekingcat.home.model.helper;

import java.util.List;

import io.reactivex.Observable;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.seekingcat.home.model.bean.GoodsRsp;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * create：  2018/11/28 20:07
 * desc：    TODO
 */
public class GoodsHelper extends BaseHelper {

    public static Observable<BaseResponse<PageRsp<List<GoodsRsp>>>> allGoods(int page){
        return apiHelper().getAllGoods(page)
                .compose(RxScheduler.<BaseResponse<PageRsp<List<GoodsRsp>>>>ioToMain());
    }
}
