package com.fitzay.workouttracker.strengthtraining.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm
import com.fitzay.workouttracker.strengthtraining.data.model.Step

@Dao
interface StepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStep(step: Step)

    @Query("SELECT * FROM Step ORDER BY id DESC")
    suspend fun getAllRecords(): List<Step>

    @Query("SELECT * FROM Step ORDER BY id DESC")
    fun getPaging(): List<Step>

    @Query("SELECT * FROM Step WHERE date = :date")
    fun isStepStepExists(date: String): Step?

    @Query("SELECT EXISTS(SELECT * FROM Step WHERE date = :date)")
    fun isStepDateExists(date: String): Boolean

    @Query("UPDATE Step SET steps = :newSteps, distance = :newDistance, time = :newTime, calories = :newCalories, stepGoal = :newStepGoal, caloriesGoal=:caloriesGoal, distanceGoal=:distanceGoal  WHERE Date = :date")
    suspend fun updateStepTable(
        date: String,
        newSteps: Int,
        newDistance: Double,
        newTime: String,
        newCalories: Double,
        newStepGoal: Int,
        caloriesGoal: Double,
        distanceGoal: Double
    )

    @Query("SELECT SUM(steps) FROM Step")
    fun getAllStepsCount(): Int

    @Query("SELECT AVG(steps) FROM Step")
    fun getAverageStepCount(): Int


    @Query("SELECT AVG(steps) FROM Step WHERE date= :date")
    fun getAverageStepForSpecificDate(date: String): Int

    @Query("SELECT AVG(steps) FROM Step WHERE date BETWEEN :startDate AND :endDate")
    fun getAverageStepsBetweenDates(startDate: String, endDate: String): Int

    @Query("SELECT * FROM Step WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getWeeklyGoal(startDate: String, endDate: String): List<Step>

    @Query("SELECT * FROM Step WHERE date= :date")
    suspend fun getStepForSpecificDate(date: String): List<Step>

}