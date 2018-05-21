package com.adouble.dagger2demo.module.netdemo;

import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:27
 * Description:
 */
public interface NetDemoApi {

    @GET("/12/12")
    Observable<HttpResponse<Article>> getBlogs();
}
