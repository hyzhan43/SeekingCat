package zqx.rj.com.base.mvp.impl;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import zqx.rj.com.base.mvp.BasePresenter;
import zqx.rj.com.base.mvp.BaseView;


/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.mvp
 * 文件名：  BasePresenterImpl
 * 创建者：  ZQX
 * 创建时间：2018/7/10 13:22
 * 描述：    TODO
 */

public class BasePresenterImpl<T extends BaseView> extends BasePresenter {

    // View 接口类型的弱引用
    private Reference<T> mViewRef;

    @Override
    public void attachView(BaseView view) {
        mViewRef = new WeakReference<>((T) view);
    }

    protected boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public T getView() {
        return mViewRef.get();
    }

    @Override
    public void detachView() {
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
