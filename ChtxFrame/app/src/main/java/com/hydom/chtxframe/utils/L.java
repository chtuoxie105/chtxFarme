package com.hydom.chtxframe.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/10/21.
 */
public class L {
    private static boolean isLog = AppConfig.isDebug;
    private static String TAG = "11";

    public static void i(String msg) {
        if (isLog)
            Log.i(TAG, msg);
    }

    public static void w(String msg) {
        if (isLog)
            Log.w(TAG, msg);
    }

    public static void e(String msg) {
        if (isLog)
            Log.e(TAG, msg);
    }
}
