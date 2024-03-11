package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.ads.FitnessInterstitialAd
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.checkForInternet
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityDisplayWorkoutsBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel
import com.fitzay.workouttracker.strengthtraining.ui.adapters.DisplayWorkOutAdapter
import com.fitzay.workouttracker.strengthtraining.ui.fragments.UnlockPremiumBottomFragment
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAdOptions

class DisplayWorkoutsActivity : AppUtil2() {

    private lateinit var binding: ActivityDisplayWorkoutsBinding
    private var TAG = "_displayactivity"

    companion object {
        var listofworkmodel :ArrayList<WorkOutModel> = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeStartExercise?.ctacolor
        binding = ActivityDisplayWorkoutsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LanguageManager(this@DisplayWorkoutsActivity)
        val activitytype = intent.getStringExtra("EXTRA_Activity")
        val name = intent.getStringExtra("EXTRA_NAME")!!
        val id = intent.getStringExtra("EXTRA_ID")
        val type = intent.getStringExtra("EXTRA_TYPE")!!
        val excersidetype = intent.getStringExtra("EXTRA_EXERCISE")
        val week = intent.getStringExtra("EXTRA_WEEk")
        val exerciseId = intent.getStringExtra("EXTRA_EXERCISE_ID")


        if (excersidetype == "INTERMEDIATE" || excersidetype == "ADVANCE" ) {
            UnlockPremiumBottomFragment.show(supportFragmentManager)
        }

        binding.apply {
            collapsingToolbar.title = "$name $type"

            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeStartExercise.showAd && checkForInternet()) {
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            when (name) {
                "ABS" -> {

                    Glide.with(this@DisplayWorkoutsActivity)
                        .load((R.drawable.abs_index))
                        .into(toolBarImage)
                }
                "CHEST" -> {

                    Glide.with(this@DisplayWorkoutsActivity)
                        .load((R.drawable.chest_index))
                        .into(toolBarImage)
                }
                "ARM" -> {

                    Glide.with(this@DisplayWorkoutsActivity)
                        .load((R.drawable.arm_index))
                        .into(toolBarImage)
                }
                "LEG" -> {

                    Glide.with(this@DisplayWorkoutsActivity)
                        .load((R.drawable.leg_index))
                        .into(toolBarImage)
                }
                "SHOULDER & BACK" -> {

                    Glide.with(this@DisplayWorkoutsActivity)
                        .load((R.drawable.shoulder_index))
                        .into(toolBarImage)
                }
            }

            if (activitytype == "category"){
                recyclerview.adapter = DisplayWorkOutAdapter(this@DisplayWorkoutsActivity,
                    Component.workOutViewModel.getWorkouts(
                        this@DisplayWorkoutsActivity,
                        id.toString()
                    ) as ArrayList<WorkOutModel>
                )
            }
            else {
                FullbodyWorkoutActivity.listoffullbodies.forEach {
                    listofworkmodel.addAll(it.cat_id?.let { it1 ->
                        it.ex_id?.toInt()?.let { it2 ->
                            Component.workOutViewModel.getFullbodyWorkouts(
                                this@DisplayWorkoutsActivity,
                                it1,
                                it2
                            )
                        }
                    } as ArrayList<WorkOutModel>)
                }

                recyclerview.adapter = DisplayWorkOutAdapter(this@DisplayWorkoutsActivity ,listofworkmodel)
                Handler(Looper.getMainLooper()).postDelayed({

                },500)
            }

            //Work out Listener

            cardStart.setOnClickListener {
                if (activitytype == "category"){
                    ExerciseActivity.activityType = "category"
                }
                else{
                    ExerciseActivity.activityType = ""
                }
                val intent = Intent(this@DisplayWorkoutsActivity, ExerciseActivity::class.java).apply {
                    putExtra("EXTRA_CATEGORY", name)
                    putExtra("EXTRA_TYPE", type)
                    putExtra("EXTRA_FROM", true)
                    putExtra("EXTRA_ID", id)
                }
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                interCallback(intent)
                ///     startActivity(intent)
            }
        }


    }

    private fun interCallback(intent: Intent) {
        if (FitnessInterstitialAd.mInterstitialAd != null) {
            FitnessInterstitialAd.mInterstitialAd!!.show(this)
            FitnessInterstitialAd.mInterstitialAd?.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        FitnessInterstitialAd.mInterstitialAd=null
                        FitnessInterstitialAd.getInstance(this@DisplayWorkoutsActivity)!!.loadAdMobInterAd()
                        startActivity(intent)
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        startActivity(intent)

                    }

                    override fun onAdShowedFullScreenContent() {
                        super.onAdShowedFullScreenContent()
                    }
                }
        } else {
            startActivity(intent)
        }
    }

    private fun loadAdaptiveNative() {

        if (AppController.fitzayModel != null) {
            val adLoader =
                AdLoader.Builder(
                    this,
                    AppController.fitzayModel!!.FitzayNativeStartExercise.adID
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

}