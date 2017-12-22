package com.nerc.baselibrary.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by double on 2016/11/1.
 */

public abstract class BaseSimpleRVAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> mDatas;
    protected OnItemClickListener mOnItemClickListener;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        onBind(holder, position, mDatas);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        try {
                            T t = mDatas.get(position);
                            mOnItemClickListener.onItemClick(holder, position, t);
                        } catch (Exception e) {
                            mOnItemClickListener.onItemClick(holder, position, null);
                        }
                    }
                }
            });
        }
    }

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int position, List<T> mDatas);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //-----
    public void addAll(@NonNull List<? extends T> datas) {
        if (datas == null) return;
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void add(@NonNull T data) {
        if (data == null) {
            return;
        }
        mDatas.add(data);
        notifyItemChanged(mDatas.size());
    }

    public void clearAddAll(@NonNull List<T> datas) {
        mDatas.clear();
        addAll(datas);
    }


    public void addToFirst(T data) {
        mDatas.add(0, data);
        notifyItemInserted(0);
    }

    public void addAllToFirst(List<T> datas) {
        mDatas.addAll(0, datas);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
        notifyItemRangeRemoved(0, mDatas.size());
    }

    public T getItemData(int position) {
        if (mDatas.size() > position) {
            T t = mDatas.get(position);
            return t;
        } else {
            return null;
        }
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void remove(int position) {
        if (mDatas.size() > position) {
            mDatas.remove(position);
            notifyDataSetChanged();
        }
    }
    //---


    public void setOnItemClickListener(OnItemClickListener li) {
        mOnItemClickListener = li;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(RecyclerView.ViewHolder holder, int position, T data);
    }

    // attacth recyclerview
    protected RecyclerView mRecyclerView;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
        // 去除 闪烁动画
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

}
