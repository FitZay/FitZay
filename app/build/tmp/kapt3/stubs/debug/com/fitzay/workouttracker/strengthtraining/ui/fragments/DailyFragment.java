package com.fitzay.workouttracker.strengthtraining.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020!H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u00109\u001a\u00020!H\u0002J\b\u0010<\u001a\u000206H\u0002J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J&\u0010@\u001a\u0004\u0018\u00010/2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010E\u001a\u000206H\u0016J\u001c\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010%\u00a8\u0006K"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/fragments/DailyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "barData", "Lcom/github/mikephil/charting/data/BarData;", "getBarData", "()Lcom/github/mikephil/charting/data/BarData;", "setBarData", "(Lcom/github/mikephil/charting/data/BarData;)V", "barDataSet", "Lcom/github/mikephil/charting/data/BarDataSet;", "getBarDataSet", "()Lcom/github/mikephil/charting/data/BarDataSet;", "setBarDataSet", "(Lcom/github/mikephil/charting/data/BarDataSet;)V", "barEntriesArrayList", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/BarEntry;", "Lkotlin/collections/ArrayList;", "getBarEntriesArrayList", "()Ljava/util/ArrayList;", "setBarEntriesArrayList", "(Ljava/util/ArrayList;)V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentDailyBinding;", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "setDateFormat", "(Ljava/text/SimpleDateFormat;)V", "popupWindow", "Landroid/widget/PopupWindow;", "tooltipView", "Landroid/view/View;", "tvValue", "Landroid/widget/TextView;", "typeClicked", "getTypeClicked", "setTypeClicked", "getBarEntriesForDaily", "", "sleepHr", "", "day", "getDayPosition", "", "noData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onNothingSelected", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "app_debug"})
public final class DailyFragment extends androidx.fragment.app.Fragment implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    private com.fitzay.workouttracker.strengthtraining.databinding.FragmentDailyBinding binding;
    @org.jetbrains.annotations.Nullable
    private com.github.mikephil.charting.data.BarData barData;
    @org.jetbrains.annotations.Nullable
    private com.github.mikephil.charting.data.BarDataSet barDataSet;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> barEntriesArrayList;
    @org.jetbrains.annotations.NotNull
    private java.lang.String typeClicked = "Daily";
    private android.view.View tooltipView;
    private android.widget.TextView tvValue;
    private android.widget.PopupWindow popupWindow;
    public java.util.Calendar calendar;
    public java.text.SimpleDateFormat dateFormat;
    @org.jetbrains.annotations.NotNull
    private java.lang.String date = "";
    
    public DailyFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.github.mikephil.charting.data.BarData getBarData() {
        return null;
    }
    
    public final void setBarData(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.BarData p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.github.mikephil.charting.data.BarDataSet getBarDataSet() {
        return null;
    }
    
    public final void setBarDataSet(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.BarDataSet p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> getBarEntriesArrayList() {
        return null;
    }
    
    public final void setBarEntriesArrayList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTypeClicked() {
        return null;
    }
    
    public final void setTypeClicked(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    public final void setCalendar(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.text.SimpleDateFormat getDateFormat() {
        return null;
    }
    
    public final void setDateFormat(@org.jetbrains.annotations.NotNull
    java.text.SimpleDateFormat p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void noData() {
    }
    
    private final void getBarEntriesForDaily(float sleepHr, java.lang.String day) {
    }
    
    private final int getDayPosition(java.lang.String day) {
        return 0;
    }
    
    @java.lang.Override
    public void onValueSelected(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.highlight.Highlight h) {
    }
    
    @java.lang.Override
    public void onNothingSelected() {
    }
}