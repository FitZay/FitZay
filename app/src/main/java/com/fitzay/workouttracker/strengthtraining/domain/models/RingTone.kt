package com.fitzay.workouttracker.strengthtraining.domain.models

import android.net.Uri

data class RingTone(var itemPos:Int,var ringToneName:String,var ringToneUri:Uri,var duration:String,var selection:Boolean=false) {
}