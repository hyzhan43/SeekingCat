package zqx.rj.com.helper;

import io.reactivex.Observable;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.model.entity.PageRsp;
import zqx.rj.com.model.entity.account.LoginRsp;
import zqx.rj.com.model.entity.goods.GoodsRsp;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * created：2018/9/4 14:18
 * desc：    用户 辅助类
 */

public class AccountHelper extends BaseHelper {

    public static Observable<BaseResponse<LoginRsp>> login(String account, String password) {
        return apiHelper()
                .getLogin(account, password)
                .compose(RxScheduler.<BaseResponse<LoginRsp>>ioToMain());
    }

    public static void register(String phone, String password) {

    }

    public static Observable<BaseResponse<PageRsp<GoodsRsp>>> test(){
        return apiHelper().getAllGoods(0)
                .compose(RxScheduler.<BaseResponse<PageRsp<GoodsRsp>>>ioToMain());
    }
}
