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
interface SleepDao : SleepBaseDao<Sleep> {


    @Query("SELECT * FROM sleep ORDER BY id DESC")
    fun getPaging(): List<Sleep>

    @Query("DELETE FROM sleep WHERE id=:id")
    fun deleteById(id: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(sleep:Sleep)


    @Query("SELECT id FROM sleep WHERE time=:time")
    fun getTime(time: Long):Long

    @Query("SELECT * FROM sleep ORDER BY id ASC")
    fun getId():List<Sleep>

//    @Query("UPDATE Sleep SET time = :alarmTime, label=:alarmLable, isEnabled=:alarmEnable")
//    fun updateItem(alarmTime:Long,alarmLable:String,alarmEnable:Boolean)
}