package zqx.rj.com.seekingcat.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.toast
 * 文件名：  ToastUtil
 * 创建者：  ZQX
 * 创建时间：2018/6/27 16:50
 * 描述：    TODO
 */

public class ToastUtil {

    public static int TOAST_TIME = Toast.LENGTH_SHORT;

    private static Toast mToast;
    private static Context mContext;

    public static void init(Context context){
        mContext = context;
    }

    public static void show(String text){
        if (mToast == null){
            mToast = Toast.makeText(mContext, text, TOAST_TIME);
        }else {
            mToast.setText(text);
        }

        mToast.show();
    }
}
