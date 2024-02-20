package com.fitzay.workouttracker.strengthtraining.core.ads

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.fitzay.workouttracker.strengthtraining.R


import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.appopen.AppOpenAd
import java.util.*

class OpenAd(var controller: AppController) : Application.ActivityLifecycleCallbacks,
    LifecycleObserver {
    private var appOpenAd: AppOpenAd? = null
    private lateinit var loadCallback: AppOpenAd.AppOpenAdLoadCallback
    private var currentActivity: Activity? = null
    private var loadTime: Long = 0

    /**
     * Constructor
     */
    init {
        controller.registerActivityLifecycleCallbacks(this)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    /**
     * LifecycleObserver methods
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

        if (currentActivity!!.javaClass.simpleName != "AdActivity") {
            showAdIfAvailable(currentActivity!!.javaClass.simpleName == "LoadingActivity")
        }
    }

    /**
     * Shows the ad if one isn't already showing.
     */
    private fun showAdIfAvailable(fromSplash: Boolean) {
        // Only show ad if there is not already an app open ad currently showing
        // and an ad is available.
        if (!isShowingAd && isAdAvailable) {
            if (fromSplash) return
            val fullScreenContentCallback: FullScreenContentCallback =
                object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        // Set the reference to null so isAdAvailable() returns false.
                        appOpenAd = null
                        isShowingAd = false
                        fetchAd(false)

                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {

                    }

                    override fun onAdShowedFullScreenContent() {
                        isShowingAd = true
                    }
                }
            appOpenAd!!.fullScreenContentCallback = fullScreenContentCallback
            appOpenAd!!.show(currentActivity!!)
        } else {
                fetchAd(fromSplash)
        }
    }

    fun fetchAd(fromSplash: Boolean) {
        // Have unused ad, no need to fetch another.
        if (isAdAvailable) {
            return
        }
        loadCallback = object : AppOpenAd.AppOpenAdLoadCallback() {
            /**
             * Called when an app open ad has loaded.
             *
             * @param ad the loaded app open ad.
             */
            override fun onAdLoaded(ad: AppOpenAd) {
                Log.e("AppOpen", "onAdLoaded: " )
                appOpenAd = ad
                loadTime = Date().time

//                        if (fromSplash) {
//                            showAdIfAvailable(true);
//                        }
            }

            /**
             * Called when an app open ad has failed to load.
             *
             * @param loadAdError the error.
             */
            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                Log.e("AppOpen", "onAdFailedToLoad: "+loadAdError.message )
                // Handle the error.
//                        if (fromSplash) {
//                            new Handler().postDelayed(new Runnable() {
//                                public void run() {
//                                    startApp();
//                                }
//                            }, 1000);
//                        }
            }
        }


        val request = adRequest
        AppOpenAd.load(
            controller, currentActivity!!.resources.getString(R.string.fitzay_app_open), request,
            AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback
        )
    }

    /**
     * Creates and returns ad request.
     */
    private val adRequest: AdRequest
        private get() = AdRequest.Builder().build()

    /**
     * Utility method that checks if ad exists and can be shown.
     */
    private fun wasLoadTimeLessThanNHoursAgo(numHours: Long): Boolean {
        val dateDifference = Date().time - loadTime
        val numMilliSecondsPerHour: Long = 3600000
        return dateDifference < numMilliSecondsPerHour * numHours
    }

    private val isAdAvailable: Boolean
        get() = appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4)

    override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
        super.onActivityPreCreated(activity, savedInstanceState)
    }

    /**
     * ActivityLifecycleCallback methods
     */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityPostCreated(activity: Activity, savedInstanceState: Bundle?) {
        super.onActivityPostCreated(activity, savedInstanceState)
    }

    override fun onActivityPreStarted(activity: Activity) {
        super.onActivityPreStarted(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPostStarted(activity: Activity) {
        super.onActivityPostStarted(activity)
    }

    override fun onActivityPreResumed(activity: Activity) {
        super.onActivityPreResumed(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        currentActivity = activity
    }

    override fun onActivityPostResumed(activity: Activity) {
        super.onActivityPostResumed(activity)
    }

    override fun onActivityPrePaused(activity: Activity) {
        super.onActivityPrePaused(activity)
    }

    override fun onActivityStopped(activity: Activity) {}
    override fun onActivityPostStopped(activity: Activity) {
        super.onActivityPostStopped(activity)
    }

    override fun onActivityPreSaveInstanceState(activity: Activity, outState: Bundle) {
        super.onActivityPreSaveInstanceState(activity, outState)
    }

    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityPostPaused(activity: Activity) {
        super.onActivityPostPaused(activity)
    }

    override fun onActivityPreStopped(activity: Activity) {
        super.onActivityPreStopped(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {}
    override fun onActivityPostSaveInstanceState(activity: Activity, outState: Bundle) {
        super.onActivityPostSaveInstanceState(activity, outState)
    }

    override fun onActivityPreDestroyed(activity: Activity) {
        super.onActivityPreDestroyed(activity)
    }

    override fun onActivityDestroyed(activity: Activity) {
        currentActivity = null
    }

    override fun onActivityPostDestroyed(activity: Activity) {
        super.onActivityPostDestroyed(activity)
    }

    companion object {
        private var isShowingAd = false
    }
}