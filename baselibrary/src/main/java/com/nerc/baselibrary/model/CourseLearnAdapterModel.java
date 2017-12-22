package com.nerc.baselibrary.model;

/**
 * Created by nerc on 2017/8/9.
 */

public class CourseLearnAdapterModel {

    public static final int CATEGORY_HEAD = 0; // 章节
    public static final int RES_ITEM = 1;   // 资源

    public static final int TEST_HEAD = 2;  // 在线练习，大标题
    public static final int TEST_CATEGORY_HEAD = 3; // 练习 章节
    public static final int TEST_ITEM = 4;  // 练习，测验

    public int type;

    public Object object;


    public CourseLearnAdapterModel(int type, Object object) {
        this.type = type;
        this.object = object;
    }
}
