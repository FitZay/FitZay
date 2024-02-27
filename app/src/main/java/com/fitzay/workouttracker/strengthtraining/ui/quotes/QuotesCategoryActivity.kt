package com.fitzay.workouttracker.strengthtraining.ui.quotes

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.checkForInternet
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityQoutesCategoryBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel
import com.fitzay.workouttracker.strengthtraining.ui.adapters.QuotesCategoriesAdapter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlin.math.round

class QuotesCategoryActivity : AppUtil2() {


    private lateinit var binding: ActivityQoutesCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityQoutesCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.recyclerview.adapter = QuotesCategoriesAdapter(Component.quotesViewModel.getDistinctQuotes(this) as ArrayList<QuotesModel>)

        if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeDailyMotivation.showAd && checkForInternet()) {
            loadAdaptiveNative()
        } else {
            binding.clAds.visibility = View.GONE
        }

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
                    this@QuotesCategoryActivity,
                    AppController.fitzayModel!!.FitzayNativeDailyMotivation.adID
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
        LanguageManager(this@QuotesCategoryActivity)
    }
}