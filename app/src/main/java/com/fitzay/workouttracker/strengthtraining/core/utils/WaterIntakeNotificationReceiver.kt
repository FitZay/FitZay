package com.fitzay.workouttracker.strengthtraining.core.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import androidx.work.impl.utils.ForceStopRunnable.BroadcastReceiver
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity

class WaterIntakeNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        super.onReceive(context, intent)
//        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val notification = AppController.buildNotification(context)
//        notificationManager.notify(0, notification)
//        Log.i("WATER-INTAKE", "onReceive: ")

    }

}