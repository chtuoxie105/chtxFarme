package com.hydom.chtxframe;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.hydom.chtxframe.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void initsView(RelativeLayout toolBar, Bundle savedInstanceState) {
        setTitlerContent("标题..");
        addRightImgview(R.mipmap.ic_chtx_test_left);
        addLeftTextView("退出");
    }

    @Override
    protected int getMainLayoutResource() {
        return R.layout.chtx_main_layout;
    }
}
