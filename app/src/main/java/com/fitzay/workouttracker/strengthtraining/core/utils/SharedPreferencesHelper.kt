package com.fitzay.workouttracker.strengthtraining.core.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val PREF_NAME = "MyPreferences"
    private val KEY_POSITION = "position"

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    // Function to get the position value from SharedPreferences
    fun getPosition(): Int {
        return sharedPreferences.getInt(KEY_POSITION, 0) // Default value is 0 if the key is not found
    }

    // Function to set the position value in SharedPreferences
    fun setPosition(position: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_POSITION, position)
        editor.apply()
    }
}
