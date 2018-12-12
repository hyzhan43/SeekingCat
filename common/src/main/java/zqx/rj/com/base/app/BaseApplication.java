package zqx.rj.com.base.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePal;

import zqx.rj.com.utils.Preferences;


/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.base.app
 * 文件名：  BaseApplication
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:43
 * 描述：    TODO
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化 leak
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        // 初始化 Logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        // 初始化 SharedPreferences
        Preferences.setContext(this);

        // 初始化 litePal 数据库
        LitePal.initialize(this);
    }
}
