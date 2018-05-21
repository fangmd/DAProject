package com.nerc.baselibrary.manager;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Created by fangmingdong on 2018/5/21-上午11:45
 * Description:
 */
public class ActivityManager {


    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        return Holder.sInstance;
    }

    private static class Holder {
        public static final ActivityManager sInstance = new ActivityManager();
    }

    private List<Activity> mActivities = new ArrayList<>();

    public void add(Activity activity) {
        mActivities.add(activity);
    }

    public void remove(Activity activity) {
        mActivities.remove(activity);
    }

    public void exit() {
        for (Activity activity : mActivities) {
            activity.finish();
        }
    }

}
