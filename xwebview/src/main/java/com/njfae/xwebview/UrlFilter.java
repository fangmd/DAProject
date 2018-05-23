//package com.njfae.xwebview;
//
//import android.app.ActivityManager;
//import android.content.Intent;
//import android.net.Uri;
//import android.text.TextUtils;
//
///**
// * Author: Created by fangmingdong on 2018/4/25-下午6:34
// * Description: 网页 URL 拦截类
// */
//public class UrlFilter {
//
//    /**
//     * 拦截网页加载的 URL
//     *
//     * @param url url
//     * @return true: 表示拦截，false：不拦截
//     */
//    public static boolean dealUrl(String url) {
//        if (TextUtils.isEmpty(url)) {
//            return false;
//        }
//
//        if (url.startsWith("tel:")) {
//            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
//            ActivityManager.getScreenManager().currentActivity().startActivity(intent);
//            return true;
//        }
//        return false;
//    }
//}
