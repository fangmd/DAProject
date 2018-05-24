//package com.nerc.baselibrary.br;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//
//import com.nerc.baselibrary.TinkerAppLike;
//import com.nerc.baselibrary.AppConstants;
//import com.nerc.baselibrary.utils.LoggerUtils;
//import com.nerc.baselibrary.utils.NetUtils;
//
//import zlc.season.rxdownload3.RxDownload;
//
///**
// * 用于处理下载过程中网络变化
// * <p>
// * Created by nercdevAndroid on 2017/5/10.
// */
//
//public class NetWorkStateReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//
//        if (NetUtils.getAPNType(context) == 1) {
//            // wifi
//            if (TinkerAppLike.getInstance().mAutoStart) {
//                RxDownload.INSTANCE.startAll();
//                LoggerUtils.d(AppConstants.Tag.DOWNLOAD, "Wifi connect , start download");
//                TinkerAppLike.getInstance().mAutoStart = false;
//            } else {
////                LoggerUtils.d(AppConstants.Tag.DOWNLOAD, "Wifi connect , auto Start is false");
//            }
//        }
//
//        if (NetUtils.getAPNType(context) != 1) {
//            // stop all download, not wifi
//            TinkerAppLike.getInstance().mAutoStart = true;
//            RxDownload.INSTANCE.stopAll();
//            LoggerUtils.d(AppConstants.Tag.DOWNLOAD, "Wifi lost , stop download, set auto start = true");
//        }
//
//        // start all auto stopped download
//        //TODO： 如果是用户自己停止的不应该开始下载
//        //LoggerUtils.d(AppConstants.Tag.DOWNLOAD, "Wifi connect , start download");
//    }
//}