package com.adouble.dagger2demo.entities;

import dagger.Module;
import dagger.Provides;

/**
 * Created by double on 2017/1/6.
 */

@Module
public class PoetryModule {


//    @PoetryScope
    @Provides
    Poetry providePoetry(String poetry){
        return new Poetry(poetry);
    }

    // 这里提供了一个生成String的方法，在这个Module里生成Poetry实例时，会查找到这里
    // 可以为上面提供String类型的参数
    @Provides
    public String providePoems(){
        return "只有意志坚强的人，才能到达彼岸";
    }
}
