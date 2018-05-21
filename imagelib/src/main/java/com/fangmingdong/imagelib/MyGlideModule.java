package com.fangmingdong.imagelib;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.fangmingdong.imagelib.progress.ProgressInterceptor;
import com.fangmingdong.imagelib.utils.Utils;

import java.io.InputStream;

import okhttp3.OkHttpClient;


/**
 * Glide 配置类
 * Created by double on 2017/8/1.
 */

@GlideModule
public class MyGlideModule extends AppGlideModule {

    /**
     * 图片缓存地址
     * sdcard/imgCache
     * or
     * 应用文件夹 外部文件夹 sdcard/Android/data/<application package>/cache/imgCache
     * 应用文件夹 内部文件夹 /data/data/<application package>/cache/imgCache
     */
    public static final String CACHE_FILE_NAME = "imgCache";

    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {

        // 内存缓存相关,默认是24m
        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));

        // 设置磁盘缓存及其路径
        int MAX_CACHE_SIZE = 100 * 1024 * 1024;

        // 应用文件夹，外部或者内部(优先使用外部，首次使用内部以后都会使用内部)
        builder.setDiskCache(new ExternalPreferredCacheDiskCacheFactory(context, CACHE_FILE_NAME, MAX_CACHE_SIZE));
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) && Utils.checkWriteExternalPermission(context)) {
            // 有 sdCard 并且有 读写权限的时候
            // 路径---->sdcard/imgCache
            String downloadDirectoryPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" +
                    CACHE_FILE_NAME;
            builder.setDiskCache(new DiskLruCacheFactory(downloadDirectoryPath, MAX_CACHE_SIZE));
        }
    }

    /**
     * 把 glide 默认的网络请求方式换成 okhttp
     */
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        //添加拦截器到Glide
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new ProgressInterceptor());
        OkHttpClient okHttpClient = builder.build();

        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));
    }

    /**
     * false: 不使用清单配置的方式,减少初始化时间
     */
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}