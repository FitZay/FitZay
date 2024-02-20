package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020 H\u0002J\u001a\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010\u001e2\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0012\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0016J\"\u00103\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0016J\b\u00106\u001a\u00020 H\u0002J\b\u00107\u001a\u00020 H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0010H\u0002J\u0010\u0010;\u001a\u0002092\u0006\u0010:\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020\u0010H\u0002J(\u0010=\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010>\u001a\u0002092\u0006\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0010\u0010A\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0002X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepCounterSensor;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "Landroid/location/LocationListener;", "()V", "TAG", "", "homePendingIntent", "Landroid/app/PendingIntent;", "isPaused", "", "locationManager", "Landroid/location/LocationManager;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "mCurrentSteps", "", "mLastSteps", "mListener", "mNotificationManager", "Landroid/app/NotificationManager;", "mTodaysSteps", "remoteViews", "Landroid/widget/RemoteViews;", "sensorManager", "Landroid/hardware/SensorManager;", "simpleStepDetector", "Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector;", "stepCount", "stepSensor", "Landroid/hardware/Sensor;", "createNotificationChannel", "", "handleEvent", "value", "initialNotification", "onAccuracyChanged", "sensor", "accuracy", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onLocationChanged", "location", "Landroid/location/Location;", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onStartCommand", "flags", "startId", "pauseStepCounting", "resumeStepCounting", "totalDistanceCovered", "", "steps", "totalDistanceCoveredinMeters", "totalDistanceGoal", "updateNotification", "distance", "burnedCalories", "formattedTime2", "updateStepCount", "app_debug"})
public final class StepCounterSensor extends android.app.Service implements android.hardware.SensorEventListener, android.location.LocationListener {
    private android.hardware.SensorManager sensorManager;
    private android.hardware.Sensor stepSensor;
    private android.location.LocationManager locationManager;
    private int stepCount = 0;
    private boolean isPaused = false;
    private com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepDetector simpleStepDetector;
    private android.hardware.SensorEventListener mListener;
    private int mTodaysSteps = 0;
    private int mCurrentSteps = 0;
    private int mLastSteps = -1;
    private android.widget.RemoteViews remoteViews;
    private android.app.PendingIntent homePendingIntent;
    private final java.lang.String TAG = "StepCounter";
    private android.app.NotificationManager mNotificationManager;
    private androidx.core.app.NotificationCompat.Builder mBuilder;
    
    public StepCounterSensor() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void handleEvent(int value) {
    }
    
    private final void handleEvent() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    @java.lang.Override
    public void onSensorChanged(@org.jetbrains.annotations.NotNull
    android.hardware.SensorEvent event) {
    }
    
    @java.lang.Override
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    @java.lang.Override
    public void onLocationChanged(@org.jetbrains.annotations.NotNull
    android.location.Location location) {
    }
    
    private final double totalDistanceCovered(int steps) {
        return 0.0;
    }
    
    private final double totalDistanceGoal(int steps) {
        return 0.0;
    }
    
    private final double totalDistanceCoveredinMeters(int steps) {
        return 0.0;
    }
    
    private final void updateStepCount(int stepCount) {
    }
    
    private final void createNotificationChannel() {
    }
    
    private final void pauseStepCounting() {
    }
    
    private final void resumeStepCounting() {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
        return null;
    }
    
    private final void initialNotification() {
    }
    
    private final void updateNotification(int stepCount, double distance, double burnedCalories, java.lang.String formattedTime2) {
    }
}