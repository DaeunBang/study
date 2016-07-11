package com.example.bangdaewoon.galleryapp;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil{
    @SuppressWarnings("static-access")
    public static void setPreference(Context context, String key, String value){
        SharedPreferences pref=context.getSharedPreferences("USER",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("USER", context.MODE_PRIVATE);
        pref = context.getSharedPreferences("USER", context.MODE_PRIVATE);
        return pref.getString(key, "");
    }



}
