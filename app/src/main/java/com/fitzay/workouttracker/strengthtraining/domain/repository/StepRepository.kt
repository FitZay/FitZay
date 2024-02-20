package com.fitzay.workouttracker.strengthtraining.domain.repository

import com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity


interface StepRepository {

    suspend fun insertSteps(step: StepEntity)
    suspend fun getAllRecords(): List<StepEntity>
    suspend fun getWeeklyGoal(startDate: String, endDate: String): List<StepEntity>
    suspend fun getAverageStepsBetweenDates(startDate: String, endDate: String): Int
    suspend fun getAverageStepForSpecificDate(startDate: String): Int
    suspend fun getGoalForSpecificDate(requiredDate: String): List<StepEntity>
    suspend fun getAllStepCount(): Int
    suspend fun getAverageStepCount(): Int
    suspend fun isDateExist(date: String): Boolean
}