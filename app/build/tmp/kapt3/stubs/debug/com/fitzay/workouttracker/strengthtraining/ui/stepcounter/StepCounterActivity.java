package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014J\b\u0010\u001d\u001a\u00020\u0014H\u0014J\b\u0010\u001e\u001a\u00020\u0014H\u0003J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\u0014H\u0002JD\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepCounterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityStepCounterBinding;", "isPaused", "", "()Z", "setPaused", "(Z)V", "locationPermissionRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "requestPermissionLauncher", "stepCounterReceiver", "Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepCounterActivity$StepCounterReceiver;", "currentDateFormat", "dailyAverageReport", "", "defaultValues", "goService", "loadAdaptiveNative", "navigateToAppSettings", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "requestPermission", "stepGoalDialog", "updatePausePlayButtonState", "updateStepCount", "stepCount", "", "distance", "", "estimatedTime", "burnedCalories", "burnedCaloriesGoal", "distanceGoal", "estimatedTimeGoal", "StepCounterReceiver", "app_debug"})
public final class StepCounterActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityStepCounterBinding binding;
    private androidx.activity.result.ActivityResultLauncher<java.lang.String> requestPermissionLauncher;
    private final com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepCounterActivity.StepCounterReceiver stepCounterReceiver = null;
    private boolean isPaused = false;
    private final java.lang.String TAG = "StepCounter";
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermissionRequest = null;
    
    public StepCounterActivity() {
        super();
    }
    
    public final boolean isPaused() {
        return false;
    }
    
    public final void setPaused(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void goService() {
    }
    
    private final void dailyAverageReport() {
    }
    
    private final void defaultValues() {
    }
    
    private final void updateStepCount(int stepCount, double distance, java.lang.String estimatedTime, double burnedCalories, double burnedCaloriesGoal, double distanceGoal, java.lang.String estimatedTimeGoal) {
    }
    
    private final java.lang.String currentDateFormat() {
        return null;
    }
    
    private final void updatePausePlayButtonState() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    private final void requestPermission() {
    }
    
    private final void navigateToAppSettings() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    private final void stepGoalDialog() {
    }
    
    private final void loadAdaptiveNative() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepCounterActivity$StepCounterReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepCounterActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
    public final class StepCounterReceiver extends android.content.BroadcastReceiver {
        
        public StepCounterReceiver() {
            super();
        }
        
        @java.lang.Override
        public void onReceive(@org.jetbrains.annotations.Nullable
        android.content.Context context, @org.jetbrains.annotations.Nullable
        android.content.Intent intent) {
        }
    }
}