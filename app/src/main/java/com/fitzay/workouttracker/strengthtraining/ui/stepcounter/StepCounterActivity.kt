package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.*
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityStepCounterBinding
import com.fitzay.workouttracker.strengthtraining.databinding.DialogStepGoalBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.TemporalAdjusters
import java.text.SimpleDateFormat
import java.util.*


class StepCounterActivity : AppUtil2() {

    private lateinit var binding: ActivityStepCounterBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    private val stepCounterReceiver = StepCounterReceiver()
    var isPaused = false
    private val TAG = "StepCounter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeStepCounter.showAd) {
            loadAdaptiveNative()
        } else {
            binding.clAds.visibility = View.GONE
        }




        defaultValues()
        dailyAverageReport()

        binding.updateStepGoal.setOnClickListener {
            stepGoalDialog()
        }

        isPaused = Component.preference.isPaused
        updatePausePlayButtonState()


        binding.totalsteps.text = Component.preference.stepGoal.toString()

// pause & resume steps
        binding.icPause.setOnClickListener {

            isPaused = !isPaused
            updatePausePlayButtonState()

            if (isPaused) {
                binding.icPause.setBackgroundResource(R.drawable.ic_step_play)
                val pauseIntent = Intent(this@StepCounterActivity, StepCounterSensor::class.java)
                pauseIntent.action = FITNESS_ACTION_PAUSE_STEP_COUNTING

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(pauseIntent)
                }else{
                    startService(pauseIntent)
                }
            } else {
                binding.icPause.setBackgroundResource(R.drawable.ic_step_pause)
                val resumeIntent = Intent(this@StepCounterActivity, StepCounterSensor::class.java)
                resumeIntent.action = FITNESS_ACTION_RESUME_STEP_COUNTING
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(resumeIntent)
                }else{
                    startService(resumeIntent)
                }
            }
        }

    }

    private fun goService() {

        if (!isLocationPermissionAllowed()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }else {
                locationPermissionRequest.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
            Log.e(TAG, "goService: Not Allowed" )
        } else {
            val serviceIntent = Intent(this@StepCounterActivity, StepCounterSensor::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            }else{
                startService(serviceIntent)
            }

            // Register the receiver for step count updates
            val intentFilter = IntentFilter(FITNESS_ACTION_STEP_COUNT)
            LocalBroadcastManager.getInstance(this@StepCounterActivity)
                .registerReceiver(stepCounterReceiver, intentFilter)

        }
    }

    private fun dailyAverageReport() {
        val currentDate = LocalDate.now()
        val firstDayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
        val lastDayOfWeek = firstDayOfWeek.plusDays(6)
        val startDate = firstDayOfWeek.toString()
        val endDate = lastDayOfWeek.toString()

        Component.stepModel.getWeeklyGoal(startDate, endDate).observe(this) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {
                    val calendar = Calendar.getInstance()
                    val currentDate = Date()
                    calendar.time = currentDate

                    it.data!!.forEach { it1 ->
                        Log.e(TAG, "dailyAverageReport: ${it1.steps}")
                        val progress = (it1.steps.toDouble() / it1.stepGoal.toDouble()) * 100

                        val date = LocalDate.parse(it1.date)
                        val dayOfWeek = date.dayOfWeek

                        when (dayOfWeek.toString()) {
                            "SATURDAY" -> {
                                binding.progressSeven.progress = progress.toInt()
                            }
                            "SUNDAY" -> binding.progressOne.progress = progress.toInt()
                            "MONDAY" -> binding.progressTwo.progress = progress.toInt()
                            "TUESDAY" -> binding.progressThree.progress = progress.toInt()
                            "WEDNESDAY" -> binding.progressFour.progress = progress.toInt()
                            "THURSDAY" -> binding.progressFive.progress = progress.toInt()
                            "FRIDAY" -> binding.progressSix.progress = progress.toInt()
                        }
                        calendar.add(Calendar.DAY_OF_YEAR, 1)
                    }
                }

                CurrentStatus.ERROR -> {
                    Toast.makeText(
                        this@StepCounterActivity,
                        "Error to Count Step",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }


    }


    private fun defaultValues() {

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(currentDate)

        if (Component.preference.currentDate != today) {
            Component.preference.stepCount = 0
            binding.estTime.text = "0h 0m 0s"
            binding.kcal.text = getFormattedCalories(0.0)
            binding.miles.text = getFormattedDistance(0.0)

            binding.goalProgress.progress = 0
            binding.totalsteps.text =
                getString(R.string.step_goal_runtime, Component.preference.stepGoal.toString())

            binding.stepTaken.text = Component.preference.stepCount.toString()

        } else {
            binding.stepTaken.text = Component.preference.stepCount.toString()
            binding.estTime.text = Component.preference.stepTime
            binding.kcal.text =
                getFormattedCalories(Component.preference.stepCalories)
            binding.miles.text =
                getFormattedDistance(Component.preference.stepDistance)
            binding.goalProgress.progress = Component.preference.stepProgress
            binding.totalsteps.text =
                getString(R.string.step_goal_runtime, Component.preference.stepGoal.toString())
        }


    }

    inner class StepCounterReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null && intent.action == FITNESS_ACTION_STEP_COUNT) {
                val stepCount = intent.getIntExtra(FITNESS_EXTRA_STEP_COUNT, 0)

                val distance = intent.getDoubleExtra(FITNESS_EXTRA_DISTANCE, 0.0)
                val estimatedTime = intent.getStringExtra(FITNESS_EXTRA_TIME)
                val estimatedTimeGoal = intent.getStringExtra(FITNESS_EXTRA_TIME_GOAL)
                val burnedCalories = intent.getDoubleExtra(FITNESS_EXTRA_BURNED_CALORIES, 0.0)
                val burnedCaloriesGoal =
                    intent.getDoubleExtra(FITNESS_EXTRA_BURNED_CALORIES_GOAL, 0.0)
                val distanceGoal = intent.getDoubleExtra(FITNESS_EXTRA_DISTANCE_GOAL, 0.0)

                updateStepCount(
                    stepCount,
                    distance,
                    estimatedTime,
                    burnedCalories,
                    burnedCaloriesGoal,
                    distanceGoal,
                    estimatedTimeGoal
                )
                val progressPercentage =
                    (Component.preference.stepCount.toDouble() / Component.preference.stepGoal.toDouble()) * 100

                binding.goalProgress.progress = progressPercentage.toInt()
                CoroutineScope(Dispatchers.Main).launch {
                    Component.preference.stepProgress = progressPercentage.toInt()
                    Component.preference.saveDailyGoal = stepCount

                    ///     Toast.makeText(this@StepCounterActivity, "" + stepCount, Toast.LENGTH_SHORT).show()


                }
            }
        }
    }

    private fun updateStepCount(
        stepCount: Int,
        distance: Double,
        estimatedTime: String?,
        burnedCalories: Double,
        burnedCaloriesGoal: Double,
        distanceGoal: Double,
        estimatedTimeGoal: String?,

        ) {
        try {
            binding.stepTaken.text = Component.preference.stepCount.toString()
            val formattedDistance = String.format("%.2f", distance)
            binding.miles.text = formattedDistance
            binding.estTime.text = estimatedTime.toString()
            val formattedCalories = String.format("%.1f", burnedCalories)
            binding.kcal.text = formattedCalories


            val formattedCaloriesGoal = String.format("%.1f", burnedCaloriesGoal)
            val formattedDistanceGoal = String.format("%.2f", distanceGoal)


            val step = StepEntity(
                steps = stepCount,
                time = estimatedTime.toString(),
                calories = formattedCalories.toDouble(),
                distance = formattedDistance.toDouble(),
                date = currentDateFormat(),
                stepGoal = Component.preference.stepGoal,
                caloriesGoal = formattedCaloriesGoal.toDouble(),
                distanceGoal = formattedDistanceGoal.toDouble(),
                timeGoal = estimatedTimeGoal
            )

            Component.stepModel.insertSteps(step).observe(this) {
                when (it.status) {
                    CurrentStatus.SUCCESS -> {
                        Component.preference.stepTime = estimatedTime.toString()
                        Component.preference.stepCalories = formattedCalories.toDouble()
                        Component.preference.stepDistance = formattedDistance.toDouble()
                    }

                    CurrentStatus.ERROR -> {
                        Toast.makeText(
                            this@StepCounterActivity,
                            "Error to Count Step",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

    }

    private fun currentDateFormat(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = Date()
        return dateFormat.format(currentDate)
    }


    private fun updatePausePlayButtonState() {
        if (isPaused) {
            binding.totalsteps.text = "Paused"
            binding.totalsteps.setTextColor(ContextCompat.getColor(this, R.color.start_btn_color))
            binding.icPause.setBackgroundResource(R.drawable.ic_step_play)
        } else {
            binding.totalsteps.setTextColor(ContextCompat.getColor(this, R.color.text_color))
            binding.totalsteps.text = Component.preference.stepGoal.toString() + " Steps"
            binding.icPause.setBackgroundResource(R.drawable.ic_step_pause)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun requestPermission() {
        val permission = Manifest.permission.ACTIVITY_RECOGNITION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            requestPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACTIVITY_RECOGNITION
                ).toString()
            )
        }else
        // Request the permission from the user
        requestPermissionLauncher.launch(permission)
    }

    private fun navigateToAppSettings() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
        {
            val builder1: AlertDialog.Builder = AlertDialog.Builder(this@StepCounterActivity)
            builder1.setMessage("Allow FitZay to access your physical activity?")
            builder1.setCancelable(true)

            builder1.setPositiveButton(
                "Allow",
                DialogInterface.OnClickListener {
                                                dialog, id -> dialog.cancel()
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                }
            )

            builder1.setNegativeButton(
                "Don't allow",
                DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

            val alert11: AlertDialog = builder1.create()
            alert11.show()
        }
        else {
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        LocalBroadcastManager.getInstance(this@StepCounterActivity)
            .unregisterReceiver(stepCounterReceiver)
    }

    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        Log.e(TAG, ": For Result" )
        if (isLocationPermissionAllowed()){
            goService()
        }else{
            navigateToAppSettings()
        }
    }


    private fun stepGoalDialog() {

        val dialog = Dialog(this@StepCounterActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val goalBinding = DialogStepGoalBinding.inflate(layoutInflater)
        dialog.setContentView(goalBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)

        goalBinding.btnSave.setOnClickListener {
            if (!goalBinding.tvStepGoal.text.isNullOrEmpty()) {
                Component.preference.stepGoal = goalBinding.tvStepGoal.text.toString().toInt()
                binding.totalsteps.text = goalBinding.tvStepGoal.text.toString()
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Add Goal", Toast.LENGTH_SHORT).show()
            }

        }
        goalBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }

    private fun loadAdaptiveNative() {

        binding.layoutAd.visibility = View.GONE

        val template = if (getFitzayRemoteString("fitzay_cta_location") == "up") {
            binding.plannerTemplateDown.visibility = View.GONE
            binding.plannerTemplateUp.visibility = View.VISIBLE
            binding.plannerTemplateUp
        } else {
            binding.plannerTemplateDown.visibility = View.VISIBLE
            binding.plannerTemplateUp.visibility = View.GONE
            binding.plannerTemplateDown
        }

        if (AppController.fitzayModel != null) {
            val adLoader =
                AdLoader.Builder(
                    this@StepCounterActivity,
                    AppController.fitzayModel!!.FitzayNativeStepCounter.adID
                )
                    .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                        template.setNativeAd(NativeAd)
                        binding.skeletonLayout.visibility = View.GONE
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


    override fun onResume() {
        super.onResume()

    }

    override fun onStart() {
        super.onStart()
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q)) {
            requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) {
                    goService()
                    Log.i("NEW-TAG", "onCreate--IF: ")

                }
                else {
                    // Permission is denied, check if the user has denied multiple times

                    Log.i("NEW-TAG", "onCreate--ELSE: ")

                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this@StepCounterActivity, Manifest.permission.ACTIVITY_RECOGNITION)) {
//                            Toast.makeText(
//                                this@StepCounterActivity,
//                                getString(R.string.permission_toast),
//                                Toast.LENGTH_SHORT
//                            ).show()
                        navigateToAppSettings()
                        //requestPermission()
                        Log.i("NEW-TAG", "onCreate--ELSE-IF: ")

                    }
                }
            }

            val permission = Manifest.permission.ACTIVITY_RECOGNITION
            if (ContextCompat.checkSelfPermission(this@StepCounterActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, request it from the user
                requestPermission()
                Log.i("NEW-TAG", "onCreate--OUT-IF: ")

            } else {
                goService()
                Log.i("NEW-TAG", "onCreate--OUT-ELSE: ")

            }
        } else {
            goService()
            Log.i("NEW-TAG", "onCreate--OUT++-ELSE: ")

        }
        LanguageManager(this@StepCounterActivity)
    }
}