package com.example.tracuudiemthi.tracuu.Fragment;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.tracuudiemthi.R;
import com.example.tracuudiemthi.tracuu.Model.ThongTinModel;
import com.example.tracuudiemthi.tracuu.Render.CustomBarChartRender;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class ThongKeFrag extends Fragment {
    private BarChart toanChart, vanChart, ngoaiNguChart;
    private BarChart vatLiChart, hoaHocChart, sinhHocChart;
    private BarChart lichSuChart, diaLiChart, gdcdChart;
    private String SRC_DATABASE_NAME = "database2024.db";
    SQLiteDatabase database = null;
    public ThongKeFrag() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thongke_fragment, container, false);

        toanChart = view.findViewById(R.id.toan_chart_2024);
        vanChart = view.findViewById(R.id.van_chart_2024);
        ngoaiNguChart = view.findViewById(R.id.ngoaingu_chart_2024);
        vatLiChart = view.findViewById(R.id.vatli_chart_2024);
        hoaHocChart = view.findViewById(R.id.hoahoc_chart_2024);
        sinhHocChart = view.findViewById(R.id.sinhhoc_chart_2024);
        lichSuChart = view.findViewById(R.id.lichsu_chart_2024);
        diaLiChart = view.findViewById(R.id.diali_chart_2024);
        gdcdChart = view.findViewById(R.id.gdcd_chart_2024);

        ArrayList<BarEntry> toan = new ArrayList<>();
        ArrayList<BarEntry> van = new ArrayList<>();
        ArrayList<BarEntry> ngoaiNgu = new ArrayList<>();
        ArrayList<BarEntry> vatLi = new ArrayList<>();
        ArrayList<BarEntry> hoaHoc = new ArrayList<>();
        ArrayList<BarEntry> sinhHoc = new ArrayList<>();
        ArrayList<BarEntry> lichSu = new ArrayList<>();
        ArrayList<BarEntry> diaLi = new ArrayList<>();
        ArrayList<BarEntry> gdcdS = new ArrayList<>();


        ArrayList<String> scoresToan = new ArrayList<>();
        ArrayList<String> scoresVan = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            toan.add(new BarEntry(i, getCountToan((float) (i * 0.2))));
            ngoaiNgu.add(new BarEntry(i, getCountNgoaiNgu((float) (i * 0.2))));
            scoresToan.add(String.format("%.1f", i * 0.2));
        }

        for (int i = 0; i <= 40; i++) {
            van.add(new BarEntry(i, getCountVan((float) (i * 0.25))));
            vatLi.add(new BarEntry(i, getCountVatli((float) (i * 0.25))));
            hoaHoc.add(new BarEntry(i, getCountHoahoc((float) (i * 0.25))));
            sinhHoc.add(new BarEntry(i, getCountSinhhoc((float) (i * 0.25))));
            lichSu.add(new BarEntry(i, getCountLichsu((float) (i * 0.25))));
            diaLi.add(new BarEntry(i, getCountDiali((float) (i * 0.25))));
            gdcdS.add(new BarEntry(i, getCountGDCD((float) (i * 0.25))));

            scoresVan.add(String.format("%.2f", i * 0.25));
        }

        BarDataSet barToanDataSet = new BarDataSet(toan, "");
        BarDataSet barVanDataSet = new BarDataSet(van, "");
        BarDataSet barNNDataSet = new BarDataSet(ngoaiNgu, "");
        BarDataSet barVatliDataSet = new BarDataSet(vatLi, "");
        BarDataSet barHoahocDataSet = new BarDataSet(hoaHoc, "");
        BarDataSet barSinhhocDataSet = new BarDataSet(sinhHoc, "");
        BarDataSet barLichsuDataSet = new BarDataSet(lichSu, "");
        BarDataSet barDialiDataSet = new BarDataSet(diaLi, "");
        BarDataSet barGDCDDataSet = new BarDataSet(gdcdS, "");

        CustomBarChartRender custom = new CustomBarChartRender(toanChart, toanChart.getAnimator(), toanChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom1 = new CustomBarChartRender(vanChart, vanChart.getAnimator(), vanChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom2 = new CustomBarChartRender(ngoaiNguChart, ngoaiNguChart.getAnimator(), ngoaiNguChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom3 = new CustomBarChartRender(vatLiChart, vatLiChart.getAnimator(), vatLiChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom4 = new CustomBarChartRender(hoaHocChart, hoaHocChart.getAnimator(), hoaHocChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom5 = new CustomBarChartRender(sinhHocChart, sinhHocChart.getAnimator(), sinhHocChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom6 = new CustomBarChartRender(lichSuChart, lichSuChart.getAnimator(), lichSuChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom7 = new CustomBarChartRender(diaLiChart, diaLiChart.getAnimator(), diaLiChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom8 = new CustomBarChartRender(gdcdChart, gdcdChart.getAnimator(), gdcdChart.getViewPortHandler(), getContext());

        barToanDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barVanDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barNNDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barVatliDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barHoahocDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barSinhhocDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barLichsuDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barDialiDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barGDCDDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));

        barToanDataSet.setLabel("Phổ điểm môn Toán");
        barVanDataSet.setLabel("Phổ điểm môn Ngữ Văn");
        barNNDataSet.setLabel("Phổ điểm môn Ngoại Ngữ");
        barVanDataSet.setLabel("Phổ điểm môn Vật Lí");
        barHoahocDataSet.setLabel("Phổ điểm môn Hóa Học");
        barSinhhocDataSet.setLabel("Phổ điểm môn Sinh Học");
        barLichsuDataSet.setLabel("Phổ điểm môn Lịch Sử");
        barDialiDataSet.setLabel("Phổ điểm môn Địa Lí");
        barGDCDDataSet.setLabel("Phổ điểm môn Giáo Dục Công Dân");

        barToanDataSet.setDrawValues(true);
        barVanDataSet.setDrawValues(true);
        barNNDataSet.setDrawValues(true);
        barVatliDataSet.setDrawValues(true);
        barHoahocDataSet.setDrawValues(true);
        barSinhhocDataSet.setDrawValues(true);
        barLichsuDataSet.setDrawValues(true);
        barDialiDataSet.setDrawValues(true);
        barGDCDDataSet.setDrawValues(true);

        Description description = new Description();
        description.setText("");

        toanChart.setDescription(description);
        toanChart.setDrawValueAboveBar(false);
        toanChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresToan));
        toanChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        toanChart.getXAxis().setDrawGridLines(false);
        toanChart.getAxisRight().setEnabled(false);
        toanChart.getXAxis().setLabelCount(scoresToan.size());
        toanChart.getXAxis().setGranularity(1f);
        toanChart.getXAxis().setLabelRotationAngle(-90);
        toanChart.getAxisLeft().setAxisMinimum(0f);
        toanChart.animateY(1000);
        toanChart.setFitBars(false);
        toanChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        toanChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        toanChart.setRenderer(custom);

        vanChart.setDescription(description);
        vanChart.setDrawValueAboveBar(false);
        vanChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        vanChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        vanChart.getXAxis().setDrawGridLines(false);
        vanChart.getAxisRight().setEnabled(false);
        vanChart.getXAxis().setLabelCount(scoresVan.size());
        vanChart.getXAxis().setGranularity(1f);
        vanChart.getXAxis().setLabelRotationAngle(-90);
        vanChart.getAxisLeft().setAxisMinimum(0f);
        vanChart.animateY(1000);
        vanChart.setFitBars(false);
        vanChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vanChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vanChart.setRenderer(custom1);

        ngoaiNguChart.setDescription(description);
        ngoaiNguChart.setDrawValueAboveBar(false);
        ngoaiNguChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresToan));
        ngoaiNguChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        ngoaiNguChart.getXAxis().setDrawGridLines(false);
        ngoaiNguChart.getAxisRight().setEnabled(false);
        ngoaiNguChart.getXAxis().setLabelCount(scoresToan.size());
        ngoaiNguChart.getXAxis().setGranularity(1f);
        ngoaiNguChart.getXAxis().setLabelRotationAngle(-90);
        ngoaiNguChart.getAxisLeft().setAxisMinimum(0f);
        ngoaiNguChart.animateY(1000);
        ngoaiNguChart.setFitBars(false);
        ngoaiNguChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        ngoaiNguChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        ngoaiNguChart.setRenderer(custom2);

        vatLiChart.setDrawValueAboveBar(false);
        vatLiChart.setDescription(description);
        vatLiChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        vatLiChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        vatLiChart.getXAxis().setDrawGridLines(false);
        vatLiChart.getAxisRight().setEnabled(false);
        vatLiChart.getXAxis().setLabelCount(scoresVan.size());
        vatLiChart.getXAxis().setGranularity(1f);
        vatLiChart.getXAxis().setLabelRotationAngle(-90);
        vatLiChart.getAxisLeft().setAxisMinimum(0f);
        vatLiChart.animateY(1000);
        vatLiChart.setFitBars(false);
        vatLiChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vatLiChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vatLiChart.setRenderer(custom3);

        hoaHocChart.setDrawValueAboveBar(false);
        hoaHocChart.setDescription(description);
        hoaHocChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        hoaHocChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        hoaHocChart.getXAxis().setDrawGridLines(false);
        hoaHocChart.getAxisRight().setEnabled(false);
        hoaHocChart.getXAxis().setLabelCount(scoresVan.size());
        hoaHocChart.getXAxis().setGranularity(1f);
        hoaHocChart.getXAxis().setLabelRotationAngle(-90);
        hoaHocChart.getAxisLeft().setAxisMinimum(0f);
        hoaHocChart.animateY(1000);
        hoaHocChart.setFitBars(false);
        hoaHocChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        hoaHocChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        hoaHocChart.setRenderer(custom4);

        sinhHocChart.setDrawValueAboveBar(false);
        sinhHocChart.setDescription(description);
        sinhHocChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        sinhHocChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        sinhHocChart.getXAxis().setDrawGridLines(false);
        sinhHocChart.getAxisRight().setEnabled(false);
        sinhHocChart.getXAxis().setLabelCount(scoresVan.size());
        sinhHocChart.getXAxis().setGranularity(1f);
        sinhHocChart.getXAxis().setLabelRotationAngle(-90);
        sinhHocChart.getAxisLeft().setAxisMinimum(0f);
        sinhHocChart.animateY(1000);
        sinhHocChart.setFitBars(false);
        sinhHocChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        sinhHocChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        sinhHocChart.setRenderer(custom5);

        lichSuChart.setDrawValueAboveBar(false);
        lichSuChart.setDescription(description);
        lichSuChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        lichSuChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lichSuChart.getXAxis().setDrawGridLines(false);
        lichSuChart.getAxisRight().setEnabled(false);
        lichSuChart.getXAxis().setLabelCount(scoresVan.size());
        lichSuChart.getXAxis().setGranularity(1f);
        lichSuChart.getXAxis().setLabelRotationAngle(-90);
        lichSuChart.getAxisLeft().setAxisMinimum(0f);
        lichSuChart.animateY(1000);
        lichSuChart.setFitBars(false);
        lichSuChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        lichSuChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        lichSuChart.setRenderer(custom6);

        diaLiChart.setDrawValueAboveBar(false);
        diaLiChart.setDescription(description);
        diaLiChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        diaLiChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        diaLiChart.getXAxis().setDrawGridLines(false);
        diaLiChart.getAxisRight().setEnabled(false);
        diaLiChart.getXAxis().setLabelCount(scoresVan.size());
        diaLiChart.getXAxis().setGranularity(1f);
        diaLiChart.getXAxis().setLabelRotationAngle(-90);
        diaLiChart.getAxisLeft().setAxisMinimum(0f);
        diaLiChart.animateY(1000);
        diaLiChart.setFitBars(false);
        diaLiChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        diaLiChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        diaLiChart.setRenderer(custom7);

        gdcdChart.setDrawValueAboveBar(false);
        gdcdChart.setDescription(description);
        gdcdChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(scoresVan));
        gdcdChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        gdcdChart.getXAxis().setDrawGridLines(false);
        gdcdChart.getAxisRight().setEnabled(false);
        gdcdChart.getXAxis().setLabelCount(scoresVan.size());
        gdcdChart.getXAxis().setGranularity(1f);
        gdcdChart.getXAxis().setLabelRotationAngle(-90);
        gdcdChart.getAxisLeft().setAxisMinimum(0f);
        gdcdChart.animateY(1000);
        gdcdChart.setFitBars(false);
        gdcdChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        gdcdChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        gdcdChart.setRenderer(custom8);

        BarData data = new BarData(barToanDataSet);
        BarData data1 = new BarData(barVanDataSet);
        BarData data2 = new BarData(barNNDataSet);
        BarData data3 = new BarData(barVatliDataSet);
        BarData data4 = new BarData(barHoahocDataSet);
        BarData data5 = new BarData(barSinhhocDataSet);
        BarData data6 = new BarData(barLichsuDataSet);
        BarData data7 = new BarData(barDialiDataSet);
        BarData data8 = new BarData(barGDCDDataSet);
        data.setBarWidth(0.5f);
        data1.setBarWidth(0.5f);
        data2.setBarWidth(0.5f);
        data3.setBarWidth(0.5f);
        data4.setBarWidth(0.5f);
        data5.setBarWidth(0.5f);
        data6.setBarWidth(0.5f);
        data7.setBarWidth(0.5f);
        data8.setBarWidth(0.5f);
        barToanDataSet.setColors(0xff648EFA);
        barVanDataSet.setColors(0xff648EFA);
        barNNDataSet.setColor(0xff648EFA);
        barVatliDataSet.setColor(0xff648EFA);
        barHoahocDataSet.setColor(0xff648EFA);
        barSinhhocDataSet.setColor(0xff648EFA);
        barLichsuDataSet.setColor(0xff648EFA);
        barDialiDataSet.setColor(0xff648EFA);
        barGDCDDataSet.setColor(0xff648EFA);
        toanChart.setData(data);
        vanChart.setData(data1);
        ngoaiNguChart.setData(data2);
        vatLiChart.setData(data3);
        hoaHocChart.setData(data4);
        sinhHocChart.setData(data5);
        lichSuChart.setData(data6);
        diaLiChart.setData(data7);
        gdcdChart.setData(data8);

        return view;
    }

    @SuppressLint("Range")
    public int getCountToan(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "toan = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountVan(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "ngu_van = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountNgoaiNgu(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "ngoai_ngu = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountVatli(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "vat_li = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountHoahoc(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "hoa_hoc = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountSinhhoc(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "sinh_hoc = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountLichsu(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "lich_su = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountDiali(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "dia_li = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }

    @SuppressLint("Range")
    public int getCountGDCD(float score) {
        String src = getContext().getDatabasePath(SRC_DATABASE_NAME).getAbsolutePath();
        database = SQLiteDatabase.openOrCreateDatabase(src, null);
        Cursor cursor = database.query("diem_thi_thpt_2024", new String[] {"COUNT(*) AS count"}, "gdcd = ?", new String[]{String.valueOf(score)}, null, null, null, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(cursor.getColumnIndex("count"));
        }
        cursor.close();
        return count;
    }
}
