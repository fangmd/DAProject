package com.adouble.dagger2demo.module.layout.mine;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.monkey.SimpleTextAdapter;
import com.nerc.baselibrary.base.BaseActivity;
import com.nerc.baselibrary.utils.LoggerUtils;

import butterknife.BindView;

public class YoudaoActivity extends BaseActivity {

    @BindView(R.id.toolbar_youdao)
    Toolbar mToolbar;
    @BindView(R.id.appbar_youdao)
    AppBarLayout mAppbar;
    @BindView(R.id.coordinator_youdao)
    CoordinatorLayout mCoordinator;
    @BindView(R.id.rv_youdao)
    RecyclerView mRv;
    @BindView(R.id.fab_youdao)
    FloatingActionButton mFab;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_edit)
    TextView mToolbarEdit;
    @BindView(R.id.collapsing_youdao)
    CollapsingToolbarLayout mCollapsing;
    @BindView(R.id.iv_toolbar)
    ImageView mIvToolbar;

    public static void start(Context context) {
        Intent starter = new Intent(context, YoudaoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.youdao_activity;
    }

    @Override
    protected void init() {

        mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            private float mLastOffsetPercent;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float density = getResources().getDisplayMetrics().density;
                LoggerUtils.d(TAG, "onOffsetChanged: " + verticalOffset + " density:" + density);
                int height = mCollapsing.getHeight();
//                Log.d(TAG, "onOffsetChanged: " + height);


                float offsetPercent = 1 - ((float) (Math.abs(verticalOffset) / density) / 60);

                if (offsetPercent == mLastOffsetPercent) {
                    return;
                }

                // title
                float dimension = 26; // getResources().getDimension(R.dimen.text_title);
                float minDimension = 18;
                mToolbarTitle.setTextSize(minDimension + (dimension - minDimension) * offsetPercent);

                RelativeLayout.LayoutParams lp = ((RelativeLayout.LayoutParams) mToolbarTitle.getLayoutParams());
                int marginTop = ((int) ((30 - 20) * density * offsetPercent));
                lp.setMargins(0, marginTop, 0, 0);
                mToolbarTitle.setLayoutParams(lp);
                //

                // edit
                if (offsetPercent <= 0.1) {
                    mToolbarEdit.setVisibility(View.GONE);
                } else {
                    mToolbarEdit.setVisibility(View.VISIBLE);
                }
                mToolbarEdit.setAlpha(offsetPercent);

                // toolbar
                ViewGroup.LayoutParams toolbarLP = mToolbar.getLayoutParams();
                int toolbarHeight = ((int) ((80 + (110 - 80) * offsetPercent) * density));
                toolbarLP.height = toolbarHeight;
                mToolbar.setLayoutParams(toolbarLP);

                //ImageView
                mIvToolbar.setScaleX(offsetPercent);
                mIvToolbar.setScaleY(offsetPercent);
                mIvToolbar.setAlpha(offsetPercent);


                LoggerUtils.d(TAG, "onOffsetChanged: offsetPercent" + offsetPercent +
                        "title size:" + dimension + " percent:" + dimension * offsetPercent);
                mLastOffsetPercent = offsetPercent;
            }
        });


        initRV();
    }

    private void initRV() {
        SimpleTextAdapter simpleTextAdapter = new SimpleTextAdapter();
        mRv.setAdapter(simpleTextAdapter);
    }

}
