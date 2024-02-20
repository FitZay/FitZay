package com.fitzay.workouttracker.strengthtraining.core.utils

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.PlayAlarmActivity
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepTrackerActivity
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.Calendar
import java.util.UUID


class AlarmReceiver : BroadcastReceiver() {

    /////Custome Layout
    private var remoteViews: RemoteViews? = null
    private var homePendingIntent: PendingIntent? = null
    private val TAG = "StepCounter"


    private lateinit var mNotificationManager: NotificationManager
    private lateinit var mBuilder: NotificationCompat.Builder


    override fun onReceive(context: Context?, intent: Intent?) {


        val type = intent!!.getStringExtra("ALARM_TYPE")
        val ringTone = intent!!.getStringExtra("ringtone")
        val label = intent!!.getStringExtra("label")
        val vibration = intent!!.getBooleanExtra("vibration", false)
        val snooze = intent!!.getLongExtra("snooze", 0)
        var alarmTimeForScreenDisplay = intent!!.getLongExtra("alarmTimeForScreenDisplay", 0)
        var bedTimeForNot = intent!!.getLongExtra("bedTimeForNot", 0)

        val differentDay = intent!!.getIntExtra("ALARM_NUMBER", 0)
        Log.e("Receiver", "onReceive: $type")
        Log.e("Receiver", "onReceive: $differentDay")
        Log.e("Receiver", "onReceive: $ringTone")
        Log.e("Receiver", "onReceive: $label")
        Log.e("Receiver", "onReceive: $vibration")


//        if (type=="DefaultRegister")
//        {
//            Log.e("Receiver", "onReceive: $type")
//            SleepTrackerActivity.alarmManager?.cancel(SleepTrackerActivity.pendingIntent)
//            val alarmIntent = Intent(context, AlarmReceiver::class.java)
//            alarmIntent.putExtra("ALARM_TYPE", "DefaultRegister")
//            val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//
//            val manager = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1L, pendingIntent)
//
//        }

        if (context != null) {
//            val notificationHelper = NotificationHelper(context)
//            val notification = notificationHelper.getNotification()
//            notificationHelper.notify(101, notification)
//
//            mNotificationManager =
//                context.getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
//                    ?: throw IllegalStateException("could not get notification service")
//            mBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
//                .setStyle(NotificationCompat.DecoratedCustomViewStyle())
//            initialNotification(context)


            if (type == "bedTime") {
                val notificationHelper = NotificationHelper(context)
                val notification = notificationHelper.getNotification()
                notificationHelper.notify(generateHashIdForNotification(), notification)

                val calendar = Calendar.getInstance()
                calendar.timeInMillis = bedTimeForNot
                calendar.add(Calendar.DAY_OF_YEAR, 7)

                bedTimeForNot=calendar.timeInMillis
                try {
                    val alarmManager = context.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
                    val intent = Intent(context, AlarmReceiver::class.java)
                    intent.putExtra("ALARM_TYPE", type)
                    intent.putExtra("bedTimeForNot", bedTimeForNot)

                    val pendingIntent = PendingIntent.getBroadcast(
                        context,
                        generateHashIdForNotification(),
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )


                    if (bedTimeForNot > System.currentTimeMillis()) {
                        alarmManager.setExact(
                            AlarmManager.RTC_WAKEUP,
                            bedTimeForNot,
                            pendingIntent
                        )
                        Log.i(TAG, "Alarm set for: " + bedTimeForNot)
                    } else {
                        Log.i(TAG, "Skipping past time: " + bedTimeForNot)
                    }

                } catch (e: Throwable) {
                    e.printStackTrace()
                }

            }
            else {
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = alarmTimeForScreenDisplay
                calendar.add(Calendar.DAY_OF_YEAR, 7)

                alarmTimeForScreenDisplay=calendar.timeInMillis
                try {
                    val alarmManager = context.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
                    val intent = Intent(context, AlarmReceiver::class.java)
                    intent.putExtra("ALARM_TYPE", type)
                    intent.putExtra("ringtone", ringTone)
                    intent.putExtra("vibration", vibration)
                    intent.putExtra("label", label)
                    intent.putExtra("snooze", snooze)
                    intent.putExtra("alarmTimeForScreenDisplay",
                        alarmTimeForScreenDisplay
                    )

                    val pendingIntent = PendingIntent.getBroadcast(
                        context,
                        generateHashId(),
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                    )

                    if (alarmTimeForScreenDisplay > System.currentTimeMillis()) {
                        alarmManager.setExact(
                            AlarmManager.RTC_WAKEUP,
                            alarmTimeForScreenDisplay,
                            //   24*60*60*1000,
                            pendingIntent
                        )
                        Log.i(TAG, "alarmTimeForScreenDisplay set for: " + alarmTimeForScreenDisplay)
                    } else {
                        Log.i(TAG, "Skipping past alarmTimeForScreenDisplay: " + alarmTimeForScreenDisplay)
                    }





                } catch (e: Throwable) {
                    e.printStackTrace()
                }
                val intent = Intent(context, PlayAlarmActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("ALARM_TYPE", type)
                intent.putExtra("ringtone", ringTone)
                intent.putExtra("vibration", vibration)
                intent.putExtra("label", label)
                intent.putExtra("snooze", snooze)
                context.startActivity(intent)

            }


            Log.i("TAG", "onReceive: " + type)
        }

    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "NotificationChannel"
            val descriptionText = "Notification Description"
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                name,
                importance
            ).apply {
                description = descriptionText
            }
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun initialNotification(context: Context) {
        remoteViews = RemoteViews(Component.context.packageName, R.layout.remote_notification)
        var actionIntent: Intent? = null
        var actionPendingIntent: PendingIntent? = null

        actionIntent = Intent(context, StopAlarmReceiver::class.java)
        actionIntent.action = "ACTION_BUTTON_CLICK"
        actionIntent.putExtra("ccccc", "bbb")

        actionPendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            actionIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        remoteViews!!.setOnClickPendingIntent(
            R.id.notification_button,
            actionPendingIntent
        )

        //home btn clicked
        val homeIntent = Intent(context, SleepTrackerActivity::class.java)

        homePendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
            PendingIntent.getActivity(context, 0, homeIntent, PendingIntent.FLAG_MUTABLE)
        else
            PendingIntent.getActivity(context, 0, homeIntent, 0)

        //    remoteViews!!.setOnClickPendingIntent(R.id.notification_button, homePendingIntent)

        createNotificationChannel(context)

        val notification: Notification = mBuilder
            .setSmallIcon(R.mipmap.ic_launcher_foreground)
            .setContentTitle(context.resources.getString(R.string.app_name))
            .setContent(remoteViews)
            .setContentIntent(homePendingIntent)
            .setAutoCancel(true)
            .setOngoing(false)
            .build()

        mNotificationManager.notify(101, notification)


        ///  startForeground(STEP_COUNTER_NOTIFICATION_ID, notification)
    }

    fun generateHashId(): Int {
        val hashBytes = MessageDigest.getInstance("MD5").digest(UUID.randomUUID().toString().toByteArray(StandardCharsets.UTF_8))
        return BigInteger(1, hashBytes).toInt()
    }
    fun generateHashIdForNotification(): Int {
        val hashBytes = MessageDigest.getInstance("MD5").digest(UUID.randomUUID().toString().toByteArray(StandardCharsets.UTF_8))
        val hashInt = BigInteger(1, hashBytes).toInt()
        return Math.abs(hashInt % 10000) // Ensure it's a 4-digit positive integer
    }
}

