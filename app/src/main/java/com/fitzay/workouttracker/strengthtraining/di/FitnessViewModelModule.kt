package com.fitzay.workouttracker.strengthtraining.di

import com.fitzay.workouttracker.strengthtraining.core.utils.FitnessPreference
import com.fitzay.workouttracker.strengthtraining.ui.viewmodels.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val fitnessViewModelModule = module {
    viewModel { WorkOutViewModel() }
    viewModel { StepViewModel(get()) }
    viewModel { SleepViewModel(get()) }
    viewModel { AlarmViewModel(get()) }
    viewModel { MotivationViewModel() }
    viewModel { RingtoneModel() }
    single { FitnessPreference() }

}