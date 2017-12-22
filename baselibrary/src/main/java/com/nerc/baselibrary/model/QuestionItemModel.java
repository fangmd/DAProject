package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 问题类
 * Created by nerc on 2017/8/4.
 */

public class QuestionItemModel {

    /**
     * SurveyNodeID : 1
     * NodeName : 您对社区教育是否了解？
     * NodeType : 1
     * OptionsList : [{"OptionsID":2,"NodeName":"非常了解","Pct":50,"OptionsCount":1},{"OptionsID":3,"NodeName":"一般了解","Pct":50,"OptionsCount":1},{"OptionsID":4,"NodeName":"不了解","Pct":0,"OptionsCount":0}]
     */

    @SerializedName("SurveyNodeID")
    public String surveyNodeID;
    @SerializedName("NodeName")
    public String nodeName;
    @SerializedName("NodeType")
    public int nodeType;    // 1为单选题  2为多选题
    @SerializedName("OptionsList")
    public List<OptionsListBean> optionsList;

    /**
     * 记录简答题用户回答
     */
    public String userShortAnswer;

    public static class OptionsListBean {
        /**
         * OptionsID : 2
         * NodeName : 非常了解
         * Pct : 50
         * OptionsCount : 1
         */

        @SerializedName("OptionsID")
        public String optionsID;
        @SerializedName("NodeName")
        public String nodeName;
        @SerializedName("Pct")
        public int pct;
        @SerializedName("OptionsCount")
        public int optionsCount;

        /**
         * 记录用户是否选择
         *
         * 用于选择题
         */
        public boolean userChecked;



        
    }
}
