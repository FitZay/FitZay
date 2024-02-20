package com.fitzay.workouttracker.strengthtraining.core.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepTrackerActivity


class NotificationHelper(private val context: Context) {

    private val channelId = "notificationChannel"

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Reminder Channel"
            val description = "Notification channel for reminders"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun getNotification(): NotificationCompat.Builder {

        //Component.ringtoneModel.startRingtone(context)

        val intent = Intent(context, SleepTrackerActivity::class.java)

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        val remainingIntent = PendingIntent.getActivity(context,
                5897,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        return NotificationCompat.Builder(context, channelId)
            .setContentTitle("Bed Time:")
            .setContentText("Your bed time is set: "+context.convertDateTime(SleepTrackerActivity.bedTimeInMilliSecond.toString(),"hh:mm")+" "+context.convertDateTime(SleepTrackerActivity.bedTimeInMilliSecond.toString(),"aa"))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setContentIntent(null)
    }

    fun notify(notificationId: Int, notification: NotificationCompat.Builder) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, notification.build())
    }
}