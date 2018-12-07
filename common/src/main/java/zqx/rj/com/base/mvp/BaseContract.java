package zqx.rj.com.base.mvp;

import android.support.annotation.StringRes;

/**
 *  MVP 基本契约
 */
public interface BaseContract {

    interface View{
        void showError(@StringRes int str);

        void showError(String str);

        void showLoading();

        void hideLoading();
    }

    interface Presenter{
        void detachView();
    }
}
