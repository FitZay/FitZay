package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPersonalizedWorkBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.AskingHeightActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions

class PersonalizedWorkAct : AppCompatActivity() {

    private lateinit var binding:ActivityPersonalizedWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalizedWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            if (AppController.fitzayModel != null && AppController.fitzayModel?.FitzayNativePersonalized?.showAd == true) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            Handler().postDelayed({
                if (AppController.inappflow)
                {
                    val intent = Intent(this@PersonalizedWorkAct, PremiumActivity::class.java).apply {
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                    startActivity(intent)
                }
                else
                {
                    if (AppController.inappScenario=="2") {
                        val intent =
                            Intent(this@PersonalizedWorkAct, MainActivity::class.java).apply {
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                            }
                        startActivity(intent)
                    }
                    else
                    {
                        if (AppController.inappflow)
                        {
                            val intent = Intent(this@PersonalizedWorkAct, PremiumActivity::class.java).apply {
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                            }
                            startActivity(intent)
                        }

                        else {
                            val intent =
                                Intent(this@PersonalizedWorkAct, MainActivity::class.java).apply {
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                }
                            startActivity(intent)
                        }
                    }
                }
            },2000)

        }
    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel?.FitzayNativePersonalized?.ctalocation == "up") {
                plannerTemplateDown.visibility = View.GONE
                plannerTemplateUp.visibility = View.VISIBLE
                plannerTemplateUp
            } else {
                plannerTemplateDown.visibility = View.VISIBLE
                plannerTemplateUp.visibility = View.GONE
                plannerTemplateDown
            }

            if (AppController.fitzayModel != null) {
                val adLoader =
                    AdLoader.Builder(
                        this@PersonalizedWorkAct,
                        AppController.fitzayModel!!.FitzayNativePersonalized.adID
                    )
                        .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                            template.setNativeAd(NativeAd)
                            skeletonLayout.visibility = View.GONE
                            clAds.visibility = View.VISIBLE
                            layoutAd.visibility = View.VISIBLE

                        }.withAdListener(object : AdListener() {
                            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                                super.onAdFailedToLoad(loadAdError)
                                clAds.visibility = View.GONE
                                layoutAd.visibility = View.GONE
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

}