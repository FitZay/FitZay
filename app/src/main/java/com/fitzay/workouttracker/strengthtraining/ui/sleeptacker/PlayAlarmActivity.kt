package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.TimeUnit
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.util.TimeUtils
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.core.utils.AlarmReceiver
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToMilliseconds
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPlayAlarmBinding
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class PlayAlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayAlarmBinding
    private lateinit var ringtoneSound: Ringtone

    var vibration=false
    private lateinit var vibrator: Vibrator

    var totalTime=0L
    override fun onCreate(savedInstanceState: Bundle?) {
        fullscreen(window.decorView)
        super.onCreate(savedInstanceState)
        binding = ActivityPlayAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        val type = intent!!.getStringExtra("ALARM_TYPE")
        val ringTone = intent!!.getStringExtra("ringtone")
        val label = intent!!.getStringExtra("label")
        vibration = intent!!.getBooleanExtra("vibration",false)
        val snooze = intent!!.getLongExtra("snooze",0)


        Log.e("Play", "Play Alarm for : $type")
        Log.e("Play", "Play Alarm for : $ringTone")
        Log.e("Play", "Play Alarm for : $label")
        Log.e("Play", "Play Alarm for : $vibration")

        if (type == "bedTime") {
            binding.txtWakeSleep.text = "Time To Sleep"
        } else {
            binding.txtWakeSleep.text = "W To WakeUp"
        }

        binding.alarmLabel.text = label
        turnOnScreen()
        getCurrentTime()

        try {
        startRingtone(Uri.parse(ringTone))

        }
        catch (e:Exception)
        {
            Log.i("TAG", "onCreate: "+e.message)
        }


        binding.snooze.setOnClickListener {
            stopRingtone()
            snoozeAlarm(snooze)
        }

        binding.layoutDismiss.setOnClickListener {
            stopRingtone()
            val intent = Intent(this@PlayAlarmActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()

        }

    }

    private fun startRingtone(rintone: Uri) {
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)

        if (vibration) {

            if (rintone != null) {
                ringtoneSound = RingtoneManager.getRingtone(this, rintone)
            } else {
                ringtoneSound = RingtoneManager.getRingtone(this, ringtoneUri)

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ringtoneSound.isLooping
            }

            //Vibration Code
            val pattern = longArrayOf(0, 100, 1000)
            vibrator.vibrate(pattern,0)

            ringtoneSound.play()
        }
        else
        {
            if (rintone != null) {
                ringtoneSound = RingtoneManager.getRingtone(this, rintone)
            } else {
                ringtoneSound = RingtoneManager.getRingtone(this, ringtoneUri)

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ringtoneSound.isLooping
            }
            ringtoneSound.play()
        }


    }

    private fun stopRingtone() {
        if (::ringtoneSound.isInitialized) {
            ringtoneSound.stop()
        }
        vibrator.cancel()

    }

    private fun turnOnScreen() {
        if (hasP()) {
            setShowWhenLocked(true)
            setTurnScreenOn(true)
        } else {
            @Suppress("DEPRECATION")
            window.addFlags(
                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
            )
        }
    }

    private fun hasP(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    }

    private fun fullscreen(view: View) {
        view.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    private fun getCurrentTime() {
        val calendar = Calendar.getInstance()
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)
        val am = if (hours >= 12) "PM" else "AM"
        binding.tvTime.text = "$hours:$minutes$am"
        binding.tvDate.text = getCurrentFormattedDate()

    }

    private fun getCurrentFormattedDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("d-MMMM, yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }

    private fun snoozeAlarm(snooze:Long) {
        val alarmManager: AlarmManager =
            getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent: PendingIntent =
            PendingIntent.getBroadcast(
                this,
                101,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        if (snooze==0L) {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                Calendar.getInstance().timeInMillis + 5 * 60000,  //...start alarm again after 5 minutes
                pendingIntent
            )
        }
        else
        {
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                snooze,  //...start alarm again after 5 minutes
                pendingIntent
            )
        }
        Log.i("TAG", "snoozeAlarm: "+snooze)
        finishAffinity()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        stopRingtone()
    }
}