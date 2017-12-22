package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CompetitionWorkTypeModel
 * Created by nerc on 2017/10/17.
 */

public class CompetitionWorkTypeModel {

    /**
     * Id : -1
     * ActivityId : -1
     * TypeName : 全部
     */

    @SerializedName("Id")
    public String id;
    @SerializedName("ActivityId")
    public String activityId;
    @SerializedName("TypeName")
    public String typeName;
}
