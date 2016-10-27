package com.hydom.chtxframe.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;


/**
 * dp、sp 转换为 px 的工具类
 *
 */
public class DisplayUtils {
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param context
     * @param pxValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param context
     * @param dipValue （DisplayMetrics类中属性density）
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param context
     * @param pxValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param context
     * @param spValue （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

//	float height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 55, context.getResources().getDisplayMetrics());
//   int size = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, context.getResources().getDisplayMetrics());
//这里COMPLEX_UNIT_SP是单位，20是数值，也就是20sp。

    /**
     * @param context
     * @param dp
     * @return
     */
    public static float getDip(Context context, int dp) {
        float height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        return height;
    }

    public static float getSp(Context context, int sp) {
        float height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
        return height;
    }

    /**
     * 获取屏幕宽
     *
     * @param context
     * @return
     */
    public static float getScreenW(Context context) {

        DisplayMetrics metrics = new DisplayMetrics();// 获取屏幕宽高
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);// 1。获取窗口管理器，2默认的屏幕，3获取屏幕的大小（赋值给metrcs）
        float ScreenW = metrics.widthPixels;
        // float ScreenH = metrics.heightPixels;
        return ScreenW;
    }

    /**
     * 获取屏幕高
     *
     * @param context
     * @return
     */
    public static float getScreenH(Context context) {

        DisplayMetrics metrics = new DisplayMetrics();// 获取屏幕宽高
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metrics);// 1。获取窗口管理器，2默认的屏幕，3获取屏幕的大小（赋值给metrcs）
        // float ScreenW = metrics.widthPixels;
        float ScreenH = metrics.heightPixels;
        return ScreenH;
    }


}