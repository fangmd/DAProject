package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * CircleModel
 * Created by nerc on 2017/10/25.
 */

public class CircleModel {

    /**
     * Id : 20
     * Title : 摄影爱好
     * menber : 4
     * Logo : http://202.205.161.103:8035/UploadFile/457357c0-d1d8-4284-8548-09b6af4a30a0.jpg
     */


    @SerializedName("Id")
    public String id;
    @SerializedName("Title")
    public String title;
    @SerializedName("menber")
    public int menber;
    @SerializedName("Logo")
    public String img;

    /**
     * 下面是 我的圈子 需要的参数
     * RowIndex : 1
     * Id : 1
     * Introduction : 声乐学习交流小组创建于2015年4月12日，为沈阳老年人大学首创兴趣小组，小组成立的目的是让更多喜爱声乐学习的朋友有一个相互促进、相互交流的空间。
     * IsLeader : 1
     * CreateDate : 2015-04-12T12:15:27
     */

    @SerializedName("RowIndex")
    public int index;
    @SerializedName("Introduction")
    public String introduction;
    @SerializedName("IsLeader")
    public int isLeader;
    @SerializedName("CreateDate")
    public String date;

    /**
     *  {
     "RowIndex": 1,
     "Id": 23,
     "Title": "1111111111",
     "menber": 1,
     "Logo": "http://202.205.161.103:8035/UploadFile/847050f6-7584-4c0f-891a-50182186694b.jpg",
     "Introduction": "111111111111111111"
     }
     */
}
