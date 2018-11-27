package zqx.rj.com.base.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import zqx.rj.com.base.mvp.BaseContract;


/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.mvp
 * 文件名：  BasePresenter
 * 创建者：  ZQX
 * 创建时间：2018/7/10 13:22
 * 描述：    TODO
 */

public class BasePresenter implements BaseContract.Presenter {

    // View 接口类型的弱引用
    private Reference<BaseContract.View> mViewRef;

    public void attachView(BaseContract.View view) {
        mViewRef = new WeakReference<>(view);
    }

    protected boolean isViewAttach(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public BaseContract.View getView() {
        return mViewRef.get();
    }

    public void detachView() {
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
