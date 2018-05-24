package com.njfea.baselibrary.widgets.loading;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * Author: Created by fangmingdong on 2018/5/24-下午3:35
 * Description: LoadingDialogFragment
 */
public class LoadingDialogFragment extends DialogFragment {

    public static LoadingDialogFragment newInstance() {
        Bundle args = new Bundle();
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //去掉默认的title
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉白色边角
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(com.njfea.baselibrary.R.layout.dialog_common_loading, container);
    }

    @Override
    public void onResume() {
        super.onResume();
        // 设置被用户取消
        setCancelable(false);
    }
}
