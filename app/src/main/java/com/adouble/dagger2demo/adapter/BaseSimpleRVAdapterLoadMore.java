package com.adouble.dagger2demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * load more:
 * <p>
 * <p>
 * <p>
 * Created by double on 2016/11/1.
 */

public abstract class BaseSimpleRVAdapterLoadMore<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TAG = BaseSimpleRVAdapterLoadMore.class.getSimpleName();

    private List<T> mDatas;
    private OnItemClickListener mListener;
    private OnItemLongClickListener mLongClickListener;
    protected Context mContext;

    public BaseSimpleRVAdapterLoadMore() {
        mDatas = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1 && loadMoreReady()) {
            return LOAD_MORE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == LOAD_MORE) {
            if (mLoadingMoreView instanceof View) {
                return new LoadMoreVH(((View) mLoadingMoreView));
            } else {
                new LoadMoreVH(((View) mLoadingMoreView));
                Log.e(TAG, "onCreateViewHolder: mLoadingMoreView should be a View ");
            }

        }

        return onCreateVH(parent, viewType);
    }

    public abstract RecyclerView.ViewHolder onCreateVH(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == LOAD_MORE) {
            return;
        }
        if (mDatas.size() > position) {
            onBind(holder, position, mDatas);
        }

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getAdapterPosition();
                    mListener.onItemClick(holder, position, mDatas.get(position));
                }
            });
        }

        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getAdapterPosition();
                    mLongClickListener.onItemLongClick(holder, position, mDatas.get(position));
                    return true;
                }
            });
        }
    }

    public abstract void onBind(RecyclerView.ViewHolder viewHolder, int position, List<T> mDatas);

    @Override
    public int getItemCount() {
        int dataSize = mDatas.size();
        if (loadMoreReady()) {
            dataSize++;
        }
        return dataSize;
    }

    public int getDataCount() {
        return mDatas.size();
    }


    //-----
    public void addAll(@NonNull List<? extends T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void add(@NonNull T data) {
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

    public void remove(int position) {
        if (mDatas.size() > position) {
            mDatas.remove(position);
            notifyDataSetChanged();
        }
    }

    public List<T> getDatas() {
        return mDatas;
    }
    //---


    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public void setOnLongClickListener(OnItemLongClickListener longClickListener) {
        mLongClickListener = longClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(RecyclerView.ViewHolder holder, int position, T data);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLongClick(RecyclerView.ViewHolder holder, int position, T data);
    }


    // load more
    private static final int LOAD_MORE = 1111;
    private boolean mIsLoadingData = false;
    private LoadingMoreListener mLoadingMoreListener;
    private LoadMoreViewImpl mLoadingMoreView;
    private boolean mLoadMoreEnable;

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && mLoadingMoreListener != null && !mIsLoadingData && mLoadMoreEnable) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
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
                        if (mLoadingMoreView != null) {
                            mLoadingMoreView.setLoading(true);
                        }
                        mIsLoadingData = true;
                        mLoadingMoreListener.onLoadMore();
                    }
                }
            }
        });
    }

    private boolean loadMoreReady() {
        return mLoadMoreEnable && mLoadingMoreView != null;
    }

    public void setLoadMoreComplete() {
        if (mLoadingMoreView != null) {
            mLoadingMoreView.setLoading(false);
        }
        mIsLoadingData = false;
    }

    public void setNoMore() {
        if (mLoadingMoreView != null) {
            mLoadingMoreView.setNoMore();
        }
    }

    public void setLoadingMoreView(LoadMoreViewImpl loadingMoreView) {
        mLoadingMoreView = loadingMoreView;
        if (loadingMoreView instanceof View) {
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);

            ((View) loadingMoreView).setLayoutParams(params);

        }
    }

    public void setLoadMoreEnable(boolean loadMoreEnable) {
        mLoadMoreEnable = loadMoreEnable;
    }

    public void setLoadingMoreListener(LoadingMoreListener loadingMoreListener) {
        mLoadMoreEnable = true;
        mLoadingMoreListener = loadingMoreListener;
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

    public interface LoadingMoreListener {
        void onLoadMore();
    }

    private class LoadMoreVH extends RecyclerView.ViewHolder {

        public LoadMoreVH(View itemView) {
            super(itemView);
        }
    }
}
