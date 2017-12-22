package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * ArchivesCourseListModel
 * Created by nerc on 2017/11/1.
 */

public class ArchivesCourseListModel {


    @SerializedName("PassCourseList")
    public List<ArchivesCourseModel> passCourseList;
    @SerializedName("NoPassCourseList")
    public List<ArchivesCourseModel> noPassCourseList;

}
