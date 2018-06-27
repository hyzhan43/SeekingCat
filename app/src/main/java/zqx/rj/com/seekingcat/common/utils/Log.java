package zqx.rj.com.seekingcat.common.utils;

import com.orhanobut.logger.Logger;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.log
 * 文件名：  Log
 * 创建者：  ZQX
 * 创建时间：2018/6/27 16:44
 * 描述：    TODO
 */

public class Log {

    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;

    // 控制 log 等级
    private static final int LEVEL = VERBOSE;

    public static void v(String tag, String message){
        Logger.t(tag).v(message);
    }

    public static void d(String tag, String message){
        Logger.t(tag).d(message);
    }

    public static void i(String tag, String message){
        Logger.t(tag).i(message);
    }

    public static void w(String tag, String message){
        Logger.t(tag).w(message);
    }

    public static void e(String tag, String message){
        Logger.t(tag).e(message);
    }

    public static void json(String tag, String message){
        Logger.t(tag).d(message);
    }
}
