package com.fitzay.workouttracker.strengthtraining.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/repository/SleepRepository;", "", "addSleep", "", "sleep", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "item", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getId", "", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSleep", "Lkotlinx/coroutines/flow/Flow;", "pageSize", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTime", "time", "app_debug"})
public abstract interface SleepRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSleep(int pageSize, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteItem(long item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addSleep(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity sleep, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTime(long time, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getId(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Sleep>> continuation);
}