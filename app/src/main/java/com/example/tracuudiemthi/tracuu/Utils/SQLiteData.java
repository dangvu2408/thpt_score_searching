package com.example.tracuudiemthi.tracuu.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class SQLiteData {
    private String SRC_DATABASE_NAME = "database2024.db";
    SQLiteDatabase database = null;
    private static SQLiteData instance;
    public static SQLiteData getInstance() {
        if (instance == null) {
            instance = new SQLiteData();
        }
        return instance;
    }

    @SuppressLint("Range")
    public int getCountToan(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "toan = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountToan(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 50; i++) {
                jsonObject.put(String.valueOf(i * 0.2), getCountToan(context, (float) (i * 0.2)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_toan", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 011 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountVan(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "ngu_van = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountVan(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountVan(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_van", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 012 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountNgoaiNgu(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "ngoai_ngu = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountNgoaiNgu(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 50; i++) {
                jsonObject.put(String.valueOf(i * 0.2), getCountNgoaiNgu(context, (float) (i * 0.2)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_ngoai_ngu", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 013 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountVatli(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "vat_li = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountVatLi(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountVatli(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_vat_li", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 014 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountHoahoc(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "hoa_hoc = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountHoaHoc(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountHoahoc(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_hoa_hoc", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 015 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountSinhhoc(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "sinh_hoc = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountSinhHoc(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountSinhhoc(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_sinh_hoc", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 016 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountLichsu(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "lich_su = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountLichSu(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountLichsu(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_lich_su", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 017 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountDiali(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "dia_li = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountDiaLi(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountDiali(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_dia_li", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 018 (Data can't solve)", e.getMessage());
        }
    }

    @SuppressLint("Range")
    public int getCountGDCD(Context context, float score) {
        String src = context.getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "gdcd = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
    public void calCountGDCD(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            for (int i = 0; i <= 40; i++) {
                jsonObject.put(String.valueOf(i * 0.25), getCountGDCD(context, (float) (i * 0.25)));
            }
            DataUtils.getInstance().saveData(context, "saved_data", "key_count_gdcd", jsonObject.toString());
        } catch (Exception e) {
            Log.d("Error 019 (Data can't solve)", e.getMessage());
        }
    }
}
