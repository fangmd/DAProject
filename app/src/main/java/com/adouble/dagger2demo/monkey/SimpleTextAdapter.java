package com.adouble.dagger2demo.monkey;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adouble.dagger2demo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by double on 2017/12/10.
 */

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {


    private final ArrayList<String> mDatas;
    private Context mContext;

    public SimpleTextAdapter() {
        mDatas = new ArrayList<>();

        initData();
    }

    private void initData() {
        for (int i = 0; i < 40; i++) {
            mDatas.add(i + " item ");
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.simple_text_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String data = mDatas.get(position);
        holder.mTvSimpleTextItem.setText(data);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_simple_text_item)
        TextView mTvSimpleTextItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
