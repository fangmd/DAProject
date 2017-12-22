package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * 积分历史记录
 * Created by nerc on 2017/11/21.
 */

public class IntegralModel {



    /**
     * RowIndex : 1
     * Id : 10
     * UserId : 505
     * CreditStyle : 1
     * UserCreditDesc : 参与活动(学生选课)获取20分
     * OperateDate : 2017-10-24T15:57:13.147
     * CreditCount : 20
     * CreditAll : 280
     * CreditReal : 230
     * Style : 0
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("UserId")
    public String userId;
    @SerializedName("CreditStyle")
    public String creditStyle;
    @SerializedName("UserCreditDesc")
    public String userCreditDesc;
    @SerializedName("OperateDate")
    public String date;
    @SerializedName("CreditCount")
    public int cnt;
    @SerializedName("CreditAll")
    public int all;
    @SerializedName("CreditReal")
    public int real;
    @SerializedName("Style")
    public String style;
}
