package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/7.
 */

public class TeacherModel {


    /**
     * ItemID : 448
     * ItemName : lei_teacher
     * ItemImageUrl : http://202.205.161.103:8035/jquery_upload_New/uploadAvatar/upload/13c46757-3f96-41ac-bc28-a5ecc5fe3db3.jpg
     * ItemSourceID : 1963
     * ItemSourceName : 巴南区
     */

    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemName")
    public String name;
    @SerializedName("ItemImageUrl")
    public String imgUrl;
    @SerializedName("ItemSourceID")
    public String sourceId;
    @SerializedName("ItemSourceName")
    public String sourceName;
}
