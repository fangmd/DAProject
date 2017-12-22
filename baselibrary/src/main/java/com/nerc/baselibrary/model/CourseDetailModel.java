package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nerc on 2017/8/7.
 */

public class CourseDetailModel {


    /**
     * ItemName : 犯错的价值
     * ItemImgURL : http://202.205.161.103:8035/UploadFile/3757f662-c0d6-4a62-b37c-f3f0ca60cf5b.jpg
     * ItemVideoUrl :
     * ItemScore : 0
     * ItemFavorites : 0
     * ItemIntro : 每个人都会避免犯错，但或许避免犯错本身就是一种错误？“犯错家”凯瑟琳舒尔茨告诉我们，或许我们不只该承认错误，更应该大力拥抱人性中“我错故我在”的本质。
        IteamStudengCount: "0",
        ItemCollectionInfoId: "4"

        ItemIsXuanKe: "0"
     */

    @SerializedName("ItemName")
    public String name;
    @SerializedName("ItemImgURL")
    public String imgUrl;
    @SerializedName("ItemVideoUrl")
    public String videoUrl;
    @SerializedName("ItemScore")
    public float score;
    @SerializedName("ItemFavorites")
    public int favorites;
    @SerializedName("ItemCollectionInfoId")
    public String collectionId;
    @SerializedName("ItemIntro")
    public String introduce;
    @SerializedName("IteamStudengCount")
    public int studentCnt;
    @SerializedName("ItemIsXuanKe")
    public int isXuanKe;
}
