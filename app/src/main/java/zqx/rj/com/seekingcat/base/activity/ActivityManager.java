package zqx.rj.com.seekingcat.base.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.activity
 * 文件名：  ActivityManager
 * 创建者：  ZQX
 * 创建时间：2018/6/27 15:36
 * 描述：    所有活动管理器
 */

public class ActivityManager {

    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        if (!activities.contains(activity)) {
            activities.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
