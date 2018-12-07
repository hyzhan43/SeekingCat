package zqx.rj.com.seekingcat.account.model.helper;

import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.rx.BaseObserver;
import zqx.rj.com.seekingcat.account.model.bean.LoginRsp;
import zqx.rj.com.seekingcat.common.BaseHelper;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.RxScheduler;

/**
 * author：  HyZhan
 * created：2018/9/4 14:18
 * desc：    用户 辅助类
 */

public class AccountHelper extends BaseHelper {

    public static void login(String account, String password, Callback<LoginRsp> callback) {
        apiHelper().getLogin(account, password)
                .compose(RxScheduler.<BaseResponse<LoginRsp>>ioToMain())
                .subscribe(new BaseObserver<BaseResponse<LoginRsp>>(callback));
    }

    public static void register(String phone, String password) {

    }
}
