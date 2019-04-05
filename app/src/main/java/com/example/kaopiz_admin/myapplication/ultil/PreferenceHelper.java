package com.example.kaopiz_admin.myapplication.ultil;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferenceHelper {
    private static SharedPreferences sharedPreferences;

    @Inject
    public PreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }


    public PreferenceHelper() {
    }

    public void putInt(String key,int value){
        sharedPreferences.edit().putInt(key,value).apply();
    }
    public void putLong(String key ,long value){
        sharedPreferences.edit().putLong(key,value).apply();
    }
    public long getLong(String key, long defaultValue){
        return sharedPreferences.getLong(key,defaultValue);
    }
    public int getInt(String key, int defaultValue){
        return sharedPreferences.getInt(key,defaultValue);
    }
    public void putString(String key,String value){
        sharedPreferences.edit().putString(key,value).apply();
    }
    public String getString(String key, String defaultValue){
        return sharedPreferences.getString(key,defaultValue);
    }
}

