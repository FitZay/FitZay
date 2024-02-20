package com.fitzay.workouttracker.strengthtraining.ui.callback;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0013"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "", "itemClick", "", "position", "", "model", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "time", "Landroid/widget/TextView;", "am_pm", "label", "day", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "longItemClickForDelete", "switchOnOff", "value", "", "app_debug"})
public abstract interface ShowAlarmItemClick {
    
    public abstract void itemClick(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model, @org.jetbrains.annotations.NotNull
    android.widget.TextView time, @org.jetbrains.annotations.NotNull
    android.widget.TextView am_pm, @org.jetbrains.annotations.NotNull
    android.widget.TextView label, @org.jetbrains.annotations.NotNull
    android.widget.TextView day, @org.jetbrains.annotations.NotNull
    androidx.appcompat.widget.SwitchCompat p6_1702747034);
    
    public abstract void longItemClickForDelete(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model);
    
    public abstract void switchOnOff(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model, boolean value);
}