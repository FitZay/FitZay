package com.fitzay.workouttracker.strengthtraining.data.repository

import android.util.Log
import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm
import com.fitzay.workouttracker.strengthtraining.data.model.Sleep
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository
import com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


class SleepRepositoryImp(private val sleepDao: SleepDao) : SleepRepository {


    override suspend fun getSleep(pageSize: Int): Flow<List<SleepEntity>> = flow {
        try {
        val a = sleepDao.getPaging().map {
            it.toDomain()
        }
        emit(a)
    }
        catch (e:Exception)
        {
            Log.i("TAG", "getAlarms-Error-Catch: "+e.message)
        }
    }.flowOn(Dispatchers.IO)



//    override suspend fun updateAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>> = flow {
//        alarmDao.update(Alarm.fromDomain(alarms))
//        emit(UpdateStatus.success(true))
//    }.flowOn(Dispatchers.IO)
//
//    override suspend fun deleteAlarms(alarms: AlarmEntity): Flow<UpdateStatus<Boolean>> = flow {
//        alarmDao.delete(Alarm.fromDomain(alarms))
//        emit(UpdateStatus.success(true))
//    }.flowOn(Dispatchers.IO)

//    override suspend fun addSleep(sleep: SleepEntity): Flow<UpdateStatus<Boolean>> = flow {
//        //alarmDao.insert(*alarms)
//        sleepDao.insertData(Sleep.fromDomain(sleep))
//        emit(UpdateStatus.success(true))
//        Log.i("MMM", "KKKMM: "+sleep)
//
//    }.flowOn(Dispatchers.IO)

    override suspend fun deleteItem(item: Long){
        CoroutineScope(Dispatchers.IO).launch {
            sleepDao.deleteById(item)
        }

        //emit(UpdateStatus.success(true))
    }
//
//    override suspend fun updateItem(id:Long,time:Long,label:String) {
//        sleepDao.update(id,time,label)
//    }

    override suspend fun addSleep(sleep: SleepEntity) {
        //alarmDao.insert(*alarms)
        CoroutineScope(Dispatchers.IO).launch {
            sleepDao.insertData(Sleep.fromDomain(sleep))
            Log.i("MMM", "KKKMM: " + sleep)
        }
    }
    override suspend fun getTime(time: Long):Long {
        //alarmDao.insert(*alarms)
           return sleepDao.getTime(time)

    }

    override suspend fun getId():List<Sleep> {
        //alarmDao.insert(*alarms)
        return sleepDao.getId()

    }
}

