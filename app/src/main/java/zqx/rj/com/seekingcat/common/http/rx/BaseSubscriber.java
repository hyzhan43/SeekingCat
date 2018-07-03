package zqx.rj.com.seekingcat.common.http.rx;

import org.reactivestreams.Subscription;

import io.reactivex.subscribers.DisposableSubscriber;
import zqx.rj.com.seekingcat.base.mvp.BaseView;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.http.rx
 * 文件名：  BaseSubscriber
 * 创建者：  ZQX
 * 创建时间：2018/6/29 14:57
 * 描述：    TODO
 */

public class BaseSubscriber<T> extends DisposableSubscriber<T> {

    protected BaseView mBaseView;

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        mBaseView.hideLoading();
    }

    @Override
    public void onComplete() {
        mBaseView.hideLoading();
    }
}
