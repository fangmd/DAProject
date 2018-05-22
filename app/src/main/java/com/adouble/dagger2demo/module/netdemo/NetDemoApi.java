package com.adouble.dagger2demo.module.netdemo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * Author: Created by fangmingdong on 2018/5/21-下午3:27
 * Description:
 */
public interface NetDemoApi {


    @GET("http://ip.taobao.com/service/getIpInfo.php?ip=117.89.35.58")
    Observable<ResponseBody> getBlog();

}
