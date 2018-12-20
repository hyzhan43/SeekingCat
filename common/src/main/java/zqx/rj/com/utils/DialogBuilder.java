package zqx.rj.com.utils;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import zqx.rj.com.common.R;

/**
 * author:  HyZhan
 * create:  2018/12/18 9:50
 * desc:    封装 dialog  默认 是 loading 样式
 */
public class DialogBuilder {

    private Context context;
    /**
     * dialog 样式
     */
    private int themeResId = R.style.Theme_Dialog;
    private View view;

    private boolean cancelable = false;
    private String message = "正在加载...";
    private int gravity = Gravity.CENTER;

    /**
     *  dialog 动画
     */
    private int animaStyle;

    private int width = WindowManager.LayoutParams.MATCH_PARENT;
    private int height = WindowManager.LayoutParams.WRAP_CONTENT;

    @SuppressLint("InflateParams")
    public DialogBuilder(Context context) {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
    }

    public DialogBuilder(Context context, int themeResId) {
        this.context = context;
        this.themeResId = themeResId;
    }

    public DialogBuilder(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public DialogBuilder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public DialogBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public DialogBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public DialogBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public DialogBuilder setLayoutId(@LayoutRes int layoutId) {
        this.view = LayoutInflater.from(context).inflate(layoutId, null);
        return this;
    }

    public DialogBuilder setAnimation(@StyleRes int animaStyle ){
        this.animaStyle = animaStyle;
        return this;
    }

    public Dialog build() {
        final Dialog dialog = new Dialog(context, themeResId);

        dialog.setCancelable(cancelable);
        dialog.setContentView(view);

        Window window = dialog.getWindow();

        if (window != null) {
            window.setGravity(gravity);
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = width;
            params.height = height;
            window.setAttributes(params);
            window.setWindowAnimations(animaStyle);
        }

        return dialog;
    }
}
