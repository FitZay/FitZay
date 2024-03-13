package com.fitzay.workouttracker.strengthtraining.domain.remote

import androidx.annotation.Keep
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class FitzayRemote(private val keyReceived: String) {
    private fun getAndCompare(): Any? {
        var json = AppController.remoteFitzayConfig?.getString(keyReceived)
        try {
            if (json.isNullOrEmpty() || json == "{}") {
                json = Component.preference.fitzayConfig
            }
            if (json != null) {
                Component.preference.fitzayConfig = json
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
        return Gson().fromJson(json, Any::class.java)
    }


    fun getFitzayConfig(listener: ((Any?) -> Unit)) {
        val value = getAndCompare()
        listener.invoke(value)
    }

}

@Keep
data class FitzayCompareModel(
    @SerializedName("fizayid")
    val adID: String = "1234567",

    @SerializedName("fitzayshow")
    val showAd: Boolean = false,

    @SerializedName("fitzay_ctacolor")
    val ctacolor: String = "#9CB135",

    @SerializedName("fitzay_ctalocation")
    val ctalocation: String = "down"
) {
    override fun toString(): String {
        return "(value : $adID value : $showAd value : $ctacolor value : $ctalocation)"
    }
}