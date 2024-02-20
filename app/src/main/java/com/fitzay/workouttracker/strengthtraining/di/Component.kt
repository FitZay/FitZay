package com.fitzay.workouttracker.strengthtraining.di

import android.content.Context
import com.fitzay.workouttracker.strengthtraining.core.utils.FitnessPreference
import com.fitzay.workouttracker.strengthtraining.ui.viewmodels.*
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@OptIn(KoinApiExtension::class)
object Component : KoinComponent {
    val context: Context by inject()
    val workOutViewModel: WorkOutViewModel by inject()
    val quotesViewModel: MotivationViewModel by inject()
    val stepModel: StepViewModel by inject()
    val alarmViewModel: AlarmViewModel by inject()
    val sleepViewModel: SleepViewModel by inject()
    val ringtoneModel: RingtoneModel by inject()
    val preference: FitnessPreference by inject()

}