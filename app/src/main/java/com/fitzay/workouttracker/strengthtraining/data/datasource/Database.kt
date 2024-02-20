package com.fitzay.workouttracker.strengthtraining.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm
import com.fitzay.workouttracker.strengthtraining.data.model.Sleep
import com.fitzay.workouttracker.strengthtraining.data.model.Step
import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmConverters
import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao
import com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao
import com.fitzay.workouttracker.strengthtraining.data.repository.StepDao

@Database(
    entities = [Step::class, Alarm::class ,Sleep::class],
    version = 5, exportSchema = false
)

@TypeConverters(AlarmConverters::class)
abstract class Database : RoomDatabase() {
    abstract val stepDao: StepDao
    abstract val alarmDao: AlarmDao
    abstract val sleepDao: SleepDao
}