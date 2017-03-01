package com.adouble.dagger2demo.entities;

import javax.inject.Inject;

/**
 * Created by double on 2017/1/6.
 */

public class Poetry {
    public String mPoetry;

    @Inject
    public Poetry() {
        mPoetry = "live is short";
    }

    public Poetry(String poetry) {
        mPoetry = poetry;
    }
}
