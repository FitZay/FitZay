package com.fitzay.workouttracker.strengthtraining.ui.callback

import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.models.RingTone

interface ShowRingToneItemClick {

    fun itemClick(position:Int,model:RingTone,check:RadioButton)
}