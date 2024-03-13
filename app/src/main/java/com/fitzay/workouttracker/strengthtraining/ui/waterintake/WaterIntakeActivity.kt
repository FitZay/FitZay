package com.fitzay.workouttracker.strengthtraining.ui.waterintake

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Dialog
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.RemoteViews
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.datastore.preferences.protobuf.StringValue
import androidx.lifecycle.ViewModelProvider
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.WaterIntakeNotificationReceiver
import com.fitzay.workouttracker.strengthtraining.core.utils.WavesLoadingIndicator
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityWaterIntakeBinding
import com.fitzay.workouttracker.strengthtraining.databinding.DialogWaterCapacityBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.viewmodels.SharedViewModel
import java.text.SimpleDateFormat
import java.util.*


class WaterIntakeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWaterIntakeBinding
    private lateinit var model: SharedViewModel
    var a = 0f
    val TAG = "WaterIntake"
    // Notification channel ID.
//    private val INTERVAL_MILLIS = 5 * 60 * 1000 // 5 minutes in milliseconds
    private val INTERVAL_MILLIS = 5*1000

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterIntakeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the notification channel.
        createNotificationChannel()

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(currentDate)

        if (Component.preference.currentDate != today) {
            Component.preference.currentDate = today
            Component.preference.saveWater = 0f
            Component.preference.totalDrink = 0
        }
        model = this.run {
            ViewModelProvider(this)[SharedViewModel::class.java]
        }
        model.select(0.1f)
        binding.txtDrink.text = Component.preference.totalDrink.toString()

        findViewById<ComposeView>(R.id.my_composable).setContent {
            MaterialTheme {
                Surface(
                    color = Color(0xff080612)
                ) {
                    Greeting()
                }
            }
        }



        binding.layoutChange.setOnClickListener {
            val intent =
                Intent(
                    this@WaterIntakeActivity,
                    CupCapacityActivity::class.java
                )
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)

        }
        binding.currentML.text = Component.preference.cupCapacity.toString() + " ml"
       // scheduleNotification()

//        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val notificationIntent = Intent(this, WaterIntakeNotificationReceiver::class.java)
//        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)
//
////        val intervalMillis = 2 * 60 * 60 * 1000 // 2 hours in milliseconds
//        val intervalMillis = 5000L // 2 hours in milliseconds
//        val triggerAtMillis = System.currentTimeMillis() + intervalMillis
//
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis,
//            intervalMillis, pendingIntent)





    }
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
                enableLights(true)
                lightColor = getColor(R.color.green)
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun scheduleNotification() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, WaterIntakeNotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        // Set repeating alarm with a 5-minute interval
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            add(Calendar.SECOND, 5)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            INTERVAL_MILLIS.toLong(),
            pendingIntent
        )
    }
    private fun showNotification() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.app_icon)
            .setContentTitle("Water Intake Reminder")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }
    }
    override fun onResume() {
        super.onResume()
        binding.txtGoal.text = getString(R.string.daily_goal)+": "+ Component.preference.waterGoal + getString(R.string.ml)
        binding.currentML.text = Component.preference.cupCapacity.toString() + getString(R.string.ml)
    }

    override fun onStart() {
        super.onStart()
        binding.txtDrink.text = Component.preference.totalDrink.toString()
    }

    companion object {
        var counter by mutableStateOf(Component.preference.saveWater)
        val CHANNEL_ID = "Water-Intake Notification"

    }

    @Composable
    fun Greeting() {

        WavesLoadingIndicator(
            modifier = Modifier.fillMaxSize(),
            color = lightThemeColors.secondaryVariant, // wave color
            progress = counter
        )

        binding.layoutAdd.setOnClickListener {

            Component.preference.totalDrink = Component.preference.totalDrink + Component.preference.cupCapacity
            val pro: Float = ((Component.preference.totalDrink).toFloat() / Component.preference.waterGoal.toFloat()) / 5
            counter += pro
            binding.txtDrink.text = Component.preference.totalDrink.toString()
            Component.preference.currentProgress = counter
            Component.preference.saveWater = counter

            if (Component.preference.totalDrink >= Component.preference.waterGoal) {
                Toast.makeText(
                    this@WaterIntakeActivity,
                    "You have Done Your Goal",
                    Toast.LENGTH_SHORT
                ).show()
            }

            Log.i("TAG", "Greeting: "+Component.preference.totalDrink+"-"+Component.preference.cupCapacity+"--"+Component.preference.totalDrink)

        }

        binding.changeGoal.setOnClickListener {
            addWater()
        }

//        binding.layoutSub.setOnClickListener {
//
//            Component.preference.totalDrink = Component.preference.totalDrink - Component.preference.cupCapacity
//            val pro: Float = ((Component.preference.totalDrink).toFloat() / Component.preference.waterGoal.toFloat()) / 10
//            counter -= pro
//            binding.txtDrink.text = Component.preference.totalDrink.toString()
//            counter -= 0.02f
//            Component.preference.saveWater = counter
//


//        }
        var i=0
        binding.layoutSub.setOnClickListener {
            val cupCapacity = Component.preference.cupCapacity
            val waterGoal = Component.preference.waterGoal


            if (Component.preference.totalDrink >= cupCapacity) {
                Component.preference.totalDrink -= cupCapacity
                val pro: Float = (Component.preference.totalDrink.toFloat() / waterGoal.toFloat()) / 5
                counter = (counter - pro).coerceAtLeast(0f) // Ensure counter doesn't go below 0
                binding.txtDrink.text = Component.preference.totalDrink.toString()
                Component.preference.currentProgress = counter
                Component.preference.saveWater = counter

                Log.i("TAG", "out: " + Component.preference.saveWater.toString() + "-" + counter)

                 i=binding.txtDrink.text.toString().toInt()
                if (i==0) {
                    counter=0f
                    Component.preference.currentProgress = counter
                    Component.preference.saveWater=counter
                    Log.i("TAG", "if: " + Component.preference.saveWater.toString() + "-" + counter)
                }
                else
                {
                    Log.i("TAG", "else if: " + Component.preference.saveWater.toString() + "-" + counter)
                    if (counter==0f)
                    {
                        counter=0f
                        binding.txtDrink.setText(counter.toInt().toString())
                        Component.preference.saveWater=counter
                        Component.preference.totalDrink=0


                    }
                }
            }
            else
            {
                Log.i("TAG", "ELSE-out: " + Component.preference.saveWater.toString() + "-" + counter+"-"+cupCapacity)
                counter=0f
                Component.preference.currentProgress = counter
                Component.preference.saveWater=counter
                binding.txtDrink.setText(counter.toInt().toString())
                Component.preference.totalDrink=0

            }



        }


    }

    val lightThemeColors = lightColors(
        primary = Color(0xFF855446),
        primaryVariant = Color(0xFF9C684B),
        secondary = Color(0xFF08A6CA),
        secondaryVariant = Color(0xFF006ABF)
    )



    private fun addWater() {

        val dialog = Dialog(this@WaterIntakeActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val waterBinding = DialogWaterCapacityBinding.inflate(layoutInflater)
        dialog.setContentView(waterBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.transparent)))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        waterBinding.tvTitle.text = getString(R.string.daily_goal)
        waterBinding.btnSave.setOnClickListener {
            if (waterBinding.tvCapacity.text.isNotEmpty()) {
                Component.preference.waterGoal = waterBinding.tvCapacity.text.toString().toInt()
                binding.txtGoal.text =
                    getString(R.string.daily_goal)+": " + waterBinding.tvCapacity.text.toString() + getString(R.string.ml)
                dialog.dismiss()
            }
            else
            {
                Toast.makeText(this@WaterIntakeActivity,"Enter Value",Toast.LENGTH_SHORT).show()
            }
        }
        waterBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

}

