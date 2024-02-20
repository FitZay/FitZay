package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString

import com.fitzay.workouttracker.strengthtraining.core.utils.showToast
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityFirstNameBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions

class FirstNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstNameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            //BackPress
            ivBack.setOnClickListener {
                onBackPressed()
            }

            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeName.showAd) {
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            //Next Btn Listener
            btnNext.setOnClickListener {
                if (binding.etName.text.isNullOrEmpty()) {
                    showToast("Add Your Name!")
                } else {
                    Component.preference.userName = binding.etName.text.toString()

                    val intent = Intent(this@FirstNameActivity, AskingAgeActivity::class.java).apply {
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                    val anim = ActivityOptions.makeCustomAnimation(this@FirstNameActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(intent)
                }
            }
            //skip Btn Listener
            txtSkip.setOnClickListener {
//                val intent = Intent(this@FirstNameActivity, AskingAgeActivity::class.java).apply {
//                    Intent.FLAG_ACTIVITY_SINGLE_TOP
//                }
//                startActivity(intent)

                val intent = Intent(this@FirstNameActivity, AskingAgeActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@FirstNameActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)
            }

            etName.requestFocus()
            etName.setSelection(etName.length());

        }




    }

//    override fun finish() {
//        super.finish()
//        val intent = Intent(this@FirstNameActivity, GenderActivity::class.java).apply {
//            Intent.FLAG_ACTIVITY_SINGLE_TOP
//        }
//        val anim = ActivityOptions.makeCustomAnimation(this@FirstNameActivity, R.anim.slide_in_left, R.anim.slide_out_right).toBundle()
//        startActivity(intent)
//    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            if (etName.text!!.isNotEmpty()) {
                etName.setText(Component.preference.userName)
                etName.setSelection(etName.length());
            }
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
                        this@FirstNameActivity,
                        AppController.fitzayModel!!.FitzayNativeName.adID
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