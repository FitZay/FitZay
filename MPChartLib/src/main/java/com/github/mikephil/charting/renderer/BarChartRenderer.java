
    package com.github.mikephil.charting.renderer;

    import android.graphics.Canvas;
    import android.graphics.Color;
    import android.graphics.Paint;
    import android.graphics.RectF;
    import android.graphics.drawable.Drawable;

    import com.github.mikephil.charting.animation.ChartAnimator;
    import com.github.mikephil.charting.buffer.BarBuffer;
    import com.github.mikephil.charting.data.BarData;
    import com.github.mikephil.charting.data.BarEntry;
    import com.github.mikephil.charting.highlight.Highlight;
    import com.github.mikephil.charting.highlight.Range;
    import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
    import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
    import com.github.mikephil.charting.utils.Fill;
    import com.github.mikephil.charting.utils.MPPointF;
    import com.github.mikephil.charting.utils.Transformer;
    import com.github.mikephil.charting.utils.Utils;
    import com.github.mikephil.charting.utils.ViewPortHandler;

    import java.util.List;

    public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {

        protected BarDataProvider mChart;

        /**
         * the rect object that is used for drawing the bars
         */
        protected RectF mBarRect = new RectF();

        protected BarBuffer[] mBarBuffers;

        protected Paint mShadowPaint;
        protected Paint mBarBorderPaint;

        public BarChartRenderer(BarDataProvider chart, ChartAnimator animator,
                                ViewPortHandler viewPortHandler) {
            super(animator, viewPortHandler);
            this.mChart = chart;

            mHighlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mHighlightPaint.setStyle(Paint.Style.FILL);
            mHighlightPaint.setColor(Color.rgb(0, 0, 0));
            // set alpha after color
            mHighlightPaint.setAlpha(120);

            mShadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mShadowPaint.setStyle(Paint.Style.FILL);

            mBarBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mBarBorderPaint.setStyle(Paint.Style.STROKE);
        }

        @Override
        public void initBuffers() {

            BarData barData = mChart.getBarData();
            mBarBuffers = new BarBuffer[barData.getDataSetCount()];

            for (int i = 0; i < mBarBuffers.length; i++) {
                IBarDataSet set = barData.getDataSetByIndex(i);
                mBarBuffers[i] = new BarBuffer(set.getEntryCount() * 4 * (set.isStacked() ? set.getStackSize() : 1),
                        barData.getDataSetCount(), set.isStacked());
            }
        }

        @Override
        public void drawData(Canvas c) {

            BarData barData = mChart.getBarData();

            for (int i = 0; i < barData.getDataSetCount(); i++) {

                IBarDataSet set = barData.getDataSetByIndex(i);

                if (set.isVisible()) {
                    drawDataSet(c, set, i);
                }
            }
        }

        private RectF mBarShadowRectBuffer = new RectF();

        protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {

            Transformer trans = mChart.getTransformer(dataSet.getAxisDependency());

            mBarBorderPaint.setColor(dataSet.getBarBorderColor());
            mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(dataSet.getBarBorderWidth()));

            final boolean drawBorder = dataSet.getBarBorderWidth() > 0.f;

            float phaseX = mAnimator.getPhaseX();
            float phaseY = mAnimator.getPhaseY();

            // draw the bar shadow before the values
            if (mChart.isDrawBarShadowEnabled()) {
                mShadowPaint.setColor(dataSet.getBarShadowColor());

                BarData barData = mChart.getBarData();

                final float barWidth = barData.getBarWidth();
                final float barWidthHalf = barWidth / 2.0f;
                float x;

                for (int i = 0, count = Math.min((int)(Math.ceil((float)(dataSet.getEntryCount()) * phaseX)), dataSet.getEntryCount());
                    i < count;
                    i++) {

                    BarEntry e = dataSet.getEntryForIndex(i);

                    x = e.getX();

                    mBarShadowRectBuffer.left = x - barWidthHalf;
                    mBarShadowRectBuffer.right = x + barWidthHalf;

                    trans.rectValueToPixel(mBarShadowRectBuffer);

                    if (!mViewPortHandler.isInBoundsLeft(mBarShadowRectBuffer.right))
                        continue;

                    if (!mViewPortHandler.isInBoundsRight(mBarShadowRectBuffer.left))
                        break;

                    mBarShadowRectBuffer.top = mViewPortHandler.contentTop();
                    mBarShadowRectBuffer.bottom = mViewPortHandler.contentBottom();

                    c.drawRect(mBarShadowRectBuffer, mShadowPaint);
                }
            }

            // initialize the buffer
            BarBuffer buffer = mBarBuffers[index];
            buffer.setPhases(phaseX, phaseY);
            buffer.setDataSet(index);
            buffer.setInverted(mChart.isInverted(dataSet.getAxisDependency()));
            buffer.setBarWidth(mChart.getBarData().getBarWidth());

            buffer.feed(dataSet);

            trans.pointValuesToPixel(buffer.buffer);

            final boolean isCustomFill = dataSet.getFills() != null && !dataSet.getFills().isEmpty();
            final boolean isSingleColor = dataSet.getColors().size() == 1;
            final boolean isInverted = mChart.isInverted(dataSet.getAxisDependency());

            if (isSingleColor) {
                mRenderPaint.setColor(dataSet.getColor());
            }

            for (int j = 0, pos = 0; j < buffer.size(); j += 4, pos++) {

                if (!mViewPortHandler.isInBoundsLeft(buffer.buffer[j + 2]))
                    continue;

                if (!mViewPortHandler.isInBoundsRight(buffer.buffer[j]))
                    break;

                if (!isSingleColor) {
                    // Set the color for the currently drawn value. If the index
                    // is out of bounds, reuse colors.
                    mRenderPaint.setColor(dataSet.getColor(pos));
                }

                if (isCustomFill) {
                    dataSet.getFill(pos)
                            .fillRect(
                                    c, mRenderPaint,
                                    buffer.buffer[j],
                                    buffer.buffer[j + 1],
                                    buffer.buffer[j + 2],
                                    buffer.buffer[j + 3],
                                    isInverted ? Fill.Direction.DOWN : Fill.Direction.UP);
                }
                else {
                    float left = buffer.buffer[j];
                    float top = buffer.buffer[j + 1];
                    float right = buffer.buffer[j + 2];
                    float bottom = buffer.buffer[j + 3];
                    float radius = 16; // You can adjust the radius to control the roundness of the corners

                    RectF rectF = new RectF(left, top, right, bottom);
                    c.drawRoundRect(rectF, radius, radius, mRenderPaint);

                }

                if (drawBorder) {
                    float left = buffer.buffer[j];
                    float top = buffer.buffer[j + 1];
                    float right = buffer.buffer[j + 2];
                    float bottom = buffer.buffer[j + 3];
                    float radius = 16; // You can adjust the radius to control the roundness of the corners

                    RectF rectF = new RectF(left, top, right, bottom);
                    c.drawRoundRect(rectF, radius, radius, mRenderPaint);

                }
            }
        }

        protected void prepareBarHighlight(float x, float y1, float y2, float barWidthHalf, Transformer trans) {

            float left = x - barWidthHalf;
            float right = x + barWidthHalf;
            float top = y1;
            float bottom = y2;

            mBarRect.set(left, top, right, bottom);

            trans.rectToPixelPhase(mBarRect, mAnimator.getPhaseY());
        }

        @Override
        public void drawValues(Canvas c) {

            // if values are drawn
            if (isDrawingValuesAllowed(mChart)) {

                List<IBarDataSet> dataSets = mChart.getBarData().getDataSets();

                final float valueOffsetPlus = Utils.convertDpToPixel(4.5f);
                float posOffset = 0f;
                float negOffset = 0f;
                boolean drawValueAboveBar = mChart.isDrawValueAboveBarEnabled();

                for (int i = 0; i < mChart.getBarData().getDataSetCount(); i++) {

                    IBarDataSet dataSet = dataSets.get(i);

                    if (!shouldDrawValues(dataSet))
                        continue;

                    // apply the text-styling defined by the DataSet
                    applyValueTextStyle(dataSet);

                    boolean isInverted = mChart.isInverted(dataSet.getAxisDependency());

                    // calculate the correct offset depending on the draw position of
                    // the value
                    float valueTextHeight = Utils.calcTextHeight(mValuePaint, "8");
                    posOffset = (drawValueAboveBar ? -valueOffsetPlus : valueTextHeight + valueOffsetPlus);
                    negOffset = (drawValueAboveBar ? valueTextHeight + valueOffsetPlus : -valueOffsetPlus);

                    if (isInverted) {
                        posOffset = -posOffset - valueTextHeight;
                        negOffset = -negOffset - valueTextHeight;
                    }

                    // get the buffer
                    BarBuffer buffer = mBarBuffers[i];

                    final float phaseY = mAnimator.getPhaseY();

                    MPPointF iconsOffset = MPPointF.getInstance(dataSet.getIconsOffset());
                    iconsOffset.x = Utils.convertDpToPixel(iconsOffset.x);
                    iconsOffset.y = Utils.convertDpToPixel(iconsOffset.y);

                    // if only single values are drawn (sum)
                    if (!dataSet.isStacked()) {

                        for (int j = 0; j < buffer.buffer.length * mAnimator.getPhaseX(); j += 4) {

                            float x = (buffer.buffer[j] + buffer.buffer[j + 2]) / 2f;

                            if (!mViewPortHandler.isInBoundsRight(x))
                                break;

                            if (!mViewPortHandler.isInBoundsY(buffer.buffer[j + 1])
                                    || !mViewPortHandler.isInBoundsLeft(x))
                                continue;

                            BarEntry entry = dataSet.getEntryForIndex(j / 4);
                            float val = entry.getY();

                            // Check if this is the last bar
                            if (i == mChart.getBarData().getDataSetCount() - 1) {
                                // Draw the value only on the last bar
                                if (dataSet.isDrawValuesEnabled()) {
                                    drawValue(c, dataSet.getValueFormatter(), val, entry, i, x,
                                            val >= 0 ?
                                                    (buffer.buffer[j + 1] + posOffset) :
                                                    (buffer.buffer[j + 3] + negOffset),
                                            dataSet.getValueTextColor(j / 4));
                                }
                            }

                            if (entry.getIcon() != null && dataSet.isDrawIconsEnabled()) {

                                Drawable icon = entry.getIcon();

                                float px = x;
                                float py = val >= 0 ?
                                        (buffer.buffer[j + 1] + posOffset) :
                                        (buffer.buffer[j + 3] + negOffset);

                                px += iconsOffset.x;
                                py += iconsOffset.y;

                                Utils.drawImage(
                                        c,
                                        icon,
                                        (int) px,
                                        (int) py,
                                        icon.getIntrinsicWidth(),
                                        icon.getIntrinsicHeight());
                            }
                        }
                    }
                }
            }
        }


        @Override
        public void drawHighlighted(Canvas c, Highlight[] indices) {

            BarData barData = mChart.getBarData();

            for (Highlight high : indices) {

                IBarDataSet set = barData.getDataSetByIndex(high.getDataSetIndex());

                if (set == null || !set.isHighlightEnabled())
                    continue;

                BarEntry e = set.getEntryForXValue(high.getX(), high.getY());

                if (!isInBoundsX(e, set))
                    continue;

                Transformer trans = mChart.getTransformer(set.getAxisDependency());

                mHighlightPaint.setColor(set.getHighLightColor());
                mHighlightPaint.setAlpha(set.getHighLightAlpha());

                boolean isStack = (high.getStackIndex() >= 0  && e.isStacked()) ? true : false;

                final float y1;
                final float y2;

                if (isStack) {

                    if(mChart.isHighlightFullBarEnabled()) {

                        y1 = e.getPositiveSum();
                        y2 = -e.getNegativeSum();

                    } else {

                        Range range = e.getRanges()[high.getStackIndex()];

                        y1 = range.from;
                        y2 = range.to;
                    }

                } else {
                    y1 = e.getY();
                    y2 = 0.f;
                }

                prepareBarHighlight(e.getX(), y1, y2, barData.getBarWidth() / 2f, trans);

                setHighlightDrawPos(high, mBarRect);

                c.drawRect(mBarRect, mHighlightPaint);
            }
        }

        /**
         * Sets the drawing position of the highlight object based on the riven bar-rect.
         * @param high
         */
        protected void setHighlightDrawPos(Highlight high, RectF bar) {
            high.setDraw(bar.centerX(), bar.top);
        }

        @Override
        public void drawExtras(Canvas c) {
        }
    }


