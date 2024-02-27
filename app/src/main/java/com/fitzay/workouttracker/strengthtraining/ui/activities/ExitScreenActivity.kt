package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.Dialog
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityExitScreenBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import java.util.Objects

class ExitScreenActivity : AppUtil2() {

    private var binding : ActivityExitScreenBinding? = null
    private var waiting_dialog : Dialog? = null
    var mInterstitialad: InterstitialAd? = null
    private var loadinginterstitial = false
    private val TAG = "ExitScreenActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExitScreenBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        LanguageManager(this@ExitScreenActivity)
        Log.d("ActivityCreation" , "oncreate")

        waiting_dialog = Dialog(this)

        binding?.doneBtn?.setOnClickListener {
            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayInterstitialExcerciseQuit.showAd && !LoadingActivity.ispurchased) {
                showWaitingDialog()
                loadSplashInterstitialAd(AppController.fitzayModel!!.FitzayInterstitialExcerciseQuit.adID)
            }
            else {
                finish()
            }
        }

        binding?.backpressBtn?.setOnClickListener {
            finish()
        }

        binding?.toohardBtn?.setOnClickListener {
            resetimages()
            binding?.toohardimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.too_hard))
            binding?.toohardtext?.setTextColor(ContextCompat.getColor(this , R.color.white))
        }

        binding?.justrightBtn?.setOnClickListener {
            resetimages()
            binding?.justrightimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.just_right))
            binding?.justrighttext?.setTextColor(ContextCompat.getColor(this , R.color.white))
        }

        binding?.tooeasyBtn?.setOnClickListener {
            resetimages()
            binding?.tooeasyimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.to_easy))
            binding?.tooeasytext?.setTextColor(ContextCompat.getColor(this , R.color.white))
        }
    }

    fun resetimages(){
        binding?.toohardimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.too_hard_dim))
        binding?.tooeasyimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.to_easy_dim))
        binding?.justrightimg?.setImageDrawable(ContextCompat.getDrawable(this , R.drawable.just_right_dim))

        binding?.toohardtext?.setTextColor(android.graphics.Color.parseColor("#8AD0CFD1"))
        binding?.tooeasytext?.setTextColor(android.graphics.Color.parseColor("#8AD0CFD1"))
        binding?.justrighttext?.setTextColor(android.graphics.Color.parseColor("#8AD0CFD1"))


    }




    fun loadSplashInterstitialAd(adId: String) {
        if (mInterstitialad == null && !loadinginterstitial) {
            loadinginterstitial = true
            var adRequest = AdRequest.Builder().build()
            this?.let {
                InterstitialAd.load(
                    it,
                    adId,
                    adRequest,
                    object : InterstitialAdLoadCallback() {
                        override fun onAdFailedToLoad(adError: LoadAdError) {
                            Log.d(TAG, "Error while loading ad : ${adError.message}")
                            mInterstitialad = null
                            loadinginterstitial = false
                            waiting_dialog?.dismiss()
                            finish()
                        }

                        override fun onAdLoaded(interstitialAd: InterstitialAd) {
                            Log.d(TAG, "Splash Ad was loaded.")
                            mInterstitialad = interstitialAd
                            waiting_dialog?.dismiss()
                            showInter()
                        }
                    })
            }
        }
    }

    fun showInter() {
        if (mInterstitialad != null) {
            mInterstitialad?.show(this)
            mInterstitialad?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    Log.d("Ad-123", "Ad was clicked.")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
                    mInterstitialad = null
                    loadinginterstitial = false
                    finish()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    loadinginterstitial = false
                    mInterstitialad = null
                    finish()
                }

                override fun onAdImpression() {
                    Log.d("Ad-123", "Ad recorded an impression.")
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d("Ad-123", "Ad showed fullscreen content.")
                }
            }
        } else {
            finish()
        }
    }

    private fun showWaitingDialog() {
        Objects.requireNonNull<Window>(waiting_dialog?.window)
            .setBackgroundDrawableResource(android.R.color.transparent)
        waiting_dialog?.setContentView(R.layout.ad_loading_dialog)
        waiting_dialog?.setCancelable(false)
        waiting_dialog?.show()

    }
}