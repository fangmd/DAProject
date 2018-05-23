package com.njfae.xwebview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Author: Created by fangmingdong on 2018/4/25-下午1:47
 * Description: 网页加载失败显示 View
 */
public class ErrorView extends FrameLayout implements View.OnClickListener {


    public ErrorView(@NonNull Context context) {
        this(context, null);
    }

    public ErrorView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ErrorView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.error_layout, this, true);
        View view = findViewById(R.id.tv_error_reload);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mErrorViewListener != null) {
            mErrorViewListener.onReloadClick();
        }
    }

    private ErrorViewListener mErrorViewListener;

    public ErrorViewListener getErrorViewListener() {
        return mErrorViewListener;
    }

    public void setErrorViewListener(ErrorViewListener errorViewListener) {
        mErrorViewListener = errorViewListener;
    }

    public interface ErrorViewListener {
        void onReloadClick();
    }
}
