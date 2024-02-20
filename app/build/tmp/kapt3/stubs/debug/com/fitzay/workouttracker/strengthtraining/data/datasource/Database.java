package com.fitzay.workouttracker.strengthtraining.data.datasource;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.fitzay.workouttracker.strengthtraining.data.repository.AlarmConverters.class})
@androidx.room.Database(entities = {com.fitzay.workouttracker.strengthtraining.data.model.Step.class, com.fitzay.workouttracker.strengthtraining.data.model.Alarm.class, com.fitzay.workouttracker.strengthtraining.data.model.Sleep.class}, version = 5, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/datasource/Database;", "Landroidx/room/RoomDatabase;", "()V", "alarmDao", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmDao;", "getAlarmDao", "()Lcom/fitzay/workouttracker/strengthtraining/data/repository/AlarmDao;", "sleepDao", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepDao;", "getSleepDao", "()Lcom/fitzay/workouttracker/strengthtraining/data/repository/SleepDao;", "stepDao", "Lcom/fitzay/workouttracker/strengthtraining/data/repository/StepDao;", "getStepDao", "()Lcom/fitzay/workouttracker/strengthtraining/data/repository/StepDao;", "app_debug"})
public abstract class Database extends androidx.room.RoomDatabase {
    
    public Database() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.fitzay.workouttracker.strengthtraining.data.repository.StepDao getStepDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao getAlarmDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao getSleepDao();
}