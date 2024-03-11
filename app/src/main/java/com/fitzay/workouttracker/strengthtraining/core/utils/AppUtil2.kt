package com.fitzay.workouttracker.strengthtraining.core.utils

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityMainBinding
import java.util.Locale


open class AppUtil2: AppCompatActivity() {
    var lang="en"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Now you can access methods and properties of MyApplication
//        var languageManager = LanguageManager(this@AppUtil2)
//        languageManager.updateResources(languageManager.language.toString());

        when(SharedPreferencesHelper(this@AppUtil2).getPosition()) {

            0 -> lang = "en"
            1 -> lang = "ar"
            2 -> lang = "hi"
            3 -> lang = "zh"
            4 -> lang = "es"
            5 -> lang = "fr"
            6 -> lang = "it"
            7 -> lang = "ru"
            8 -> lang = "pt"
            9 -> lang = "ja"

        }
        val newLocale = Locale(lang)
        val configuration: Configuration = resources.configuration
        configuration.setLocale(newLocale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}