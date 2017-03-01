package com.fang.common.base.utils.over;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by double on 2017/1/7.
 */

public class SPUtils {

    /**
     * 保存在手机里的文件名
     */
    public static final String FILE_NAME = "sp_data";

    /**
     * SPUtils构造函数
     * <p>在Application中初始化</p>
     */
    private SPUtils(Context context) {

    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.edit();
    }

    public static void putLong(Context context, String key, Long value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(key, value);
        editor.apply();
    }

    public static void putBoolean(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void putFloat(Context context, String key, Float value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putFloat(key, value);
        editor.apply();
    }


    public static void putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.apply();
    }


    public static void putStringSet(Context context, String key, Set<String> value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putStringSet(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(key, defValue);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getLong(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getInt(key, defValue);
    }


    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(key, defValue);
    }


    public static float getFloat(Context context, String key, float defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getFloat(key, defValue);
    }


    public static Set<String> getLong(Context context, String key, Set<String> defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getStringSet(key, defValue);
    }

    /**
     * 删除指定的数据
     *
     * @param key key
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 返回所有的键值对
     *
     * @return map
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        Map<String, ?> map = sp.getAll();
        return map;
    }

    /**
     * 清除所有数据
     *
     * @param context context
     */
    public static void clear(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 检查是否存在此key对应的数据
     *
     * @param context context
     * @param key     key
     * @return boolean
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.contains(key);
    }

}
