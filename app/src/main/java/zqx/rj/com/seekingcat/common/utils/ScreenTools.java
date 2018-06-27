package zqx.rj.com.seekingcat.common.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.utils
 * 文件名：  ScreenTools
 * 创建者：  ZQX
 * 创建时间：2018/6/27 17:15
 * 描述：    TODO
 */

public class ScreenTools {

    public static void activity(Activity activity) {
        ScreenAdapterTools.getInstance().loadView(activity.getWindow().getDecorView());
    }

    public static void fragment(View view) {
        ScreenAdapterTools.getInstance().loadView(view);
    }

    public static void adapterAndroid7(Activity activity){
        //如果希望android7.0分屏也适配的话,加上这句
        ScreenAdapterTools.getInstance().reset(activity);
    }
}
