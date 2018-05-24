package com.njfea.baselibrary.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.njfea.baselibrary.AppConstants;
import com.njfea.baselibrary.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by nerc on 2017/9/7.
 */

public class ShareUtils {

    public static void shareBitmap(Activity activity, UMShareListener listener, Bitmap bitmap,
                                   String title,
                                   String introduce) {
        UMImage thumb = new UMImage(activity, R.mipmap.ic_launcher);

        UMImage umImage = new UMImage(activity, bitmap);
        umImage.setTitle(title);
        umImage.setThumb(thumb);
        umImage.setDescription(introduce);

        new ShareAction(activity)
                .withMedia(umImage)
                .setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA, SHARE_MEDIA.QQ)
                .setCallback(listener).open();
    }

    public static void shareWork(Activity activity, UMShareListener listener, String type,
                                 String id,
                                 String title,
                                 String introduce) {
        // http://202.205.161.103:8040/WorkInfoDetails.aspx?type=1&id=15
        String shareUrl = AppConstants.Api.WEB_URL + "WorkInfoDetails.aspx?type=" + type + "&id=" + id;
        share(activity, listener, title, introduce, shareUrl);
    }

    private static void share(Activity activity, UMShareListener listener, String title, String introduce, String shareUrl) {
        UMWeb web = new UMWeb(shareUrl);
        UMImage thumb = new UMImage(activity, R.mipmap.ic_launcher);
        web.setTitle(title);//标题
        web.setThumb(thumb);  //缩略图
        web.setDescription(introduce);//描述

        new ShareAction(activity)
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA, SHARE_MEDIA.QQ)
                .setCallback(listener).open();
    }

    public static void shareCourse(Activity activity, UMShareListener listener, String url, String courseId, String courseName,
                                   String courseDesc) {

        // mCourseId
        // mCourseImgUrl
        // http://202.205.161.103:9179/web/CourseDetail.aspx?courseId=571
        String shareUrl = AppConstants.Api.WEB_URL + "web/CourseDetail.aspx?courseId=" + courseId;

        share(activity, listener, courseName, courseDesc, shareUrl);
    }


    public static String getServerFromUrl(String url) {
        String ret = "";
        if (TextUtils.isEmpty(url)) {
            return ret;
        }

        try {
            int i = url.indexOf("/", 7);

            ret = url.substring(0, i);
        } catch (Exception e) {
            LoggerUtils.e("image url get server fail:" + url);
        }
        return ret;
    }
}
