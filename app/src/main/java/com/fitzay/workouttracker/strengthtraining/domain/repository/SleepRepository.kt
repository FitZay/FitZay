package com.fitzay.workouttracker.strengthtraining.domain.repository

import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.data.model.Sleep
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity
import kotlinx.coroutines.flow.Flow


interface SleepRepository {
    suspend fun getSleep(pageSize: Int) : Flow<List<SleepEntity>>
//    suspend fun addSleep( sleep: SleepEntity): Flow<UpdateStatus<Boolean>>
    suspend fun deleteItem(item: Long)
    //    suspend fun updateItem(item: AlarmEntity)
   // suspend fun updateItem(sleepID:Long,sleepTime:Long,sleepLable:String)

    suspend fun addSleep( sleep: SleepEntity)
    suspend fun getTime(time: Long):Long

    suspend fun getId(): List<Sleep>
}