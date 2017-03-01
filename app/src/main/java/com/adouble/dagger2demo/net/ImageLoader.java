package com.adouble.dagger2demo.net;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.adouble.dagger2demo.AppConstants;
import com.adouble.dagger2demo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by double on 2017/1/13.
 */

public class ImageLoader {


    /**
     * 有 error 和 loading place holder
     * @param context context
     * @param imageView ImageView
     * @param photoFilePath image url
     */
    public static void loadPhoto(Context context, ImageView imageView, String photoFilePath) {

        if (imageView != null && !TextUtils.isEmpty(photoFilePath)) {

            final ObjectAnimator anim = ObjectAnimator.ofInt(imageView, "ImageLevel", 0, AppConstants.MAX_LEVEL);
            anim.setDuration(800);
            anim.setRepeatCount(ObjectAnimator.INFINITE);
            anim.start();

            Glide.with(context)
                    .load(photoFilePath)
                    .placeholder(R.drawable.place_holder_loading)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            anim.cancel();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            anim.cancel();
                            return false;
                        }
                    })
                    .error(R.drawable.place_holder_error_ic)
                    .into(imageView);
        }
    }


    public static void loadPhoto(Context context, ImageView photoImg, int resourceId) {
//        Glide.with(context).load(resourceId).into(photoImg);
        photoImg.setImageDrawable(context.getResources().getDrawable(resourceId));
    }


}
