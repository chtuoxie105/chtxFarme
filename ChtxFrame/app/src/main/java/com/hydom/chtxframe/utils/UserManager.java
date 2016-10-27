package com.hydom.chtxframe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2016/10/21.
 */
public class UserManager {
    private static String FILE_NAME = "";
    private static String FILE_KEY = "";

    public static void saveUseInfo(Context context, String data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor it = sharedPreferences.edit();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream write = new ObjectOutputStream(outputStream);
            write.writeChars(data);
            String base = Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
            it.putString(FILE_KEY, base);
            write.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUseInfo(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILE_NAME, Activity.MODE_PRIVATE);
        String data = sharedPreferences.getString(FILE_KEY, null);
        if (data == null) {
            return null;
        }
        byte[] base = Base64.decode(data, Base64.DEFAULT);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(base);
        try {
            ObjectInputStream objInput = new ObjectInputStream(inputStream);
            data = (String) objInput.readObject();
            objInput.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void cleanUseInfo(Context context) {
        SharedPreferences share = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor it = share.edit();
        it.putString(FILE_KEY, null);
        it.commit();
    }
}
