package com.adouble.dagger2demo.module.simple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adouble.dagger2demo.R;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
    }
}
