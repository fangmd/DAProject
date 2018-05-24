package com.njfea.baselibrary.utils;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

/**
 * Created by nerc on 2017/9/7.
 */

public class AnimateUtils {

    /**
     * 控制循环动画
     */
    private static boolean mAnimateStop = false;


    public static void rotateTo(View v, float angle) {
        v.animate()
                .rotation(angle)
                .start();
    }

    public static void rotate(View v, float angle) {
        v.animate()
                .rotationBy(angle)
                .start();
    }

    public static void stopAnimate(View v) {
        mAnimateStop = true;
        v.clearAnimation();
        v.animate().cancel();
    }

    public static void scale(View v, float value, Interpolator interpolator, Animator.AnimatorListener listener) {
        ViewPropertyAnimator animate = v.animate();
        animate.scaleX(value)
                .scaleY(value);

        if (interpolator != null) {
            animate.setInterpolator(interpolator);
        }

        animate.setListener(listener);

        animate.start();
    }

    public static void scale(View v, float value, Interpolator interpolator) {
        scale(v, value, interpolator, null);
    }

    public static void scale(View v, float value) {
        scale(v, value, null, null);
    }

    /**
     * 闪烁
     */
    public static void showShiny(View v) {
        showShiny(v, true);
    }

    private static void showShiny(View v, boolean firstTime) {
        if (firstTime) {
            mAnimateStop = false;
        }

        float value = 0.3f;
        if (v.getScaleX() < 1) {
            value = 1;
        }

        ViewPropertyAnimator toSmallAnimator = v.animate()
                .scaleX(value)
                .scaleY(value)
                .setInterpolator(new OvershootInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (mAnimateStop) {
                            return;
                        }
                        showShiny(v, false);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
        toSmallAnimator.start();
    }

}
