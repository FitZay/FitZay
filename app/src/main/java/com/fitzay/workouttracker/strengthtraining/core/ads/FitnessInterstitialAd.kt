package com.fitzay.workouttracker.strengthtraining.core.ads

import android.content.Context
import android.util.Log
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class FitnessInterstitialAd(var context: Context) {
    companion object {
        private const val TAG = "GoogleAds"
        var mInstance: FitnessInterstitialAd? = null
        var mInterstitialAd: InterstitialAd? = null
        fun getInstance(context: Context?): FitnessInterstitialAd? {
            if (mInstance == null) {
                mInstance = FitnessInterstitialAd(context!!)
            }
            return mInstance
        }

    }

    fun loadAdMobInterAd() {
        if (AppController.fitzayModel!=null && AppController.fitzayModel!!.FitzayInterstitialMain.showAd && !LoadingActivity.ispurchased) {
            if (mInterstitialAd == null) {
                val adRequest = AdRequest.Builder().build()
                InterstitialAd.load(
                    context,
                    AppController.fitzayModel!!.FitzayInterstitialMain.adID,
                    adRequest,
                    object : InterstitialAdLoadCallback() {
                        override fun onAdFailedToLoad(adError: LoadAdError) {
                            Log.e(TAG, adError.message)
                            mInterstitialAd = null
                        }

                        override fun onAdLoaded(interstitialAd: InterstitialAd) {
                            Log.e(TAG, "Ad loaded.")
                            mInterstitialAd = interstitialAd
                        }

                    })
            }
        }
    }
}