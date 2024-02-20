package com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager

interface OnDownloadProgressListener {
    fun percent(percent: Int)
    fun downloadStart()
    fun downloadedSuccess()
    fun downloadFail(error: String?)
    fun downloadCancel()
}