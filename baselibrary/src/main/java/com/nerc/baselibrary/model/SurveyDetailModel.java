package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/8/4.
 */

public class SurveyDetailModel {

    /**
     * {
     * "SurveyName": "社区教育问卷调查",
     * "SurveyNodeList": [
     */

    @SerializedName("SurveyName")
    public String surveyName;
    @SerializedName("SurveyNodeList")
    public List<QuestionItemModel> surveyNodeList;

}
