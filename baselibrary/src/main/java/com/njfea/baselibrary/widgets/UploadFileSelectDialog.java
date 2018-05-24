package com.njfea.baselibrary.widgets;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.njfea.baselibrary.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UploadFileSelectDialog extends DialogFragment {

    public static final String TYPE = "type";

    public static final int IMAGE = 0;
    public static final int FILE = 1;

    private ImageView mIvRecord;
    private LinearLayout mLlTakePhoto;
    private LinearLayout mLLSelectFile;
    private LinearLayout mLLSelectPhoto;

    public UploadFileSelectDialog() {
        // Required empty public constructor
    }

    public static UploadFileSelectDialog newInstance() {
        return newInstance(FILE);
    }

    public static UploadFileSelectDialog newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(TYPE, type);
        UploadFileSelectDialog fragment = new UploadFileSelectDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.upload_file_selecte_dialog, null);

        mLlTakePhoto = (LinearLayout) view.findViewById(R.id.ll_take_photo);
        mLLSelectFile = (LinearLayout) view.findViewById(R.id.ll_select_fail);
        mLLSelectPhoto = (LinearLayout) view.findViewById(R.id.ll_select_photo);

        mLlTakePhoto.setOnClickListener(v -> {
            if (mOnUploadFileSelectListener != null) {
                mOnUploadFileSelectListener.takePhoto();
            }
        });
        mLLSelectFile.setOnClickListener(v -> {
            if (mOnUploadFileSelectListener != null) {
                mOnUploadFileSelectListener.selectFile();
            }
        });
        mLLSelectPhoto.setOnClickListener(v -> {
            if (mOnUploadFileSelectListener != null) {
                mOnUploadFileSelectListener.selectPhoto();
            }
        });

        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
//        Window window = alertDialog.getWindow();
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        window.setLayout(ScreenUtils.dp2px(getContext(), 300), ScreenUtils.dp2px(getContext(), 120));
//        window.setGravity(Gravity.CENTER_VERTICAL);
//        alertDialog.setCanceledOnTouchOutside(true);

        int type = getArguments().getInt(TYPE);
        if (type == IMAGE) {
            mLLSelectFile.setVisibility(View.GONE);
        }

        return alertDialog;
    }

    @Override
    public void onStart() {
        super.onStart();
//        Window window = getDialog().getWindow();
//        WindowManager.LayoutParams windowParams = window.getAttributes();
//        windowParams.dimAmount = 0.0f;

//        window.setAttributes(windowParams);
    }


    private OnUploadFileSelectListener mOnUploadFileSelectListener;

    public void setOnUploadFileSelectListener(OnUploadFileSelectListener onUploadFileSelectListener) {
        mOnUploadFileSelectListener = onUploadFileSelectListener;
    }

    public interface OnUploadFileSelectListener {
        void takePhoto();

        void selectPhoto();

        void selectFile();
    }

}
