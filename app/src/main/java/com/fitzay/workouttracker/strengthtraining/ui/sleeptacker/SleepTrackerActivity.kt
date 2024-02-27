package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.provider.Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AlarmReceiver
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDateTime
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToMilliseconds
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToMillisecondsHrAndMin
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayIndex
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayNameAndValue
import com.fitzay.workouttracker.strengthtraining.core.utils.listRingtones
import com.fitzay.workouttracker.strengthtraining.core.utils.systemDefaultAlarmTone
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepTrackerBinding
import com.fitzay.workouttracker.strengthtraining.databinding.DialogEditBedTimeBinding
import com.fitzay.workouttracker.strengthtraining.databinding.DialogStepGoalBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.RingTone
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.adapters.RingToneShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowRingToneItemClick
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import nl.joery.timerangepicker.TimeRangePicker
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SleepTrackerActivity : AppUtil2(), ShowRingToneItemClick {
    private lateinit var binding: ActivitySleepTrackerBinding

    private var ringToneAdapter: RingToneShowAdapter? = null
    private var selectedDays = mutableSetOf<Int>()


    private val TAG = "SleepTrackerActivity"


    private var lastSelectedItemPosition = RecyclerView.NO_POSITION
    var pos = 0


    var ringToneList = ArrayList<RingTone>()
    private var mediaPlayer: MediaPlayer? = null
    private var isMediaPlaying: Boolean = false

    var indexGen = 0
    var indexGenM = 0
    var indexGenT = 0
    var indexGenW = 0
    var indexGenTH = 0
    var indexGenF = 0
    var indexGenS = 0
    var indexGenSUN = 0

    var dateL = ArrayList<String>()
    var sleepId = 0L
    var storeDays = ArrayList<String>()
    var list = ArrayList<Int>()

    var default = false
    var alreadySet = false

    var onBack=""


    var permissionSave=false


    companion object {
        var ringToneUri: Uri? = null
        var ringToneName: String = ""
        var ringToneLabel: String = "Alarm"
        var ringToneVibration = false
        var milliSeconds = 0L
        var second = 0L
        var mintInText = "5 minutes"


        var totalSleepingHr = ""

        var alarmTimeInMilliSecond = 0L
        var bedTimeInMilliSecond = 0L

        var alarmTimeForScreenDisplay = ArrayList<Long>()
        var bedTimeForNotification = ArrayList<Long>()


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        var checker = intent.getStringExtra("key")!!
        onBack = intent.getStringExtra("onBack")!!
        var id = intent.getLongExtra("id", 0L)



        dateL = arrayListOf<String>()
        val calendar = Calendar.getInstance()

        Log.i("CHECK-ID", "onCreate: "+checker+"-"+id)
        milliSeconds = 5 * 60 * 1000

        binding.apply {


            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeSleepTracker.showAd) {
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            //setUpAlarms()
            ivBack.setOnClickListener {
                if (onBack=="summary")
                {
                    moveAct(SleepSummaryActivity::class.java)
                }
                else
                {
                    moveAct(SleepTrackerHomeScreen::class.java)

                }
            }



                alarmOnOffSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {

                        if (Settings.canDrawOverlays(this@SleepTrackerActivity))
                        {
                            layoutVisible()
                        }
                        else
                        {
                            AlertDialog.Builder(this@SleepTrackerActivity)
                                .setTitle(getString(R.string.need_permission))
                                .setMessage(getString(R.string.draw_allow))
                                .setCancelable(false)
                                .setPositiveButton(
                                    getString(R.string.allow)
                                ) { _, _ ->
                                    val intent = Intent(
                                        Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                                        Uri.parse("package:${this@SleepTrackerActivity.packageName}")
                                    )
                                    startActivityForResult(intent,987)
                                }.show()
                        }



                    } else {
                        layoutInvisible()
                    }



                }



            //Days Click Listener
            daysClickListener()



            if (checker == "newAlarmSet") {

                var hourStart = TimeRangePicker.Time(22, 0).hour
                var minStart = TimeRangePicker.Time(22, 0).minute

                var hourEnd = TimeRangePicker.Time(6, 0).hour
                var minEnd = TimeRangePicker.Time(6, 0).minute



                val timeFormat = String.format(
                    "%02d:%02d %s",
                    if (hourStart > 12) hourStart - 12 else hourStart,
                    minStart,
                    if (hourStart >= 12) "PM" else "AM"
                )
                val timeFormat2 = String.format(
                    "%02d:%02d %s",
                    if (hourEnd > 12) hourEnd - 12 else hourEnd,
                    minEnd,
                    if (hourEnd >= 12) "PM" else "AM"
                )

                Log.i("5678", "onCreate: "+hourStart+"-"+minStart+"---"+hourEnd+"-"+minEnd)
                tvBedTime.text = timeFormat
                tvWakeTime.text = timeFormat2




                binding.txtTwelve.text = binding.picker.duration.hour.toString() + " hr " + binding.picker.duration.minute + " min"

                val calendar_1 = Calendar.getInstance()
                val formatter = SimpleDateFormat("dd-MM-yyyy")
                val currentDateString = formatter.format(calendar.time)

                val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
                indexGen = 0

                for (i in 0 until 7) {
                    val currentDateString_1 = formatter.format(calendar_1.time)
                    dateL.add(currentDateString_1)
                    calendar_1.add(Calendar.DAY_OF_YEAR, 1)
                }

                when (dayOfWeek) {
                    Calendar.SUNDAY -> {
                        txtSunday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtSunday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 0
                        if (!list.contains(indexGenSUN) && list.size == 0) {
                            list.add(indexGenSUN)
                            storeDays.add(dateL[indexGenSUN])
                        }


                    }

                    Calendar.MONDAY -> {
                        txtMonday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtMonday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 1
                        if (!list.contains(indexGenM) && list.size == 0) {
                            list.add(indexGenM)
                            storeDays.add(dateL[indexGenM])
                        }


                    }

                    Calendar.TUESDAY -> {
                        txtTuesday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtTuesday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 2

                        if (!list.contains(indexGenT) && list.size == 0) {
                            list.add(indexGenT)
                            storeDays.add(dateL[indexGenT])
                        }

                    }

                    Calendar.WEDNESDAY -> {
                        txtWednesday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtWednesday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 3
                        if (!list.contains(indexGenW) && list.size == 0) {
                            list.add(indexGenW)
                            storeDays.add(dateL[indexGenW])
                        }

                    }

                    Calendar.THURSDAY -> {
                        txtThursday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtThursday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 4
                        if (!list.contains(indexGenTH) && list.size == 0) {
                            list.add(indexGenTH)
                            storeDays.add(dateL[indexGenTH])
                        }

                    }

                    Calendar.FRIDAY -> {
                        txtFriday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtFriday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 5
                        if (!list.contains(indexGenF) && list.size == 0) {
                            list.add(indexGenF)
                            storeDays.add(dateL[indexGenF])
                        }

                    }

                    Calendar.SATURDAY -> {
                        txtSaturday.setBackgroundResource(R.drawable.bg_circle_yellow)
                        txtSaturday.setTextColor(
                            ContextCompat.getColor(
                                this@SleepTrackerActivity,
                                R.color.text_color
                            )
                        )
                        indexGen = 6
                        if (!list.contains(indexGenS) && list.size == 0) {
                            list.add(indexGenS)
                            storeDays.add(dateL[indexGenS])
                        }
                    }
                }

                Handler().postDelayed({
                    when (indexGen) {
                        1 -> {
                            indexGenM = 0
                            indexGenT = 1
                            indexGenW = 2
                            indexGenTH = 3
                            indexGenF = 4
                            indexGenS = 5
                            indexGenSUN = 6
                        }

                        2 -> {
                            indexGenT = 0
                            indexGenW = 1
                            indexGenTH = 2
                            indexGenF = 3
                            indexGenS = 4
                            indexGenSUN = 5
                            indexGenM = 6
                        }

                        3 -> {
                            indexGenW = 0
                            indexGenTH = 1
                            indexGenF = 2
                            indexGenS = 3
                            indexGenSUN = 4
                            indexGenM = 5
                            indexGenT = 6
                        }

                        4 -> {

                            indexGenTH = 0
                            indexGenF = 1
                            indexGenS = 2
                            indexGenSUN = 3
                            indexGenM = 4
                            indexGenT = 5
                            indexGenW = 6
                        }

                        5 -> {

                            indexGenF = 0
                            indexGenS = 1
                            indexGenSUN = 2
                            indexGenM = 3
                            indexGenT = 4
                            indexGenW = 5
                            indexGenTH = 6
                        }

                        6 -> {
                            indexGenS = 0
                            indexGenSUN = 1
                            indexGenM = 2
                            indexGenT = 3
                            indexGenW = 4
                            indexGenTH = 5
                            indexGenF = 6
                        }

                        0 -> {

                            indexGenSUN = 0
                            indexGenM = 1
                            indexGenT = 2
                            indexGenW = 3
                            indexGenTH = 4
                            indexGenF = 5
                            indexGenS = 6
                        }


                    }
                }, 1200)

                ivSave.setOnClickListener {
                    try {
                        if (list.size == 0) {
                            Toast.makeText(
                                this@SleepTrackerActivity,
                                "Select Day",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        } else {


                            if (tvBedTime.text.toString() == "0h 0m a") {
                                Toast.makeText(
                                    this@SleepTrackerActivity,
                                    "Select Bed Time ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (tvWakeTime.text.toString() == "0h 0m a") {
                                Toast.makeText(
                                    this@SleepTrackerActivity,
                                    "Select Wake Time ",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {

                                var time = System.currentTimeMillis()

                                list.forEach {
                                    when (it) {
                                        1 -> {
                                            if (!storeDays.contains(dateL[1])) {
                                                storeDays.add(dateL[1])
                                            }
                                        }

                                        2 -> {
                                            if (!storeDays.contains(dateL[2])) {
                                                storeDays.add(dateL[2])

                                            }
                                        }

                                        3 -> {

                                            if (!storeDays.contains(dateL[3])) {
                                                storeDays.add(dateL[3])

                                            }
                                        }

                                        4 -> {

                                            if (!storeDays.contains(dateL[4])) {
                                                storeDays.add(dateL[4])

                                            }
                                        }

                                        5 -> {

                                            if (!storeDays.contains(dateL[5])) {
                                                storeDays.add(dateL[5])

                                            }
                                        }

                                        6 -> {

                                            if (!storeDays.contains(dateL[6])) {
                                                storeDays.add(dateL[6])

                                            }
                                        }

                                        7 -> {
                                            if (!storeDays.contains(dateL[7])) {
                                                storeDays.add(dateL[7])

                                            }

                                        }

                                        0 -> {
                                            if (!storeDays.contains(dateL[0])) {
                                                storeDays.add(dateL[0])

                                            }

                                        }

                                    }

                                }

                                ivSave.isClickable = false

                                var aTime = convertTimeToMillisecondsHrAndMin(tvWakeTime.text.toString())
                                var bTime = convertTimeToMillisecondsHrAndMin(tvBedTime.text.toString())

                                alarmTimeInMilliSecond = timeInMilliSecondForAlarm(aTime.first, aTime.second)
                                bedTimeInMilliSecond = timeInMilliSecondForBed(bTime.first, bTime.second)


//                                alarmTimeInMilliSecond=convertTimeToMilliseconds(tvWakeTime.text.toString())
//                                bedTimeInMilliSecond=convertTimeToMilliseconds(tvBedTime.text.toString())

                                totalSleepingHr = binding.txtTwelve.text.toString()

                                CoroutineScope(Dispatchers.IO).launch {

                                    for (i in 0 until storeDays.size) {

                                        var alarmForASelectedDay =
                                            Component.alarmViewModel.alarmRepository.getAlarmForADay(
                                                list[i].toString()
                                            )

                                        if (ringToneUri != null) {

                                            if (alarmForASelectedDay.isEmpty()) {
                                                if (!default) {
                                                    default = true
                                                    Component.sleepViewModel.createSleep(time, "HI")
                                                }
                                                Handler(Looper.getMainLooper()).postDelayed({
                                                    CoroutineScope(Dispatchers.IO).launch {
                                                        Component.alarmViewModel.updateOrCreateAlarm(
                                                            Component.sleepViewModel.sleepRepository.getTime(
                                                                time
                                                            ), time, list[i].toString(),
                                                            bedTimeInMilliSecond,
                                                            alarmTimeInMilliSecond,
                                                            ringToneUri!!.toString(),
                                                            ringToneLabel,
                                                            milliSeconds,
                                                            ringToneVibration,Component.preference.alarmOnOff,
                                                            0,
                                                            1,
                                                            totalSleepingHr,
                                                            storeDays[i]
                                                        )
                                                    }

                                                }, 1200)

                                            } else {
                                                if (!alreadySet) {
                                                    alreadySet = true
                                                    withContext(Dispatchers.Main) {
                                                        Toast.makeText(
                                                            this@SleepTrackerActivity,
                                                            "Already Set this Day",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                }



                                            }

                                        } else {

                                            if (alarmForASelectedDay.isEmpty()) {
                                                if (!default) {
                                                    default = true
                                                    Component.sleepViewModel.createSleep(time, "HI")
                                                }

                                                Handler(Looper.getMainLooper()).postDelayed({
                                                    CoroutineScope(Dispatchers.IO).launch {
                                                        Component.alarmViewModel.updateOrCreateAlarm(
                                                            Component.sleepViewModel.sleepRepository.getTime(
                                                                time
                                                            ), time,
                                                            list[i].toString(),
                                                            bedTimeInMilliSecond,
                                                            alarmTimeInMilliSecond,
                                                            systemDefaultAlarmTone().toString(),
                                                            ringToneLabel,
                                                            milliSeconds,
                                                            ringToneVibration,Component.preference.alarmOnOff,
                                                            0,
                                                            1,
                                                            totalSleepingHr,
                                                            storeDays[i]
                                                        )
                                                    }

                                                }, 1200)


                                            } else {
                                                if (!alreadySet) {
                                                    alreadySet = true
                                                    withContext(Dispatchers.Main) {
                                                        Toast.makeText(
                                                            this@SleepTrackerActivity,
                                                            "Already Set this Day",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                }


                                            }
                                        }
                                    }

                                    if (ringToneUri != null) {
                                        scheduleReminder(
                                            "wakeTime",
                                            ringToneUri!!.toString(),
                                            ringToneVibration,
                                            ringToneLabel,
                                        )
                                        scheduleBedTimeNotification(
                                            "bedTime"
                                        )

                                        Log.i("kkkkk", "if: ")
                                    } else {
                                        scheduleReminder(
                                            "wakeTime",
                                            systemDefaultAlarmTone().toString(),
                                            ringToneVibration,
                                            ringToneLabel
                                        )
                                        scheduleBedTimeNotification(
                                            "bedTime"
                                        )
                                        Log.i("kkkkk", "else: ")

                                    }


                                    runOnUiThread {
                                        Handler().postDelayed({
                                            startActivity(
                                                Intent(
                                                    this@SleepTrackerActivity,
                                                    SleepTrackerHomeScreen::class.java
                                                )
                                            )
                                            finish()
                                        }, 1500)
                                    }
                                }
                            }

                        }
                    } catch (e: Exception) {
                        Log.i("TAG", "onCreate--+++---: " + e.message)

                    }

                }
            }
            else if (checker == "homeScreen" && id != 0L) {
                dummy()
                CoroutineScope(Dispatchers.IO).launch {

                    val result=Component.alarmViewModel.alarmRepository.getAlarmId(id)
                    for (model in result) {
                        if (model.isEnabled)
                        {

                            withContext(Dispatchers.Main) {
                                layoutVisible()
                                alarmOnOffSwitch.isChecked = true
                            }
                        }
                        else
                        {

                            withContext(Dispatchers.Main) {
                                layoutInvisible()
                                alarmOnOffSwitch.isChecked = false
                            }
                        }
                    }
                }


                CoroutineScope(Dispatchers.IO).launch {
                    Component.alarmViewModel.alarmRepository.getAlarms(1)
                        .collect { result ->
                            for (i in result.listIterator().iterator()) {
                                if (id == i.sleepId) {

                                    withContext(Dispatchers.Main)
                                    {

                                        txtTwelve.text = i.totalSleepingHr
                                        tvLabel.text = i.label!!
                                        tvWakeTime.text = convertDateTime(
                                            i.time.toString(),
                                            "hh:mm"
                                        ) + " " + convertDateTime(i.time.toString(), "aa")
                                        tvBedTime.text = convertDateTime(
                                            i.bedTime.toString(),
                                            "hh:mm"
                                        ) + " " + convertDateTime(i.bedTime.toString(), "aa")

                                        when (i.snoozeTime) {
                                            300000L -> {
                                                tvSnooze.text = "5 minutes"
                                            }

                                            600000L -> {
                                                tvSnooze.text = "10 minutes"
                                            }

                                            900000L -> {
                                                tvSnooze.text = "15 minutes"
                                            }

                                            1200000L -> {
                                                tvSnooze.text = "20 minutes"
                                            }

                                            1500000L -> {
                                                tvSnooze.text = "25 minutes"
                                            }

                                            1800000L -> {
                                                tvSnooze.text = "30 minutes"
                                            }
                                        }


                                        var dayOfWeek = getDayIndex(i.date!!)


                                        when (dayOfWeek) {
                                            Calendar.SUNDAY -> {
                                                txtSunday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtSunday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenSUN)) {
                                                    list.add(indexGenSUN)

                                                }


                                            }

                                            Calendar.MONDAY -> {
                                                txtMonday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtMonday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenM)) {
                                                    list.add(indexGenM)

                                                }

//
                                            }

                                            Calendar.TUESDAY -> {

                                                txtTuesday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtTuesday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )


                                                if (!list.contains(indexGenT)) {
                                                    list.add(indexGenT)

                                                }
//
                                            }

                                            Calendar.WEDNESDAY -> {
                                                txtWednesday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtWednesday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenW)) {
                                                    list.add(indexGenW)
                                                }
                                            }

                                            Calendar.THURSDAY -> {
                                                txtThursday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtThursday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenTH)) {
                                                    list.add(indexGenTH)


                                                }


                                            }

                                            Calendar.FRIDAY -> {
                                                txtFriday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtFriday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenF)) {
                                                    list.add(indexGenF)

                                                }

                                            }

                                            Calendar.SATURDAY -> {
                                                txtSaturday.setBackgroundResource(R.drawable.bg_circle_yellow)
                                                txtSaturday.setTextColor(
                                                    ContextCompat.getColor(
                                                        this@SleepTrackerActivity,
                                                        R.color.text_color
                                                    )
                                                )
                                                if (!list.contains(indexGenS)) {
                                                    list.add(indexGenS)

                                                }

                                            }
                                        }


                                        dateL.forEach {
                                            if (it == i.date!!) {
                                                if (!storeDays.contains(it)) {
                                                    storeDays.add(it)

                                                }
                                            }
                                        }


                                        //selectAllDay.visibility = View.INVISIBLE


                                        ivSave.setOnClickListener {

                                            ivSave.isClickable = false

                                            //Update Data
                                            var updateSleepHr = txtTwelve.text.toString()
                                            var updateLabel = tvLabel.text.toString()
//                                            var updateAlarmTime = convertTimeToMilliseconds(tvWakeTime.text.toString())
//                                            var updateBedTime = convertTimeToMilliseconds(tvBedTime.text.toString())

                                            var aTime = convertTimeToMillisecondsHrAndMin(tvWakeTime.text.toString())
                                            var bTime = convertTimeToMillisecondsHrAndMin(tvBedTime.text.toString())

                                            var updateAlarmTime = timeInMilliSecondForAlarm(aTime.first, aTime.second)
                                            var updateBedTime = timeInMilliSecondForBed(bTime.first, bTime.second)

                                            var updateSnoozeTime = 0L
                                            when (tvSnooze.text.toString()) {
                                                "5 minutes" -> {
                                                    updateSnoozeTime = 5 * 60 * 1000
                                                }

                                                "10 minutes" -> {
                                                    updateSnoozeTime = 10 * 60 * 1000
                                                }

                                                "15 minutes" -> {
                                                    updateSnoozeTime = 15 * 60 * 1000
                                                }

                                                "20 minutes" -> {
                                                    updateSnoozeTime = 20 * 60 * 1000
                                                }

                                                "25 minutes" -> {
                                                    updateSnoozeTime = 25 * 60 * 1000
                                                }

                                                "30 minutes" -> {
                                                    updateSnoozeTime = 30 * 60 * 1000
                                                }
                                            }


                                            var time = System.currentTimeMillis()
                                            CoroutineScope(Dispatchers.IO).launch {
                                                Component.alarmViewModel.alarmRepository.deleteItem(
                                                    id
                                                )




                                                Log.i("TYR", "sDay: " + storeDays.size)
                                                for (i in 0 until storeDays.size) {

                                                    Log.i("HACK", "onCreate: " + list[i])
                                                    Log.i("HACK", "sDay: " + storeDays[i])
                                                    if (ringToneUri != null) {
                                                        Handler(Looper.getMainLooper()).postDelayed(
                                                            {
                                                                CoroutineScope(Dispatchers.IO).launch {
                                                                    Component.alarmViewModel.updateOrCreateAlarm(
                                                                        id,
                                                                        time,
                                                                        list[i].toString(),
                                                                        updateBedTime,
                                                                        updateAlarmTime,
                                                                        ringToneUri!!.toString(),
                                                                        updateLabel,
                                                                        updateSnoozeTime,
                                                                        ringToneVibration,Component.preference.alarmOnOff,
                                                                        0,
                                                                        1,
                                                                        updateSleepHr,
                                                                        storeDays[i]
                                                                    )
                                                                }

                                                            },
                                                            1200
                                                        )
                                                    } else {


                                                        Handler(Looper.getMainLooper()).postDelayed(
                                                            {
                                                                CoroutineScope(Dispatchers.IO).launch {
                                                                    Component.alarmViewModel.updateOrCreateAlarm(
                                                                        id, time,
                                                                        list[i].toString(),
                                                                        updateBedTime,
                                                                        updateAlarmTime,
                                                                        systemDefaultAlarmTone().toString(),
                                                                        updateLabel,
                                                                        updateSnoozeTime,
                                                                        ringToneVibration,Component.preference.alarmOnOff,
                                                                        0,
                                                                        1,
                                                                        updateSleepHr,
                                                                        storeDays[i]
                                                                    )
                                                                }

                                                            },
                                                            1200
                                                        )

                                                    }
                                                }


                                                if (ringToneUri != null) {
                                                    scheduleReminder(
                                                        "wakeTime",
                                                        ringToneUri!!.toString(),
                                                        ringToneVibration,
                                                        updateLabel,
                                                    )
                                                    scheduleBedTimeNotification(
                                                        "bedTime"
                                                    )

                                                } else {
                                                    scheduleReminder(
                                                        "wakeTime",
                                                        systemDefaultAlarmTone().toString(),
                                                        ringToneVibration,
                                                        updateLabel
                                                    )
                                                    scheduleBedTimeNotification(
                                                        "bedTime"
                                                    )
                                                }



                                                runOnUiThread {
                                                    Handler().postDelayed({
                                                        startActivity(
                                                            Intent(
                                                                this@SleepTrackerActivity,
                                                                SleepTrackerHomeScreen::class.java
                                                            )
                                                        )
                                                        finish()
                                                    }, 1500)
                                                }


                                            }

                                        }

                                    }


                                }
                            }
                        }

                }
            }




            picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
                override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                    Log.e(TAG, "Start time: ${startTime.calendar}")

                    val hourStart = binding.picker.startTime.hour
                    val minStart = binding.picker.startTime.minute

                    val timeFormat = String.format(
                        "%02d:%02d %s",
                        if (hourStart > 12) hourStart - 12 else hourStart,
                        minStart,
                        if (hourStart >= 12) "PM" else "AM"
                    )
                    tvBedTime.text = timeFormat
                    Component.preference.bedTime = timeFormat


                }

                override fun onEndTimeChange(endTime: TimeRangePicker.Time) {

                    val hourStart = picker.endTime.hour
                    val minStart = picker.endTime.minute
                    val timeFormat = String.format(
                        "%02d:%02d %s",
                        if (hourStart > 12) hourStart - 12 else hourStart,
                        minStart,
                        if (hourStart >= 12) "PM" else "AM"
                    )
                    tvWakeTime.text = timeFormat
                    Component.preference.wakeTime = timeFormat


                }

                override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                    binding.txtTwelve.text =
                        duration.hour.toString() + " hr " + duration.minute + " min"

                    totalSleepingHr = binding.txtTwelve.text.toString()


                }
            })

            picker.setOnDragChangeListener(object : TimeRangePicker.OnDragChangeListener {
                override fun onDragStart(thumb: TimeRangePicker.Thumb): Boolean {
                    // Do something on start dragging
                    if (thumb != TimeRangePicker.Thumb.START) {
                        //      animate(thumb, true)
                        Log.i("PIC", "IF: ")
                    }
                    Log.i("PIC", "OUT: ")
                    return true // Return false to disallow the user from dragging a handle.

                }

                override fun onDragStop(thumb: TimeRangePicker.Thumb) {
                    // Do something on stop dragging
                    Log.i("PIC", "onDragStop: " + thumb.name)
                }
            })

            layoutBed.setOnClickListener {
                timePickerForBedTimeDialog(true)
            }

            //Button Listener
            layoutAlarm.setOnClickListener {
                timePickerDialog(false)
            }


            //Alarm Sound Working
            var dialog = Dialog(this@SleepTrackerActivity)
            layoutAlarmSound.setOnClickListener {

                ringToneList = listRingtones()
                dialog.setContentView(R.layout.ringtone_show_dialog)
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

                var ringToneRv = dialog.findViewById<RecyclerView>(R.id.ringToneRv)
                var save = dialog.findViewById<View>(R.id.cancel_dialog)
                var back = dialog.findViewById<View>(R.id.back_dialog)
                ringToneRv.layoutManager = LinearLayoutManager(
                    this@SleepTrackerActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                ringToneAdapter = RingToneShowAdapter(
                    this@SleepTrackerActivity,
                    ringToneList,
                    this@SleepTrackerActivity
                )



                ringToneRv.adapter = ringToneAdapter

                dialog.show()
                save.setOnClickListener {
                    dialog.dismiss()
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null
                    isMediaPlaying = false

                    if (ringToneName != "") {
                        binding.tvSound.text = ringToneName
                    }
                }
                back.setOnClickListener {
                    dialog.dismiss()
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null
                    isMediaPlaying = false

                    if (ringToneName != "") {
                        binding.tvSound.text = ringToneName
                    }
                }

            }

            //Label Working

            layoutLabel.setOnClickListener {
                labelDialog()
            }

            //Snooze Working
            layoutSnooze.setOnClickListener {
                snoozeDialog()
            }




            swOnOff.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    ringToneVibration = isChecked
                    Log.i("TAG", "check: " + ringToneVibration)
                } else {
                    ringToneVibration = isChecked
                    Log.i("TAG", "check---: " + ringToneVibration)
                }
            }


        }


    }

    fun timeInMilliSecondForBed(hr: Int, min: Int): Long {
        val selectedCalendar = Calendar.getInstance()
        storeDays.forEach { date ->
            val dateFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = dateFormat.parse(date)
            selectedCalendar.time = date
            selectedCalendar.set(Calendar.HOUR_OF_DAY, hr)
            selectedCalendar.set(Calendar.MINUTE, min)
            selectedCalendar.set(Calendar.SECOND, 0)
            selectedCalendar.set(Calendar.MILLISECOND, 0)
            bedTimeForNotification.add(selectedCalendar.timeInMillis)
        }
        return selectedCalendar.timeInMillis

    }

    fun timeInMilliSecondForAlarm(hr: Int, min: Int): Long {
        val selectedCalendar = Calendar.getInstance()
        storeDays.forEach { date ->
            val dateFormat = SimpleDateFormat("dd-MM-yyyy")
            val date = dateFormat.parse(date)
            selectedCalendar.time = date
            selectedCalendar.set(Calendar.HOUR_OF_DAY, hr)
            selectedCalendar.set(Calendar.MINUTE, min)
            selectedCalendar.set(Calendar.SECOND, 0)
            selectedCalendar.set(Calendar.MILLISECOND, 0)
            alarmTimeForScreenDisplay.add(selectedCalendar.timeInMillis)
        }
        return selectedCalendar.timeInMillis

    }

    fun daysClickListener() {
        binding.apply {

            txtMonday.setOnClickListener {
                toggleDaySelection(txtMonday, indexGenM)

            }
            txtTuesday.setOnClickListener {
                toggleDaySelection(txtTuesday, indexGenT)


            }
            txtWednesday.setOnClickListener {
                toggleDaySelection(txtWednesday, indexGenW)

            }
            txtThursday.setOnClickListener {
                toggleDaySelection(txtThursday, indexGenTH)
            }
            txtFriday.setOnClickListener {
                toggleDaySelection(txtFriday, indexGenF)
            }
            txtSaturday.setOnClickListener {
                toggleDaySelection(txtSaturday, indexGenS)

            }
            txtSunday.setOnClickListener {
                toggleDaySelection(txtSunday, indexGenSUN)
            }
        }
    }

    fun dummy() {
        // Get Current Date
        val calendar = Calendar.getInstance()
        val calendar_1 = Calendar.getInstance()
        val formatter = SimpleDateFormat("dd-MM-yyyy")
        val currentDateString = formatter.format(calendar.time)

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        indexGen = 0


        for (i in 0 until 7) {
            val currentDateString_1 = formatter.format(calendar_1.time)
            dateL.add(currentDateString_1)
            calendar_1.add(Calendar.DAY_OF_YEAR, 1)
            Log.i("TAG", "onCreate: " + dateL)
        }


        when (dayOfWeek) {
            Calendar.SUNDAY -> {
                indexGen = 0
            }

            Calendar.MONDAY -> {
                indexGen = 1
            }

            Calendar.TUESDAY -> {
                indexGen = 2
            }

            Calendar.WEDNESDAY -> {

                indexGen = 3


            }

            Calendar.THURSDAY -> {
                indexGen = 4
            }

            Calendar.FRIDAY -> {
                indexGen = 5
            }

            Calendar.SATURDAY -> {
                indexGen = 6

            }
        }

        when (indexGen) {
            1 -> {
                indexGenM = 0
                indexGenT = 1
                indexGenW = 2
                indexGenTH = 3
                indexGenF = 4
                indexGenS = 5
                indexGenSUN = 6
            }

            2 -> {
                indexGenT = 0
                indexGenW = 1
                indexGenTH = 2
                indexGenF = 3
                indexGenS = 4
                indexGenSUN = 5
                indexGenM = 6
            }

            3 -> {

                indexGenW = 0
                indexGenTH = 1
                indexGenF = 2
                indexGenS = 3
                indexGenSUN = 4
                indexGenM = 5
                indexGenT = 6
            }

            4 -> {

                indexGenTH = 0
                indexGenF = 1
                indexGenS = 2
                indexGenSUN = 3
                indexGenM = 4
                indexGenT = 5
                indexGenW = 6
            }

            5 -> {

                indexGenF = 0
                indexGenS = 1
                indexGenSUN = 2
                indexGenM = 3
                indexGenT = 4
                indexGenW = 5
                indexGenTH = 6
            }

            6 -> {
                indexGenS = 0
                indexGenSUN = 1
                indexGenM = 2
                indexGenT = 3
                indexGenW = 4
                indexGenTH = 5
                indexGenF = 6
            }

            0 -> {

                indexGenSUN = 0
                indexGenM = 1
                indexGenT = 2
                indexGenW = 3
                indexGenTH = 4
                indexGenF = 5
                indexGenS = 6
            }


        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateTimes() {
        binding.tvWakeTime.text = binding.picker.endTime.toString()
        binding.tvBedTime.text = binding.picker.startTime.toString()


    }

    private fun updateTimer(
        timeFormat: String,
        selectedHour: Int,
        selectedMinute: Int,
        isBedTime: Boolean
    ) {

        Log.d("Bedtimepicker" , "$isBedTime")
        if (isBedTime) {
            Component.preference.bedTime = timeFormat
            binding.tvBedTime.text = timeFormat
            binding.picker.startTime = TimeRangePicker.Time(selectedHour, selectedMinute)
            binding.txtTwelve.text = binding.picker.duration.hour.toString() + " hr " + binding.picker.duration.minute + " min"

        } else {
            Component.preference.wakeTime = timeFormat
            binding.tvWakeTime.text = timeFormat
            binding.picker.endTimeMinutes = (selectedHour*60)+selectedMinute
            binding.txtTwelve.text = binding.picker.duration.hour.toString() + " hr " + binding.picker.duration.minute + " min"


        }
    }


    private fun timePickerForBedTimeDialog(isBedTime: Boolean) {

        val dialog = Dialog(this@SleepTrackerActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bedTimeBinding = DialogEditBedTimeBinding.inflate(layoutInflater)
        dialog.setContentView(bedTimeBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        bedTimeBinding.timePicker.setIs24HourView(true)

        bedTimeBinding.btnSave.setOnClickListener {

            val selectedCalendar = Calendar.getInstance()

            storeDays.forEach { date ->
                val dateFormat = SimpleDateFormat("dd-MM-yyyy")
                val date = dateFormat.parse(date)
                selectedCalendar.time = date
                selectedCalendar.set(Calendar.HOUR_OF_DAY, bedTimeBinding.timePicker.hour)
                selectedCalendar.set(Calendar.MINUTE, bedTimeBinding.timePicker.minute)
                selectedCalendar.set(Calendar.SECOND, 0)
                selectedCalendar.set(Calendar.MILLISECOND, 0)
                bedTimeForNotification.add(selectedCalendar.timeInMillis)
            }


            val selectedHour = selectedCalendar.get(Calendar.HOUR_OF_DAY)
            val selectedMinute = selectedCalendar.get(Calendar.MINUTE)


            val timeFormat = String.format(
                "%02d:%02d %s",
                if (selectedHour > 12) selectedHour - 12 else selectedHour,
                selectedMinute,
                if (selectedHour >= 12) "PM" else "AM"
            )

            updateTimer(timeFormat, selectedHour, selectedMinute, true)
            dialog.dismiss()


            Log.i("TAG", "timePickerDialog: " + selectedCalendar.timeInMillis)
        }
        bedTimeBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun timePickerDialog(isBedTime: Boolean) {

        val dialog = Dialog(this@SleepTrackerActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val bedTimeBinding = DialogEditBedTimeBinding.inflate(layoutInflater)
        dialog.setContentView(bedTimeBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        bedTimeBinding.timePicker.setIs24HourView(true)




        bedTimeBinding.btnSave.setOnClickListener {

            val selectedCalendar = Calendar.getInstance()
            storeDays.forEach { date ->
                val dateFormat = SimpleDateFormat("dd-MM-yyyy")
                val date = dateFormat.parse(date)
                selectedCalendar.time = date
                selectedCalendar.set(Calendar.HOUR_OF_DAY, bedTimeBinding.timePicker.hour)
                selectedCalendar.set(Calendar.MINUTE, bedTimeBinding.timePicker.minute)
                selectedCalendar.set(Calendar.SECOND, 0)
                selectedCalendar.set(Calendar.MILLISECOND, 0)

                alarmTimeForScreenDisplay.add(selectedCalendar.timeInMillis)


            }

            Log.i("Pick", "timePickerDialog: " + selectedCalendar.timeInMillis)

            var selectedHour = selectedCalendar.get(Calendar.HOUR_OF_DAY)
            var selectedMinute = selectedCalendar.get(Calendar.MINUTE)


            val timeFormat = String.format(
                "%02d:%02d %s",
                if (selectedHour > 12) selectedHour - 12 else selectedHour,
                selectedMinute,
                if (selectedHour >= 12) "PM" else "AM"
            )

            updateTimer(timeFormat, selectedHour, selectedMinute, false)
            dialog.dismiss()

        }
        bedTimeBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


    @SuppressLint("ResourceAsColor")
    private fun toggleDaySelection(dayView: TextView, dayOfWeek: Int) {

        if (!list.contains(dayOfWeek)) {

            list.add(dayOfWeek)
            storeDays.add(dateL[dayOfWeek])
            Log.i(
                "ifffffffffffffffff",
                "toggleDaySelection: " + dayOfWeek + "=======" + list + "00000" + storeDays
            )

            dayView.setBackgroundResource(R.drawable.bg_circle_yellow) // Set selected background
            dayView.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.text_color
                )
            ) // Use color resource
        } else {
            Log.i("ifffffffffffffffff", "toggleDaySelectionelseeeeeeee: " + dayOfWeek)

            list.remove(dayOfWeek)
            storeDays.remove(dateL[dayOfWeek])
            dayView.setBackgroundResource(0)
            if (dayOfWeek == 7) {
                dayView.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.red
                    )
                ) // Use color resource
            }
            dayView.setTextColor(
                ContextCompat.getColor(
                    this,
                    R.color.tab_not_selected
                )
            ) // Use color resource
        }

    }


    private fun scheduleReminder(
        type: String,
        ringTone: String,
        vibration: Boolean,
        label: String,
    ) {

        if (Component.preference.alarmOnOff) {
            try {
                var index = 1
                for (timeInMill in bedTimeForNotification) {
                    var alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                    val intent = Intent(this, AlarmReceiver::class.java)
                    intent.putExtra("ALARM_TYPE", type)
                    intent.putExtra("ringtone", ringTone)
                    intent.putExtra("vibration", vibration)
                    intent.putExtra("label", label)
                    intent.putExtra("snooze", milliSeconds)
                    intent.putExtra("alarmTimeForScreenDisplay", timeInMill)

                    val pendingIntent = PendingIntent.getBroadcast(
                        this,
                        index++,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )

                    if (timeInMill > System.currentTimeMillis()) {
                        alarmManager.setExact(
                            AlarmManager.RTC_WAKEUP,
                            timeInMill,
                            //   24*60*60*1000,
                            pendingIntent
                        )
                        Log.i("KKKK", "Alarm set for it: " + timeInMill)
                    } else {
                        Log.i("KKKK", "Skipping past time it: " + timeInMill)
                    }
                }
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun scheduleBedTimeNotification(
        type: String,
    ) {
        try {
            var index = 2
            var alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager


            for (timeInMill in bedTimeForNotification) {
                val intent = Intent(this, AlarmReceiver::class.java)
                intent.putExtra("ALARM_TYPE", type)
                intent.putExtra("bedTimeForNot", timeInMill)

                val pendingIntent = PendingIntent.getBroadcast(
                    this,
                    index++,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
                if (timeInMill > System.currentTimeMillis()) {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP, timeInMill, pendingIntent
                    )
                    Log.i("KKKK", "Alarm set for: " + timeInMill)
                } else {
                    Log.i("KKKK", "Skipping past time: " + timeInMill)
                }
                Log.i("KKKK", "it: " + timeInMill)
            }


        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }


    private fun loadAdaptiveNative() {

        if (AppController.fitzayModel != null) {
            val adLoader =
                AdLoader.Builder(
                    this,
                    AppController.fitzayModel!!.FitzayNativeSleepTracker.adID
                )
                    .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                        binding.bannerTypeTempalte.setNativeAd(NativeAd)
                        binding.clAds.visibility = View.VISIBLE
                        binding.layoutAd.visibility = View.VISIBLE

                    }.withAdListener(object : AdListener() {
                        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                            super.onAdFailedToLoad(loadAdError)
                            binding.clAds.visibility = View.GONE
                            binding.layoutAd.visibility = View.GONE
                        }
                    })
                    .withNativeAdOptions(
                        NativeAdOptions.Builder()
                            .setRequestCustomMuteThisAd(true)
                            .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT)
                            .build()
                    )
                    .build()

            adLoader.loadAd(AdRequest.Builder().build())
        }
    }

    override fun itemClick(position: Int, model: RingTone, check: RadioButton) {

        pos = ringToneList[position].itemPos


        if (ringToneName != "" && ringToneName == model.ringToneName) {
            check.isChecked = true
        } else {
            check.isChecked = false
        }

        check.setOnClickListener {

            if (pos == ringToneList[position].itemPos) {
                check.isChecked = if (ringToneList[position].selection) false else true

                ringToneList[position].selection = !ringToneList[position].selection


                // Stop the media player if the radio button is not selected
                if (check.isChecked) {
                    // Start the media player if the radio button is selected
                    mediaPlayer?.release()
                    mediaPlayer = MediaPlayer.create(this@SleepTrackerActivity, model.ringToneUri)
                    mediaPlayer?.start()
                    isMediaPlaying = true
                    ringToneUri = model.ringToneUri
                    ringToneName = model.ringToneName

                } else {
                    // Stop the media player if the radio button is not selected
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null
                    isMediaPlaying = false
                }

                ringToneAdapter!!.notifyItemChanged(position)


                // Check if the last selected item is different from the current one
                if (lastSelectedItemPosition != RecyclerView.NO_POSITION && lastSelectedItemPosition != position) {
                    // Close the last selected item if it was open
                    ringToneList[lastSelectedItemPosition].selection = false
                    ringToneAdapter!!.notifyItemChanged(lastSelectedItemPosition)
                }

                // Update the last selected item position
                lastSelectedItemPosition = position

            }

        }

    }

    override fun onDestroy() {
        mediaPlayer?.release()
        super.onDestroy()
    }

    private fun labelDialog() {

        val dialog = Dialog(this@SleepTrackerActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val labelBinding = DialogStepGoalBinding.inflate(layoutInflater)
        dialog.setContentView(labelBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        labelBinding.tvTitle.text = getString(R.string.label)
        labelBinding.tvStepGoal.inputType = InputType.TYPE_CLASS_TEXT
        labelBinding.btnSave.setOnClickListener {
            if (!labelBinding.tvStepGoal.text.isNullOrEmpty()) {

                ringToneLabel = labelBinding.tvStepGoal.text.toString()
                if (ringToneLabel != "Alarm") {
                    binding.tvLabel.text = ringToneLabel
                }
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Add Label", Toast.LENGTH_SHORT).show()
            }

        }
        labelBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun snoozeDialog() {
        val dialog = Dialog(this@SleepTrackerActivity)
        dialog.setContentView(R.layout.snooze_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        var cancel = dialog.findViewById<TextView>(R.id.cancel)
        var save = dialog.findViewById<TextView>(R.id.save)

        var check5 = dialog.findViewById<RadioButton>(R.id.check)
        var check10 = dialog.findViewById<RadioButton>(R.id.check10)
        var check15 = dialog.findViewById<RadioButton>(R.id.check15)
        var check20 = dialog.findViewById<RadioButton>(R.id.check20)
        var check25 = dialog.findViewById<RadioButton>(R.id.check25)
        var check30 = dialog.findViewById<RadioButton>(R.id.check30)

        when (mintInText) {
            "5 minutes" -> {
                check5.isChecked = true
                check10.isChecked = false
                check15.isChecked = false
                check20.isChecked = false
                check25.isChecked = false
                check30.isChecked = false
            }

            "10 minutes" -> {
                check5.isChecked = false
                check10.isChecked = true
                check15.isChecked = false
                check20.isChecked = false
                check25.isChecked = false
                check30.isChecked = false
            }

            "15 minutes" -> {
                check5.isChecked = false
                check10.isChecked = false
                check15.isChecked = true
                check20.isChecked = false
                check25.isChecked = false
                check30.isChecked = false
            }

            "20 minutes" -> {
                check5.isChecked = false
                check10.isChecked = false
                check15.isChecked = false
                check20.isChecked = true
                check25.isChecked = false
                check30.isChecked = false
            }

            "25 minutes" -> {
                check5.isChecked = false
                check10.isChecked = false
                check15.isChecked = false
                check20.isChecked = false
                check25.isChecked = true
                check30.isChecked = false
            }

            "30 minutes" -> {
                check5.isChecked = false
                check10.isChecked = false
                check15.isChecked = false
                check20.isChecked = false
                check25.isChecked = false
                check30.isChecked = true
            }
        }
        check5.setOnClickListener {
            check5.isChecked = true
            check10.isChecked = false
            check15.isChecked = false
            check20.isChecked = false
            check25.isChecked = false
            check30.isChecked = false

            second = 5 * 60
            milliSeconds = second * 1000

            mintInText = "5 minutes"
        }
        check10.setOnClickListener {
            check5.isChecked = false
            check10.isChecked = true
            check15.isChecked = false
            check20.isChecked = false
            check25.isChecked = false
            check30.isChecked = false
            second = 10 * 60
            milliSeconds = second * 1000

            mintInText = "10 minutes"

        }
        check15.setOnClickListener {
            check5.isChecked = false
            check10.isChecked = false
            check15.isChecked = true
            check20.isChecked = false
            check25.isChecked = false
            check30.isChecked = false

            second = 15 * 60
            milliSeconds = second * 1000
            mintInText = "15 minutes"
        }
        check20.setOnClickListener {
            check5.isChecked = false
            check10.isChecked = false
            check15.isChecked = false
            check20.isChecked = true
            check25.isChecked = false
            check30.isChecked = false

            second = 20 * 60
            milliSeconds = second * 1000
            mintInText = "20 minutes"
        }
        check25.setOnClickListener {
            check5.isChecked = false
            check10.isChecked = false
            check15.isChecked = false
            check20.isChecked = false
            check25.isChecked = true
            check30.isChecked = false

            second = 25 * 60
            milliSeconds = second * 1000

            mintInText = "25 minutes"

        }
        check30.setOnClickListener {
            check5.isChecked = false
            check10.isChecked = false
            check15.isChecked = false
            check20.isChecked = false
            check25.isChecked = false
            check30.isChecked = true

            second = 20 * 60
            milliSeconds = second * 1000

            mintInText = "30 minutes"
        }

        save.setOnClickListener {
            dialog.dismiss()
            if (mintInText != "") {
                binding.tvSnooze.text = mintInText
            }
        }
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()


    }

    override fun onBackPressed() {
        if (onBack=="summary")
        {
            moveAct(SleepSummaryActivity::class.java)
        }
        else
        {
            moveAct(SleepTrackerHomeScreen::class.java)

        }

    }

    private fun moveAct(cl:Class<*>){
        val intent = Intent(this@SleepTrackerActivity, cl)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }

    private fun layoutVisible() {
        binding.apply {
            s.visibility = View.VISIBLE
            l.visibility = View.VISIBLE
            sn.visibility = View.VISIBLE
            vb.visibility = View.VISIBLE

            ss.visibility = View.GONE
            ll.visibility = View.GONE
            sn2.visibility = View.GONE
            vb2.visibility = View.GONE
            Component.preference.alarmOnOff = true

        }
    }

    private fun layoutInvisible() {
        binding.apply {
            ss.visibility = View.VISIBLE
            ll.visibility = View.VISIBLE
            sn2.visibility = View.VISIBLE
            vb2.visibility = View.VISIBLE

            s.visibility = View.GONE
            l.visibility = View.GONE
            sn.visibility = View.GONE
            vb.visibility = View.GONE

            Component.preference.alarmOnOff = false

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode==987)
        {

        }
        else
        {
            if (Settings.canDrawOverlays(this@SleepTrackerActivity))
            {
                Log.i("TAG", "else if  OK: ")
                binding.alarmOnOffSwitch.isChecked=true
                layoutVisible()
            }

            else
            {
                Log.i("TAG", "else else: ")
                binding.alarmOnOffSwitch.isChecked=false
                layoutInvisible()
            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 987) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.i("TAG", "Granted: ")
//                permissionSave=true
//            } else {
//
//                Log.i("TAG", "not-Granted: ")
//                permissionSave=false
//
//            }

        }
        else
        {
            if (Settings.canDrawOverlays(this@SleepTrackerActivity))
            {
                Log.i("TAG", "Below Andorid 10 if  OK: ")
                binding.alarmOnOffSwitch.isChecked=true
                layoutVisible()
            }

            else
            {
                Log.i("TAG", "Below Andorid 10 else else: ")
                binding.alarmOnOffSwitch.isChecked=false
                layoutInvisible()
            }
        }

    }

    override fun onStart() {
        super.onStart()
        LanguageManager(this@SleepTrackerActivity)
    }
}