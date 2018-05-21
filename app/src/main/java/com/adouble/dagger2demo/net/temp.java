package com.adouble.dagger2demo.net;

import com.adouble.dagger2demo.entities.Article;
import com.adouble.dagger2demo.entities.HttpResponse;
import com.adouble.dagger2demo.net.api.BlogService;
import com.nerc.baselibrary.network.RxService;

import io.reactivex.Observable;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午2:47
 * Description:
 */
public class temp {

    public void getApi() {
        Observable<HttpResponse<Article>> observable = RxService.createApi(BlogService.class).getBlogs();
        
    }
}
