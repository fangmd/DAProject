package com.adouble.dagger2demo.module.main;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseActivity;
import com.adouble.dagger2demo.dagger.base.ActivityModule;
import com.adouble.dagger2demo.dagger.main.DaggerMainComponent;
import com.adouble.dagger2demo.dagger.main.MainComponent;
import com.adouble.dagger2demo.dagger.main.MainPresenterModule;
import com.adouble.dagger2demo.module.simple.SimpleActivity;
import com.adouble.dagger2demo.module.toastandrsp.ToastAct;
import com.adouble.dagger2demo.module.views.ViewsAct;

import javax.inject.Inject;

import hugo.weaving.DebugLog;


public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    MainContract.Presenter mPresenter;
    @Inject
    Application mApplication;


    private TextView mTV;
    private MainFrag mFragment;

    private MainComponent mMainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTV = (TextView) findViewById(R.id.tv_main);

        if (mFragment == null) {
            mFragment = MainFrag.newInstance();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_container, mFragment, "fl_container")
                .commit();

        initInject();

        Log.d(TAG, "onCreate: " + mApplication.toString());

    }

    private void initInject() {
        mMainComponent = DaggerMainComponent.builder()
                .applicationComponent(getAppComponent())
                .mainPresenterModule(new MainPresenterModule(mFragment))
                .activityModule(new ActivityModule(this))
                .build();
        mMainComponent.inject(this);
    }

    public void toApplication(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    @DebugLog
    public void toToastAct(View view) {
        ToastAct.actionStart(this);
    }

    public void toViewAct(View view) {
        ViewsAct.actionStart(this);
    }


}


