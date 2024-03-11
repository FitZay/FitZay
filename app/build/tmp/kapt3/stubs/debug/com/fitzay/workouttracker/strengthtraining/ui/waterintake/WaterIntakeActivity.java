package com.fitzay.workouttracker.strengthtraining.ui.waterintake;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0015J\b\u0010\u001e\u001a\u00020\u0018H\u0014J\b\u0010\u001f\u001a\u00020\u0018H\u0014J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/waterintake/WaterIntakeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "INTERVAL_MILLIS", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "a", "", "getA", "()F", "setA", "(F)V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityWaterIntakeBinding;", "lightThemeColors", "Landroidx/compose/material/Colors;", "getLightThemeColors", "()Landroidx/compose/material/Colors;", "model", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/SharedViewModel;", "Greeting", "", "addWater", "createNotificationChannel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "scheduleNotification", "showNotification", "Companion", "app_debug"})
public final class WaterIntakeActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityWaterIntakeBinding binding;
    private com.fitzay.workouttracker.strengthtraining.ui.viewmodels.SharedViewModel model;
    private float a = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "WaterIntake";
    private final int INTERVAL_MILLIS = 5000;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.waterintake.WaterIntakeActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.compose.runtime.MutableState counter$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_ID = "Water-Intake Notification";
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.material.Colors lightThemeColors = null;
    
    public WaterIntakeActivity() {
        super();
    }
    
    public final float getA() {
        return 0.0F;
    }
    
    public final void setA(float p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTAG() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"ServiceCast"})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void createNotificationChannel() {
    }
    
    private final void scheduleNotification() {
    }
    
    private final void showNotification() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @androidx.compose.runtime.Composable
    public final void Greeting() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.material.Colors getLightThemeColors() {
        return null;
    }
    
    private final void addWater() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/waterintake/WaterIntakeActivity$Companion;", "", "()V", "CHANNEL_ID", "", "getCHANNEL_ID", "()Ljava/lang/String;", "<set-?>", "", "counter", "getCounter", "()F", "setCounter", "(F)V", "counter$delegate", "Landroidx/compose/runtime/MutableState;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final float getCounter() {
            return 0.0F;
        }
        
        public final void setCounter(float p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCHANNEL_ID() {
            return null;
        }
    }
}