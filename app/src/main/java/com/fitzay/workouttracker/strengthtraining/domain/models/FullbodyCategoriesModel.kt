package com.fitzay.workouttracker.strengthtraining.domain.models

import com.google.gson.annotations.SerializedName

data class FullbodyCategoriesModel(
    @SerializedName("week") var week: String? = null,
    @SerializedName("day") var day: String? = null,
    @SerializedName("cat_id") var cat_id: String? = null,
    @SerializedName("ex_id") var ex_id: String? = null
)
