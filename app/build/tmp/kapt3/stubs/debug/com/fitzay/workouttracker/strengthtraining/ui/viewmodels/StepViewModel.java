package com.fitzay.workouttracker.strengthtraining.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\bJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\t0\b2\u0006\u0010\u0017\u001a\u00020\u000bJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\t0\b2\u0006\u0010\u001a\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/StepViewModel;", "Landroidx/lifecycle/ViewModel;", "stepRepository", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/StepRepository;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/repository/StepRepository;)V", "getStepRepository", "()Lcom/fitzay/workouttracker/strengthtraining/domain/repository/StepRepository;", "getAllRecords", "Landroidx/lifecycle/LiveData;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/StepEntity;", "getAverageStepCount", "", "getAverageStepForSpecificDate", "startDate", "", "getAverageStepsBetweenDates", "endDate", "getDailyRecord", "getWeeklyGoal", "insertSteps", "", "stepEntity", "isDateExists", "", "date", "app_debug"})
public final class StepViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository stepRepository = null;
    
    public StepViewModel(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository stepRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository getStepRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<kotlin.Unit>> insertSteps(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity stepEntity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity>>> getAllRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>> isDateExists(@org.jetbrains.annotations.NotNull
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Integer>> getAverageStepCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Integer>> getAverageStepsBetweenDates(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Integer>> getAverageStepForSpecificDate(@org.jetbrains.annotations.NotNull
    java.lang.String startDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity>>> getWeeklyGoal(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.util.List<com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity>>> getDailyRecord(@org.jetbrains.annotations.NotNull
    java.lang.String startDate) {
        return null;
    }
}