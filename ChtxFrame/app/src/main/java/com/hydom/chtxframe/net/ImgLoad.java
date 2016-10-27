package com.hydom.chtxframe.net;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hydom.chtxframe.R;
import com.hydom.chtxframe.utils.GlideCircleTransform;
import com.hydom.chtxframe.utils.GlideRoundTransform;

/**
 * Created by Administrator on 2016/10/21.
 */
public class ImgLoad {
    private static Context context;
    public static void initS(Context con){
        context =con;
    }

    public static void loadImg(String url, ImageView img){
        Glide.with(context).load(url).centerCrop().placeholder(R.mipmap.ic_img_loading).error(R.mipmap.ic_img_load_fail).into(img);

    }

    public static void loadGifImg(String url, ImageView img){
        Glide.with(context).load(url).asGif().placeholder(R.mipmap.ic_img_loading).error(R.mipmap.ic_img_load_fail).into(img);
    }
    /**加载圆角图片*/
    public static void loadRoundImg(String url, ImageView img){
        Glide.with(context).load(url).centerCrop().placeholder(R.mipmap.ic_img_loading)
                .error(R.mipmap.ic_img_load_fail).transform(new GlideRoundTransform(context)).into(img);
    }
    /**加载圆形图片*/
    public static void loadCircleImg(String url, ImageView img){
        Glide.with(context).load(url).centerCrop().placeholder(R.mipmap.ic_img_loading)
                .error(R.mipmap.ic_img_load_fail).transform(new GlideCircleTransform(context)).into(img);
    }
}
