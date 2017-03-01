package com.adouble.dagger2demo.entities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by double on 2017/1/6.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PoetryScope {
}