package com.adouble.dagger2demo.dagger.base;

import android.app.Activity;

import com.adouble.dagger2demo.dagger.PerActivity;

import dagger.Component;

/**
 * Created by double on 2017/1/6.
 */

@PerActivity
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();
}