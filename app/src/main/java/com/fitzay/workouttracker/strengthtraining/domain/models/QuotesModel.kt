package com.fitzay.workouttracker.strengthtraining.domain.models

import com.google.gson.annotations.SerializedName

data class QuotesModel(
    @SerializedName("type") var type: String? = null,
    @SerializedName("text") var text: String? = null,
    @SerializedName("author") var author: String? = null
)
