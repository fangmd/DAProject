package com.adouble.dagger2demo.dagger.main;

import com.adouble.dagger2demo.dagger.PerActivity;
import com.adouble.dagger2demo.dagger.base.ActivityComponent;
import com.adouble.dagger2demo.dagger.base.ActivityModule;
import com.adouble.dagger2demo.dagger.base.ApplicationComponent;
import com.adouble.dagger2demo.module.main.MainActivity;

import dagger.Component;

/**
 * MainComponent继承了ActivityComponent，假如ActivityComponent中定义了创建类实例方法，则MainComponent中必须提供@Inject或@Provides对应的
 * 初始化类实例的方法
 * Created by double on 2017/1/6.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, MainPresenterModule.class})
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity mainActivity);


//    MainFragmentComponent mainFragmentComponent();

}
