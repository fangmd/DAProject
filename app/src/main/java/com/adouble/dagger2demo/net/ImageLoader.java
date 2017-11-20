package com.nerc.baselibrary.network;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.net.GlideApp;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;


/**
 * Created by nercdevAndroid on 2017/3/14.
 */

public class ImageLoader {

    /**
     * 有 error 和 loading place holder
     *
     * @param context       context 如果是 activity glide 会与其生命周期关联,在 onStop() 中取消加载图片,
     *                      如果想要始终加载图片则需要传入 Application 实例
     * @param imageView     ImageView
     * @param photoFilePath image url
     */
    public static void loadImg(Context context, ImageView imageView, String photoFilePath) {
        loadImg(context, imageView, photoFilePath, R.drawable.load_error);
    }

    public static void loadImg(Context context, ImageView imageView, String photoFilePath, int resId) {
        if (TextUtils.isEmpty(photoFilePath)) {
            imageView.setImageResource(R.drawable.load_error);
            return;
        }

        if (imageView != null) {
            final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, 10000);
            anim.setDuration(800);
            anim.setRepeatCount(ObjectAnimator.INFINITE);
            anim.start();

            GlideApp.with(context)
                    .asBitmap()
                    .load(photoFilePath)
                    .placeholder(R.drawable.place_holder_loading)
                    .listener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                            anim.cancel();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                            anim.cancel();
                            return false;
                        }
                    })
                    .error(resId)
                    .centerCrop()
                    .transition(new BitmapTransitionOptions().crossFade(200))
                    .into(imageView);
        }
    }


    public static void blue(Context context, ImageView imageView, String photoFilePath) {
        if (TextUtils.isEmpty(photoFilePath)) {
            imageView.setImageResource(R.drawable.load_error);
            return;
        }
        if (imageView == null) {
            return;
        }

        GlideApp.with(context).load(photoFilePath)
                .apply(bitmapTransform(new BlurTransformation(80)))
                .placeholder(R.drawable.place_holder_loading)
                .error(android.R.color.white)
                .into(imageView);
    }

    /**
     * 加载圆形头像
     */
    public static void loadRoundImg(Context context, String url, ImageView target) {


        //https://github.com/wasabeef/glide-transformations--glide转换库
        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.place_holder_loading)
                .error(R.drawable.avt_default)
                .circleCrop()
                .transition(new DrawableTransitionOptions().crossFade(1000))//渐显效果
                .into(target);
    }

    /**
     * 加载圆角图片
     */
    public static void loadRoundedCornersImg(Context context, String url, ImageView target) {

        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.place_holder_loading)
                .error(R.drawable.load_error)
                .transform(new RoundedCorners(40))
                .transition(new DrawableTransitionOptions().crossFade(200))//渐显效果
                .into(target);
    }

    /**
     * 加载Gif为一张静态图片
     */
    public static void loadGiftAsBitmap(Context context, String url, ImageView imageView) {
        GlideApp.with(context).asBitmap().load(url).into(imageView);
    }

    /**
     * 清除缓存
     */
    public void clearCache(final Context context) {
        clearMemoryCache(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                clearDiskCache(context);
            }
        }).start();
    }

    /**
     * 清除内存缓存
     */
    public void clearMemoryCache(Context context) {
        GlideApp.get(context).clearMemory();
    }

    /**
     * 清除磁盘缓存
     */
    public void clearDiskCache(Context context) {
        GlideApp.get(context).clearDiskCache();
    }


}
