package com.fitzay.workouttracker.strengthtraining.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0011J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR3\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/SleepViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "sleepRepository", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/SleepRepository;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/repository/SleepRepository;)V", "actionListener", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/ActionLiveData;", "Lkotlin/Pair;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AlarmAction;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "getActionListener", "()Lcom/fitzay/workouttracker/strengthtraining/core/utils/ActionLiveData;", "actionListener$delegate", "Lkotlin/Lazy;", "sleepEntity", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "getSleepEntity", "()Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "setSleepEntity", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;)V", "getSleepRepository", "()Lcom/fitzay/workouttracker/strengthtraining/domain/repository/SleepRepository;", "createSleep", "", "time", "", "label", "", "deleteItem", "item", "generateAlarm", "getId", "getTime", "app_debug"})
public final class SleepViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull
    private final com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository sleepRepository = null;
    @org.jetbrains.annotations.Nullable
    private com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity sleepEntity;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy actionListener$delegate = null;
    
    public SleepViewModel(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository sleepRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository getSleepRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity getSleepEntity() {
        return null;
    }
    
    public final void setSleepEntity(@org.jetbrains.annotations.Nullable
    com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.core.utils.ActionLiveData<kotlin.Pair<com.fitzay.workouttracker.strengthtraining.core.utils.AlarmAction, com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> getActionListener() {
        return null;
    }
    
    public final void createSleep(long time, @org.jetbrains.annotations.NotNull
    java.lang.String label) {
    }
    
    public final void deleteItem(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity item) {
    }
    
    public final void getTime(long time) {
    }
    
    public final void getId() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity generateAlarm(long time, @org.jetbrains.annotations.NotNull
    java.lang.String label) {
        return null;
    }
}