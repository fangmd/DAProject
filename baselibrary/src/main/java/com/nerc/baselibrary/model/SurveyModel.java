package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/4.
 */

public class SurveyModel {


    /**
     * workId : 2
     * SurveyName : APP社区教育版功能使用调查
     * SurveyContent : APP社区教育版功能使用调查
     * BeginDate : 2017-07-24T00:00:00
     * EndDate : 2017-09-30T00:00:00
     */

    @SerializedName(value = "workId", alternate = "id")
    public String id;
    @SerializedName("SurveyName")
    public String surveyName;
    @SerializedName("SurveyContent")
    public String surveyContent;
    @SerializedName("BeginDate")
    public String beginDate;
    @SerializedName("EndDate")
    public String endDate;
}
