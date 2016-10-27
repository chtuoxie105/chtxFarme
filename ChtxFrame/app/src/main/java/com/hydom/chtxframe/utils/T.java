package com.hydom.chtxframe.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/21.
 */
public class T {
    private static Context context;

    public static void init(Context con) {
        context = con;
    }

    public static void showShort(int resourcesId) {
        Toast.makeText(context, resourcesId, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resourcesId) {
        Toast.makeText(context, resourcesId, Toast.LENGTH_LONG).show();
    }

    public static void showShort(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public static void showLong(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
