package com.fitzay.workouttracker.strengthtraining.data.repository;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\'J\b\u0010\b\u001a\u00020\u0007H\'J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\'J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u000bH\'J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\'JQ\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/repository/StepDao;", "", "getAllRecords", "", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Step;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStepsCount", "", "getAverageStepCount", "getAverageStepForSpecificDate", "date", "", "getAverageStepsBetweenDates", "startDate", "endDate", "getStepForSpecificDate", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeeklyGoal", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertStep", "", "step", "(Lcom/fitzay/workouttracker/strengthtraining/data/model/Step;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isStepDateExists", "", "isStepStepExists", "updateStepTable", "newSteps", "newDistance", "", "newTime", "newCalories", "newStepGoal", "caloriesGoal", "distanceGoal", "(Ljava/lang/String;IDLjava/lang/String;DIDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface StepDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertStep(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.data.model.Step step, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM Step ORDER BY id DESC")
    public abstract java.lang.Object getAllRecords(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Step>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM Step WHERE date = :date")
    public abstract com.fitzay.workouttracker.strengthtraining.data.model.Step isStepStepExists(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM Step WHERE date = :date)")
    public abstract boolean isStepDateExists(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "UPDATE Step SET steps = :newSteps, distance = :newDistance, time = :newTime, calories = :newCalories, stepGoal = :newStepGoal, caloriesGoal=:caloriesGoal, distanceGoal=:distanceGoal  WHERE Date = :date")
    public abstract java.lang.Object updateStepTable(@org.jetbrains.annotations.NotNull
    java.lang.String date, int newSteps, double newDistance, @org.jetbrains.annotations.NotNull
    java.lang.String newTime, double newCalories, int newStepGoal, double caloriesGoal, double distanceGoal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Query(value = "SELECT SUM(steps) FROM Step")
    public abstract int getAllStepsCount();
    
    @androidx.room.Query(value = "SELECT AVG(steps) FROM Step")
    public abstract int getAverageStepCount();
    
    @androidx.room.Query(value = "SELECT AVG(steps) FROM Step WHERE date= :date")
    public abstract int getAverageStepForSpecificDate(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @androidx.room.Query(value = "SELECT AVG(steps) FROM Step WHERE date BETWEEN :startDate AND :endDate")
    public abstract int getAverageStepsBetweenDates(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM Step WHERE date BETWEEN :startDate AND :endDate")
    public abstract java.lang.Object getWeeklyGoal(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Step>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM Step WHERE date= :date")
    public abstract java.lang.Object getStepForSpecificDate(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.fitzay.workouttracker.strengthtraining.data.model.Step>> continuation);
}