package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ThemeActivityModel
 * <p>
 * 我的活动-主题活动
 * 主题活动列表
 * 主题活动详情页
 * Created by nerc on 2017/11/2.
 */

public class ThemeActivityModel {

    /**
     * 我的活动-主题活动
     * {
     * RowIndex: 1,
     * Id: 17,
     * ActiveTitle: "444444",
     * ActiveImgurl: "",
     * ActiveBeginTime: "2017-11-09T17:48:00",
     * ActiveEndTime: "2017-12-05T17:48:00",
     * ItemSEDate: "2017.11.09--2017.12.05"
     * }
     */

    @SerializedName("ActiveBeginTime")
    public String beginTime;
    @SerializedName("ActiveEndTime")
    public String endTime;


    /**
     * RowIndex : 1
     * Id : 14
     * ActiveTitle : 11111111
     * ActiveImgurl :
     * studentcount : 0
     * address : null
     * ItemPrice : ￥100.00
     * ItemSEDate : 2017.11.01--2017.11.30
     * ItemBaoMingJieZhiDate : 2017.11.16
     */


    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Id")
    public String id;
    @SerializedName("ActiveTitle")
    public String activeTitle;
    @SerializedName("ActiveImgurl")
    public String img;
    @SerializedName("studentcount")
    public int studentCount;
    @SerializedName("address")
    public String address;
    @SerializedName("ItemPrice")
    public String price;
    @SerializedName("ItemSEDate")
    public String sEDate;
    @SerializedName("ItemBaoMingJieZhiDate")
    public String signUpDeadline;

    @SerializedName("ItemFavorites")
    public String collectioned;
    @SerializedName("ItemCollectionInfoId")
    public String collectionId;


    /**
     * detail:
     *   {
     "Id": 2,
     "ActiveTitle": "练习22",
     "ClassName": "练习1",
     "ActiveLable": "热会工作",
     "studentcount": 2,
     "ActiveIsFell": 1,
     "ActiveImgurl": "",
     "ActiveAddress": "中关村南大街",
     "ActiveInto": "22222222222222222222222222222",
     "ActiveRegular": null,
     "ActiveCreatetime": "2017-10-25T13:13:12",
     "Schoolid": null,
     "address": null,
     "USERSTATE": 0,
     "ItemPrice": "￥400.00",
     "ItemSEDate": "2017.10.24--2017.11.29",
     "ItemBaoMingJieZhiDate": "2017.10.18"
     }
     *
     */


    /**
     * ClassName : 练习1
     * ActiveLable : 热会工作
     * ActiveIsFell : 1
     * ActiveAddress : 中关村南大街
     * ActiveInto : 22222222222222222222222222222
     * ActiveRegular : null
     * ActiveCreatetime : 2017-10-25T13:13:12
     * Schoolid : null
     * address : null
     * USERSTATE : 0
     */

    @SerializedName("ClassName")
    public String className;
    @SerializedName("ActiveLable")
    public String activeLable;
    @SerializedName("ActiveIsFell")
    public int activeIsFell;
    @SerializedName("ActiveAddress")
    public String activeAddress;
    @SerializedName("ActiveInto")
    public String activeInto;
    @SerializedName("ActiveRegular")
    public String activeRegular;
    @SerializedName("ActiveCreatetime")
    public String activeCreatetime;
    @SerializedName("Schoolid")
    public String schoolid;
    @SerializedName("USERSTATE")
    public int USERSTATE;   // 状态， 0：没有参加，1：已经参加


}
