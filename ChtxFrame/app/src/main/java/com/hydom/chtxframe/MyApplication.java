package com.hydom.chtxframe;

import android.app.Application;

import com.hydom.chtxframe.utils.AppConfig;
import com.hydom.chtxframe.utils.T;

import org.xutils.x;

/**
 * Created by Administrator on 2016/10/21.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        T.init(this);
        //xutils......init.....
        x.Ext.setDebug(AppConfig.isDebug);
        x.Ext.init(this);

    }
}
