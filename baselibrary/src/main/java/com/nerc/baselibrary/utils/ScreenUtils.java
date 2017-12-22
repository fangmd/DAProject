package com.nerc.baselibrary.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by nerc on 2017/8/2.
 */

public class ScreenUtils {

    public static int dp2px2(Context context, float ps){
        return ((int) (context.getResources().getDisplayMetrics().density * ps + 0.5));
    }

    public static int dp2px(Context context, int ps){
        return ((int) (context.getResources().getDisplayMetrics().density * ps + 0.5));
    }

    public static int dp2pxMin(Context context, int ps){
        return ((int) (context.getResources().getDisplayMetrics().density * ps));
    }

    public static int getWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }


    /**
     * dp转px
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

}
