package zqx.rj.com.utils;

import com.orhanobut.logger.Logger;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.seekingcat.common.log
 * 文件名：  Log
 * 创建者：  ZQX
 * 创建时间：2018/6/27 16:44
 * 描述：    logger 封装
 */

public class Log {

    private static String tag = "LST";

    public static void v(String tag, String message){
        Logger.t(tag).v(message);
    }

    public static void d(String tag, String message){
        Logger.t(tag).d(message);
    }

    public static void d(String message){
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
