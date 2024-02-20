package com.fitzay.workouttracker.strengthtraining.domain.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WorkOutModel(
    @SerializedName("ex_id") var exId: Int? = null,
    @SerializedName("ex_title") var exTitle: String? = null,
    @SerializedName("cat_id") var catId: String? = null,
    @SerializedName("ex_time") var exTime: Int? = null,
    @SerializedName("ex_rest") var exRest: Int? = null,
    @SerializedName("ex_gif") var exGif: String? = null,
    @SerializedName("ex_description") var exDescription: String? = null,
    @SerializedName("isTime") var isTime: Boolean? = null,
    @SerializedName("timeSaved") var timeSaved: Int? = null,
    @SerializedName("isRecommended") var isRecommended: Boolean? = null
) : Serializable
