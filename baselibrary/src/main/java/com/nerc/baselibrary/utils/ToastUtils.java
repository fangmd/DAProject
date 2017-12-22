package com.nerc.baselibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Created by double on 16-6-9.
 * Project: WayTone
 */
public class ToastUtils {

    private static Toast sToast;
    private static Toast sLToast;
    private static Toast sCToast;
    private static Toast sCLToast;
    private static Toast sCCToast;

    private static Handler mHandler;

    static {
        mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * - @param text
     */
    public static void showToast(Context context, String text) {
        if (sToast == null) {
            if (context != null) {
                sToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            }
        } else {
            sToast.setText(text);
        }
        mHandler.post(() -> sToast.show());
    }

    /**
     * - @param text
     */
    public static void showLToast(Context context,String text) {
        if (sLToast == null) {
            if (context != null) {
                sLToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG);
            }
        } else {
            sLToast.setText(text);
        }
        mHandler.post(() -> sLToast.show());
    }

    /**
     * - @param context
     * - @param resId
     */
    public static void showToast(Context context,int resId) {
        String text = context.getApplicationContext().getString(resId);
        showToast(context,text);
    }


    /**
     * - @param text
     */
    public static void showCToast(Context context,String text) {
        if (sCToast == null) {
            sCToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
            sCToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            sCToast.setText(text);
        }
        mHandler.post(() -> sCToast.show());
    }

    /**
     * - @param context
     * - @param resId
     */
    public static void showCToast(Context context,int resId) {
        String text = context.getApplicationContext().getString(resId);
        showCToast(context,text);
    }

    /**
     * - 提示字符串
     * - short Toast
     * <p/>
     * - @param context
     * - @param text
     */
    public static void showCLToast(Context context,String text) {
        if (sCLToast == null) {
            sCLToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_LONG);
            sCLToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            sCLToast.setText(text);
        }
        mHandler.post(() -> sCLToast.show());
    }


    /**
     * - 提示根据ResId关联字符串
     * - 时常long   Toast
     * <p/>
     * - @param context
     * - @param resId
     */
    public static void showCLToast(Context context,int resId) {
        String s = context.getApplicationContext().getString(resId);
        showCLToast(context,s);
    }

//    /**
//     * 自定义 Toast
//     *
//     * @param text     要显示的文字
//     * @param layoutId 布局 workId
//     */
//    public static void showCCToast(Context context,String text, int layoutId) {
//        if (sCCToast == null) {
//            View view = LayoutInflater.from(context).inflate(layoutId, null);
//            TextView tvMessage = (TextView) view.findViewById(R.workId.tv_message);
//            tvMessage.setText(text);
//            sCCToast = new Toast(context);
//            sCCToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//            sCCToast.setDuration(Toast.LENGTH_SHORT);
//            sCCToast.setView(view);
//            sCCToast.show();
//        } else {
//            ((TextView) sCCToast.getView().findViewById(R.workId.tv_message)).setText(text);
//        }
//        mHandler.post(() -> sCCToast.show());
//    }
//
//    /**
//     * 自定义 Toast
//     *
//     * @param text     要显示的文字
//     * @param layoutId 布局 workId
//     */
//    public static void showCCAToast(Context context,String text, int layoutId) {
//        if (sCCToast == null) {
//            View view = LayoutInflater.from(context).inflate(layoutId, null);
//            TextView tvMessage = (TextView) view.findViewById(R.workId.tv_message);
//            tvMessage.setText(text);
//            sCCToast = new Toast(context);
//            sCCToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//            sCCToast.setDuration(Toast.LENGTH_SHORT);
//            sCCToast.setView(view);
//            sCCToast.show();
//        } else {
//            ((TextView) sCCToast.getView().findViewById(R.workId.tv_message)).setText(text);
//        }
//        mHandler.post(() -> sCCToast.show());
//    }

}
