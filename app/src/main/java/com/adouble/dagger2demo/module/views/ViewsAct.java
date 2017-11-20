package com.adouble.dagger2demo.module.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseActivity;

import java.util.LinkedList;

public class ViewsAct extends BaseActivity {

    private ViewFlipper mVF;

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, ViewsAct.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        mVF = (ViewFlipper) findViewById(R.id.vf_views);

        TextView textView;
        for (int i = 0; i < 4; i++) {
            textView = new TextView(this);
            textView.setTextSize(getResources().getDimensionPixelSize(R.dimen.text_size));
            textView.setText("Text" + i);
            textView.setBackgroundColor(Color.BLUE);
            textView.setGravity(Gravity.CENTER);
            mVF.addView(textView);
        }

        mVF.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_top));
        mVF.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom));
        mVF.setFlipInterval(1000);




    }

    @Override
    protected void initInject() {

    }

    public void stop(View view) {
        mVF.stopFlipping();
    }

    public void start(View view) {
        mVF.startFlipping();
    }

    public void queue(){

        LinkedList<String> strings = new LinkedList<>();

        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");


        String peek = strings.poll();
    }
}
