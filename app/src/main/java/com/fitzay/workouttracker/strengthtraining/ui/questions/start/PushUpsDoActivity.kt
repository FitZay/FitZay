package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPartShouldFocusBinding
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPushUpsDoBinding
import com.fitzay.workouttracker.strengthtraining.ui.activities.PersonalizedWorkAct
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions

class PushUpsDoActivity : AppUtil2() {

    private lateinit var binding: ActivityPushUpsDoBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativePushUp?.ctacolor
        binding = ActivityPushUpsDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if (AppController.fitzayModel != null && AppController.fitzayModel?.FitzayNativePushUp?.showAd == true) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            cl30.setOnClickListener {
                reset(cl30)
                cl30.setBackgroundColor(resources.getColor(R.color.green));

            }
            cl1529.setOnClickListener {
                reset(cl1529)
                cl1529.setBackgroundColor(resources.getColor(R.color.green));

            }
            cl629Week.setOnClickListener {
                reset(cl629Week)
                cl629Week.setBackgroundColor(resources.getColor(R.color.green));

            }
            clLess5.setOnClickListener {
                reset(clLess5)
                clLess5.setBackgroundColor(resources.getColor(R.color.green));

            }

            btnNext.setOnClickListener {
                val intent = Intent(this@PushUpsDoActivity, HeightandWeightAct::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                startActivity(intent)
            }
            ivBack.setOnClickListener {
                onBackPressed()
            }

        }

    }


    fun reset(view:ConstraintLayout) {
        binding.apply {
            cl30.setBackgroundResource(R.drawable.bg_options)
            cl1529.setBackgroundResource(R.drawable.bg_options)
            cl629Week.setBackgroundResource(R.drawable.bg_options)
            clLess5.setBackgroundResource(R.drawable.bg_options)
        }
        //view.setBackgroundColor(R.color.green)
    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel?.FitzayNativePushUp?.ctalocation == "up") {
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
                        this@PushUpsDoActivity,
                        AppController.fitzayModel!!.FitzayNativePushUp.adID
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

    override fun onStart() {
        super.onStart()
        LanguageManager(this@PushUpsDoActivity)
    }
}