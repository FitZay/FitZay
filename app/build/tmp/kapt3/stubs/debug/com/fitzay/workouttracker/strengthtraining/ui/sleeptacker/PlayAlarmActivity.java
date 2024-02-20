package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002J\b\u0010\'\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/sleeptacker/PlayAlarmActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityPlayAlarmBinding;", "ringtoneSound", "Landroid/media/Ringtone;", "totalTime", "", "getTotalTime", "()J", "setTotalTime", "(J)V", "vibration", "", "getVibration", "()Z", "setVibration", "(Z)V", "vibrator", "Landroid/os/Vibrator;", "fullscreen", "", "view", "Landroid/view/View;", "getCurrentFormattedDate", "", "getCurrentTime", "hasP", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "snoozeAlarm", "snooze", "startRingtone", "rintone", "Landroid/net/Uri;", "stopRingtone", "turnOnScreen", "app_debug"})
public final class PlayAlarmActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityPlayAlarmBinding binding;
    private android.media.Ringtone ringtoneSound;
    private boolean vibration = false;
    private android.os.Vibrator vibrator;
    private long totalTime = 0L;
    
    public PlayAlarmActivity() {
        super();
    }
    
    public final boolean getVibration() {
        return false;
    }
    
    public final void setVibration(boolean p0) {
    }
    
    public final long getTotalTime() {
        return 0L;
    }
    
    public final void setTotalTime(long p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void startRingtone(android.net.Uri rintone) {
    }
    
    private final void stopRingtone() {
    }
    
    private final void turnOnScreen() {
    }
    
    private final boolean hasP() {
        return false;
    }
    
    private final void fullscreen(android.view.View view) {
    }
    
    private final void getCurrentTime() {
    }
    
    private final java.lang.String getCurrentFormattedDate() {
        return null;
    }
    
    private final void snoozeAlarm(long snooze) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
}