package com.nerc.baselibrary.network.api;


import com.nerc.baselibrary.model.FilePostResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by nercdevAndroid on 2017/4/28.
 */

public interface FileUploadApi {

//    @Multipart
//    @POST("Upload/receive")
//    Observable<FileUploadResponse> uploadFile(@Part MultipartBody.Part file, @Part MultipartBody.Part allows);


    // http://202.205.161.103:8035/api/uploader/upload
    @Multipart
    @POST("api/uploader/upload")
    Observable<FilePostResponse> uploadFile(@Part MultipartBody.Part file, @Part MultipartBody.Part allows);


}
