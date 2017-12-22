package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/8/9.
 */

public class ResCategoryModel {


    /**
     * zhangID : 1190
     * zhangname : 与梦想同行之草原之行
     * jielist : []
     * zuoyelist : []
     * testlist : []
     */

    @SerializedName("zhangID")
    public String id;
    @SerializedName("zhangname")
    public String name;
    @SerializedName("jielist")
    public List<ResourceModel> resList;
    @SerializedName("zuoyelist")
    public List<HomeworkModel> homeworks;
    @SerializedName("testlist")
    public List<TestModel> tests;

}
