package com.nerc.baselibrary.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by nerc on 2017/8/7.
 */

public class NoScrollViewPager extends ViewPager {

    public boolean isCanScroll = false;

    public NoScrollViewPager(Context context) {
        this(context, null);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCanScroll(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

    //第一种
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!isCanScroll) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isCanScroll) {
            return false;
        }
        return super.onInterceptHoverEvent(event);
    }

//    //第二种
//    @Override
//    public void scrollTo(int x, int y) {
//        if (isCanScroll) {
//            super.scrollTo(x, y);
//        }
//    }


}
