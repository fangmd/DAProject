package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionInfoEntity {
    private String questionId;
    private String questionTitle;
    private String questionType;    // 1 2 6 , 3  , 0: 简答题
    private String questionCategory;
    private String questionResolving;
    private List<ObjectEntity> objList;
    private String questionNum;
    private String questionAnswers;

    /**
     * 选择题答案
     */
    private List<String> questionUserAnswers;
    /**
     * 问答题答案
     */
    private String userAnwer;

    /**
     * 填空题，空格数
     */
    public int ItemOptionsCount;

    /**
     * 组合题，子题
     */
    public List<MultipleQuestionEntity.ItemSonsBean> itemSons;

    /**
     * 填空题 ItemOptions
     */
    public List<MultipleQuestionEntity.ItemSonsBean.ItemOptionsBean> itemOptionsBeen;

    /**
     * 填空题 答案
     */
    public List<ItemAnswerBean> itemAnswerBeen;

    /**
     * 用于简答题的分数显示在 回答 的地方
     */
    public String shortAnswerScore = "";


    public static class ItemAnswerBean {
        /**
         * {
         ”AnswerId”:”用户答案id”，
         ”Answer”:” 标准答案内容”
         ”QuestionId”:”问题id”
         }
         *
         */

        @SerializedName(value = "AnswerId", alternate = "Id")
        public String AnswerId;
        @SerializedName("Answer")
        public String Answer;
        @SerializedName("QuestionId")
        public String QuestionId;


    }



    public String getUserAnwer() {
        return userAnwer;
    }

    public void setUserAnwer(String userAnwer) {
        this.userAnwer = userAnwer;
    }

    public String getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(String questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public List<String> getQuestionUserAnswers() {
        return questionUserAnswers;
    }

    public void setQuestionUserAnswers(List<String> questionUserAnswers) {
        this.questionUserAnswers = questionUserAnswers;
    }

    public String getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(String questionNum) {
        this.questionNum = questionNum;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public String getQuestionResolving() {
        return questionResolving;
    }

    public void setQuestionResolving(String questionResolving) {
        this.questionResolving = questionResolving;
    }

    public List<ObjectEntity> getObjList() {
        return objList;
    }

    public void setObjList(List<ObjectEntity> objList) {
        this.objList = objList;
    }

    private String questionRight;

    public String getQuestionRight() {
        return questionRight;
    }

    public void setQuestionRight(String questionRight) {
        this.questionRight = questionRight;
    }

    private String questionIdRight;

    public String getQuestionIdRight() {
        return questionIdRight;
    }

    public void setQuestionIdRight(String questionIdRight) {
        this.questionIdRight = questionIdRight;
    }

}