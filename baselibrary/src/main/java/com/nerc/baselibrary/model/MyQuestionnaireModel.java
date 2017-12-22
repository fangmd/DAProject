package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * MyQuestionnaireModel
 * Created by nerc on 2017/10/23.
 */

public class MyQuestionnaireModel {

    /**
     * RowIndex : 1
     * workId : 3
     * SurveyName : 满意度调查0817
     * ItemSEDate : 2017.09.15
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("workId")
    public String id;
    @SerializedName("SurveyName")
    public String name;
    @SerializedName("ItemSEDate")
    public String sEDate;
}
