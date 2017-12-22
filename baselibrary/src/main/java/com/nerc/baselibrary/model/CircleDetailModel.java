package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;
import com.nerc.baselibrary.AppConstants;

/**
 * CircleDetailModel
 * Created by nerc on 2017/10/25.
 */

public class CircleDetailModel {
    /**
     * Id : 20
     * Title : 摄影爱好
     * menber : 3
     * Logo : http://202.205.161.103:8035/UploadFile/457357c0-d1d8-4284-8548-09b6af4a30a0.jpg
     * Introduction : 摄影爱好者的聚集地
     * USTATE : 1
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("menber")
    public int menber;
    @SerializedName("Logo")
    public String img;
    @SerializedName("Introduction")
    public String introduction;
    /**
     * USTATE说明：
     * 1表示当前用户已经加入该圈子并审核通过；
     * 0表示当前用户已申请加入圈子，等待审核中…；
     * NULL表示当前用户未加入圈子（加入按钮可根据该字段判断该进行何种操作）
     * {@link AppConstants.CircleUserState}
     */
    @SerializedName("USTATE")
    public String uState;
    @SerializedName("IsLeader")
    public int isLeader;
    @SerializedName("userName")
    public String userName;
    @SerializedName("trueName")
    public String trueName;
}
