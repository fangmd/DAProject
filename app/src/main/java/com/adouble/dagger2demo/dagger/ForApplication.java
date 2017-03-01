package com.adouble.dagger2demo.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by double on 2017/1/5.
 */
@Qualifier @Retention(RetentionPolicy.RUNTIME)
public @interface ForApplication {

}
