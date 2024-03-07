package com.fitzay.workouttracker.strengthtraining.core.utils

import android.content.SharedPreferences
import androidx.core.content.edit
import com.fitzay.workouttracker.strengthtraining.di.Component

private const val SELECTED_LAG = "selectedLanguage"
private const val STEP_COUNT = "stepCount"
private const val PAUSE_RESUME = "pauseResume"
private const val ALARM_OFF = "ALARM_OFF"
private const val KEY_DAILY_GOAL = "dailyGoal"
private const val KEY_STEP_GOAL = "stepGoal"

private const val STEP_TIME = "stepTime"
private const val BED_TIME = "bedTime"
private const val WAKE_TIME = "wakeTime"
private const val STEP_CALORIES = "stepCalories"
private const val STEP_DISTANCE = "stepDistance"
private const val STEP_PROGRESS = "stepProgress"
private const val CUP_CAPACITY = "cupCapacity"
private const val CURRENT_PROGRESS = "currentProgress"
private const val WATER_GOAL = "waterGoal"
private const val TOTAL_DRINK = "totalDrink"

private const val USER_PROFILE_PATH = "userProfilePath"
private const val USER_NAME = "userName"
private const val USER_GENDER = "userGender"
private const val USER_AGE = "userAge"
private const val USER_HEIGHT = "userHeight"
private const val USER_HEIGHT_FT = "userHeightFt"
private const val USER_HEIGHT_INCH = "userHeightInch"
private const val USER_HEIGHT_TYPE = "userHeightType"
private const val USER_WEIGHT_TYPE = "userWeightType"
private const val USER_WEIGHT = "userWeight"
private const val USER_TARGET_WEIGHT = "userTargetWight"
private const val USER_TARGET_WEIGHT_TYPE = "userTargetWightType"

private const val IS_INTRO = "isIntro"
private const val IS_FITNESS_TOUR = "isFitnessTour"

private const val RECENT_EXERCISE_CATEGORY = "recentExerciseCategory"
private const val RECENT_EXERCISE_NAME = "recentExerciseName"
private const val RECENT_EXERCISE_PERCENTAGE = "recentExercisePercentage"
private const val SELECTED_DAYS = "selectedDays"

private const val CURRENT_DATE = "currentDate"
private const val FITZAY_CONFIG = "fitzayConfig"
private const val SAVE_WATER = "saveWater"

class FitnessPreference {
    var editor: SharedPreferences.Editor
    var prefernece: SharedPreferences =
        Component.context.getSharedPreferences("FitnessPreference", 0)

    init {
        editor = prefernece.edit()
    }

    var fitzayConfig: String?
        get() = prefernece.getString(FITZAY_CONFIG, "name")
        set(userName) {
            editor.putString(FITZAY_CONFIG, userName)
            editor.apply()
        }


    var selectedDays: Set<String>
        get() = prefernece.getStringSet(SELECTED_DAYS, emptySet()) ?: emptySet()
        set(value) = prefernece.edit { putStringSet(SELECTED_DAYS, value) }

    var isFitnessTour: Boolean
        get() = prefernece.getBoolean(IS_FITNESS_TOUR, false)
        set(value) = prefernece.edit { putBoolean(IS_FITNESS_TOUR, value) }


    var isIntro: Boolean
        get() = prefernece.getBoolean(IS_INTRO, false)
        set(value) = prefernece.edit { putBoolean(IS_INTRO, value) }


    var recentExerciseCategory: String
        get() = prefernece.getString(RECENT_EXERCISE_CATEGORY, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(RECENT_EXERCISE_CATEGORY, value).apply() }

    var currentDate: String
        get() = prefernece.getString(CURRENT_DATE, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(CURRENT_DATE, value).apply() }

    var recentExerciseName: String
        get() = prefernece.getString(RECENT_EXERCISE_NAME, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(RECENT_EXERCISE_NAME, value).apply() }

    var recentExercisePercentage: Float
        get() = prefernece.getFloat(RECENT_EXERCISE_PERCENTAGE, 0f)
        set(value) = prefernece.edit { putFloat(RECENT_EXERCISE_PERCENTAGE, value).apply() }


    var userProfilePath: String
        get() = prefernece.getString(USER_PROFILE_PATH, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(USER_PROFILE_PATH, value).apply() }

    var userName: String
        get() = prefernece.getString(USER_NAME, "") ?: ""
        set(value) = prefernece.edit { putString(USER_NAME, value).apply() }

    var userGender: String
        get() = prefernece.getString(USER_GENDER, "") ?: ""
        set(value) = prefernece.edit { putString(USER_GENDER, value).apply() }

    var userHeightType: String
        get() = prefernece.getString(USER_HEIGHT_TYPE, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(USER_HEIGHT_TYPE, value).apply() }

    var userWeightType: String
        get() = prefernece.getString(USER_WEIGHT_TYPE, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(USER_WEIGHT_TYPE, value).apply() }


    var userTargetWeightType: String
        get() = prefernece.getString(USER_TARGET_WEIGHT_TYPE, "empty") ?: "empty"
        set(value) = prefernece.edit { putString(USER_TARGET_WEIGHT_TYPE, value).apply() }

    var userAge: Int
        get() = prefernece.getInt(USER_AGE, 0)
        set(value) = prefernece.edit { putInt(USER_AGE, value) }

    var userHeight: Int
        get() = prefernece.getInt(USER_HEIGHT, 0)
        set(value) = prefernece.edit { putInt(USER_HEIGHT, value) }

    var userHeightFt: Int
        get() = prefernece.getInt(USER_HEIGHT_FT, 0)
        set(value) = prefernece.edit { putInt(USER_HEIGHT_FT, value) }

    var userHeightInch: Int
        get() = prefernece.getInt(USER_HEIGHT_INCH, 0)
        set(value) = prefernece.edit { putInt(USER_HEIGHT_INCH, value) }

    var userWeight: Int
        get() = prefernece.getInt(USER_WEIGHT, 0)
        set(value) = prefernece.edit { putInt(USER_WEIGHT, value) }

    var userTargetWight: Int
        get() = prefernece.getInt(USER_TARGET_WEIGHT, 0)
        set(value) = prefernece.edit { putInt(USER_TARGET_WEIGHT, value) }


    var totalDrink: Int
        get() = prefernece.getInt(TOTAL_DRINK, 0)
        set(totalDrink) {
            editor.putInt(TOTAL_DRINK, totalDrink)
            editor.apply()
        }


    var cupCapacity: Int
        get() = prefernece.getInt(CUP_CAPACITY, 0)
        set(cupCapacity) {
            editor.putInt(CUP_CAPACITY, cupCapacity)
            editor.apply()
        }

    var waterGoal: Int
        get() = prefernece.getInt(WATER_GOAL, 2000)
        set(waterGoal) {
            editor.putInt(WATER_GOAL, waterGoal)
            editor.apply()
        }

    var currentProgress: Float
        get() = prefernece.getFloat(CURRENT_PROGRESS, 0.1f)
        set(currentProgress) {
            editor.putFloat(CURRENT_PROGRESS, currentProgress)
            editor.apply()
        }

    var saveWater: Float
        get() = prefernece.getFloat(SAVE_WATER, 0.1f)
        set(value) {
            editor.putFloat(SAVE_WATER, value)
            editor.apply()
        }

    var selectedLang: String
        get() = prefernece.getString(SELECTED_LAG, "en") ?: "en"
        set(selectedLang) {
            editor.putString(SELECTED_LAG, selectedLang)
            editor.apply()
        }

    var stepCount: Int
        get() = prefernece.getInt(STEP_COUNT, 0)
        set(value) = prefernece.edit { putInt(STEP_COUNT, value).apply() }

    var isPaused: Boolean
        get() = prefernece.getBoolean(PAUSE_RESUME, false)
        set(value) = prefernece.edit { putBoolean(PAUSE_RESUME, value) }

    var alarmOnOff: Boolean
        get() = prefernece.getBoolean(ALARM_OFF, false)
        set(value) = prefernece.edit { putBoolean(ALARM_OFF, value) }

    var saveDailyGoal: Int
        get() = prefernece.getInt(KEY_DAILY_GOAL, 500)
        set(value) = prefernece.edit { putInt(KEY_DAILY_GOAL, value) }

    var stepGoal: Int
        get() = prefernece.getInt(KEY_STEP_GOAL, 1000)
        set(value) = prefernece.edit { putInt(KEY_STEP_GOAL, value).apply() }

    var stepTime: String
        get() = prefernece.getString(STEP_TIME, "0h 0m") ?: "0h 0m"
        set(value) = prefernece.edit { putString(STEP_TIME, value) }


    var wakeTime: String
        get() = prefernece.getString(WAKE_TIME, "0h 0m a") ?: "0h 0m a"
        set(value) = prefernece.edit { putString(WAKE_TIME, value) }

    var bedTime: String
        get() = prefernece.getString(BED_TIME, "0h 0m a") ?: "0h 0m a"
        set(value) = prefernece.edit { putString(BED_TIME, value) }


    var stepCalories: Double
        get() = prefernece.getFloat(STEP_CALORIES, 0f).toDouble()
        set(value) = prefernece.edit { putFloat(STEP_CALORIES, value.toFloat()) }

    var stepDistance: Double
        get() = prefernece.getFloat(STEP_DISTANCE, 0f).toDouble()
        set(value) = prefernece.edit { putFloat(STEP_DISTANCE, value.toFloat()) }

    var stepProgress: Int
        get() = prefernece.getInt(STEP_PROGRESS, 0)
        set(value) = prefernece.edit { putInt(STEP_PROGRESS, value).apply() }

}