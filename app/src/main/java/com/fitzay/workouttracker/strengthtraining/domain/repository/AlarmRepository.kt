package com.fitzay.workouttracker.strengthtraining.domain.repository

import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import kotlinx.coroutines.flow.Flow


interface AlarmRepository {
    suspend fun getAlarms(pageSize: Int) : Flow<List<AlarmEntity>>
    suspend fun getAlarmId(id:Long):List<AlarmEntity>
    suspend fun getAlarmForADay(day:String):List<AlarmEntity>
    suspend fun getAllEnabledAlarms(): Flow<List<AlarmEntity>>
    suspend fun updateAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>>
    suspend fun deleteAlarms( alarms: AlarmEntity): Flow<UpdateStatus<Boolean>>
    suspend fun addAlarms( alarms: AlarmEntity): Flow<UpdateStatus<Boolean>>
    suspend fun deleteItem(item: Long)
//    suspend fun updateItem(item: AlarmEntity)
    suspend fun updateItem(sleepId:Long,currentTime:Long,alarmTime:Long,alarmLable:String,alarmEnable:Boolean,alarmVibrate:Boolean,soundUri:String,alarmBT:Long,selectedDays:String,alarmSnoozeTime:Long,sleepHr:String,alarmDate:String)
//    suspend fun updateItem(alarmTime:Long,alarmLable:String,alarmDate:String)
}