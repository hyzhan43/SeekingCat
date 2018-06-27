package zqx.rj.com.seekingcat.base.app;

import android.app.Application;


/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.app
 * 文件名：  BaseApplication
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:43
 * 描述：    TODO
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Cat.init(this)
                .configure();

    }
}
