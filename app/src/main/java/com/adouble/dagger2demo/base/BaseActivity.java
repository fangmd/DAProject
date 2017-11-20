package com.adouble.dagger2demo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adouble.dagger2demo.App;
import com.adouble.dagger2demo.dagger.base.ApplicationComponent;

public abstract class BaseActivity extends AppCompatActivity {

    public ApplicationComponent getAppComponent(){
        return ((App) getApplication()).component();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        initInject();
    }


    protected abstract void initInject();
}
