package com.fitzay.workouttracker.strengthtraining.ui.callback

import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity

interface ShowAlarmItemClick {

    fun itemClick(position:Int,model:AlarmEntity,time:TextView,am_pm:TextView,label:TextView,day:TextView,switch:SwitchCompat)
    fun longItemClickForDelete(position:Int,model:AlarmEntity)

    fun switchOnOff(position:Int,model:AlarmEntity,value: Boolean)
}