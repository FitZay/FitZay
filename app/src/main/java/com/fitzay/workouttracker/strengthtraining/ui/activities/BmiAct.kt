package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.calculateBMI
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityBmiBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions

class BmiAct : AppCompatActivity() {
    private lateinit var binding:ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeBMI?.ctacolor
        binding= ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {

            if (AppController.fitzayModel != null && AppController.fitzayModel?.FitzayNativeBMI?.showAd == true) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            ageValue.text =Component.preference.userAge.toString()
            weightValue.text =Component.preference.userWeight.toString()+"kg"
            heightValue.text =Component.preference.userHeight.toString()+"cm"

            var bmi=calculateBMI(Component.preference.userHeight,Component.preference.userWeight)
            bmiValue.setText(bmi.toString())

            if (bmi < 18.5) {
                bmiLow.visibility= View.VISIBLE
                bmiNormal.visibility= View.INVISIBLE
                bmiOverweight.visibility= View.INVISIBLE
                bmiObese.visibility= View.INVISIBLE
                bmiExtreme.visibility= View.INVISIBLE
                des.text="You have a great potential to get in \nbetter shape, move now!"
            } else if (bmi >= 18.5 && bmi < 22.9) {
                bmiLow.visibility= View.INVISIBLE
                bmiNormal.visibility= View.VISIBLE
                bmiOverweight.visibility= View.INVISIBLE
                bmiObese.visibility= View.INVISIBLE
                bmiExtreme.visibility= View.INVISIBLE
                des.text="Maintaining a healthy weight may reduce the rish\n of chronic diseases associated with overweight and obesity"
            }
            else if (bmi >= 23.0 && bmi < 24.9) {
                bmiLow.visibility= View.INVISIBLE
                bmiNormal.visibility= View.INVISIBLE
                bmiOverweight.visibility= View.VISIBLE
                bmiObese.visibility= View.INVISIBLE
                bmiExtreme.visibility= View.INVISIBLE
                des.text="You only need a bit more \n sweat exercise to see a filer you!"
            }
            else if (bmi >= 25.0 && bmi < 29.9) {
                bmiLow.visibility= View.INVISIBLE
                bmiNormal.visibility= View.INVISIBLE
                bmiOverweight.visibility= View.INVISIBLE
                bmiObese.visibility= View.VISIBLE
                bmiExtreme.visibility= View.INVISIBLE
                des.text="You only need a bit more \n sweat exercise to see a filer you!"
            }
            else if (bmi >= 30) {
                bmiLow.visibility= View.INVISIBLE
                bmiNormal.visibility= View.INVISIBLE
                bmiOverweight.visibility= View.INVISIBLE
                bmiObese.visibility= View.INVISIBLE
                bmiExtreme.visibility= View.VISIBLE
                des.text="You only need a bit more \n sweat exercise to see a filer you!"
            }

            btnNext.setOnClickListener {
                val intent = Intent(this@BmiAct, PersonalizedWorkAct::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                startActivity(intent)
            }

            back.setOnClickListener {
                onBackPressed()
            }


        }
    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel?.FitzayNativeBMI?.ctalocation == "up") {
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
                        this@BmiAct,
                        AppController.fitzayModel!!.FitzayNativeBMI.adID
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