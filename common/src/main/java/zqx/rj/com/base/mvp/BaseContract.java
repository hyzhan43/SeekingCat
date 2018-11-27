package zqx.rj.com.base.mvp;

import android.support.annotation.StringRes;

/**
 *  MVP 基本契约
 */
public interface BaseContract {

    interface View<T>{
        void showError(@StringRes int str);

        void showError(String str);

        void showLoading();

        void success(T data);
    }

    interface Presenter{
        void attachView(View view);

        void detachView();
    }
}
