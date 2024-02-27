package com.fitzay.workouttracker.strengthtraining.core

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.fitzay.workouttracker.strengthtraining.BuildConfig
import com.fitzay.workouttracker.strengthtraining.core.ads.OpenAd
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.InAppPurchaseUtil
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteLong
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.di.databaseModule
import com.fitzay.workouttracker.strengthtraining.di.fitnessRepository
import com.fitzay.workouttracker.strengthtraining.di.fitnessViewModelModule
import com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayModel
import com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayRemote
import com.google.android.ads.nativetemplates.TemplateView.ctacolor
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppController : Application() {

    private val TAG = "AppController"

    companion object {
        var fitAdCount = 0
        var fitAdTotal = 2
        var fitzayModel: FitzayModel? = null
        var isFirstOpen = true
        var remoteFitzayConfig: FirebaseRemoteConfig? = null
        var weeklyvalue = ""
        var monthlyvalue = ""
        var yearlyvalue = ""
        var inappScenario = "1"
        var inappflow = false

    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(databaseModule, fitnessRepository, fitnessViewModelModule))
        }
        FirebaseApp.initializeApp(this)
        //     MobileAds.initialize(this) {}
        OpenAd(this)
        setupNetworkCallback()

        InAppPurchaseUtil.onlygetPrice(this, "fitzay_weekly_premium") {
            weeklyvalue = it
        }

        InAppPurchaseUtil.onlygetPrice(this, "fitzay_monthly_premium") {
            Log.d("Pricesutilsvalues" , "Monthly : $it")
            monthlyvalue = it
        }

        Handler(Looper.getMainLooper()).postDelayed({
            InAppPurchaseUtil.onlygetPrice(this, "fitzay_yearly_premium") {
                Log.d("Pricesutilsvalues" , "Yearly : $it")
                yearlyvalue = it
            }
        },1000)

        AppUtil2()
    }

    private fun setupNetworkCallback() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder().build()

        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                fetchAndActivate()
            }

            override fun onLost(network: Network) {
            }

        }
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    }


    private fun fetchAndActivate() {
        val buildKey = if (BuildConfig.DEBUG) "fitzay_new_debug" else "fitzay_new_release"

        val remoteConfigTime = if (BuildConfig.DEBUG) {
            10
        } else {
            3600
        }

        remoteFitzayConfig = FirebaseRemoteConfig.getInstance()

        val mConfigSetting = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(remoteConfigTime.toLong())
            .build()

        remoteFitzayConfig!!.setConfigSettingsAsync(mConfigSetting)
        remoteFitzayConfig!!.setDefaultsAsync(
            mapOf(buildKey to Gson().toJson(Any()))
        )

        remoteFitzayConfig!!.fetchAndActivate()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    try {
                        val plRemoteConfig = FitzayRemote(buildKey)
                        plRemoteConfig.getFitzayConfig() { it ->
                            it?.let {
                                Log.e(TAG, "RemoteSuccess")
                                val remoteJson = Gson().toJson(it)
                                fitzayModel = Gson().fromJson(remoteJson, FitzayModel::class.java)
                                inappScenario = remoteFitzayConfig?.getString("inapp_flow").toString()
                                inappflow = remoteFitzayConfig?.getBoolean("FitZay_contries_for_inapp") == true

                                Log.i(TAG, "fetchAndActivate: "+inappflow)
                                Log.e(
                                    TAG,
                                    "Fitzay Count: " + getFitzayRemoteLong("fitzay_ad_count")
                                )
                                Log.e(
                                    TAG,
                                    "Fitzay Color Code: " + getFitzayRemoteString("fitzay_cta_color")
                                )
                                Log.e(TAG, "Fitzay Location : " + getFitzayRemoteString("fitzay_cta_location"))

                            } ?: Log.e(TAG, "RemoteFail")
                        }
                    } catch (e: RuntimeException) {
                        e.printStackTrace()
                    }
                } else {
                    //      Toast.makeText(this, "Fetch Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}