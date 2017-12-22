package com.nerc.baselibrary.model;

/**
 * Created by nerc on 2017/8/8.
 */

public class StatisticsHeadModel {

    public String title;
    public String learnTime;
    public int noteCnt;

    public StatisticsHeadModel(String title, String learnTime, int noteCnt) {
        this.title = title;
        this.learnTime = learnTime;
        this.noteCnt = noteCnt;
    }
}
