package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R

import com.fitzay.workouttracker.strengthtraining.core.utils.InAppPurchaseUtil
import com.fitzay.workouttracker.strengthtraining.core.utils.checkForInternet
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityLoadingBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.GenderActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.google.android.ump.UserMessagingPlatform
import java.util.concurrent.atomic.AtomicBoolean


class LoadingActivity : AppCompatActivity() {

    var mInterstitialAd: InterstitialAd? = null
    var isStarted = false
    //
    private lateinit var handlerLoading: Handler
    private lateinit var rLoading: Runnable
    private var isConsentDone = false

    // Use an atomic boolean to initialize the Google Mobile Ads SDK and load ads once.
    private var isMobileAdsInitializeCalled = AtomicBoolean(false)

    companion object {
        var ispurchased = false
    }


    val TAG = "LoadingActivity"
    private lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isStarted = true
        InAppPurchaseUtil.isPurchaseSubscribed(this)
        handlerLoading = Handler(Looper.getMainLooper())
        if (checkForInternet()) {
            consentForm()
        } else {
            initializeMobileAdsSdk()
        }

    }

//    private fun loadAdaptiveNative() {
//
//        val adLoader =
//            AdLoader.Builder(
//                this@LoadingActivity,
//                resources.getString(R.string.fitzay_native_splash)
//            )
//                .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
//                    binding.plannerTemplate.setNativeAd(NativeAd)
//                    binding.clAds.visibility = View.VISIBLE
//                    binding.layoutAd.visibility = View.VISIBLE
//
//                }.withAdListener(object : AdListener() {
//                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
//                        super.onAdFailedToLoad(loadAdError)
//                        binding.clAds.visibility = View.GONE
//                    }
//                })
//                .withNativeAdOptions(
//                    NativeAdOptions.Builder()
//                        .setRequestCustomMuteThisAd(true)
//                        .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT)
//                        .build()
//                )
//                .build()
//
//        adLoader.loadAd(AdRequest.Builder().build())
//    }
//
//=======


//    private fun loadAdaptiveNative() {
//
//        val adLoader =
//            AdLoader.Builder(
//                this@LoadingActivity,
//                resources.getString(R.string.fitzay_native_splash)
//            )
//                .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
//                    binding.plannerTemplate.setNativeAd(NativeAd)
//                    binding.clAds.visibility = View.VISIBLE
//                    binding.layoutAd.visibility = View.VISIBLE
//
//                }.withAdListener(object : AdListener() {
//                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
//                        super.onAdFailedToLoad(loadAdError)
//                        binding.clAds.visibility = View.GONE
//                    }
//                })
//                .withNativeAdOptions(
//                    NativeAdOptions.Builder()
//                        .setRequestCustomMuteThisAd(true)
//                        .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT)
//                        .build()
//                )
//                .build()
//
//        adLoader.loadAd(AdRequest.Builder().build())
//    }

    private fun interAd() {
        if (mInterstitialAd == null) {
            val adRequest = AdRequest.Builder().build()
            InterstitialAd.load(
                this,
                resources.getString(R.string.fitzay_inter_splash),
                adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.e(TAG, adError.message)
                        mInterstitialAd = null

                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        Log.e(TAG, "Ad was loaded.")
                        mInterstitialAd = interstitialAd
                    }
                })
        }

    }

    private fun interCallback() {
        if (mInterstitialAd != null) {
            mInterstitialAd!!.show(this)
            mInterstitialAd?.fullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent()
                        isStarted = true
                        loadNext()
                        Log.e(TAG, "Ad was dismissed.")
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        super.onAdFailedToShowFullScreenContent(p0)
                        Log.e(TAG, "Ad was Failed To Show.")

                    }

                }
        } else {
            loadNext()
        }
    }

    override fun onStart() {
        super.onStart()
        isStarted = true
        if (isConsentDone) {
            showLoading()
        }

    }


    private fun loadNext() {
        if (isStarted) {
            if (!Component.preference.isIntro) {
                val intent = Intent(this@LoadingActivity, GenderActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this@LoadingActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        isStarted = true
        if (::handlerLoading.isInitialized) {
            try {
                handlerLoading.postDelayed(rLoading, 5000)
            } catch (e: Exception) {
                Log.e(TAG, "onResume: ")
            }
        }
    }

    override fun onPause() {
        super.onPause()
        isStarted = false
        try {
            handlerLoading.removeCallbacks(rLoading)
        } catch (e: Exception) {
            Log.e(TAG, "onPause: ")
        }

    }

    override fun onStop() {
        super.onStop()
//        isStarted = false


    }


    private fun showLoading() {
        var percent = 0
        Thread {
            while (percent < 100 && isStarted) {
                try {
                    Thread.sleep(100)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                rLoading = Runnable {
                    try {
                        if (percent < 100) {
                            binding.loadingProgress.progress = percent
                            if (percent > 30) {
                                binding.wishIt.setTextColor(
                                    ContextCompat.getColor(
                                        this,
                                        R.color.white
                                    )
                                )
                            }
                            if (percent > 60) {
                                binding.wantIt.setTextColor(
                                    ContextCompat.getColor(
                                        this,
                                        R.color.white
                                    )
                                )
                            }
                            if (percent > 80) {
                                binding.doIt.setTextColor(
                                    ContextCompat.getColor(
                                        this,
                                        R.color.white
                                    )
                                )
                            }
                        } else {
                            binding.loadingProgress.progress = 100
                            interCallback()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        loadNext()
                    }
                }
                percent += 1
                handlerLoading.post(rLoading)
            }
        }.start()

//        val totalMillis = 10000 // 10 seconds
//        val intervalMillis = 100 // 0.1 second
//
//        val countDownTimer = object : CountDownTimer(totalMillis.toLong(), intervalMillis.toLong()) {
//            override fun onTick(millisUntilFinished: Long) {
//                val remainingPercent = ((totalMillis - millisUntilFinished) / totalMillis.toDouble() * 100).toInt()
////                rLoading = Runnable {
//                try {
//                    binding.loadingProgress.progress = remainingPercent
//                    if (remainingPercent > 30) {
//                        binding.wishIt.setTextColor(ContextCompat.getColor(this@LoadingActivity, R.color.white))
//                    }
//                    if (remainingPercent > 60) {
//                        binding.wantIt.setTextColor(ContextCompat.getColor(this@LoadingActivity, R.color.white))
//                    }
//                    if (remainingPercent > 80) {
//                        binding.doIt.setTextColor(ContextCompat.getColor(this@LoadingActivity, R.color.white))
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    loadNext()
//                }
////                }
////                handlerLoading.post(rLoading)
//            }
//
//            override fun onFinish() {
//                // Code to be executed when the countdown finishes
//                binding.loadingProgress.progress = 100
//                interCallback()
//            }
//        }
//
//        countDownTimer.start()

    }

    private fun consentForm() {
        // Set tag for under age of consent. false means users are not under age
        // of consent.
        val TAG = "ConsentForm"

        val params = ConsentRequestParameters
            .Builder()
            .setTagForUnderAgeOfConsent(false)
            .build()

        val consentInformation: ConsentInformation =
            UserMessagingPlatform.getConsentInformation(this)
        //    consentInformation.reset() // FIXME : REMOVE
        consentInformation.requestConsentInfoUpdate(
            this,
            params,
            {
                Log.e(TAG, "onCreate: On Consent Updated ")
                UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                    this@LoadingActivity
                ) { loadAndShowError ->
                    // Consent gathering failed.
                    try {
                        Log.w(
                            TAG, "loadAndShow Error " + String.format(
                                "%s: %s",
                                loadAndShowError?.errorCode,
                                loadAndShowError?.message
                            )
                        )
                    } catch (e: NullPointerException) {
                        Log.e(TAG, "consentForm: Exception" + e.message)
                    }
                    // Consent has been gathered.
                    if (consentInformation.canRequestAds()) {
                        Log.e(TAG, "consentForm: inside")
                        initializeMobileAdsSdk()
                    } else {
                        Log.e(TAG, "consentForm: No Form Display")
                    }
                }
            },
            { requestConsentError ->
                // Consent gathering failed.
                Log.w(
                    TAG, String.format(
                        "%s: %s",
                        requestConsentError.errorCode,
                        requestConsentError.message
                    )
                )

            })

        // Check if you can initialize the Google Mobile Ads SDK in parallel
        // while checking for new consent information. Consent obtained in
        // the previous session can be used to request ads.
        if (consentInformation.canRequestAds()) {
            Log.e(TAG, "consentForm: Outer ")
            initializeMobileAdsSdk()
        }

    }

    private fun initializeMobileAdsSdk() {
        Log.e("ConsentForm", "initializeMobileAdsSdk: Above ")
        if (isMobileAdsInitializeCalled.getAndSet(true)) {
            return
        }
        Log.e("ConsentForm", "initializeMobileAdsSdk: Initialize")
        // Initialize the Google Mobile Ads SDK.
        Handler(Looper.getMainLooper()).postDelayed({
            if (!ispurchased) {
                MobileAds.initialize(this)
                if (checkForInternet()) {
//            loadAdaptiveNative()
                    interAd()
                } else {
//            binding.clAds.visibility = View.GONE
                }
                if (!isConsentDone) {
                    isConsentDone = true
                    showLoading()
                }
            }
            else {
                loadNext()
            }
        },1500)
    }

}