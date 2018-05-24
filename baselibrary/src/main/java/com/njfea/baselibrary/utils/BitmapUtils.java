package com.njfea.baselibrary.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import javax.annotation.Nonnull;

/**
 * Created by nerc on 2017/11/20.
 */

public class BitmapUtils {

    public static Bitmap createBitmap(View v) {
        Bitmap b = Bitmap.createBitmap(v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        v.draw(c);
        return b;
    }


    public static Bitmap combineImages(@Nonnull Bitmap topBitmap, @Nonnull Bitmap bottomBitmap) {
        Bitmap cs = null;

        int width = Math.max(topBitmap.getWidth(), bottomBitmap.getWidth());
        int height = topBitmap.getHeight() + bottomBitmap.getHeight();

        cs = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas comboImage = new Canvas(cs);

        comboImage.drawBitmap(topBitmap, 0f, 0f, null);
        comboImage.drawBitmap(bottomBitmap, 0f, topBitmap.getHeight(), null);

        return cs;
    }


}
