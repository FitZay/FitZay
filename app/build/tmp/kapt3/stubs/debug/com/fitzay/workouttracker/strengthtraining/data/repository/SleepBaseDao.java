package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\'J!\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\'J!\u0010\r\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0006\"\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepBaseDao;", "T", "", "delete", "", "t", "", "([Ljava/lang/Object;)V", "deleteAll", "list", "", "insert", "insertAll", "update", "app_debug"})
public abstract interface SleepBaseDao<T extends java.lang.Object> {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> list);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    T... t);
    
    @androidx.room.Update
    public abstract void update(@org.jetbrains.annotations.NotNull
    T... t);
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    T... t);
    
    @androidx.room.Delete
    public abstract void deleteAll(@org.jetbrains.annotations.NotNull
    java.util.List<? extends T> list);
}