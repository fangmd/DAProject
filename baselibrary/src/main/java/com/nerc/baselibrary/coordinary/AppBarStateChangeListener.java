package com.nerc.baselibrary.coordinary;

import android.support.design.widget.AppBarLayout;

/**
 * Created by nerc on 2017/8/7.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    private int mLastI;

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    private State mCurrentState = State.IDLE;

    @Override
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.IDLE) {
                onStateChanged(appBarLayout, State.IDLE);
            }
            mCurrentState = State.IDLE;
        }

        if (Math.abs(mLastI - i) > 0.05) {
            onStateChanged(appBarLayout, mCurrentState, i);
            mLastI = i;
        }

    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state, int i);
}