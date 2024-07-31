package com.example.tracuudiemthi.tracuu.Render;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import com.example.tracuudiemthi.R;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CustomBarChartRender extends BarChartRenderer {
    private Context mContext;
    public CustomBarChartRender(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler, Context context) {
        super(chart, animator, viewPortHandler);
        this.mContext = context;
    }

    @Override
    public void drawValue(Canvas c, String valueText, float x, float y, int color) {
        mValuePaint.setColor(color);
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(Utils.convertDpToPixel(9f));
        paint.setTextAlign(Paint.Align.CENTER);
        Typeface customTypeface = ResourcesCompat.getFont(mContext, R.font.sfpro_regular);
        paint.setTypeface(customTypeface);
        c.save();
        c.rotate(-90f, x, y);
        c.drawText(valueText, x + 54, y, paint);
        c.restore();
    }
}
