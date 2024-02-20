package com.fitzay.workouttracker.strengthtraining.di

import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmRepositoryImp
import com.fitzay.workouttracker.strengthtraining.data.repository.SleepRepositoryImp
import com.fitzay.workouttracker.strengthtraining.data.repository.StepRepositoryImp
import com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository
import com.fitzay.workouttracker.strengthtraining.domain.repository.SleepRepository
import com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository
import org.koin.dsl.module

val fitnessRepository = module {
    single<StepRepository> { StepRepositoryImp(get()) }
    single<AlarmRepository> { AlarmRepositoryImp(get()) }
    single<SleepRepository> { SleepRepositoryImp(get()) }
}