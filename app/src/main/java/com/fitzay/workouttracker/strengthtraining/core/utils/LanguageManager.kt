package com.fitzay.workouttracker.strengthtraining.core.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.Locale

class LanguageManager(private val context: Context) {
    private var sharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)

    fun updateResources(code: String) {
        val locale = Locale(code)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
        setLanguage(code)
    }

    private fun setLanguage(code: String) {
        val myEdit = sharedPreferences.edit()
        myEdit.putString("app_lang", code)
        myEdit.apply()
    }

    val language: String?
        get() = sharedPreferences.getString("app_lang", "en")
}