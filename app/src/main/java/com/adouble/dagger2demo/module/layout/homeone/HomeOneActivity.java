package com.adouble.dagger2demo.module.layout.homeone;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.module.layout.homeone.home.HomeFragment;
import com.adouble.dagger2demo.module.layout.homeone.invest.InvestFragment;
import com.adouble.dagger2demo.module.layout.homeone.my.MyFragment;
import com.njfea.baselibrary.adapter.SimpleFragmentPagerAdapter;
import com.njfea.baselibrary.base.BaseActivity;
import com.njfea.baselibrary.widgets.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author: Created by fangmingdong on -上午10:19
 * Description: 首页例子：Tab + ViewPager + Fragment + LazyLoad
 */
public class HomeOneActivity extends BaseActivity {

    @BindView(R.id.vp_home_one)
    NoScrollViewPager mVpHomeOne;
    @BindView(R.id.iv_tab_home)
    ImageView mIvTabHome;
    @BindView(R.id.iv_tab_invest)
    ImageView mIvTabInvest;
    @BindView(R.id.iv_tab_my)
    ImageView mIvTabMy;
    private ArrayList<ImageView> mIvTabs;

    public static void start(Context context) {
        Intent starter = new Intent(context, HomeOneActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_one_activity;
    }

    @Override
    protected void init() {
        initViewPager();
        initTabView();

        showLoadingDialog();
    }

    private void initViewPager() {
        Fragment[] tabs = new Fragment[3];
        tabs[0] = HomeFragment.newInstance();
        tabs[1] = InvestFragment.newInstance();
        tabs[2] = MyFragment.newInstance();
        String[] tabtitles = new String[3];
        tabtitles[0] = getString(R.string.home_title);
        tabtitles[1] = getString(R.string.invest_title);
        tabtitles[2] = getString(R.string.my_title);
        mVpHomeOne.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(), tabs, tabtitles));
    }

    private void initTabView() {
        mIvTabs = new ArrayList<>();
        mIvTabs.add(mIvTabHome);
        mIvTabs.add(mIvTabInvest);
        mIvTabs.add(mIvTabMy);

        setSelect(0);
    }

    @OnClick({R.id.fl_tab_home, R.id.fl_tab_invest, R.id.fl_tab_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_tab_home:
                setSelect(0);
                break;
            case R.id.fl_tab_invest:
                setSelect(1);
                break;
            case R.id.fl_tab_my:
                setSelect(2);
                break;
        }
    }

    private void setSelect(int position) {
        updateUI(position);
        mVpHomeOne.setCurrentItem(position, false);
    }

    private void updateUI(int position) {
        for (ImageView ivTab : mIvTabs) {
            ivTab.setSelected(false);
        }
        mIvTabs.get(position).setSelected(true);
    }
}
