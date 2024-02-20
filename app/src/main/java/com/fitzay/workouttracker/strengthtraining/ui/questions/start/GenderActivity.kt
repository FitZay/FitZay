package com.fitzay.workouttracker.strengthtraining.ui.questions.start


import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.fadeOut
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityGenderBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions


class GenderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenderBinding

    private var isMaleSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGenderBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeGender.showAd) {
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }


            //Skip Button Listener
            txtSkip.setOnClickListener {
                val intent = Intent(this@GenderActivity, FirstNameActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@GenderActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)
            }

            //Female Button Listener
            clFemale.setOnClickListener {
                unSelectBoth()
                clFemale.background = resources.getDrawable(R.drawable.bg_selected_circle, null)
                tvFemale.setTextColor(resources.getColor(R.color.white, null))

            }

            //Male Button Listener
            clMale.setOnClickListener {
                unSelectBoth()
                clMale.background = resources.getDrawable(R.drawable.bg_selected_circle, null)
                tvMale.setTextColor(resources.getColor(R.color.white, null))
            }




            //Next Button Listener
            btnNext.setOnClickListener {

                if (isMaleSelected) {
                    Component.preference.userGender = "Male"
                } else {
                    Component.preference.userGender = "Female"
                }



                val intent = Intent(this@GenderActivity, FirstNameActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@GenderActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)


                //var an=AnimationUtils.loadAnimation(this@GenderActivity, R.anim.slide_in_right_2)
                // personAni.startAnimation(an)

            }

        }

    }


    private fun unSelectBoth() {
        binding.apply {
            clMale.background = resources.getDrawable(R.drawable.bg_not_selected_circle, null)
            tvMale.setTextColor(resources.getColor(R.color.text_gray, null))
            clFemale.background = resources.getDrawable(R.drawable.bg_not_selected_circle, null)
            tvFemale.setTextColor(resources.getColor(R.color.text_gray, null))
        }

    }

    private fun loadAdaptiveNative() {

        binding.apply {
           layoutAd.visibility = View.GONE

            val template = if (getFitzayRemoteString("fitzay_cta_location") == "up") {
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
                        this@GenderActivity,
                        AppController.fitzayModel!!.FitzayNativeGender.adID
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