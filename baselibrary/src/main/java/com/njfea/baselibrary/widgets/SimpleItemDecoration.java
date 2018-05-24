package com.njfea.baselibrary.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.njfea.baselibrary.R;
import com.njfea.baselibrary.utils.ScreenUtils;

/**
 * Created by nerc on 2017/8/2.
 */

public class SimpleItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int mLrOffset;

    public SimpleItemDecoration(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.line_divider);
    }

    public SimpleItemDecoration(Context context, int lrOffset) {
        mDivider = context.getResources().getDrawable(R.drawable.line_divider);
        mLrOffset = lrOffset;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int left = parent.getPaddingLeft() + ScreenUtils.dp2pxMin(parent.getContext(), mLrOffset);
        int right = parent.getWidth() - parent.getPaddingRight() - ScreenUtils.dp2pxMin(parent.getContext(), mLrOffset);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

//    @Override
//    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
//        int i = ScreenUtils.dp2px(view.getContext(), 1);
//        int leftOffset = ScreenUtils.dp2px(view.getContext(), mLrOffset);
//        outRect.set(leftOffset, i, leftOffset, 0);
//    }
}
