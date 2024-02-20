package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus
import com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository
import kotlinx.coroutines.Dispatchers

class StepViewModel(private val stepRepository: StepRepository) : ViewModel() {

    fun insertSteps(stepEntity: StepEntity) = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.insertSteps(stepEntity)))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

    fun getAllRecords() = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.getAllRecords()))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

    fun isDateExists(date: String) = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.isDateExist(date)))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

    fun getAverageStepCount() = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.getAverageStepCount()))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

    fun getAverageStepsBetweenDates(startDate: String, endDate: String) = liveData(Dispatchers.IO) {
        try {
            emit(
                UpdateStatus.success(
                    stepRepository.getAverageStepsBetweenDates(
                        startDate,
                        endDate
                    )
                )
            )
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

    fun getAverageStepForSpecificDate(startDate: String) = liveData(Dispatchers.IO) {
        try {
            emit(
                UpdateStatus.success(
                    stepRepository.getAverageStepForSpecificDate(
                        startDate
                    )
                )
            )
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }


    fun getWeeklyGoal(startDate: String, endDate: String) = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.getWeeklyGoal(startDate, endDate)))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }


    fun getDailyRecord(startDate: String) = liveData(Dispatchers.IO) {
        try {
            emit(UpdateStatus.success(stepRepository.getGoalForSpecificDate(startDate)))
        } catch (e: Exception) {
            emit(UpdateStatus.error(null, "an error $e"))
        }
    }

}