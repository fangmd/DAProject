package com.njfea.baselibrary.recyclerview.simpleloadmore.loadmoreview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.njfea.baselibrary.R;
import com.njfea.baselibrary.recyclerview.simpleloadmore.LoadMoreViewImpl;

/**
 * Created by nerc on 2017/8/3.
 */

public class SimpleLoadMoreView extends FrameLayout implements LoadMoreViewImpl{


    private ProgressBar mPB;
    private TextView mTvNoMore;

    public SimpleLoadMoreView(@NonNull Context context) {
        this(context, null);
    }

    public SimpleLoadMoreView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public SimpleLoadMoreView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.simple_load_more_view, this);

        mPB = findViewById(R.id.progress_view_simple_load_more);
        mTvNoMore = findViewById(R.id.tv_simple_load_more);

    }

    @Override
    public void setLoading(boolean loading) {
        if (loading) {
            mPB.setVisibility(VISIBLE);
            mTvNoMore.setVisibility(INVISIBLE);
        }else{
            mPB.setVisibility(INVISIBLE);
        }
    }

    @Override
    public void setNoMore() {
        mPB.setVisibility(INVISIBLE);
        mTvNoMore.setVisibility(VISIBLE);
    }
}
