package com.adouble.dagger2demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by double on 2016/11/1.
 */

public abstract class BaseSimpleRVAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> mDatas;
    private OnItemClickListener mListener;
    protected Context mContext;

    public BaseSimpleRVAdapter() {
        mDatas = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return onCreateVH(parent, viewType);
    }

    public abstract RecyclerView.ViewHolder onCreateVH(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        onBind(holder, position, mDatas);

        if (mListener != null) {
            holder.itemView.setOnClickListener(v -> mListener.onItemClick(holder, position, data));
        }
    }

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int position, List<T> mDatas);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addAll(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearAddAll(List<T> datas) {
        mDatas.clear();
        addAll(datas);
    }

    public T getItemData(int position) {
        if (mDatas.size() > position) {
            T t = mDatas.get(position);
            return t;
        } else {
            return null;
        }
    }

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(RecyclerView.ViewHolder holder, int position, T data);
    }

}
