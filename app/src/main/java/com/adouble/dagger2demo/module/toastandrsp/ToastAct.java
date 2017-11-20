package com.adouble.dagger2demo.module.toastandrsp;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.AppConstants;
import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseActivity;
import com.adouble.dagger2demo.service.DownloadJobService;
import com.fang.common.base.utils.over.SPUtils;
import com.fang.common.base.utils.over.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.job.JobInfo.NETWORK_TYPE_ANY;

public class ToastAct extends BaseActivity {


    @BindView(R.id.btn_csn)
    Button mBtnCsn;
    @BindView(R.id.btn_csc)
    Button mBtnCsc;
    @BindView(R.id.btn_csca)
    Button mBtnCsca;

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, ToastAct.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        ButterKnife.bind(this);
    }

    @Override
    protected void initInject() {

    }

    @OnClick({R.id.btn_csn, R.id.btn_csc, R.id.btn_csca})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_csn:
                ToastUtil.showCToast(this,getString(R.string.center_short_normal_toast));
                break;
            case R.id.btn_csc:
//                ToastUtil.showCCToast(this,getString(R.string.center_short_custom_toast), R.layout.toast_zhifubao);
                break;
            case R.id.btn_csca:

                break;

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            jobSche();
        }
    }

    public void saveSp(View view) {
        SPUtils.putString(this,AppConstants.SP_KEY.TEMP, "asd");
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void jobSche() {

        JobScheduler jobScheduler = (JobScheduler) App.getInstance().getSystemService(Context.JOB_SCHEDULER_SERVICE);
        ComponentName jobService = new ComponentName(this, DownloadJobService.class);

        int jobId = 123;
        PersistableBundle extras = new PersistableBundle();
        extras.putString("key", "from UI");

        JobInfo jobInfo = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            jobInfo = new JobInfo.Builder(jobId, jobService)
                    .setRequiredNetworkType(NETWORK_TYPE_ANY) // net is available
                    .setExtras(extras)
                    .setPersisted(true)
                    .setRequiresDeviceIdle(false)
                    .setPeriodic(500, 500)
                    .build();
        }


        jobScheduler.schedule(jobInfo);
    }
}
