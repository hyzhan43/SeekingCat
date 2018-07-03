package zqx.rj.com.seekingcat.base.mvp;

import java.util.Set;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.mvp
 * 文件名：  BaseRxPresenter
 * 创建者：  ZQX
 * 创建时间：2018/6/29 14:34
 * 描述：    TODO
 */

public class BaseRxPresenter<T extends BaseView> extends BasePresenter{

    private T mView;
    private Set<Object> subscribers;

    protected synchronized void addSubscrebe(Object subscriber){
        subscribers.add(subscriber);
    }

    protected synchronized void unSubscribe(Object subscriber){
        subscribers.remove(subscriber);
    }

    @Override
    public void attachView(BaseView view) {

    }

    @Override
    public void detachView() {
        if (mView != null){
            mView = null;
        }

        unSubscribe(subscribers);
    }
}
