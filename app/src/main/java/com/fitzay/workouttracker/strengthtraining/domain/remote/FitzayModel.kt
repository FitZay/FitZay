package com.fitzay.workouttracker.strengthtraining.domain.remote

import com.google.gson.annotations.SerializedName

class FitzayModel(


    @SerializedName("FitzayBannerProfile")
    var FitzayBannerProfile: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayBannerWorkout")
    var FitzayBannerWorkout: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayInterstitialSplash")
    var FitzayInterstitialSplash: FitzayCompareModel = FitzayCompareModel(""),


    @SerializedName("FitzayInterstitialMain")
    var FitzayInterstitialMain: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayInterstitialExcerciseQuit")
    var FitzayInterstitialExcerciseQuit: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayRewardedAdvance")
    var FitzayRewardedAdvance: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeSplash")
    var FitzayNativeSplash: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeExerciseRest")
    var FitzayNativeExerciseRest: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeStatsSummary")
    var FitzayNativeStatsSummary: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeGender")
    var FitzayNativeGender: FitzayCompareModel = FitzayCompareModel(""),
    @SerializedName("FitzayNativeName")
    var FitzayNativeName: FitzayCompareModel = FitzayCompareModel(""),
    @SerializedName("FitzayNativeAge")
    var FitzayNativeAge: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeHeight")
    var FitzayNativeHeight: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeWeight")
    var FitzayNativeWeight: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeTargetWeight")
    var FitzayNativeTargetWeight: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeSleepTracker")
    var FitzayNativeSleepTracker: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeStepCounter")
    var FitzayNativeStepCounter: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeDailyMotivation")
    var FitzayNativeDailyMotivation: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeExercise")
    var FitzayNativeExercise: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeStats")
    var FitzayNativeStats: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeStartExercise")
    var FitzayNativeStartExercise: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeLanguage")
    var FitzayNativeLanguage: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativeBMI")
    var FitzayNativeBMI: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativePersonalized")
    var FitzayNativePersonalized: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayNativePushUp")
    var FitzayNativePushUp: FitzayCompareModel = FitzayCompareModel(""),

    @SerializedName("FitzayAppOpen")
    var FitzayAppOpen: FitzayCompareModel = FitzayCompareModel("")
) {
    override fun toString(): String {
        return ""
    }
}