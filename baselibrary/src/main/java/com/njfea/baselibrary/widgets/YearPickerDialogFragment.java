package com.njfea.baselibrary.widgets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.njfea.baselibrary.R;
import com.njfea.baselibrary.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * YearPickerDialogFragment
 * Created by nerc on 2017/11/14.
 */

public class YearPickerDialogFragment extends android.support.v4.app.DialogFragment {

    protected List<String> mYears = new ArrayList<>();
    private RecyclerView mRv;

    public static YearPickerDialogFragment newInstance() {

        Bundle args = new Bundle();

        YearPickerDialogFragment fragment = new YearPickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initData();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.year_dialog, null);

        mRv = view.findViewById(R.id.rv_year_dialog);
        mRv.setAdapter(new YearAdapter());

        builder.setView(view);
        AlertDialog dialog = builder.create();

        dialog.show();
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(null);
        window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, ScreenUtils.dp2px(getContext(), 300));    // 设置宽高
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setAttributes(attributes);

        return dialog;
    }

    private void initData() {
        if (mYears.size()>0) {
            return;
        }
        Calendar cal;

        cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        for (int i = -50; i < 50; i++) {
            mYears.add(String.valueOf(year + i));
            if (i == 0) {
                mYears.add("0"); // 全部
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mRv != null) {
            mRv.scrollToPosition(47);
        }
    }

    public class YearAdapter extends RecyclerView.Adapter<YearAdapter.YearHolder> {


        @Override
        public YearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.year_dialog_item, parent, false);
            return new YearHolder(view);
        }

        @Override
        public void onBindViewHolder(YearHolder holder, int position) {

            String text = mYears.get(position);
            if ("0".equals(text)) {
                holder.mTv.setText("全部");
            } else {
                holder.mTv.setText(text);
            }
        }

        @Override
        public int getItemCount() {
            return mYears.size();
        }

        public class YearHolder extends RecyclerView.ViewHolder {

            private final TextView mTv;

            public YearHolder(View itemView) {
                super(itemView);
                mTv = ((TextView) itemView.findViewById(R.id.tv_year_dialog_item));
                mTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null) {
                            mListener.pick(mYears.get(YearHolder.this.getAdapterPosition()));
                        }
                        dismiss();
                    }
                });
            }
        }
    }

    private OnYearPickerListener mListener;

    public void setListener(OnYearPickerListener listener) {
        mListener = listener;
    }

    public interface OnYearPickerListener {
        void pick(String year);
    }


}
