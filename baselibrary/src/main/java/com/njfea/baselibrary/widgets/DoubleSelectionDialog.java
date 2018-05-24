package com.njfea.baselibrary.widgets;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.njfea.baselibrary.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoubleSelectionDialog extends DialogFragment {

    public static final String TITLE = "title";
    public static final String MSG = "msg";

    public DoubleSelectionDialog() {
        // Required empty public constructor
    }

    public static DoubleSelectionDialog newInstance(String title, String msg) {

        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putString(MSG, msg);

        DoubleSelectionDialog fragment = new DoubleSelectionDialog();
        fragment.setArguments(args);
        return fragment;
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String title = arguments.getString(TITLE);
        String msg = arguments.getString(MSG);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msg)
                .setTitle(title)
                .setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mDoubleSelectionListener != null) {
                            mDoubleSelectionListener.onPositiveClick();
                        }
                    }
                }).setNegativeButton(R.string.dialog_negative, (dialog, which) -> {
            if (mDoubleSelectionListener != null) {
                mDoubleSelectionListener.onNegativeClick();
            }
        });

        return builder.create();
    }


    private DoubleSelectionListener mDoubleSelectionListener;

    public void setDoubleSelectionListener(DoubleSelectionListener doubleSelectionListener) {
        mDoubleSelectionListener = doubleSelectionListener;
    }
}
