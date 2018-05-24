package com.njfea.baselibrary.recyclerview.simpleloadmore;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by nercdevAndroid on 2017/4/11.
 */

public class Adapter extends BaseSimpleRVAdapterLoadMore<RecyclerView.ViewHolder> {

    @Override
    public int getItemViewType(int position) {


        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateVH(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int position, List<RecyclerView.ViewHolder> mDatas) {

    }

}
