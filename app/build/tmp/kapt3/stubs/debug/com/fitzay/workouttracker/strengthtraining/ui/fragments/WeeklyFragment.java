package com.fitzay.workouttracker.strengthtraining.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\'H\u0002J\u0012\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u00010%2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010<\u001a\u000202H\u0016J\u001c\u0010=\u001a\u0002022\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u0002022\u0006\u00103\u001a\u00020\'H\u0002J\u0018\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\'H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-\u00a8\u0006F"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/fragments/WeeklyFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentWeeklyBinding;", "getBinding", "()Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentWeeklyBinding;", "setBinding", "(Lcom/fitzay/workouttracker/strengthtraining/databinding/FragmentWeeklyBinding;)V", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "setCalendar", "(Ljava/util/Calendar;)V", "calendarCopy", "getCalendarCopy", "setCalendarCopy", "calendarCopy2", "getCalendarCopy2", "setCalendarCopy2", "date", "", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "setDateFormat", "(Ljava/text/SimpleDateFormat;)V", "popupWindow", "Landroid/widget/PopupWindow;", "tooltipView", "Landroid/view/View;", "tvValue", "Landroid/widget/TextView;", "weekEnd", "Ljava/util/Date;", "getWeekEnd", "()Ljava/util/Date;", "setWeekEnd", "(Ljava/util/Date;)V", "weekStart", "getWeekStart", "setWeekStart", "nextWeek", "", "textView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onNothingSelected", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "previousWeek", "setBarData", "pattern", "txt", "app_debug"})
public final class WeeklyFragment extends androidx.fragment.app.Fragment implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    public com.fitzay.workouttracker.strengthtraining.databinding.FragmentWeeklyBinding binding;
    private android.view.View tooltipView;
    private android.widget.TextView tvValue;
    private android.widget.PopupWindow popupWindow;
    public java.util.Calendar calendarCopy;
    public java.util.Calendar calendar;
    public java.util.Calendar calendarCopy2;
    public java.util.Date weekStart;
    public java.util.Date weekEnd;
    public java.text.SimpleDateFormat dateFormat;
    @org.jetbrains.annotations.NotNull
    private java.lang.String date = "";
    
    public WeeklyFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.databinding.FragmentWeeklyBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.databinding.FragmentWeeklyBinding p0) {
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
    
    private final void setBarData(java.text.SimpleDateFormat pattern, android.widget.TextView txt) {
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