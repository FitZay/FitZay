package com.fitzay.workouttracker.strengthtraining.core.utils

data class UpdateStatus<out T>(val status: CurrentStatus, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T): UpdateStatus<T> =
            UpdateStatus(status = CurrentStatus.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): UpdateStatus<T> =
            UpdateStatus(status = CurrentStatus.ERROR, data = data, message = message)
    }
}
