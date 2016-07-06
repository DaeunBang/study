package com.example.bangdaewoon.galleryapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class PreferenceUtil extends AppCompatActivity {

    public static void setPreference(Context context, String key, String value){
        SharedPreferences pref=context.getSharedPreferences("USER",context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences("USER", context.MODE_PRIVATE);
        pref = context.getSharedPreferences("pref", context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

}
