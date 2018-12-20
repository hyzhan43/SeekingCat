package zqx.rj.com.rx;

import com.alibaba.android.arouter.launcher.ARouter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zqx.rj.com.constants.Constants;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.net.callback.Callback;
import zqx.rj.com.utils.Log;
import zqx.rj.com.utils.Preferences;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.http.rx
 * 文件名：  BaseObserver
 * 创建者：  ZQX
 * 创建时间：2018/6/29 17:30
 * 描述：    TODO
 */

public class BaseObserver<T> implements Observer<T> {

    private Callback callback;

    public BaseObserver(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        BaseResponse response = (BaseResponse) t;
        if (response.getCode() == BaseResponse.TOKEN_EXPIRE) {
            // 如果 token 过期的话。就直接 设置未登录状态
            Preferences.putBoolean(Constants.IS_LOGIN, false);
            // 通过 ARouter 跳转 到 loginActivity
            ARouter.getInstance().build("/login/activity").navigation();
        } else if (response.getCode() == BaseResponse.REQUEST_SUC) {
            callback.onSuccess(response.getData());
        } else {
            callback.onFail(response.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.d("e ->" + e);
        callback.onFail(Constants.NETWORK_ERROR);
    }

    @Override
    public void onComplete() {

    }
}
