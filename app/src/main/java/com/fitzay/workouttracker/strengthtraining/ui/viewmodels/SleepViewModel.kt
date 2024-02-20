package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import android.icu.text.DateFormat
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.util.Log
import android.util.SparseBooleanArray
import androidx.core.util.contains
import androidx.core.util.set
import androidx.lifecycle.*
import com.fitzay.workouttracker.strengthtraining.core.utils.ActionLiveData
import com.fitzay.workouttracker.strengthtraining.core.utils.AlarmAction
import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository
import com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.util.*
import java.util.logging.SimpleFormatter
import kotlin.collections.ArrayList

class SleepViewModel(
    val sleepRepository: SleepRepository
) : ViewModel(), LifecycleObserver {

    var sleepEntity: SleepEntity? = null
    val actionListener by lazy { ActionLiveData<Pair<AlarmAction, UpdateStatus<Boolean>>>() }


    init {

    }


    fun createSleep(time: Long, label: String
    ) {
        viewModelScope.launch {
            //var label = convertDate(alarmTime.toString(), "dd-MM-yyyy");


            sleepEntity = generateAlarm(
                time,
                label
            )

            sleepRepository.addSleep(sleepEntity!!)
//            sleepRepository.addSleep(sleepEntity!!).collect { result ->
//                actionListener.postAction(Pair(AlarmAction.CREATE, result))
//            }


        }
    }



    fun deleteItem(item: SleepEntity) {
        viewModelScope.launch {
            sleepRepository.deleteItem(item.id)
        }
    }

    fun getTime(time: Long) {
        viewModelScope.launch {
            sleepRepository.getTime(time)
        }
    }
    fun getId() {
        viewModelScope.launch {
            sleepRepository.getId()
        }
    }

//    fun updateItem(id:Long,time:Long,label:String) {
//        viewModelScope.launch {
//            sleepRepository.updateItem(id,time,label)
//        }
//    }




    fun generateAlarm(
        time: Long,
        label: String

    ) = SleepEntity(
        time = time,
        label = label
    )



}