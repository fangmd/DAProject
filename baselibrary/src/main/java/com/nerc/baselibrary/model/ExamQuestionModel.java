package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/10/20.
 */

public class ExamQuestionModel {

    /**
     *
     * 简答题 题目
     * {
     RowIndex: 1,
     ItemID: "3f4e2a54-afeb-4bc1-bf33-bea8511a747d",
     ItemTitle: "在旅行途中，注意理性消费。遇到强制购物情况，无论是现金还是刷卡，都要注意保存购物小票，这样在物品出现问题时会有消费保障。",
     ItemCategory: ",怎样识别低价旅游团陷阱,",
     ItemResolving: ""
     }

     简答包含答案：
     {
     RowIndex: 1,
     ItemID: "864ca8c4-1fc9-41ef-90e9-fb7de448858a",
     ItemTitle: "在旅行途中，注意理性消费。遇到强制购物情况，无论是现金还是刷卡，都要注意保存购物小票，这样在物品出现问题时会有消费保障。",
     ItemCategory: ",怎样识别低价旅游团陷阱,",
     ItemResolving: "网上秒杀低价游。一些旅行团会通过App平台推出显示低价秒杀，并不是全都不可信，但有一些存在消费陷阱。注意看好商家消息通知里的旅行线路价格是否合理，往返飞机票是否包含在内，预订酒店及用餐标准。 签订履行合同时，要将合同中的各项条约看清楚，旅行社重要的口头承诺也必须要在合同中体现。看清合同中是否有强制消费购物情况，是否包含旅游人身意外险，警惕“霸王条款”",
     UserAnswer: "high",
     ItemScore: "10"
     }

     */



    /**
     * ItemID : eec095d6-5e2c-4b79-8e06-6f77defe4b7d
     * ItemTitle : 十年前，有一本书叫《叫我如何不宰你》，是一位资深导游写的，现在从没旅游过的人不存在吧，旅游过的人对他书里描述的现象都会感觉戚戚焉。你问我宰你有多深；你知道我在宰你吗；你知道谁在宰你吗；叫找如何不宰你；旅游者的悲哀；旅行社的悲哀；导游的悲哀？十年后，整个旅行环境都好了很多，但有利益的地方，就有江湖。
     * ItemType : 2
     * ItemCategory : ,教你识破日本旅游的三大骗局,
     * ItemResolving :
     * ItemAnswers : A, B, C, D, E
     * ItemUserAnswers : [{"Id":"2"},{"Id":"4"}]
     * ItemOptions : [{"ItemID":"3dafdb64-844b-44db-bc46-1e422d71409f","ItemTitle":"免税店骗","ItemIsCorrect":"1"},{"ItemID":"5fb81a48-ffb9-4ef3-aed4-e75608ca2bb4","ItemTitle":"旅行社骗","ItemIsCorrect":"1"},{"ItemID":"7f7fdcb7-a84e-435b-aa31-7bd7cb137aba","ItemTitle":"资格骗","ItemIsCorrect":"1"},{"ItemID":"82578be5-dd08-4e7f-9017-220b90757d01","ItemTitle":"购物骗","ItemIsCorrect":"1"},{"ItemID":"cb548b46-2d31-4ae3-aec3-5103f9d363e2","ItemTitle":"旅费骗","ItemIsCorrect":"1"}]
     */

    @SerializedName("ItemID")
    public String id;
    @SerializedName("ItemTitle")
    public String title;
    /**
     * 题目类型
     * {@link com.nerc.baselibrary.AppConstants.ExamQuestionType}
     */
    @SerializedName("ItemType")
    public String type;
    @SerializedName("ItemCategory")
    public String category;
    @SerializedName("ItemResolving")
    public String resolving;
    @SerializedName("ItemAnswers")
    public String rightAnswers;
    @SerializedName("ItemUserAnswers")
    public List<ItemUserAnswersBean> userAnswers;
    @SerializedName("ItemOptions")
    public List<ItemOptionsBean> itemOptions;

    /**
     * 下面两个参数 简答题 独有
     */
    @SerializedName("ItemScore")
    public String shortAnswerScore;
    @SerializedName("UserAnswer")
    public String shortAnswerUserAnswer;

    public static class ItemUserAnswersBean {
        /**
         * Id : 2
         */

        @SerializedName("Id")
        public String Id;
    }

    public static class ItemOptionsBean {
        /**
         * ItemID : 3dafdb64-844b-44db-bc46-1e422d71409f
         * ItemTitle : 免税店骗
         * ItemIsCorrect : 1
         */

        @SerializedName("ItemID")
        public String id;
        @SerializedName("ItemTitle")
        public String title;
        @SerializedName("ItemIsCorrect")
        public int isCorrect;
    }
}
