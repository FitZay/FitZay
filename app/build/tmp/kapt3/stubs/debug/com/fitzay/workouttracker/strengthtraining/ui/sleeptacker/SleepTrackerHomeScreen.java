package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0003J@\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\fH\u0016J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0014H\u0014J \u0010$\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006)"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/sleeptacker/SleepTrackerHomeScreen;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "()V", "adapter", "Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/AlarmShowAdapter;", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivitySleepTrackerHomeScreenBinding;", "lastSelectedItemPosition", "", "list", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "pos", "", "getPos", "()J", "setPos", "(J)V", "itemClick", "", "position", "model", "time", "Landroid/widget/TextView;", "am_pm", "label", "day", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "longItemClickForDelete", "item", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "switchOnOff", "mm", "value", "", "Companion", "app_debug"})
public final class SleepTrackerHomeScreen extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 implements com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepTrackerHomeScreenBinding binding;
    private com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter adapter;
    private java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> list;
    private int lastSelectedItemPosition = androidx.recyclerview.widget.RecyclerView.NO_POSITION;
    private long pos = 0L;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepTrackerHomeScreen.Companion Companion = null;
    private static boolean toggleValue = true;
    
    public SleepTrackerHomeScreen() {
        super();
    }
    
    public final long getPos() {
        return 0L;
    }
    
    public final void setPos(long p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
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
    public void switchOnOff(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity mm, boolean value) {
    }
    
    @java.lang.Override
    public void longItemClickForDelete(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity item) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/sleeptacker/SleepTrackerHomeScreen$Companion;", "", "()V", "toggleValue", "", "getToggleValue", "()Z", "setToggleValue", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getToggleValue() {
            return false;
        }
        
        public final void setToggleValue(boolean p0) {
        }
    }
}