package com.fangmingdong.imagelib;

import android.graphics.Bitmap;

/**
 * 图片下载监听
 * Created by double on 2018/4/8.
 */

public interface IImageDownloadListener {

    void downloadSuccess(Bitmap bitmap);

    void downloadFail();
}
