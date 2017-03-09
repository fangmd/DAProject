package com.adouble.dagger2demo;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static android.R.attr.data;

/**
 * Created by double on 2016/11/1.
 */

public abstract class BaseSimpleRVAdapterLoadMore<T> extends RecyclerView.Adapter<BaseSimpleRVAdapterLoadMore.BaseSimpleViewHolder> {

    private List<T> mDatas;
    private OnItemClickListener mListener;

    public BaseSimpleRVAdapterLoadMore() {
        mDatas = new ArrayList<>();
    }

    @Override
    public BaseSimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateVH(parent, viewType);
    }

    public abstract BaseSimpleViewHolder onCreateVH(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(BaseSimpleViewHolder holder, int position) {

        onBind(holder, position, mDatas);

        if (mListener != null) {
            holder.itemView.setOnClickListener(v -> mListener.onItemClick(holder, position, data));
        }
    }

    public abstract void onBind(BaseSimpleViewHolder viewHolder, int position, List<T> mDatas);

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
        void onItemClick(BaseSimpleViewHolder holder, int position, T data);
    }

    protected static class BaseSimpleViewHolder extends RecyclerView.ViewHolder {

        public BaseSimpleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    // load more
    private boolean mIsLoadingData = false;
    private LoadingMoreListener mLoadingMoreListener;
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && loadMoreListener != null && !mIsLoadingData && canloadMore) {
                    RecyclerView.LayoutManager layoutManager = getLayoutManager();
                    int lastVisibleItemPosition;
                    if (layoutManager instanceof GridLayoutManager) {
                        lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        int[] into = new int[((StaggeredGridLayoutManager) layoutManager).getSpanCount()];
                        ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(into);
                        lastVisibleItemPosition = last(into);
                    } else {
                        lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }

                    if (layoutManager.getChildCount() > 0
                            && lastVisibleItemPosition >= layoutManager.getItemCount() - 1) {
                        if (loadingMoreFooter != null) {
                            loadingMoreFooter.setVisible();
                        }
                        mIsLoadingData = true;
                        mLoadingMoreListener.onLoadMore();
                    }
                }
            }
        });
    }

    //取到最后的一个节点
    private int last(int[] lastPositions) {
        int last = lastPositions[0];
        for (int value : lastPositions) {
            if (value > last) {
                last = value;
            }
        }
        return last;
    }


    public interface LoadingMoreListener{
        void onLoadMore();
    }
}
