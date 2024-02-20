package com.fitzay.workouttracker.strengthtraining.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm
import com.fitzay.workouttracker.strengthtraining.data.model.Sleep
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity

@Dao
interface AlarmDao : AlarmBaseDao<Alarm> {

    @Query("SELECT * FROM alarm ORDER BY id DESC")
    fun getPaging(): List<Alarm>

    @Query("SELECT * FROM alarm WHERE isEnabled")
    fun getAllEnabled(): List<Alarm>

    @Query("DELETE FROM Alarm WHERE sleepId=:id")
    fun deleteById(id: Long)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertData(alarm: AlarmEntity)

//    @Update
//    fun updateItem(item: Alarm)


//    @Query("UPDATE Alarm SET time = :alarmTime, label=:alarmLable WHERE date = :alarmDate")
//    fun updateItem(alarmTime:Long,alarmLable:String,alarmDate:String)

    @Query("SELECT * FROM alarm WHERE selectedDay=:day ORDER BY date ASC")
    fun getAlarmForADay(day:String):List<AlarmEntity>

    @Query("SELECT * FROM alarm WHERE sleepId=:id ORDER BY date ASC")
    fun getAlarmBySleepId(id:Long):List<AlarmEntity>

    @Query("UPDATE Alarm SET id=:currentTime,time = :alarmTime, label=:alarmLable, isEnabled=:alarmEnable,isVibrationEnabled=:alarmVibrate,soundUri=:soundUri,bedTime=:alarmBT,selectedDay=:selectedDays,snoozeTime=:alarmSnoozeTime,totalSleepingHr=:sleepHr,date=:alarmDate WHERE sleepId = :sleepId AND date=:alarmDate")
    fun updateItem(sleepId:Long,currentTime:Long,alarmTime:Long,alarmLable:String,alarmEnable:Boolean,alarmVibrate:Boolean,soundUri:String,alarmBT:Long,selectedDays:String,alarmSnoozeTime:Long,sleepHr:String,alarmDate:String)



}