package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * 积分规则 model
 * Created by nerc on 2017/11/21.
 */

public class IntegralRuleModel {


    /**
     * Id : 5
     * RuleName : 参与活动(学生选课)
     * RuleDesc : 注册用户每成功选课一次，将获得一次积分奖励。
     * RulePoint : 20
     * State : 1
     * OpenState : 1
     * CreateDate : 2017-10-24T14:56:46
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("RuleName")
    public String name;
    @SerializedName("RuleDesc")
    public String desc;
    @SerializedName("RulePoint")
    public int point;
    @SerializedName("State")
    public String state;
    @SerializedName("OpenState")
    public String openState;
    @SerializedName("CreateDate")
    public String createDate;


}
