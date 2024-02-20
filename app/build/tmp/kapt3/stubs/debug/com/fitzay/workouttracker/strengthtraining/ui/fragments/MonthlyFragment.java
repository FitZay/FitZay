package com.fitzay.workouttracker.strengthtraining.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u00010,2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00108\u001a\u000200H\u0016J\u001c\u00109\u001a\u0002002\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0018\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020AH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/fragments/MonthlyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "averageSleep", "", "getAverageSleep", "()Ljava/lang/String;", "setAverageSleep", "(Ljava/lang/String;)V", "barEntriesArrayList", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/BarEntry;", "Lkotlin/collections/ArrayList;", "getBarEntriesArrayList", "()Ljava/util/ArrayList;", "setBarEntriesArrayList", "(Ljava/util/ArrayList;)V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentMonthlyBinding;", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "calendarCopy", "getCalendarCopy", "setCalendarCopy", "calendarCopy2", "getCalendarCopy2", "setCalendarCopy2", "calendar_2", "getCalendar_2", "setCalendar_2", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "setDateFormat", "(Ljava/text/SimpleDateFormat;)V", "popupWindow", "Landroid/widget/PopupWindow;", "tooltipView", "Landroid/view/View;", "tvValue", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onNothingSelected", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "updateUI", "textView", "month", "", "app_debug"})
public final class MonthlyFragment extends androidx.fragment.app.Fragment implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    private com.fitzay.workouttracker.strengthtraining.databinding.FragmentMonthlyBinding binding;
    @org.jetbrains.annotations.Nullable
    private java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> barEntriesArrayList;
    private android.view.View tooltipView;
    private android.widget.TextView tvValue;
    private android.widget.PopupWindow popupWindow;
    public java.util.Calendar calendar;
    public java.util.Calendar calendar_2;
    public java.util.Calendar calendarCopy;
    public java.util.Calendar calendarCopy2;
    public java.text.SimpleDateFormat dateFormat;
    @org.jetbrains.annotations.NotNull
    private java.lang.String averageSleep = "";
    
    public MonthlyFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> getBarEntriesArrayList() {
        return null;
    }
    
    public final void setBarEntriesArrayList(@org.jetbrains.annotations.Nullable
    java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    public final void setCalendar(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar_2() {
        return null;
    }
    
    public final void setCalendar_2(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendarCopy() {
        return null;
    }
    
    public final void setCalendarCopy(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendarCopy2() {
        return null;
    }
    
    public final void setCalendarCopy2(@org.jetbrains.annotations.NotNull
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
    public final java.lang.String getAverageSleep() {
        return null;
    }
    
    public final void setAverageSleep(@org.jetbrains.annotations.NotNull
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
    
    private final void updateUI(android.widget.TextView textView, int month) {
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