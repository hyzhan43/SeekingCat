package zqx.rj.com.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名：  SeekingCat
 * 包名：    zqx.rj.com.common.utils
 * 文件名：  Preferences
 * 创建者：  ZQX
 * 创建时间：2018/6/28 16:30
 * 描述：    SharedPreferences 封装
 */

public class Preferences {

    private static final String NAME = "config";
    private static SharedPreferences preference;

    // 初始化 application 传入
    public static void setContext(Context context){
        preference = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    // 键    值
    public static void putString(String key, String value){
        preference.edit().putString(key, value).apply();
    }

    // 键    默认值
    public static String getString (String key, String defvalue){
        return preference.getString(key, defvalue);
    }

    // 键    值
    public static void putInt(String key, int value){
        preference.edit().putInt(key, value).apply();
    }

    // 键    默认值
    public static int getInt(String key, int defvalue){
        return preference.getInt(key, defvalue);
    }

    // 键    值
    public static void putBoolean(String key, boolean value){
        preference.edit().putBoolean(key, value).apply();
    }

    // 键    默认值
    public static boolean getBoolean(String key, boolean defvalue){
        return preference.getBoolean(key, defvalue);
    }

    // 删除  单个
    public static void deleteShare(String key){
        preference.edit().remove(key).apply();
    }

    // 删除   全部
    public static void deleteAll(){
        preference.edit().clear().apply();
    }
}
