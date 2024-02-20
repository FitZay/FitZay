package com.github.mikephil.charting.renderer;

import static java.lang.Double.min;

import android.graphics.Canvas;
import android.graphics.Color;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CustomBarChartRenderer extends BarChartRenderer {
    private boolean lastBarWhite = false; // Flag to track the last bar's color

    public CustomBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
        // Set the color mode to NORMAL
    }

    @Override
    protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
        Transformer trans = mChart.getTransformer(dataSet.getAxisDependency());

        mBarBorderPaint.setColor(dataSet.getBarBorderColor());
        mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));

        final float phaseX = (float) Math.max(0f, min(1f, mAnimator.getPhaseX()));
        final float phaseY = mAnimator.getPhaseY();

        // Modify the bar color for the last bar
        if (dataSet.getEntryCount() > 0) {
            lastBarWhite = dataSet.getEntryForIndex(dataSet.getEntryCount() - 1).getY() > 0;
        } else {
            lastBarWhite = false;
        }

        // Set the color for the bars
        if (lastBarWhite) {
            mRenderPaint.setColor(Color.WHITE);
        } else {
            mRenderPaint.setColor(Color.parseColor("#007AFF4D"));
        }

        BarBuffer buffer = mBarBuffers[index];

        buffer.setPhases(phaseX, phaseY);
        buffer.setDataSet(index);
        buffer.setInverted(mChart.isInverted(dataSet.getAxisDependency()));
        buffer.setBarWidth(mChart.getBarData().getBarWidth());

        buffer.feed(dataSet);

        trans.pointValuesToPixel(buffer.buffer);

        // Draw the bar
        c.drawRect(buffer.buffer[0], buffer.buffer[1], buffer.buffer[2], buffer.buffer[3], mRenderPaint);

        // If bar borders are enabled, draw them
        if (dataSet.getBarBorderWidth() > 0f) {
            c.drawRect(buffer.buffer[0], buffer.buffer[1], buffer.buffer[2], buffer.buffer[3], mBarBorderPaint);
        }
    }


}

