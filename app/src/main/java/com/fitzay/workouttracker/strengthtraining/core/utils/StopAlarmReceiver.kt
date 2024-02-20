package com.fitzay.workouttracker.strengthtraining.core.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.fitzay.workouttracker.strengthtraining.di.Component

class StopAlarmReceiver :BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1?.action == "ACTION_BUTTON_CLICK") {
            Component.ringtoneModel.stopRingtone()
        }
    }
}