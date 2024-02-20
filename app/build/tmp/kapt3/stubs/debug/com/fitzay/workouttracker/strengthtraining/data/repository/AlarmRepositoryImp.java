package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0018\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJq\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010\'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmRepositoryImp;", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/AlarmRepository;", "alarmDao", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmDao;", "(Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmDao;)V", "addAlarms", "Lkotlinx/coroutines/flow/Flow;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "alarms", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAlarms", "deleteItem", "", "item", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmForADay", "", "day", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmId", "id", "getAlarms", "pageSize", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEnabledAlarms", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAlarms", "updateItem", "sleepId", "currentTime", "alarmTime", "alarmLable", "alarmEnable", "alarmVibrate", "soundUri", "alarmBT", "selectedDays", "alarmSnoozeTime", "sleepHr", "alarmDate", "(JJJLjava/lang/String;ZZLjava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AlarmRepositoryImp implements com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository {
    private final com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao alarmDao = null;
    
    public AlarmRepositoryImp(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao alarmDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAlarms(int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAllEnabledAlarms(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object updateAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object deleteAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object addAlarms(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarms, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object deleteItem(long item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAlarmId(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAlarmForADay(@org.jetbrains.annotations.NotNull
    java.lang.String day, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object updateItem(long sleepId, long currentTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String alarmLable, boolean alarmEnable, boolean alarmVibrate, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, long alarmBT, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDays, long alarmSnoozeTime, @org.jetbrains.annotations.NotNull
    java.lang.String sleepHr, @org.jetbrains.annotations.NotNull
    java.lang.String alarmDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}