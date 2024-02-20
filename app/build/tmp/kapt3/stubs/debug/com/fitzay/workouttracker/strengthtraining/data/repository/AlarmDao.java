package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\'Jh\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\'\u00a8\u0006\u001d"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmDao;", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmBaseDao;", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Alarm;", "deleteById", "", "id", "", "getAlarmBySleepId", "", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "getAlarmForADay", "day", "", "getAllEnabled", "getPaging", "updateItem", "sleepId", "currentTime", "alarmTime", "alarmLable", "alarmEnable", "", "alarmVibrate", "soundUri", "alarmBT", "selectedDays", "alarmSnoozeTime", "sleepHr", "alarmDate", "app_debug"})
public abstract interface AlarmDao extends com.fitzay.workouttracker.strengthtraining.data.repository.AlarmBaseDao<com.fitzay.workouttracker.strengthtraining.data.model.Alarm> {
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm ORDER BY id DESC")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Alarm> getPaging();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm WHERE isEnabled")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Alarm> getAllEnabled();
    
    @androidx.room.Query(value = "DELETE FROM Alarm WHERE sleepId=:id")
    public abstract void deleteById(long id);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm WHERE selectedDay=:day ORDER BY date ASC")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> getAlarmForADay(@org.jetbrains.annotations.NotNull
    java.lang.String day);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM alarm WHERE sleepId=:id ORDER BY date ASC")
    public abstract java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> getAlarmBySleepId(long id);
    
    @androidx.room.Query(value = "UPDATE Alarm SET id=:currentTime,time = :alarmTime, label=:alarmLable, isEnabled=:alarmEnable,isVibrationEnabled=:alarmVibrate,soundUri=:soundUri,bedTime=:alarmBT,selectedDay=:selectedDays,snoozeTime=:alarmSnoozeTime,totalSleepingHr=:sleepHr,date=:alarmDate WHERE sleepId = :sleepId AND date=:alarmDate")
    public abstract void updateItem(long sleepId, long currentTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String alarmLable, boolean alarmEnable, boolean alarmVibrate, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, long alarmBT, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDays, long alarmSnoozeTime, @org.jetbrains.annotations.NotNull
    java.lang.String sleepHr, @org.jetbrains.annotations.NotNull
    java.lang.String alarmDate);
}