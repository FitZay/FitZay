package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityAskingAgeBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions


class AskingAgeActivity : AppUtil2() {

    private lateinit var binding: ActivityAskingAgeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeAge?.ctacolor
        binding = ActivityAskingAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeAge.showAd) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            ivBack.setOnClickListener {
                onBackPressed()
            }

            txtSkip.setOnClickListener {
                val intent = Intent(this@AskingAgeActivity, AskingHeightActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@AskingAgeActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)
            }

            btnNext.setOnClickListener {
                val age = userAge.getCurrentSelectedItem()
                Component.preference.userAge = age!!.toInt()
                val intent = Intent(this@AskingAgeActivity, AskingHeightActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@AskingAgeActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)
            }



        }

    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel!!.FitzayNativeAge.ctalocation == "up") {
                binding.plannerTemplateDown.visibility = View.GONE
                binding.plannerTemplateUp.visibility = View.VISIBLE
                binding.plannerTemplateUp
            } else {
               plannerTemplateDown.visibility = View.VISIBLE
                plannerTemplateUp.visibility = View.GONE
                plannerTemplateDown
            }

            if (AppController.fitzayModel != null) {
                val adLoader =
                    AdLoader.Builder(
                        this@AskingAgeActivity,
                        AppController.fitzayModel!!.FitzayNativeAge.adID
                    )
                        .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                            template.setNativeAd(NativeAd)

                           clAds.visibility = View.VISIBLE
                            skeletonLayout.visibility = View.GONE
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

//    override fun finish() {
//        super.finish()
//        val intent = Intent(this@AskingAgeActivity, FirstNameActivity::class.java).apply {
//            Intent.FLAG_ACTIVITY_SINGLE_TOP
//        }
//        val anim = ActivityOptions.makeCustomAnimation(this@AskingAgeActivity, R.anim.slide_in_left, R.anim.slide_out_right).toBundle()
//        startActivity(intent)
//    }

    override fun onStart() {
        super.onStart()
        binding.userAge.setSelectedItem(Component.preference.userAge.toString())
        LanguageManager(this@AskingAgeActivity)
    }
}