package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

/**
 * ActivityCollectionBodyModel
 * Created by nerc on 2017/11/13.
 */

public class ActivityCollectionBodyModel {

    @SerializedName("CourseId")
    public String id;
    @SerializedName("userId")
    public String userId;
    /**
     * {@link com.nerc.baselibrary.AppConstants.CollectionType}
     */
    @SerializedName("CollectionType")
    public String collectionType;

}
