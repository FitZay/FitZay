package com.fitzay.workouttracker.strengthtraining.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0015\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJq\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010\'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/repository/AlarmRepository;", "", "addAlarms", "Lkotlinx/coroutines/flow/Flow;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "alarms", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlarms", "deleteItem", "", "item", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmForADay", "", "day", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmId", "id", "getAlarms", "pageSize", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEnabledAlarms", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAlarms", "updateItem", "sleepId", "currentTime", "alarmTime", "alarmLable", "alarmEnable", "alarmVibrate", "soundUri", "alarmBT", "selectedDays", "alarmSnoozeTime", "sleepHr", "alarmDate", "(JJJLjava/lang/String;ZZLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface AlarmRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAlarms(int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAlarmId(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAlarmForADay(@org.jetbrains.annotations.NotNull
    java.lang.String day, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllEnabledAlarms(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteItem(long item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateItem(long sleepId, long currentTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String alarmLable, boolean alarmEnable, boolean alarmVibrate, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, long alarmBT, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDays, long alarmSnoozeTime, @org.jetbrains.annotations.NotNull
    java.lang.String sleepHr, @org.jetbrains.annotations.NotNull
    java.lang.String alarmDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}