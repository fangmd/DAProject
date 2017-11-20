package com.adouble.dagger2demo.dagger.simple;

import com.adouble.dagger2demo.dagger.PerActivity;
import com.adouble.dagger2demo.dagger.base.ApplicationComponent;
import com.adouble.dagger2demo.module.simple.SimpleActivity;

import dagger.Component;

/**
 * Created by nerc on 2017/11/20.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {SimplePresenterModule.class})
public interface SimpleComponent {

    void inject(SimpleActivity simpleActivity);
}
