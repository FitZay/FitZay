package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import android.content.Context
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Build
import androidx.lifecycle.ViewModel
import com.fitzay.workouttracker.strengthtraining.R

class RingtoneModel : ViewModel() {
    private lateinit var ringtoneSound: Ringtone

    fun startRingtone(context: Context){
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
         ringtoneSound = RingtoneManager.getRingtone(context, ringtoneUri)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ringtoneSound.isLooping
        }
        ringtoneSound.play()
    }
    fun stopRingtone(){
        if (::ringtoneSound.isInitialized){
            ringtoneSound.stop()
        }
    }


    //Me Created Media Player

    fun playMedia(context:Context)
    {
        var mediaPlayer = MediaPlayer.create(context, R.raw.task_complete)
        mediaPlayer.start() // no need to call prepare(); create() does that for you
    }

}