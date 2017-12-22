package com.nerc.baselibrary.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nerc on 2017/8/7.
 */

public class WrapCommunityEduNetAllModel {

    @SerializedName("message")
    public List<CommunityEduNetAllModel> communityEduNetAllModelList;
}
