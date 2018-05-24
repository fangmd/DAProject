package com.njfea.baselibrary.widgets;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.njfea.baselibrary.R;


/**
 * Created by nercdevAndroid on 2017/5/12.
 */

public class DownloadDialog extends DialogFragment {


    private TextView mTvTitle;
    private TextView mTvCancel;
    private TextView mTvProgress;
    private ProgressBar mProgressBar;

    public static DownloadDialog newInstance(String title) {

        Bundle args = new Bundle();
        args.putString("title", title);
        DownloadDialog fragment = new DownloadDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.download_dialog, null, false);
        mTvTitle = view.findViewById(R.id.tv_download_dialog_title);
        mTvCancel = view.findViewById(R.id.tv_download_dialog_cancel);
        mTvProgress = view.findViewById(R.id.tv_download_dialog_progress);
        mTvTitle.setText(title + "(正在下载)");
        mTvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDownloadDialogListener != null) {
                    mDownloadDialogListener.onCancel();
                }
            }
        });
        mProgressBar = ((ProgressBar) view.findViewById(R.id.progress_download_dialog));
        builder.setView(view);

        return builder.create();
    }


    public void setProgress(int progress) {
        if (mProgressBar != null) {
            mProgressBar.setProgress(progress);
        }
//        if (mTvProgress != null) {
//            mTvProgress.setText(progress + "%");
//        }
    }

    public void setMax(int progress) {
        if (mProgressBar != null) {
            mProgressBar.setProgress(progress);
        }
    }

    public void setProgress(String progress) {
        if (mTvProgress != null) {
            mTvProgress.setText(progress);
        }
    }

    private DownloadDialogListener mDownloadDialogListener;

    public void setDownloadDialogListener(DownloadDialogListener downloadDialogListener) {
        mDownloadDialogListener = downloadDialogListener;
    }

    public interface DownloadDialogListener {
        void onCancel();
    }
}
