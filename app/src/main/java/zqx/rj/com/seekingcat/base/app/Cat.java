package zqx.rj.com.seekingcat.base.app;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

import java.util.HashMap;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.base.app
 * 文件名：  Cat
 * 创建者：  ZQX
 * 创建时间：2018/6/27 14:51
 * 描述：    TODO
 */

public class Cat {

    public static Configurator init(Context context){

        // 屏幕适配
        ScreenAdapterTools.init(context);
        // 初始化 Logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        Configurator.getInstance()
                .getCatConfigs()
                .put(ConfigType.APPLICATION_CONTEXT, context.getApplicationContext());

        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigurations(){
        return Configurator.getInstance().getCatConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT);
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static Configurator getConfiguration(Object key){
        return getConfigurator().getConfiguration(key);
    }
}
