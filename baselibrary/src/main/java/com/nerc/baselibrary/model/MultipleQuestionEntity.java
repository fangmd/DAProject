package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/6/30.
 */

public class MultipleQuestionEntity {


    /**
     * ItemID : 主试题Id
     * ItemTitle : 主试题标题
     * ItemType : 主试题类型
     * ItemCategory : 主试题分类
     * ItemResolving : 主试题提示
     * ItemSons : [{"ItemID":"子试题Id","ItemTitle":"子试题标题","ItemType":"子试题类型","ItemCategory":"子试题分类","ItemResolving":"子提示","ItemOptionsCount":"选项或者空的个数","ItemOptions":[{"ItemID":"选项iD","ItemTitle":"选项标题","ItemIsCorrect":"是否正确"}]}]
     */

    @SerializedName("ItemID")
    public String itemID;
    @SerializedName("ItemTitle")
    public String itemTitle;
    @SerializedName("ItemType")
    public String itemType;
    @SerializedName("ItemCategory")
    public String itemCategory;
    @SerializedName("ItemResolving")
    public String itemResolving;
    @SerializedName("ItemSons")
    public List<ItemSonsBean> itemSons;

    public static class ItemSonsBean {

        /**
         * ItemID : 子试题Id
         * ItemTitle : 子试题标题
         * ItemType : 子试题类型
         * ItemCategory : 子试题分类
         * ItemResolving : 子提示
         * ItemOptionsCount : 选项或者空的个数
         * ItemOptions : [{"ItemID":"选项iD","ItemTitle":"选项标题","ItemIsCorrect":"是否正确"}]
         */

        @SerializedName("ItemID")
        public String itemID;
        @SerializedName("ItemTitle")
        public String itemTitle;
        @SerializedName("ItemType")
        public String itemType;
        @SerializedName("ItemCategory")
        public String itemCategory;
        @SerializedName("ItemResolving")
        public String itemResolving;
        @SerializedName("ItemOptionsCount")
        public int itemOptionsCount;
        @SerializedName("ItemOptions")
        public List<ItemOptionsBean> itemOptions;


        public String userAnswer;
        public String rightAnswer;


        public static class ItemOptionsBean {
            /**
             * ItemID : 选项iD
             * ItemTitle : 选项标题
             * ItemIsCorrect : 是否正确
             */

            @SerializedName("ItemID")
            public String itemID;
            @SerializedName("ItemTitle")
            public String itemTitle;
            @SerializedName("ItemIsCorrect")
            public String itemIsCorrect;

            public String itemCollect; // A,B C, D 用于表示选项
        }
    }
}
