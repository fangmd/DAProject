package com.adouble.dagger2demo.dagger.base;

import android.app.Application;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.net.NetWorks;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by double on 2017/1/5.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    // Field injections of any dependencies of the DemoApplication
    void inject(App app);


    //    // Exported for child-components. 下面的 对象 可以被子 Compoennt 使用
    Application getContext();

    //    LocationManager getLocationManager();
//
//    ThreadExecutor threadExecutor();   // 线程池
//
    NetWorks getNetworks();
//
//    SPUtils getSpfManager();  // SharedPreference管理类
//
//    DBManager dbManager();  // 数据库管理类

}
