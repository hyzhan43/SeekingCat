package zqx.rj.com.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.toast
 * 文件名：  ToastUtil
 * 创建者：  ZQX
 * 创建时间：2018/6/27 16:50
 * 描述：    toast 封装
 */

public class ToastUtil {

    private static final int TOAST_TIME = Toast.LENGTH_SHORT;

    private static Toast mToast;

    @SuppressLint("ShowToast")
    public static void show(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, TOAST_TIME);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }
}
