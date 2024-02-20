package com.fitzay.workouttracker.strengthtraining.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

interface AlarmBaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<T>)

    @Insert
    fun insert(vararg t: T)

    @Update
    fun update(vararg t: T)

    @Delete
    fun delete(vararg t: T)

    @Delete
    fun deleteAll(list: List<T>)



}