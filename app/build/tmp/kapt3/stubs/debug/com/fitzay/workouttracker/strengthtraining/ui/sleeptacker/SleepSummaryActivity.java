package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J \u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006&"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/sleeptacker/SleepSummaryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "()V", "adapter", "Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/ScheduleAlarmShowAdapter;", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivitySleepSummaryBinding;", "list", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "typeClicked", "", "getTypeClicked", "()Ljava/lang/String;", "setTypeClicked", "(Ljava/lang/String;)V", "itemClick", "", "position", "", "model", "time", "Landroid/widget/TextView;", "am_pm", "label", "day", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "loadAdaptiveNative", "longItemClickForDelete", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "switchOnOff", "boolean", "", "unSelect", "app_debug"})
public final class SleepSummaryActivity extends androidx.appcompat.app.AppCompatActivity implements com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepSummaryBinding binding;
    @org.jetbrains.annotations.NotNull
    private java.lang.String typeClicked = "Daily";
    private com.fitzay.workouttracker.strengthtraining.ui.adapters.ScheduleAlarmShowAdapter adapter;
    private java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> list;
    
    public SleepSummaryActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTypeClicked() {
        return null;
    }
    
    public final void setTypeClicked(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void unSelect() {
    }
    
    @java.lang.Override
    public void itemClick(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model, @org.jetbrains.annotations.NotNull
    android.widget.TextView time, @org.jetbrains.annotations.NotNull
    android.widget.TextView am_pm, @org.jetbrains.annotations.NotNull
    android.widget.TextView label, @org.jetbrains.annotations.NotNull
    android.widget.TextView day, @org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.SwitchCompat p6_1702747034) {
    }
    
    @java.lang.Override
    public void longItemClickForDelete(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model) {
    }
    
    @java.lang.Override
    public void switchOnOff(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model, boolean p2_32355860) {
    }
    
    private final void loadAdaptiveNative() {
    }
}