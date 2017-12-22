package com.nerc.baselibrary.download;

import zlc.season.rxdownload3.core.Mission;

/**
 * 资源下载封装类
 * Created by nerc on 2017/10/24.
 */

public class ResourceMission extends Mission {

    /**
     * 资源 workId，课程资源的时候需要设置
     */
    private String resId = "";
    private String courseId = "";


    public ResourceMission(String url) {
        super(url);
    }

    public ResourceMission(String url, String saveName, String savePath) {
        super(url, saveName, savePath);
    }

    public ResourceMission(String url, String saveName, String savePath, Boolean rangeFlag, String tag) {
        super(url, saveName, savePath, rangeFlag, tag);
    }

    public ResourceMission(Mission mission) {
        super(mission);
    }

    public ResourceMission(Mission mission, String resId, String courseId) {
        super(mission);
        this.resId = resId;
        this.courseId = courseId;
    }


    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
