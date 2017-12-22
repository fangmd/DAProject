package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleMemberModel
 * Created by nerc on 2017/10/25.
 */

public class CircleMemberModel {

    /**
     * RowIndex : 1
     * workId : 218
     * GroupId : 20
     * userName : admin
     * trueName : 管理员
     * UserImage : http://202.205.161.103:8035/UploadFile/images/unknown.jpg
     * CreateDate : 2017-10-25T09:50:32
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("workId")
    public String id;
    @SerializedName("GroupId")
    public String groupId;
    @SerializedName("userName")
    public String userName;
    @SerializedName("trueName")
    public String trueName;
    @SerializedName("UserImage")
    public String img;
    @SerializedName("CreateDate")
    public String createDate;
}
