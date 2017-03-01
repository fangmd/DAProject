package com.adouble.dagger2demo.module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.entities.Poetry;
import com.google.gson.Gson;

import javax.inject.Inject;

public class ScopeActivity extends AppCompatActivity {

    @Inject
    Gson mGson;
    @Inject
    Poetry mPoetry;


    private TextView mTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scope);


        mTV = (TextView) findViewById(R.id.tv_scope);


//        BaseUseComponent baseUseComponent = DaggerBaseUseComponent.builder()
//
//                .build();
//        baseUseComponent.inject(this);

        mTV.setText(mGson.toJson(mPoetry) + " mPoetry:" + mPoetry.toString());
    }
}
