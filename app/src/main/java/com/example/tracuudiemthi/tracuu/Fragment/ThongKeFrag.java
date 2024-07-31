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
    int[] countToan;
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
        ArrayList<String> scoresToan = new ArrayList<>();
        ArrayList<String> scoresVan = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            toan.add(new BarEntry(i, getCountToan((float) (i * 0.2))));
            scoresToan.add(String.format("%.1f", i * 0.2));
        }

        for (int i = 0; i <= 40; i++) {
            van.add(new BarEntry(i, getCountVan((float) (i * 0.25))));
            scoresVan.add(String.format("%.2f", i * 0.25));
        }

        BarDataSet barToanDataSet = new BarDataSet(toan, "");
        BarDataSet barVanDataSet = new BarDataSet(van, "");

        CustomBarChartRender custom = new CustomBarChartRender(toanChart, toanChart.getAnimator(), toanChart.getViewPortHandler(), getContext());
        CustomBarChartRender custom1 = new CustomBarChartRender(vanChart, vanChart.getAnimator(), vanChart.getViewPortHandler(), getContext());

        barToanDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barVanDataSet.setValueTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        barToanDataSet.setLabel("Phổ điểm môn Toán");
        barVanDataSet.setLabel("Phổ điểm môn Ngữ Văn");
        barToanDataSet.setDrawValues(true);
        barVanDataSet.setDrawValues(true);

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
        vanChart.getXAxis().setLabelCount(scoresToan.size());
        vanChart.getXAxis().setGranularity(1f);
        vanChart.getXAxis().setLabelRotationAngle(-90);
        vanChart.getAxisLeft().setAxisMinimum(0f);
        vanChart.animateY(1000);
        vanChart.setFitBars(false);
        vanChart.getXAxis().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vanChart.getAxisLeft().setTypeface(ResourcesCompat.getFont(getContext(), R.font.sfpro_regular));
        vanChart.setRenderer(custom1);

        BarData data = new BarData(barToanDataSet);
        BarData data1 = new BarData(barVanDataSet);
        data.setBarWidth(0.5f);
        data1.setBarWidth(0.5f);
        barToanDataSet.setColors(0xff648EFA);
        barVanDataSet.setColors(0xff648EFA);
        toanChart.setData(data);
        vanChart.setData(data1);

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
}
