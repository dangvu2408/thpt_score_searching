package com.example.tracuudiemthi.tracuu.Utils;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;

public class DataUtils {
    private static DataUtils instance;
    private Dialog dialogLoading;
    public static DataUtils getInstance() {
        if (instance == null) {
            instance = new DataUtils();
        }
        return instance;
    }

    public void saveData(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public String getData(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }


}
