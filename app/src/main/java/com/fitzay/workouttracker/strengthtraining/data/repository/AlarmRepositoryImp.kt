package com.fitzay.workouttracker.strengthtraining.data.repository

import android.util.Log
import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class AlarmRepositoryImp(private val alarmDao: AlarmDao) : AlarmRepository {


    override suspend fun getAlarms(pageSize: Int): Flow<List<AlarmEntity>> = flow {
        try {
        val a = alarmDao.getPaging().map {
            it.toDomain()
        }
        emit(a)
    }
        catch (e:Exception)
        {
            Log.i("TAG", "getAlarms-Error-Catch: "+e.message)
        }
    }.flowOn(Dispatchers.IO)


    override suspend fun getAllEnabledAlarms(): Flow<List<AlarmEntity>> = flow {
        val a = alarmDao.getAllEnabled().map {
            it.toDomain()
        }
        emit(a)
    }.flowOn(Dispatchers.IO)

    override suspend fun updateAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>> = flow {
        alarmDao.update(Alarm.fromDomain(alarms))
        emit(UpdateStatus.success(true))
    }.flowOn(Dispatchers.IO)

    override suspend fun deleteAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>> = flow {
        alarmDao.delete(Alarm.fromDomain(alarms))
        emit(UpdateStatus.success(true))
    }.flowOn(Dispatchers.IO)

    override suspend fun addAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>> = flow {
        //alarmDao.insert(*alarms)
        alarmDao.insert(Alarm.fromDomain(alarms))
        emit(UpdateStatus.success(true))
    }.flowOn(Dispatchers.IO)

    override suspend fun deleteItem(item: Long){
        alarmDao.deleteById(item)
        //emit(UpdateStatus.success(true))
    }

    override suspend fun getAlarmId(id:Long):List<AlarmEntity>{
        return alarmDao.getAlarmBySleepId(id)
        //emit(UpdateStatus.success(true))
    }
    override suspend fun getAlarmForADay(day:String):List<AlarmEntity>{
        return alarmDao.getAlarmForADay(day)
        //emit(UpdateStatus.success(true))
    }

//   override suspend fun updateItem(item: AlarmEntity) {
//        alarmDao.updateItem(Alarm.fromDomain(item))
//    }

    override suspend fun updateItem(sleepId:Long,currentTime:Long,alarmTime:Long,alarmLable:String,alarmEnable:Boolean,alarmVibrate:Boolean,soundUri:String,alarmBT:Long,selectedDays:String,alarmSnoozeTime:Long,sleepHr:String,alarmDate:String) {
        alarmDao.updateItem(sleepId,currentTime,alarmTime,alarmLable,alarmEnable,alarmVibrate,soundUri,alarmBT,selectedDays,alarmSnoozeTime,sleepHr,alarmDate)
    }
//    override suspend fun updateItem(alarmTime:Long,alarmLable:String,alarmDate:String) {
//        alarmDao.updateItem(alarmTime,alarmLable,alarmDate)
//    }
}

