package com.njfea.baselibrary.widgets.wrapcontentviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * WrapContentFragmentPagerAdapter
 * <p>
 * 需要配合 {@link WrapContentViewPager} 使用
 * Created by nercdev on 2017/1/17.
 */

public class WrapContentFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mTabs;
    private String[] mTabTitles;
    private int mCurrentPosition = -1;

    public WrapContentFragmentPagerAdapter(FragmentManager fm, Fragment[] tabs, String[] tabtitles) {
        super(fm);
        mTabs = tabs;
        mTabTitles = tabtitles;
    }

    public WrapContentFragmentPagerAdapter(FragmentManager fm, Fragment[] tabs) {
        super(fm);
        mTabs = tabs;
        mTabTitles = new String[tabs.length];
    }

    @Override
    public Fragment getItem(int position) {
        return mTabs[position];
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }

    public void clear() {
        mTabs = new Fragment[0];
        mTabTitles = new String[0];
        notifyDataSetChanged();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            WrapContentViewPager pager = (WrapContentViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }

}
