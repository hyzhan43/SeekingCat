package zqx.rj.com.base.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;

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
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);

        // 初始化 Logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        // 初始化 SharedPreferences
        Preferences.setContext(this);

        // 初始化 litePal 数据库
        LitePal.initialize(this);

        // 初始化 ARouter
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);

        // 延迟初始化 防止被 splash 页面 finish
        Beta.initDelay = 4 * 1000;
        // 初始化 Bugly
        Bugly.init(this, "876c78faf0", false);
    }
}
