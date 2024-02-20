package com.fitzay.workouttracker.strengthtraining.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/AlarmReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "TAG", "", "homePendingIntent", "Landroid/app/PendingIntent;", "mBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "mNotificationManager", "Landroid/app/NotificationManager;", "remoteViews", "Landroid/widget/RemoteViews;", "createNotificationChannel", "", "context", "Landroid/content/Context;", "generateHashId", "", "generateHashIdForNotification", "initialNotification", "onReceive", "intent", "Landroid/content/Intent;", "app_debug"})
public final class AlarmReceiver extends android.content.BroadcastReceiver {
    private android.widget.RemoteViews remoteViews;
    private android.app.PendingIntent homePendingIntent;
    private final java.lang.String TAG = "StepCounter";
    private android.app.NotificationManager mNotificationManager;
    private androidx.core.app.NotificationCompat.Builder mBuilder;
    
    public AlarmReceiver() {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
    
    private final void createNotificationChannel(android.content.Context context) {
    }
    
    private final void initialNotification(android.content.Context context) {
    }
    
    public final int generateHashId() {
        return 0;
    }
    
    public final int generateHashIdForNotification() {
        return 0;
    }
}