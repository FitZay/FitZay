package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.util.SparseBooleanArray
import androidx.core.util.contains
import androidx.core.util.set
import androidx.lifecycle.*
import com.fitzay.workouttracker.strengthtraining.core.utils.ActionLiveData
import com.fitzay.workouttracker.strengthtraining.core.utils.AlarmAction
import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.util.*
import java.util.stream.LongStream

class AlarmViewModel(val alarmRepository: AlarmRepository) : ViewModel(), LifecycleObserver {

    var alarm: AlarmEntity? = null
    var isCreateMode: Boolean = true
    val actionListener by lazy { ActionLiveData<Pair<AlarmAction, UpdateStatus<Boolean>>>() }
    val bedTime = MutableLiveData<LocalTime>()
    val wakeTime = MutableLiveData<LocalTime>()
    val label = MutableLiveData<String>()
    val soundUri = MutableLiveData<String?>(null)
    val isVibrationEnabled = MutableLiveData(true)
    val weekDays = MutableLiveData<SparseBooleanArray>()

    var count=0L
    init {
        // set data from intent
//        savedStateHandle.get<AlarmEntity>(KEY_ALARM)?.let {
//            alarm = it
//            isCreateMode = false
//            bedTime.value = LocalTime.ofSecondOfDay(it.bedTime)
//            wakeTime.value = LocalTime.ofSecondOfDay(it.time)
//            soundUri.value = it.soundUri
//            isVibrationEnabled.value = it.isVibrationEnabled
//            label.value = it.label ?: ""
//            weekDays.value = initWeekDays(it.allDays)
//        } ?: run {
//            isCreateMode = true
//            //default
//            bedTime.value = LocalTime.of(22, 0)
//            wakeTime.value = LocalTime.of(7, 0)
//            soundUri.value = null
//            isVibrationEnabled.value = true
//            label.value = ""
//            weekDays.value = initWeekDays()
//        }
    }

    fun setBedTime(time: LocalTime) {
        bedTime.value = time
    }

    fun setWakeTime(time: LocalTime) {
        wakeTime.value = time
    }

    fun setVibrationEnable(isEnabled: Boolean) {
        isVibrationEnabled.value = isEnabled
    }

    fun setSoundUri(uri: Uri) {
        soundUri.value = uri.toString()
    }

    fun updateOrCreateAlarm(
        sleepId: Long,
        id:Long,
        selectedDay: String,
        bedTime: Long,
        alarmTime: Long,
        soundUri: String,
        label: String,
        snooze: Long,
        vibration: Boolean,
        isEnabled: Boolean,
        dayOfWeek: Int,
        number: Int,
        totalSleepingHr:String,
        date:String
    ) {

        viewModelScope.launch {
            //var label = convertDate(alarmTime.toString(), "dd-MM-yyyy");

            alarm = generateAlarm(
                sleepId,
                id,
                selectedDay,
                bedTime,
                alarmTime,
                soundUri,
                label,
                snooze,
                vibration,
                isEnabled,
                dayOfWeek,
                number,
                totalSleepingHr,
                date
            )

            alarmRepository.addAlarms(alarm!!).collect { result ->
                actionListener.postAction(Pair(AlarmAction.CREATE, result))
            }


        }
    }

    fun setSelectedDay(dayIndex: Int, isSelected: Boolean) {
        weekDays.value?.let { it[dayIndex] = isSelected }
    }




    private fun updateAlarm() {
        viewModelScope.launch {
            alarm?.let {
                //alarm = generateAlarm(it.id)
                alarmRepository.updateAlarms(alarm!!).collect { result ->
                    actionListener.postAction(Pair(AlarmAction.UPDATE, result))
                }
            }
        }
    }


    fun deleteAlarm() {
        viewModelScope.launch {
            alarm?.let {
                alarmRepository.deleteAlarms(it).collect { result ->
                    actionListener.postAction(Pair(AlarmAction.DELETE, result))
                }
            }
        }
    }
    fun deleteItem(item: AlarmEntity) {
        viewModelScope.launch {
            alarmRepository.deleteItem(item.sleepId)
        }
    }


    fun getAlamBySleepId(id:Long) {
        viewModelScope.launch {
            alarmRepository.getAlarmId(id)
        }
    }

    fun getAlamByADay(day:String) {
        viewModelScope.launch {
            alarmRepository.getAlarmForADay(day)
        }
    }


    fun updateItem(sleepId:Long,currentTime:Long,alarmTime:Long,alarmLable:String,alarmEnable:Boolean,alarmVibrate:Boolean,soundUri:String,alarmBT:Long,selectedDays:String,alarmSnoozeTime:Long,sleepHr:String,alarmDate:String) {
        viewModelScope.launch {
            alarmRepository.updateItem(sleepId,currentTime,alarmTime,alarmLable,alarmEnable,alarmVibrate,soundUri,alarmBT,selectedDays,alarmSnoozeTime,sleepHr,alarmDate)
        }
    }
//    fun updateItem(alarmTime:Long,alarmLable:String,alarmDate:String) {
//        viewModelScope.launch {
//            alarmRepository.updateItem(alarmTime,alarmLable,alarmDate)
//        }
//    }

    fun convertDate(dateInMilliseconds: String, dateFormat: String?): String {
        var formatter = SimpleDateFormat(dateFormat);
        return formatter.format(Date(dateInMilliseconds.toLong()))
    }

    fun generateAlarm(
        sleepId:Long,
        id:Long,
        selectedDay: String,
        bedTime: Long,
        alarmTime: Long,
        soundUri: String,
        label: String,
        snooze: Long,
        vibration: Boolean,
        isEnabled: Boolean,
        dayOfWeek: Int,
        number: Int,
        totalSleepingHr: String,
        date:String
    ) = AlarmEntity(
        id = id,
        sleepId =sleepId,
        time = alarmTime,
        label = label,
        isEnabled = isEnabled,
        isVibrationEnabled = vibration,
        soundUri = soundUri,
        allDays = weekDays.value,
        bedTime = bedTime,
        selectedDay =selectedDay,
        snoozeTime = snooze,
        totalSleepingHr =totalSleepingHr,
        date =date
    )


    private fun initWeekDays(array: SparseBooleanArray? = null): SparseBooleanArray {
        return array?.apply {
            (Calendar.SUNDAY..Calendar.SATURDAY).forEach {
                if (!contains(it)) {
                    put(it, false)
                }
            }
        } ?: run {
            SparseBooleanArray().apply {
                (Calendar.SUNDAY..Calendar.SATURDAY).forEach {
                    put(it, true)
                }
            }
        }
    }

}