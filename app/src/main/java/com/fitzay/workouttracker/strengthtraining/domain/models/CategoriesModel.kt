package com.fitzay.workouttracker.strengthtraining.domain.models

import com.google.gson.annotations.SerializedName

data class CategoriesModel(
    @SerializedName("cat_id") var catId: String? = null,
    @SerializedName("cat_name") var catName: String? = null,
    @SerializedName("cat_type") var catType: String? = null
)
