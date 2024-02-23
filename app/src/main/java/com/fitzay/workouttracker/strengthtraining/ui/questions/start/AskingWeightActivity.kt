package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.*
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityAskingWeightBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions


class AskingWeightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAskingWeightBinding
    var lb = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeWeight?.ctacolor
        binding = ActivityAskingWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeWeight.showAd) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

           ivBack.setOnClickListener {
                onBackPressed()
            }


            txtKGLB.text = "KG"
            rbOptions.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.rbKg) {
                    lb = false
                    txtKGLB.text = "KG"
                    if (!etInput.text.isNullOrEmpty()) {
                        val doubleValue = etInput.text.toString().convertStringToDouble ()

                        doubleValue.let {
                            val poundsToKilograms = it!!.toDouble().toKilograms()
                            Log.e("Pounds", "pound to kg: $poundsToKilograms")
                            etInput.setText(poundsToKilograms.roundToNearestWhole().toString())
                        }
                    }
                } else if (checkedId == R.id.rbLbs) {
                    lb = true
                    txtKGLB.text = "LBS"
                    if (!etInput.text.isNullOrEmpty()) {
                        val doubleValue = etInput.text.toString().convertStringToDouble ()
                        doubleValue.let {
                            val kilogramsToPounds = it!!.toDouble().toPounds()

                            Log.e("Pounds", "Kg to pound: $kilogramsToPounds")
                            etInput.setText(kilogramsToPounds.toString())
                        }
                    }
                }

                etInput.setSelection(etInput.length())
            }

           btnNext.setOnClickListener {
                if (lb && !etInput.text.isNullOrEmpty()) {
                    Component.preference.userWeightType = "LB"
                    Component.preference.userWeight = binding.etInput.text.toString().toInt()

                    val intent = Intent(this@AskingWeightActivity, TargetWeightActivity::class.java).apply {
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                    val anim = ActivityOptions.makeCustomAnimation(this@AskingWeightActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(intent)

                } else if (!lb && !etInput.text.isNullOrEmpty()) {
                    Component.preference.userWeightType = "KG"
                    Component.preference.userWeight = etInput.text.toString().toInt()


                    val intent = Intent(this@AskingWeightActivity, TargetWeightActivity::class.java).apply {
                        Intent.FLAG_ACTIVITY_SINGLE_TOP
                    }
                    val anim = ActivityOptions.makeCustomAnimation(this@AskingWeightActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                    startActivity(intent)

                } else {
                    showToast("Add Your Weight!")
                }

               etInput.setSelection(etInput.length())
            }

            etInput.requestFocus()
            etInput.setSelection(etInput.length())
        }

    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel!!.FitzayNativeWeight.ctalocation == "up") {
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
                        this@AskingWeightActivity,
                        AppController.fitzayModel!!.FitzayNativeWeight.adID
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
//    override fun finish() {
//        super.finish()
//        val intent = Intent(this@AskingWeightActivity, AskingHeightActivity::class.java).apply {
//            Intent.FLAG_ACTIVITY_SINGLE_TOP
//        }
//        val anim = ActivityOptions.makeCustomAnimation(this@AskingWeightActivity, R.anim.slide_in_left, R.anim.slide_out_right).toBundle()
//        startActivity(intent)
//    }

    override fun onStart() {
        super.onStart()
        binding.apply {

            if (Component.preference.userWeight != 0) {
                if (Component.preference.userWeightType == "KG") {
                   etInput.setText(Component.preference.userWeight.toString())
                   etInput.setSelection(etInput.length())
                } else {
                    etInput.setText(Component.preference.userWeight.toString())
                   etInput.setSelection(etInput.length())
                }
            }
        }

    }
}