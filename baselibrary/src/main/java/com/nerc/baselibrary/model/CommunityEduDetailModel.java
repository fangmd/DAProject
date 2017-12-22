package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CommunityEduDetailModel
 * Created by nerc on 2017/11/14.
 */

public class CommunityEduDetailModel {

    /**
     * workId : 5537
     * schoolName : 金星
     * parentId : 5534
     * Background :
     * info : 朝阳区位于北京市的东部，西与东城区、丰台区、海淀区相毗邻，北连昌平区、顺义区，东与通州区接壤，南与大兴区相邻，全区面积470.8平方公里，平均海拔34米，是北京市城近郊区
     */

    @SerializedName("workId")
    public String id;
    @SerializedName("schoolName")
    public String name;
    @SerializedName("parentId")
    public String parentId;
    @SerializedName("Background")
    public String background;
    @SerializedName("info")
    public String info;
}
