package com.hydom.chtxframe.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hydom.chtxframe.R;

/**
 * Created by Administrator on 2016/10/20.
 *
 */
public abstract class BaseActivity extends FragmentActivity {
    private RelativeLayout toolbarLy, toolBarleftLy, toolbarCenterLy, toolBarRightLy;
    private FrameLayout mainFly;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarLy = (RelativeLayout) findViewById(R.id.mainactivity_titleybar);
        toolBarleftLy = (RelativeLayout) findViewById(R.id.mainactivity_titlebar_left_layout);
        toolbarCenterLy = (RelativeLayout) findViewById(R.id.mainactivity_titlebar_center_layout);
        toolBarRightLy = (RelativeLayout) findViewById(R.id.mainactivity_titlebar_right_layout);
        mainFly = (FrameLayout) findViewById(R.id.mainactivity_mainlayout);
        View mainView = LayoutInflater.from(this).inflate(getMainLayoutResource(), null);
        mainFly.addView(mainView);
        initsView(toolbarLy, savedInstanceState);
    }

    protected abstract void initsView(RelativeLayout toolBar, Bundle savedInstanceState);

    protected abstract int getMainLayoutResource();

    protected void setTitlerContent(String title) {
        TextView textView = getTextView(title, getResources().getDimension(R.dimen.textsize_14sp),false);
        toolbarCenterLy.setGravity(Gravity.CENTER);
        toolbarCenterLy.addView(textView);
    }

    protected TextView addLeftTextView(String text) {
        TextView textView = getTextView(text, getResources().getDimension(R.dimen.textsize_12sp),true);
        toolBarleftLy.setGravity(Gravity.CENTER_VERTICAL);
        toolBarleftLy.addView(textView);
        return textView;
    }

    protected ImageView addLeftImgview(int resource) {
        ImageView imageView = new ImageView(this);
        int paddSpace= (int) getResources().getDimension(R.dimen.dimen_space_5dp);
        imageView.setPadding(paddSpace,0,paddSpace,0);
        imageView.setClickable(true);
        imageView.setImageResource(resource);
        toolBarleftLy.addView(imageView);
        return imageView;
    }

    protected TextView addRightTextView(String text) {
        TextView textView = getTextView(text, getResources().getDimension(R.dimen.textsize_12sp),true);
        toolBarRightLy.setGravity(Gravity.CENTER);
        toolBarRightLy.addView(textView);
        return textView;
    }

    protected ImageView addRightImgview(int resource) {
        ImageView imageView = new ImageView(this);
        int paddSpace= (int) getResources().getDimension(R.dimen.dimen_space_5dp);
        imageView.setPadding(paddSpace,paddSpace,0,paddSpace);
        imageView.setClickable(true);
        imageView.setImageResource(resource);
        toolBarRightLy.addView(imageView);
        return imageView;
    }

    private TextView getTextView(String text, float textSize, boolean clickable) {
        TextView textView = new TextView(this);
        textView.setTextSize(textSize);
        textView.setTextColor(ContextCompat.getColor(this, R.color.black));
        textView.setSingleLine(true);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        if (clickable) {
            textView.setClickable(true);
            textView.setBackgroundResource(R.drawable.selector_white_gray_bg);
            int paddSpace= (int) getResources().getDimension(R.dimen.dimen_space_5dp);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
            textView.setLayoutParams(lp);
            textView.setPadding(paddSpace,0,paddSpace,0);
        }
        return textView;
    }

}
