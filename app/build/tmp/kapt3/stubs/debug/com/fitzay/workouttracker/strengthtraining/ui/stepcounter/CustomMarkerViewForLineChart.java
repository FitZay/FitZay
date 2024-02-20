package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@android.annotation.SuppressLint(value = {"ViewConstructor"})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/CustomMarkerViewForLineChart;", "Lcom/github/mikephil/charting/components/MarkerView;", "Lcom/github/mikephil/charting/components/IMarker;", "context", "Landroid/content/Context;", "layoutResource", "", "height", "chartHoverModelList", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/ChartHoverModel;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;IILjava/util/ArrayList;)V", "mChartHoverModelList", "tooltip", "Landroid/widget/TextView;", "uiScreenHeight", "getOffset", "Lcom/github/mikephil/charting/utils/MPPointF;", "refreshContent", "", "e", "Lcom/github/mikephil/charting/data/Entry;", "highlight", "Lcom/github/mikephil/charting/highlight/Highlight;", "app_debug"})
public final class CustomMarkerViewForLineChart extends com.github.mikephil.charting.components.MarkerView implements com.github.mikephil.charting.components.IMarker {
    private final android.widget.TextView tooltip = null;
    private final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.ui.stepcounter.ChartHoverModel> mChartHoverModelList = null;
    private final int uiScreenHeight = 0;
    
    public CustomMarkerViewForLineChart(@org.jetbrains.annotations.NotNull
    android.content.Context context, int layoutResource, int height, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.ui.stepcounter.ChartHoverModel> chartHoverModelList) {
        super(null, 0);
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override
    public void refreshContent(@org.jetbrains.annotations.NotNull
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.NotNull
    com.github.mikephil.charting.highlight.Highlight highlight) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.github.mikephil.charting.utils.MPPointF getOffset() {
        return null;
    }
}