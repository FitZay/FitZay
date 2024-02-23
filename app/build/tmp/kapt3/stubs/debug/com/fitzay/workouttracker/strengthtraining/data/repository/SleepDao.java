package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\'J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepDao;", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepBaseDao;", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "deleteById", "", "id", "", "getId", "", "getPaging", "getTime", "time", "insertData", "sleep", "app_debug"})
public abstract interface SleepDao extends com.fitzay.workouttracker.strengthtraining.data.repository.SleepBaseDao<com.fitzay.workouttracker.strengthtraining.data.model.Sleep> {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM sleep ORDER BY id DESC")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Sleep> getPaging();
    
    @androidx.room.Query(value = "DELETE FROM sleep WHERE id=:id")
    public abstract void deleteById(long id);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertData(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.data.model.Sleep sleep);
    
    @androidx.room.Query(value = "SELECT id FROM sleep WHERE time=:time")
    public abstract long getTime(long time);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM sleep ORDER BY id ASC")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Sleep> getId();
}