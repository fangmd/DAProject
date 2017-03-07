package com.fang.common.base.utils.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by double on 2017/1/17.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mTabs;
    private String[] mTabTitles;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Fragment[] tabs, String[] tabTitles) {
        super(fm);
        mTabs = tabs;
        mTabTitles = tabTitles;
    }

    public SimpleFragmentPagerAdapter(FragmentManager fm, Fragment[] tabs) {
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
}
