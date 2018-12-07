package zqx.rj.com.seekingcat.mine.model.helper;

import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.seekingcat.mine.model.bean.UserInfoRsp;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * create：  2018/12/4 15:07
 * desc：    TODO
 */
public class MineHelper extends BaseHelper {

    public static void getUserInfo(final Callback<UserInfoRsp> callback) {
        apiHelper().getUserInfo()
                .compose(RxScheduler.<BaseResponse<UserInfoRsp>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<UserInfoRsp>>(callback));
    }
}
