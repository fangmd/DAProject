package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/10/11.
 */

public class HallDetailModel {


    /**
     * Id : 17
     * ResourceName : 海淀春季运动会
     * ResourceURL : http://202.205.161.103:8035/UploadFile/056a3b72-ef51-4687-ac1c-57c7498defea.mp4
     * BigLectureId : 30
     * ResourceImageURL : http://202.205.161.103:8035/UploadFile/236b052e-eda7-4c4b-ae9c-085f95f3f866.jpg
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("ResourceName")
    public String name;
    @SerializedName("ResourceURL")
    public String url;
    @SerializedName("BigLectureId")
    public String bigLectureId;
    @SerializedName("ResourceImageURL")
    public String imgUrl;
}
