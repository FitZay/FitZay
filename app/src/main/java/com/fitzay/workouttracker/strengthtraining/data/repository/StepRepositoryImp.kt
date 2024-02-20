package com.fitzay.workouttracker.strengthtraining.data.repository

import com.fitzay.workouttracker.strengthtraining.data.model.Step
import com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity
import com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository

class StepRepositoryImp(private val stepDao: StepDao) : StepRepository {

    override suspend fun getAllStepCount(): Int {
        return stepDao.getAllStepsCount()
    }

    override suspend fun getAverageStepCount(): Int {
        return stepDao.getAverageStepCount()
    }

    override suspend fun isDateExist(date: String): Boolean {
        return stepDao.isStepDateExists(date)
    }

    override suspend fun getAverageStepsBetweenDates(startDate: String, endDate: String): Int {
        return stepDao.getAverageStepsBetweenDates(startDate, endDate)
    }

    override suspend fun getAverageStepForSpecificDate(startDate: String): Int {
        return stepDao.getAverageStepForSpecificDate(startDate)
    }


    override suspend fun insertSteps(step: StepEntity) {
        val existingStep = stepDao.isStepStepExists(step.date.toString())
        if (existingStep != null) {
            stepDao.updateStepTable(
                step.date.toString(),
                step.steps,
                step.distance,
                step.time.toString(),
                step.calories,
                step.stepGoal,
                step.caloriesGoal,
                step.distanceGoal
            )
        } else {
            stepDao.insertStep(Step.fromDomain(step))
        }

    }

    override suspend fun getAllRecords(): List<StepEntity> {
        return stepDao.getAllRecords().map {
            it.toDomain()
        }
    }

    override suspend fun getWeeklyGoal(startDate: String, endDate: String): List<StepEntity> {
        return stepDao.getWeeklyGoal(startDate, endDate).map {
            it.toDomain()
        }
    }

    override suspend fun getGoalForSpecificDate(requiredDate: String): List<StepEntity> {
        return stepDao.getStepForSpecificDate(requiredDate).map {
            it.toDomain()
        }
    }

}