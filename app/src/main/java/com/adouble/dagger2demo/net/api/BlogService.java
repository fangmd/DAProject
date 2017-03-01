package com.adouble.dagger2demo.net.api;

import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by double on 2017/1/8.
 */

public interface BlogService {

    @GET("blog/")
    Observable<HttpResponse<Article>> getBlogs();


}
