package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.Manifest
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.*
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class StepCounterSensor : Service(), SensorEventListener, LocationListener {
    private var sensorManager: SensorManager? = null
    private var stepSensor: Sensor? = null
    private lateinit var locationManager: LocationManager
    private var stepCount = 0
    private var isPaused = false

    private lateinit var simpleStepDetector: StepDetector
    private lateinit var mListener: SensorEventListener

    // steps at the current day
    private var mTodaysSteps: Int = 0

    // steps reported from sensor
    private var mCurrentSteps: Int = 0

    // steps reported from sensor STEP_COUNTER in previous event
    private var mLastSteps = -1

    /////Custome Layout
    private var remoteViews: RemoteViews? = null
    private var homePendingIntent: PendingIntent? = null
    private val TAG = "StepCounter"

    private lateinit var mNotificationManager: NotificationManager
    private lateinit var mBuilder: NotificationCompat.Builder

    override fun onCreate() {
        super.onCreate()

        mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
                ?: throw IllegalStateException("could not get notification service")
        mBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
        initialNotification()


        // connect sensor
        val mSensorManager = getSystemService(Context.SENSOR_SERVICE) as? SensorManager
            ?: throw IllegalStateException("could not get sensor service")
        var mStepSensor: Sensor? = null

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER) &&
            (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) == PackageManager.PERMISSION_GRANTED)
        ) {
            // androids built in step counter
            Log.d(TAG, "using sensor step counter")
            mStepSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
            mListener = object : SensorEventListener {

                override fun onSensorChanged(event: SensorEvent) {
                    Log.e(TAG, "On Step Detector: ")
                    handleEvent(event.values[0].toInt())
                }

                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                    // no-op
                    Log.e(TAG, "onAccuracyChanged:  $accuracy    $sensor")
                }
            }
        } else
            if (packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER)) {
                // fallback sensor
                Log.d(TAG, "using fallback sensor accelerometer")
                mStepSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                simpleStepDetector = StepDetector(object : StepDetector.StepListener {
                    override fun step(timeNs: Long) {
                        Log.e(TAG, "accelerometer step: $timeNs")
                        handleEvent(mCurrentSteps + 1)
                    }
                })
                mListener = object : SensorEventListener {

                    override fun onSensorChanged(event: SensorEvent) {
                        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                            Log.e(TAG, "onSensorChanged: TYPE_ACCELEROMETER" + event.values[0])
                            simpleStepDetector.updateAccel(
                                event.timestamp,
                                event.values[0],
                                event.values[1],
                                event.values[2]
                            )
                        }
                    }

                    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                        Log.e(TAG, " TYPE_ACCELEROMETER onAccuracyChanged: $accuracy    $sensor")
                        // no-op
                    }
                }
            } else {
                locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                try {
                    locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        1000, // minimum time interval in milliseconds between updates
                        0f,   // minimum distance interval in meters between updates
                        this
                    )
                } catch (ex: SecurityException) {
                    // Handle location permission not granted
                }
            }

        if (mStepSensor != null) {
            mSensorManager.registerListener(
                mListener, mStepSensor,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        } else {
            Toast.makeText(Component.context, "No Sensor Found in your device", Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun handleEvent(value: Int) {
        mCurrentSteps = value
        if (mLastSteps == -1) {
            mLastSteps = value
        }
        mTodaysSteps += value - mLastSteps
        mLastSteps = value
        handleEvent()
    }

    private fun handleEvent() {
        // Check if new day started
        if (!isPaused) {
            // Step count from the sensor will be recorded automatically.

            val currentDate = Date()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = dateFormat.format(currentDate)

            if (Component.preference.currentDate == today) {
                Component.preference.stepCount = stepCount
                stepCount++
                updateStepCount(stepCount)
            } else {
                Component.preference.currentDate = today
                stepCount = 0
                Component.preference.stepCount = stepCount
                updateStepCount(stepCount)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (stepSensor != null) {
            sensorManager!!.unregisterListener(this)
        }
        if (locationManager != null) {
            locationManager.removeUpdates(this)
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_STEP_COUNTER && !isPaused) {
            // Step count from the sensor will be recorded automatically.

            val currentDate = Date()
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = dateFormat.format(currentDate)

            if (Component.preference.currentDate == today) {
                Component.preference.stepCount = stepCount
                stepCount++
                updateStepCount(stepCount)
            } else {
                Component.preference.currentDate = today
                stepCount = 0
                Component.preference.stepCount = stepCount
                updateStepCount(stepCount)
            }

            Log.e("Sensor", "onSensorChanged: $stepCount")

        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for step counter sensor
    }

    override fun onLocationChanged(location: Location) {
        // Calculate step count based on GPS tracking (example: 1 step ≈ 0.8 meters)
        val stepLength = 0.8 // meters (you can adjust this value based on user's stride)
        stepCount += (location.distanceTo(location) / stepLength).toInt()
        updateStepCount(stepCount)
    }

    private fun totalDistanceCovered(steps: Int): Double {
        val stepLengthMeters = 0.8
        val meters = steps * stepLengthMeters
        val miles = meters / 1609.34
        return miles
    }

    private fun totalDistanceGoal(steps: Int): Double {
        val stepLengthMeters = 0.8
        val meters = steps * stepLengthMeters
        val miles = meters / 1609.34
        return miles
    }


    private fun totalDistanceCoveredinMeters(steps: Int): Double {
        val stepLengthMeters = 0.8
        return steps * stepLengthMeters
    }

    private fun updateStepCount(stepCount: Int) {
        // Update step count in the main activity
        val distance = totalDistanceCovered(stepCount)
        val distance1 = totalDistanceCoveredinMeters(stepCount)
        val distanceGoal = totalDistanceGoal(Component.preference.stepGoal)
        val timeGoal = totalDistanceCoveredinMeters(Component.preference.stepGoal)

        //for time calculation
        val averageWalkingSpeed = 3.0

        val estimatedTimeInSeconds = (distance1 / averageWalkingSpeed).toInt()
        val estimatedTimeInSecondsGoal = (timeGoal / averageWalkingSpeed).toInt()
        val formattedTime2 = formatTime(estimatedTimeInSeconds)
        val formattedTimeGoal = formatTime(estimatedTimeInSecondsGoal)

        //burned calories
        val kilograms = if (Component.preference.userWeightType == "LB") {
            poundsToKilograms(Component.preference.userWeight.toDouble())
        } else {
            Component.preference.userWeight.toDouble()
        }
        val weightKg = kilograms
        val distanceKM = distance * 1.60
        val distanceKMGoal = distanceGoal * 1.60
        val burnedCalories = weightKg * distanceKM
        val burnedCaloriesGoal = weightKg * distanceKMGoal


        val intent = Intent(FITNESS_ACTION_STEP_COUNT)
        intent.putExtra(FITNESS_EXTRA_STEP_COUNT, stepCount)
        intent.putExtra(FITNESS_EXTRA_DISTANCE, distance)
        intent.putExtra(FITNESS_EXTRA_DISTANCE_GOAL, distanceGoal)
        intent.putExtra(FITNESS_EXTRA_TIME, formattedTime2)
        intent.putExtra(FITNESS_EXTRA_TIME_GOAL, formattedTimeGoal)
        intent.putExtra(FITNESS_EXTRA_BURNED_CALORIES, burnedCalories)
        intent.putExtra(FITNESS_EXTRA_BURNED_CALORIES_GOAL, burnedCaloriesGoal)
        intent.putExtra(FITNESS_EXTRA_BURNED_CALORIES_GOAL, burnedCaloriesGoal)

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

        updateNotification(stepCount, distance, burnedCalories, formattedTime2)

    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                name,
                importance
            ).apply {
                description = descriptionText
            }
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun pauseStepCounting() {
        isPaused = true
    }

    // Method to resume the step counting
    private fun resumeStepCounting() {
        isPaused = false
        updateStepCount(stepCount)
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            FITNESS_ACTION_PAUSE_STEP_COUNTING -> {
                pauseStepCounting()
            }

            FITNESS_ACTION_RESUME_STEP_COUNTING -> {
                resumeStepCounting()
            }
        }
        Component.preference.isPaused = isPaused

        return START_STICKY
    }


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun initialNotification() {
        remoteViews = RemoteViews(this.packageName, R.layout.custom_step_notification)

        //home btn clicked
        val homeIntent = Intent(this, MainActivity::class.java)

        homePendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            PendingIntent.getActivity(this, STEP_COUNTER_NOTIFICATION_ID, homeIntent, PendingIntent.FLAG_IMMUTABLE)
        else
            PendingIntent.getActivity(
                this,
                STEP_COUNTER_NOTIFICATION_ID,
                homeIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        remoteViews!!.setOnClickPendingIntent(R.id.mainV, homePendingIntent)

        createNotificationChannel()

        val notification: Notification = mBuilder
            .setSmallIcon(R.mipmap.ic_launcher_foreground)
            .setContentTitle(getString(R.string.app_name))
            .setContent(remoteViews)
            .setAutoCancel(false)
            .setOngoing(true)
            .build()


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//            ServiceCompat.startForeground(
//                /* service = */ this,
//                STEP_COUNTER_NOTIFICATION_ID,
//                /* notification = */ notification,
//                /* foregroundServiceType = */
//                ServiceInfo.FOREGROUND_SERVICE_TYPE_HEALTH
//            )
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            startForeground(STEP_COUNTER_NOTIFICATION_ID, notification)
//        }

        try {

            ServiceCompat.startForeground(
                /* service = */ this,
                /* id = */ STEP_COUNTER_NOTIFICATION_ID, // Cannot be 0
                /* notification = */ notification,
                /* foregroundServiceType = */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_HEALTH
                } else {
                    0
                }
            )
        } catch (e: Exception) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
                && e is ForegroundServiceStartNotAllowedException) {
                // App not in a valid state to start foreground service
                // (e.g. started from bg)
                Log.e(TAG, "initialNotification: "+e.message )
            }
        }
    }

    // use this method to update the Notification's UI
    private fun updateNotification(
        stepCount: Int,
        distance: Double,
        burnedCalories: Double,
        formattedTime2: String
    ) {
        try {// update the title
            remoteViews!!.setTextViewText(
                R.id.steps, stepCount.toString()
            )

            val dis = "%.2f".format(milesToMeters(distance))

            // update the title
            remoteViews!!.setTextViewText(
                R.id.miles, dis
            )

            val cal = "%.2f".format(burnedCalories)


            // update the content
            remoteViews!!.setTextViewText(
                R.id.kcal,
                cal
            )
            // update the content
            remoteViews!!.setTextViewText(
                R.id.estTime,
                formattedTime2
            )
            mNotificationManager.notify(STEP_COUNTER_NOTIFICATION_ID, mBuilder.build())
        } catch (e: NumberFormatException) {
            e.printStackTrace()
        }

    }

}