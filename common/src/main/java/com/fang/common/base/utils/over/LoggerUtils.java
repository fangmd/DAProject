package com.fang.common.base.utils.over;

import com.fang.common.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by double on 16-7-17.
 * Project: VQChat
 */
public class LoggerUtils {

    //TODO: 设置release版本不打印log

    //TODO:
//    private static boolean DEBUG = com.waytone.vqchat.BuildConfig.LOG_DEBUG;
    private static boolean DEBUG = BuildConfig.LOG_DEBUG;
//    public static boolean NET_DEBUG = com.waytone.vqchat.BuildConfig.NET_DEBUG;


    public static void v(String s) {
        if (DEBUG) {
            Logger.v(s);
        }
    }


    public static void v(String tag, String s) {
        if (DEBUG) {
            Logger.t(tag).v(s);
        }
    }


    public static void w(String s) {
        if (DEBUG) {
            LoggerUtils.w(s);
        }
    }

    public static void w(String tag, String s) {
        if (DEBUG) {
            Logger.t(tag).w(s);
        }
    }

    public static void e(String s) {
        if (DEBUG) {
            Logger.e(s);
        }
    }

    public static void e(String tag, String s) {
        if (DEBUG) {
            Logger.t(tag).e(s);
        }
    }

    public static void d(String s) {
        if (DEBUG) {
            Logger.d(s);
        }
    }


    public static void d(String tag, String s) {
        if (DEBUG) {
            Logger.t(tag).d(s);
        }
    }

    public static void i(String s) {
        if (DEBUG) {
            Logger.i(s);
        }
    }

    public static void i(String tag, String s) {
        if (DEBUG) {
            Logger.t(tag).i(s);
        }
    }

}
