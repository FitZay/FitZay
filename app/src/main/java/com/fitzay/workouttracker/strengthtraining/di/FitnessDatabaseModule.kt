package com.fitzay.workouttracker.strengthtraining.di

import android.app.Application
import androidx.room.Room
import com.fitzay.workouttracker.strengthtraining.data.datasource.Database
import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao
import com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao
import com.fitzay.workouttracker.strengthtraining.data.repository.StepDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): Database {
        return Room.databaseBuilder(application, Database::class.java, "fitnessDB.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideStepDao(database: Database): StepDao {
        return database.stepDao
    }

    fun provideAlarmDao(database: Database): AlarmDao {
        return database.alarmDao
    }
    fun provideSleepDao(database: Database): SleepDao {
        return database.sleepDao
    }

    single {
        provideDatabase(androidApplication())
    }
    single {
        provideStepDao(get())
    }
    single {
        provideSleepDao(get())
    }
    single {
        provideAlarmDao(get())
    }
}