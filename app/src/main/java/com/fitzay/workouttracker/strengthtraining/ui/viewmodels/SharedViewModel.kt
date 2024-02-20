package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val selected = MutableLiveData<Float>()

    fun select(item: Float) {
        selected.value = item
    }
}