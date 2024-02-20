package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepTrackerHomeScreenBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SleepTrackerHomeScreen : AppCompatActivity(), ShowAlarmItemClick {

    private lateinit var binding: ActivitySleepTrackerHomeScreenBinding
    private lateinit var adapter: AlarmShowAdapter

    //    private var list = ArrayList<AlarmEntity>()
    private var list = ArrayList<AlarmEntity>()

    private var lastSelectedItemPosition = RecyclerView.NO_POSITION
    var pos = 0L

    companion object {
        var toggleValue=true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sleep_tracker_home_screen)




        binding.apply {

            ivBack.setOnClickListener {
                onBackPressed()
            }


            addViewIcon.setOnClickListener {
                val intent = Intent(this@SleepTrackerHomeScreen, SleepTrackerActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                intent.putExtra("key", "newAlarmSet")
                intent.putExtra("onBack", "")
                startActivity(intent)
                finish()
            }


            alarmRv.layoutManager = LinearLayoutManager(
                this@SleepTrackerHomeScreen,
                LinearLayoutManager.VERTICAL,
                false
            )


            CoroutineScope(Dispatchers.IO).launch {

                val sleepList=Component.sleepViewModel.sleepRepository.getId()
                Log.i("NewHome", "onCreate-55-if: "+list)
                Log.i("NewHome", "onCreate-55-if: "+sleepList)
                       var model = AlarmEntity(1L,1L, 1L, "Test", false, false, "", null, 1L, "", 1L, "0", "")

                   if (sleepList.isEmpty())
                   {
                       list.add(model)
                   }
                   for(sleep in sleepList){
                       val result=Component.alarmViewModel.alarmRepository.getAlarmId(sleep.id)

                       var day = ""
                      // var alarm=AlarmEntity()
                       for (i in result) {
                               day = day + "," + getDayOfWeek(i.date!!)
                               day = day.removePrefix(",")
                               i.days=day
                           model=i
                       }
                       if (model.sleepId!=0L) {
                           list.add(model)

                           Log.i("NewHome", "onCreate--if: "+list)
                       }


                }
                withContext(Dispatchers.Main) {
                    adapter = AlarmShowAdapter(
                        this@SleepTrackerHomeScreen,
                        list,
                        this@SleepTrackerHomeScreen
                    )
                    alarmRv.adapter = adapter
                }



            }


        }
    }


    override fun itemClick(
        position: Int,
        model: AlarmEntity,
        time: TextView,
        am_pm: TextView,
        label: TextView,
        day: TextView,
        switch: SwitchCompat,
    ) {

        if (time.text == "No Alarm") {
            val intent = Intent(this@SleepTrackerHomeScreen, SleepTrackerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.putExtra("key", "newAlarmSet")
            intent.putExtra("onBack","")
            startActivity(intent)
            finish()
        } else {

            val intent = Intent(this@SleepTrackerHomeScreen, SleepTrackerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.putExtra("key", "homeScreen")
            intent.putExtra("id", model.sleepId)
            intent.putExtra("onBack","")



            startActivity(intent)
            finish()


        }


    }

    override fun switchOnOff(
        position: Int,
        mm: AlarmEntity,
        value: Boolean,
    ) {


        CoroutineScope(Dispatchers.IO).launch {

                val result=Component.alarmViewModel.alarmRepository.getAlarmId(mm.sleepId)

                for (model in result) {
                Component.alarmViewModel.alarmRepository.updateItem(model.sleepId,model.id,model.time,model.label!!,value,model.isVibrationEnabled,model.soundUri!!,model.bedTime,model.selectedDay!!,model.snoozeTime,model.totalSleepingHr!!,model.date!!)
                }


        }

    }

    override fun longItemClickForDelete(
        position: Int,
        item: AlarmEntity
    ) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Alarm")
        builder.setMessage("Are you sure want to delete.?")
        builder.setPositiveButton("OK") { dialog, which ->
            binding.apply {

                var model = AlarmEntity(0L,1L, 1L, "Test", false, false, "", null, 1L, "", 1L, "0", "")



                CoroutineScope(Dispatchers.IO).launch {
                    Component.sleepViewModel.sleepRepository.deleteItem(item.sleepId)
                    Component.alarmViewModel.alarmRepository.deleteItem(item.sleepId)

                    withContext(Dispatchers.Main) {
                        list.removeAt(position)
                        adapter.notifyItemRemoved(position)
                        if (list.size == 0) {
                            list.add(model)
                        }
                        adapter.notifyItemRangeChanged(position, list.size)
                    }
                }

            }
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()

    }
}
