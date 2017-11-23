package com.adouble.dagger2demo.module.simple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseActivity;
import com.adouble.dagger2demo.dagger.simple.DaggerSimpleComponent;
import com.adouble.dagger2demo.dagger.simple.SimpleComponent;
import com.adouble.dagger2demo.dagger.simple.SimplePresenterModule;

import javax.inject.Inject;

public class SimpleActivity extends BaseActivity {

    private SimpleComponent mComponent;

    @Inject
    SimpleFragment mFragment;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SimpleActivity.class);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_act);

        Intent intent = getIntent();
        if (intent != null) {


        } else {
            throw new RuntimeException("use actionStart");
        }

        Fragment fragment = (SimpleFragment) getSupportFragmentManager().findFragmentById(R.id.content);
        if (fragment == null) {
            fragment = mFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.content, fragment);
            transaction.commit();
        }


    }

    @Override
    protected void initInject() {

        mComponent = DaggerSimpleComponent.builder()
                .applicationComponent(App.getInstance().component())
                .simplePresenterModule(new SimplePresenterModule(mFragment))
                .build();

        mComponent.inject(this);
    }


}
