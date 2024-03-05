package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u00105\u001a\u0002062\u0006\u0010 \u001a\u00020!2\u0006\u00107\u001a\u00020+H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u0005H\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020;2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010=\u001a\u0002062\u0006\u0010>\u001a\u00020+H\u0002J\u0012\u0010?\u001a\u0002062\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J&\u0010B\u001a\u0004\u0018\u00010)2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010G\u001a\u000206H\u0016J\u001c\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0017J\u0010\u0010M\u001a\u0002062\u0006\u0010>\u001a\u00020+H\u0002J(\u0010N\u001a\u0002062\u0006\u0010 \u001a\u00020!2\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020;H\u0002J\b\u0010R\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101\u00a8\u0006S"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepWeeklyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentStepWeeklyBinding;", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "calendarCopy", "getCalendarCopy", "setCalendarCopy", "calendarCopy2", "getCalendarCopy2", "setCalendarCopy2", "check", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "setDateFormat", "(Ljava/text/SimpleDateFormat;)V", "i", "", "getI", "()I", "setI", "(I)V", "popupWindow", "Landroid/widget/PopupWindow;", "tooltipView", "Landroid/view/View;", "tvValue", "Landroid/widget/TextView;", "weekEnd", "Ljava/util/Date;", "getWeekEnd", "()Ljava/util/Date;", "setWeekEnd", "(Ljava/util/Date;)V", "weekStart", "getWeekStart", "setWeekStart", "common", "", "txtDate", "getDayPosition", "day", "isCurrentMonth", "", "isCurrentWeek", "nextWeek", "textView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onNothingSelected", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "previousWeek", "setBarData", "pattern", "txt", "displayAsWeekdays", "unSelectSub", "app_debug"})
public final class StepWeeklyFragment extends androidx.fragment.app.Fragment implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    private com.fitzay.workouttracker.strengthtraining.databinding.FragmentStepWeeklyBinding binding;
    public java.util.Calendar calendarCopy;
    public java.util.Calendar calendar;
    public java.util.Calendar calendarCopy2;
    public java.util.Date weekStart;
    public java.util.Date weekEnd;
    public java.text.SimpleDateFormat dateFormat;
    @org.jetbrains.annotations.NotNull
    private java.lang.String date = "";
    private android.view.View tooltipView;
    private android.widget.TextView tvValue;
    private android.widget.PopupWindow popupWindow;
    private java.lang.String check = "Step";
    private java.lang.String TAG = "StepWeeklyFragment";
    private int i = 1;
    
    public StepWeeklyFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendarCopy() {
        return null;
    }
    
    public final void setCalendarCopy(@org.jetbrains.annotations.NotNull
    java.util.Calendar p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getCalendar() {
        return null;
    }
    
    public final void setCalendar(@org.jetbrains.annotations.NotNull
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
    public final java.util.Date getWeekStart() {
        return null;
    }
    
    public final void setWeekStart(@org.jetbrains.annotations.NotNull
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getWeekEnd() {
        return null;
    }
    
    public final void setWeekEnd(@org.jetbrains.annotations.NotNull
    java.util.Date p0) {
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
    
    public final int getI() {
        return 0;
    }
    
    public final void setI(int p0) {
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
    
    private final void previousWeek(android.widget.TextView textView) {
    }
    
    private final void nextWeek(android.widget.TextView textView) {
    }
    
    private final void unSelectSub() {
    }
    
    private final void setBarData(int i, java.text.SimpleDateFormat pattern, android.widget.TextView txt, boolean displayAsWeekdays) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override
    public void onValueSelected(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.highlight.Highlight h) {
    }
    
    @java.lang.Override
    public void onNothingSelected() {
    }
    
    private final boolean isCurrentMonth(java.util.Calendar calendar) {
        return false;
    }
    
    private final boolean isCurrentWeek(java.util.Calendar calendar) {
        return false;
    }
    
    private final int getDayPosition(java.lang.String day) {
        return 0;
    }
    
    private final void common(int i, android.widget.TextView txtDate) {
    }
}