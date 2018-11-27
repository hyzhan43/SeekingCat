package zqx.rj.com.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zqx.rj.com.base.mvp.BaseContract;
import zqx.rj.com.common.R;
import zqx.rj.com.model.entity.BaseResponse;
import zqx.rj.com.utils.Log;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.http.rx
 * 文件名：  BaseObserver
 * 创建者：  ZQX
 * 创建时间：2018/6/29 17:30
 * 描述：    TODO
 */

public class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private BaseContract.View mView;

    public BaseObserver(BaseContract.View view) {
        this.mView = view;
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onNext(BaseResponse<T> response) {
        if (response.getCode() == BaseResponse.REQUEST_SUC) {
            mView.success(response.getData());
        } else {
            mView.showError(response.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        mView.showError(R.string.network_error);
        Log.d("LST", "error -> " + e);
    }

    @Override
    public void onComplete() {

    }
}
