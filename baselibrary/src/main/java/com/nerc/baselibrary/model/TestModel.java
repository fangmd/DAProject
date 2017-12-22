package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/9.
 */

public class TestModel {

    /**
     * testID : d2892a96-3888-4584-8ad2-9c4ee3c85e02
     * testname : 如何识破旅游“陷阱
     * ExamTime : 2017/5/22 23:59:59
     */

    @SerializedName("testID")
    public String id;
    @SerializedName("testname")
    public String name;
    @SerializedName("ExamTime")
    public String examTime;

    // 增加一个参数用于获取试卷详情
    public String zhangId;
}
