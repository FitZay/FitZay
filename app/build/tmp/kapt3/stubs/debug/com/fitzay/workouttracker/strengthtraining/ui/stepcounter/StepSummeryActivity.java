package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0014J\u001c\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0006\u0010\"\u001a\u00020\u0014J\u0016\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010\'\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepSummeryActivity;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityStepSummeryBinding;", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "typeClicked", "getTypeClicked", "()Ljava/lang/String;", "setTypeClicked", "(Ljava/lang/String;)V", "clickedButton", "", "isChoice", "hideAllLayouts", "monthlyReport", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNothingSelected", "onStart", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "resetLineChart", "setData", "values", "Ljava/util/ArrayList;", "setLineChart", "unSelect", "weekReport", "app_debug"})
public final class StepSummeryActivity extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 implements com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    private final java.lang.String TAG = "StepSum";
    @org.jetbrains.annotations.NotNull
    private java.lang.String typeClicked = "Daily";
    private int currentPosition = 1;
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityStepSummeryBinding binding;
    
    public StepSummeryActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTypeClicked() {
        return null;
    }
    
    public final void setTypeClicked(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getCurrentPosition() {
        return 0;
    }
    
    public final void setCurrentPosition(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void clickedButton(int isChoice) {
    }
    
    private final void unSelect() {
    }
    
    private final void hideAllLayouts() {
    }
    
    private final void weekReport(int isChoice) {
    }
    
    private final void monthlyReport(int isChoice) {
    }
    
    private final void setData(java.util.ArrayList<com.github.mikephil.charting.data.Entry> values) {
    }
    
    private final void setLineChart() {
    }
    
    public final void resetLineChart() {
    }
    
    @java.lang.Override
    public void onValueSelected(@org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.Nullable
    com.github.mikephil.charting.highlight.Highlight h) {
    }
    
    @java.lang.Override
    public void onNothingSelected() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
}