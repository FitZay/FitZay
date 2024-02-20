package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.media.RingtoneManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.clickWithThrottle
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityExerciseBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import java.util.Objects
import java.util.concurrent.TimeUnit


class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding
    private lateinit var loadingHandler: Handler
    private lateinit var runalble: Runnable

    private lateinit var arr: ArrayList<WorkOutModel>
    private val TAG = "ExerciseActivity"
    var isReady = false
    private var arrIndex = 0
    private var categoryName = ""
    private var categoryType = ""
    var handlerTime = 0
    var millisUntilFinished: Long = 0
    var timer: Timer? = null
    var rest = 0
    var percent = 0
    private var quitdialog : Dialog? = null
    private var waiting_dialog : Dialog? = null
    var mSplashInterstitial: InterstitialAd? = null
    private var loadinginterstitial = false
    private var nativeAd : NativeAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quitdialog = Dialog(this)
        waiting_dialog = Dialog(this)

        arr = ArrayList()
        loadingHandler = Handler(Looper.getMainLooper()!!)

        binding.apply {

            ivBack.setOnClickListener {
                onBackPressed()
            }


            val isFrom = intent.getBooleanExtra("EXTRA_FROM", false)
            if (isFrom) {

                val id = intent.getStringExtra("EXTRA_ID")
                categoryName = intent.getStringExtra("EXTRA_CATEGORY").toString()
                categoryType = intent.getStringExtra("EXTRA_TYPE").toString()


                arr = Component.workOutViewModel.getWorkouts(
                    this@ExerciseActivity,
                    id.toString()
                ) as ArrayList<WorkOutModel>

                exName.text = arr[arrIndex].exTitle
                exNameTwo.text = arr[arrIndex].exTitle

                exTime.text = arr[arrIndex].exTime.toString()
                description.text = arr[arrIndex].exDescription.toString()

                txtToolbar.text = arr[arrIndex].exTitle
                if (!isFinishing) {
                    Glide.with(this@ExerciseActivity)
                        .load(("file:///android_asset/men/" + arr[arrIndex].exGif))
                        .into(exImage)
                }
                getReadyForExercise()

                skip.setOnClickListener {
                    if (arrIndex > 0 && arrIndex < arr.size) {
                        timer?.cancel()
                        performExercise()
                    } else {
                        finish()
                    }
                }

                layoutNext.clickWithThrottle {
                    arrIndex++
                    if (arrIndex > 0 && arrIndex < arr.size) {
                        takeRestForNextEx()
                    } else {
                        finish()
                    }
                }


                layoutPrevious.setOnClickListener {
                    if (arrIndex > 0 && arrIndex < arr.size) {
                        arrIndex--
                        takeRestForNextEx()

                        Log.i(TAG, "if: "+arr.size)
                        Log.i(TAG, "if: "+arrIndex)
                    } else {
                        layoutPrevious.visibility = View.GONE
                        Log.i(TAG, "Ese: "+arr.size)
                        Log.i(TAG, "Ese: "+arrIndex)

                    }

                }

                btnNext.setOnClickListener {
//            if (::loadingHandler.isInitialized)
//            loadingHandler.removeCallbacks(runalble)
                    isReady = true
                    performExercise()
                }

                cardFinish.setOnClickListener {
                    arrIndex++
                    if (arrIndex > 0 && arrIndex < arr.size) {
                        takeRestForNextEx()
                    } else {
                        Toast.makeText(this@ExerciseActivity, "All Done.", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    }
                }

                cardIncreaseTime.setOnClickListener {
                    //  handlerTime += 20
                    updateTimer(true)
                }
            }
        }
    }


    override fun onBackPressed() {
        if (arrIndex < arr.size){
            showQuitDialog()
        }
    }

    private fun getReadyForExercise() {
        hideAllLayout()

        binding.apply {
            layoutReady.visibility = View.VISIBLE
            var percent = 0
            var rest = 15
            progressBar.max = 15
            ///  binding.progressBar.progress = 15
            Thread {
                try {
                    while (percent < 15) {
                        try {
                            Thread.sleep(1000)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                        runalble = Runnable {
                            try {
                                if (percent < 15) {
                                    rest--
                                    progressBar.progress = percent
                                    txtProgress.text = "$rest"
                                } else {
                                    if (!isReady)
                                        performExercise()
                                }
                            } catch (e: RuntimeException) {
                                e.printStackTrace()
                            }
                        }
                        percent++
                        loadingHandler.post(runalble)
                    }
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                }
            }.start()
        }

    }

    private fun performExercise() {
        hideAllLayout()

        binding.apply {
            layoutExercise.visibility = View.VISIBLE
            Log.i(TAG, "performExercise: "+arr.size)
            Log.i(TAG, "performExercise: "+arrIndex)
            if (arrIndex==0)
            {
                layoutPrevious.visibility=View.GONE
            }
            else
            {
                layoutPrevious.visibility=View.VISIBLE
            }

            exNameTwo.text = arr[arrIndex].exTitle
            description.text = arr[arrIndex].exDescription.toString()
            Component.preference.recentExerciseCategory = "$categoryName $categoryType"
            if (!isFinishing) {
                Glide.with(this@ExerciseActivity)
                    .load(("file:///android_asset/men/" + arr[arrIndex].exGif))
                    .into(exImage)
            }
            val exTime = if (arr[arrIndex].isTime!!) {
                "00:" + arr[arrIndex].exTime.toString()
            } else {
                "X" + arr[arrIndex].exTime.toString()
            }
            ex.text = exTime

            Log.i(TAG, "performExercise---: "+exTime)
            Component.preference.recentExerciseName = arr[arrIndex].exTitle.toString() + " " + exTime
            Component.preference.recentExercisePercentage = (arrIndex * 100 / arr.size).toFloat()

            if (arr[arrIndex].isTime!!) {
                var percent = 0
                var rest = arr[arrIndex].exTime
                progressBar.max = arr[arrIndex].exTime!!
                progressBar.progress = arr[arrIndex].exTime!!
                try {
                    Thread {
                        try {
                            while (percent < arr[arrIndex].exTime!!) {
                                try {
                                    Thread.sleep(1000)
                                } catch (e: InterruptedException) {
                                    e.printStackTrace()
                                }
                                runalble = Runnable {
                                    try {
                                        if (percent < arr[arrIndex].exTime!!) {
                                            rest = rest!! - 1
                                            progressBar.progress = rest as Int

                                            // Format the seconds with leading zeros
                                            val formattedRest = String.format("%02d", rest)

                                            binding.exTime.text = "00:$formattedRest"


                                            Log.i(TAG, "performExercise++++++: "+rest)
                                            if (rest==1)
                                            {
                                                Log.i(TAG, "OCALL: "+rest)
                                                Component.ringtoneModel.playMedia(this@ExerciseActivity)
                                            }

                                        } else {
                                            arrIndex++
                                            if (arrIndex < arr.size)
                                                takeRestForNextEx()
                                            Log.i(TAG, "performExercise++++++:")

                                        }
                                    } catch (e: RuntimeException) {
                                        e.printStackTrace()
                                    }
                                }
                                percent++
                                loadingHandler.post(runalble)
                            }
                        } catch (e: IndexOutOfBoundsException) {
                            e.printStackTrace()
                            startActivity(Intent(this@ExerciseActivity , ExitScreenActivity :: class.java))
                            finish()
                        }
                    }.start()
                } catch (e: IndexOutOfBoundsException) {
                    e.printStackTrace()
                    startActivity(Intent(this@ExerciseActivity , ExitScreenActivity :: class.java))
                    finish()
                }
            }
        }

    }

    private fun takeRestForNextEx() {
        try {

            if (arrIndex < arr.size) {
                if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeExerciseRest.showAd && !LoadingActivity.ispurchased){
                    binding?.clAds?.visibility = View.VISIBLE
                    loadAdaptiveNative()
                }
                else {
                    binding?.clAds?.visibility = View.GONE
                }

                hideAllLayout()
                binding.layoutRest.visibility = View.VISIBLE
                binding.exNameThree.text = arr[arrIndex].exTitle
                if (!isFinishing) {
                    Glide.with(this)
                        .load("file:///android_asset/men/" + arr[arrIndex].exGif)
                        .into(binding.exImage)
                }
                binding.txtToolbar.text = arr[arrIndex].exTitle

                if (arr[arrIndex].isTime!!) {
                    binding.exTime.text = "00:" + arr[arrIndex].exTime.toString()
                } else {
                    binding.exTime.text = "X" + arr[arrIndex].exTime.toString()
                }
                percent = 0
                rest = arr[arrIndex].exRest!!
                binding.progressBar.max = arr[arrIndex].exRest!!
                binding.progressBar.progress = arr[arrIndex].exRest!!
                handlerTime = arr[arrIndex].exRest!!

                updateTimer(false)

            } else {
                Toast.makeText(this@ExerciseActivity, "All Done", Toast.LENGTH_SHORT).show()
                finish()
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            e.printStackTrace()
        }
    }

    private fun hideAllLayout() {
        binding.layoutReady.visibility = View.GONE
        binding.layoutExercise.visibility = View.GONE
        binding.layoutRest.visibility = View.GONE
    }

    //Call this method to start timer on activity start
    private fun startTimer() {
        timer = Timer(10000)
        timer?.start()
    }

    //Call this method to update the timer
    private fun updateTimer(increaseTime: Boolean) {
        if (timer != null) {
            if (increaseTime) {
                rest += 20
            }
            val miliis = millisUntilFinished + TimeUnit.SECONDS.toMillis(20)
            //Here you need to maintain single instance for previous
            Log.e(TAG, "onTick: Upper $rest")

            timer?.cancel()
            timer = Timer(miliis)
            timer?.start()
        } else {
            startTimer()
        }
    }


    inner class Timer(miliis: Long) : CountDownTimer(miliis, 1000) {
        override fun onFinish() {
            Log.e(TAG, "onFinish: ")
            try {
                rest = 0
                if (rest==0)
                {
                    Component.ringtoneModel.playMedia(this@ExerciseActivity)
                }
                if (arrIndex < arr.size)
                    performExercise()
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }

        }

        override fun onTick(millisUntilFinish: Long) {
            millisUntilFinished = millisUntilFinish
            try {
                rest -= 1
                if (rest > 0) {
                    binding.txtReadyNext.text = secToTime(rest)

                } else {
                    timer!!.cancel()
                }

            } catch (e: RuntimeException) {
                e.printStackTrace()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (::loadingHandler.isInitialized && ::runalble.isInitialized)
            loadingHandler.removeCallbacks(runalble)
    }


    fun secToTime(sec: Int): String {
        val seconds = sec % 60
        var minutes = sec / 60
        if (minutes >= 60) {
            val hours = minutes / 60
            minutes %= 60
            if (hours >= 24) {
                val days = hours / 24
                return String.format("%d days %02d:%02d:%02d", days, hours % 24, minutes, seconds)
            }
            return String.format("%02d:%02d:%02d", hours, minutes, seconds)
        }
        return String.format("%02d:%02d", minutes, seconds)
    }


    private fun showQuitDialog() {
        Objects.requireNonNull<Window>(quitdialog?.window)
            .setBackgroundDrawableResource(android.R.color.transparent)
        quitdialog?.setContentView(R.layout.quitdialog)
        quitdialog?.setCancelable(false)
        quitdialog?.show()

        quitdialog?.findViewById<TextView>(R.id.quitBtn)?.setOnClickListener {
            quitdialog?.dismiss()
            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayInterstitialExcerciseQuit.showAd && !LoadingActivity.ispurchased) {
                showWaitingDialog()
                loadSplashInterstitialAd(AppController.fitzayModel!!.FitzayInterstitialExcerciseQuit.adID)
            }
            else {
                finish()
            }
        }

        quitdialog?.findViewById<TextView>(R.id.cancelBtn)?.setOnClickListener {
            quitdialog?.dismiss()
        }
    }


    fun loadSplashInterstitialAd(adId: String) {
        if (mSplashInterstitial == null && !loadinginterstitial) {
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
                            mSplashInterstitial = null
                            loadinginterstitial = false
                            waiting_dialog?.dismiss()
                            finish()
                        }

                        override fun onAdLoaded(interstitialAd: InterstitialAd) {
                            Log.d(TAG, "Splash Ad was loaded.")
                            mSplashInterstitial = interstitialAd
                            waiting_dialog?.dismiss()
                            showInter()
                        }
                    })
            }
        }
    }

    fun showInter() {
        if (mSplashInterstitial != null) {
            mSplashInterstitial?.show(this)
            mSplashInterstitial?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    Log.d("Ad-123", "Ad was clicked.")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
                    mSplashInterstitial = null
                    loadinginterstitial = false
                    finish()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    loadinginterstitial = false
                    mSplashInterstitial = null
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


    private fun loadAdaptiveNative() {
        if (nativeAd == null) {
            binding?.skeletonLayout?.startLoading()
            if (AppController.fitzayModel != null) {
                val adLoader =
                    AdLoader.Builder(
                        this,
                        AppController.fitzayModel!!.FitzayNativeExerciseRest.adID
                    )
                        .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                            nativeAd = NativeAd
                            binding?.skeletonLayout?.stopLoading()
                            binding.plannerTemplateDown.setNativeAd(nativeAd)
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
        else {
            binding.plannerTemplateDown.setNativeAd(nativeAd)
            binding.clAds.visibility = View.VISIBLE
            binding.layoutAd.visibility = View.VISIBLE
        }
    }


}

