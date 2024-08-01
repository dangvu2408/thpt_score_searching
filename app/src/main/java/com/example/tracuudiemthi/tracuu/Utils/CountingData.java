package com.example.tracuudiemthi.tracuu.Utils;

import android.content.Context;
import android.util.Log;

public class CountingData {
    private static CountingData instance;
    private Context context;
    public static CountingData getInstance() {
        if (instance == null) {
            instance = new CountingData();
        }
        return instance;
    }

    public void initData(Context context) {
        this.context = context;
        try {
            getToan(); getVan(); getNgoaiNgu(); getVatLi(); getHoaHoc(); getSinhHoc(); getLichSu(); getDiaLi(); getGDCD();
        } catch (Exception e) {
            Log.d("Error 000 (Data not found)", e.getMessage());
        }
    }

    public void getToan() {
        try {
            SQLiteData.getInstance().calCountToan(this.context);
        } catch (Exception e) {
            Log.d("Error 001 (Data not found)", e.getMessage());
        }
    }

    public void getVan() {
        try {
            SQLiteData.getInstance().calCountVan(this.context);
        } catch (Exception e) {
            Log.d("Error 002 (Data not found)", e.getMessage());
        }
    }

    public void getNgoaiNgu() {
        try {
            SQLiteData.getInstance().calCountNgoaiNgu(this.context);
        } catch (Exception e) {
            Log.d("Error 003 (Data not found)", e.getMessage());
        }
    }

    public void getVatLi() {
        try {
            SQLiteData.getInstance().calCountVatLi(this.context);
        } catch (Exception e) {
            Log.d("Error 004 (Data not found)", e.getMessage());
        }
    }

    public void getHoaHoc() {
        try {
            SQLiteData.getInstance().calCountHoaHoc(this.context);
        } catch (Exception e) {
            Log.d("Error 005 (Data not found)", e.getMessage());
        }
    }

    public void getSinhHoc() {
        try {
            SQLiteData.getInstance().calCountSinhHoc(this.context);
        } catch (Exception e) {
            Log.d("Error 006 (Data not found)", e.getMessage());
        }
    }

    public void getLichSu() {
        try {
            SQLiteData.getInstance().calCountLichSu(this.context);
        } catch (Exception e) {
            Log.d("Error 007 (Data not found)", e.getMessage());
        }
    }

    public void getDiaLi() {
        try {
            SQLiteData.getInstance().calCountDiaLi(this.context);
        } catch (Exception e) {
            Log.d("Error 008 (Data not found)", e.getMessage());
        }
    }

    public void getGDCD() {
        try {
            SQLiteData.getInstance().calCountGDCD(this.context);
        } catch (Exception e) {
            Log.d("Error 009 (Data not found)", e.getMessage());
        }
    }
}
