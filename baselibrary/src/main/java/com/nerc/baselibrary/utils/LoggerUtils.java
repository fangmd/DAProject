package com.nerc.baselibrary.utils;

import com.nerc.baselibrary.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by double on 16-7-17.
 * Project: VQChat
 */
public class LoggerUtils {

    private static boolean DEBUG = BuildConfig.LOG_DEBUG;

    public static void init() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

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

    public static void e(String tag, Throwable t) {
        if (DEBUG) {
            Logger.t(tag).e(t.getMessage());
        }
    }

    public static void e(Throwable t) {
        if (DEBUG) {
            Logger.e(t.getMessage());
        }
    }

    public static void d(String s) {
        if (DEBUG) {
            Logger.d(s);
        }
    }

    public static void d(Object object) {
        if (DEBUG) {
            Logger.d(object);
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
