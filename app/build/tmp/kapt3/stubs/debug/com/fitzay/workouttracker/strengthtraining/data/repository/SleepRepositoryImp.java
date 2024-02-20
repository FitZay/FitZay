package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepRepositoryImp;", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/SleepRepository;", "sleepDao", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepDao;", "(Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepDao;)V", "addSleep", "", "sleep", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "item", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSleep", "Lkotlinx/coroutines/flow/Flow;", "pageSize", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTime", "time", "app_debug"})
public final class SleepRepositoryImp implements com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository {
    private final com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao sleepDao = null;
    
    public SleepRepositoryImp(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao sleepDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getSleep(int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity>>> continuation) {
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
    public java.lang.Object addSleep(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity sleep, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getTime(long time, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getId(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Sleep>> continuation) {
        return null;
    }
}