package com.nerc.baselibrary.widgets;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nerc.baselibrary.AppConstants;
import com.nerc.baselibrary.R;
import com.nerc.baselibrary.utils.FileUtils;
import com.nerc.baselibrary.utils.IntentUtils;
import com.nerc.baselibrary.utils.PermissionUtils;
import com.nerc.baselibrary.utils.ToastUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class UploadFileSelectDialog2 extends DialogFragment {

    public static final String TYPE = "type";

    public static final int IMAGE = 0;
    public static final int FILE = 1;

    private ImageView mIvRecord;
    private LinearLayout mLlTakePhoto;
    private LinearLayout mLLSelectFile;
    private LinearLayout mLLSelectPhoto;
    private String mFilePath;
    private Activity mActivity;
    private Fragment mFragment;
    private Uri mUri;
    private String mImgPath;

    public UploadFileSelectDialog2() {
        // Required empty public constructor
    }

    public static UploadFileSelectDialog2 newInstance() {
        return newInstance(FILE);
    }

    public static UploadFileSelectDialog2 newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(TYPE, type);
        UploadFileSelectDialog2 fragment = new UploadFileSelectDialog2();
        fragment.setArguments(args);
        return fragment;
    }

    public void setActivity(Activity activity){
        mActivity = activity;

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
            getPhotoFromSysCamera();
            mOnUploadFileSelectListener.takePhoto(mFilePath);
        });
        mLLSelectFile.setOnClickListener(v -> {
            getFileFromLocal();

        });
        mLLSelectPhoto.setOnClickListener(v -> {
            getPhotoFromGallery();
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


    private OnUploadFileSelectListener2 mOnUploadFileSelectListener;

    public void setOnUploadFileSelectListener(OnUploadFileSelectListener2 onUploadFileSelectListener) {
        mOnUploadFileSelectListener = onUploadFileSelectListener;
    }

    private void getPhotoFromGallery() {
        PermissionUtils.permission(getActivity(), aBoolean -> {
            if (aBoolean) {
                Intent intent = IntentUtils.getPhotoIntent();
                mFragment.startActivityForResult(intent, AppConstants.RequestCode.PICK_PHOTO);
            } else {
                //TODO: 提示用户打开权限，跳转链接
                ToastUtils.showToast(getActivity(), getString(R.string.error_permission_denied));
            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE);

        dismiss();

    }

    private void getPhotoFromSysCamera() {
        PermissionUtils.permission(getActivity(), aBoolean -> {
            if (aBoolean) {
                mFilePath = FileUtils.getImgDirPath() + System.currentTimeMillis() + ".jpg";
                Intent openCameraIntent = IntentUtils.getTakePhotoIntent(getActivity(), mFilePath);
                mFragment.startActivityForResult(openCameraIntent, AppConstants.RequestCode.TAKE_PHOTO);
            } else {
                //TODO: 提示用户打开权限，跳转链接
                ToastUtils.showToast(getActivity(), getString(R.string.error_permission_denied));
            }
        }, Manifest.permission.CAMERA);

        dismiss();

    }


    private void getFileFromLocal() {
        Intent intent = IntentUtils.getPickFileIntent();
        try {
            mFragment.startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    AppConstants.RequestCode.PICK_FILE);
        } catch (android.content.ActivityNotFoundException ex) {
            ToastUtils.showToast(getActivity(), "本机没有可用的文件游览器");
        }

        dismiss();
    }

    public void setFragmentParent(Fragment fragment) {
        mFragment = fragment;
    }


    public interface OnUploadFileSelectListener2 {
        /**
         * 在拍照的时候需要传 imgPath 到调用者
         */
        void takePhoto(String imgPath);

    }
}
