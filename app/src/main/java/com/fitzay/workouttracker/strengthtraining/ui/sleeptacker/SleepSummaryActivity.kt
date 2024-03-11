package com.fitzay.workouttracker.strengthtraining.ui.sleeptacker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.core.utils.setLocale
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepSummaryBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import com.fitzay.workouttracker.strengthtraining.ui.adapters.ScheduleAlarmShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick
import com.fitzay.workouttracker.strengthtraining.ui.fragments.DailyFragment
import com.fitzay.workouttracker.strengthtraining.ui.fragments.MonthlyFragment
import com.fitzay.workouttracker.strengthtraining.ui.fragments.WeeklyFragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SleepSummaryActivity : AppUtil2(), ShowAlarmItemClick {

    private lateinit var binding: ActivitySleepSummaryBinding
    var typeClicked = "Daily"
    private lateinit var adapter: ScheduleAlarmShowAdapter
    private var list = ArrayList<AlarmEntity>()
//    private var list = ArrayList<SleepEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySleepSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeStatsSummary.showAd && !LoadingActivity.ispurchased) {
            binding?.clAds?.visibility = View.VISIBLE
            loadAdaptiveNative()
        }
        else {
            binding?.clAds?.visibility = View.GONE
        }



        supportFragmentManager.beginTransaction().replace(R.id.dailyContainer, DailyFragment()).commit()


        binding.apply {
            ivBack.setOnClickListener { onBackPressed() }

            txtDaily.setOnClickListener {
                unSelect()
                txtDaily.setBackgroundResource(R.drawable.bg_selected)
                typeClicked = "Daily"
                txtMonthly.isEnabled=true
                txtDaily.isEnabled=false
                txtWeekly.isEnabled=true

                supportFragmentManager.beginTransaction().replace(R.id.dailyContainer, DailyFragment()).commit()

            }

            txtWeekly.setOnClickListener {
                unSelect()
                 txtWeekly.setBackgroundResource(R.drawable.bg_selected)
                typeClicked = "Weekly"
                txtMonthly.isEnabled=true
                txtDaily.isEnabled=true
                txtWeekly.isEnabled=false
                supportFragmentManager.beginTransaction().replace(R.id.dailyContainer, WeeklyFragment()).commit()


            }


            txtMonthly.setOnClickListener {
                unSelect()
                binding.txtMonthly.setBackgroundResource(R.drawable.bg_selected)
                typeClicked = "Monthly"
                txtMonthly.isEnabled=false
                txtDaily.isEnabled=true
                txtWeekly.isEnabled=true
                supportFragmentManager.beginTransaction().replace(R.id.dailyContainer, MonthlyFragment()).commit()


            }

            alarmRv.layoutManager = LinearLayoutManager(
                this@SleepSummaryActivity,
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
                    adapter = ScheduleAlarmShowAdapter(
                        this@SleepSummaryActivity,
                        list,
                        this@SleepSummaryActivity
                    )
                    alarmRv.adapter = adapter
                }



            }

        }


    }

    private fun unSelect() {
        binding.txtDaily.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.txtWeekly.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.txtMonthly.setBackgroundResource(R.drawable.bg_unselected_options)
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


        val intent = Intent(this@SleepSummaryActivity, SleepTrackerActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.putExtra("key","homeScreen")
        intent.putExtra("id",model.sleepId)
        intent.putExtra("onBack","summary")
        startActivity(intent)
        finish()

        Log.i("TAG", "itemClick: "+model.sleepId)


    }

    override fun longItemClickForDelete(position: Int,
                                        model: AlarmEntity) {


    }

    override fun switchOnOff(
        position: Int,
        model: AlarmEntity,
        boolean: Boolean,
    ) {

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
                    this,
                    AppController.fitzayModel!!.FitzayNativeStatsSummary.adID
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

    override fun onStart() {
        super.onStart()
        LanguageManager(this@SleepSummaryActivity)
    }
}

