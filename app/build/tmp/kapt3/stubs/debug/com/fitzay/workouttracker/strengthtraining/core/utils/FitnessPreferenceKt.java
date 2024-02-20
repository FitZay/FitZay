package com.fitzay.workouttracker.strengthtraining.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"ALARM_OFF", "", "BED_TIME", "CUP_CAPACITY", "CURRENT_DATE", "CURRENT_PROGRESS", "FITZAY_CONFIG", "IS_FITNESS_TOUR", "IS_INTRO", "KEY_DAILY_GOAL", "KEY_STEP_GOAL", "PAUSE_RESUME", "RECENT_EXERCISE_CATEGORY", "RECENT_EXERCISE_NAME", "RECENT_EXERCISE_PERCENTAGE", "SAVE_WATER", "SELECTED_DAYS", "SELECTED_LAG", "STEP_CALORIES", "STEP_COUNT", "STEP_DISTANCE", "STEP_PROGRESS", "STEP_TIME", "TOTAL_DRINK", "USER_AGE", "USER_GENDER", "USER_HEIGHT", "USER_HEIGHT_FT", "USER_HEIGHT_INCH", "USER_HEIGHT_TYPE", "USER_NAME", "USER_PROFILE_PATH", "USER_TARGET_WEIGHT", "USER_TARGET_WEIGHT_TYPE", "USER_WEIGHT", "USER_WEIGHT_TYPE", "WAKE_TIME", "WATER_GOAL", "app_debug"})
public final class FitnessPreferenceKt {
    private static final java.lang.String SELECTED_LAG = "selectedLanguage";
    private static final java.lang.String STEP_COUNT = "stepCount";
    private static final java.lang.String PAUSE_RESUME = "pauseResume";
    private static final java.lang.String ALARM_OFF = "ALARM_OFF";
    private static final java.lang.String KEY_DAILY_GOAL = "dailyGoal";
    private static final java.lang.String KEY_STEP_GOAL = "stepGoal";
    private static final java.lang.String STEP_TIME = "stepTime";
    private static final java.lang.String BED_TIME = "bedTime";
    private static final java.lang.String WAKE_TIME = "wakeTime";
    private static final java.lang.String STEP_CALORIES = "stepCalories";
    private static final java.lang.String STEP_DISTANCE = "stepDistance";
    private static final java.lang.String STEP_PROGRESS = "stepProgress";
    private static final java.lang.String CUP_CAPACITY = "cupCapacity";
    private static final java.lang.String CURRENT_PROGRESS = "currentProgress";
    private static final java.lang.String WATER_GOAL = "waterGoal";
    private static final java.lang.String TOTAL_DRINK = "totalDrink";
    private static final java.lang.String USER_PROFILE_PATH = "userProfilePath";
    private static final java.lang.String USER_NAME = "userName";
    private static final java.lang.String USER_GENDER = "userGender";
    private static final java.lang.String USER_AGE = "userAge";
    private static final java.lang.String USER_HEIGHT = "userHeight";
    private static final java.lang.String USER_HEIGHT_FT = "userHeightFt";
    private static final java.lang.String USER_HEIGHT_INCH = "userHeightInch";
    private static final java.lang.String USER_HEIGHT_TYPE = "userHeightType";
    private static final java.lang.String USER_WEIGHT_TYPE = "userWeightType";
    private static final java.lang.String USER_WEIGHT = "userWeight";
    private static final java.lang.String USER_TARGET_WEIGHT = "userTargetWight";
    private static final java.lang.String USER_TARGET_WEIGHT_TYPE = "userTargetWightType";
    private static final java.lang.String IS_INTRO = "isIntro";
    private static final java.lang.String IS_FITNESS_TOUR = "isFitnessTour";
    private static final java.lang.String RECENT_EXERCISE_CATEGORY = "recentExerciseCategory";
    private static final java.lang.String RECENT_EXERCISE_NAME = "recentExerciseName";
    private static final java.lang.String RECENT_EXERCISE_PERCENTAGE = "recentExercisePercentage";
    private static final java.lang.String SELECTED_DAYS = "selectedDays";
    private static final java.lang.String CURRENT_DATE = "currentDate";
    private static final java.lang.String FITZAY_CONFIG = "fitzayConfig";
    private static final java.lang.String SAVE_WATER = "saveWater";
}