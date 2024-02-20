package com.fitzay.workouttracker.strengthtraining.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006J\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eJ\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00070\u00062\u0006\u0010\u0015\u001a\u00020\tJ\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00070\u00062\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/StepViewModel;", "Landroidx/lifecycle/ViewModel;", "stepRepository", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/StepRepository;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/repository/StepRepository;)V", "getAllRecords", "Landroidx/lifecycle/LiveData;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/StepEntity;", "getAverageStepCount", "", "getAverageStepForSpecificDate", "startDate", "", "getAverageStepsBetweenDates", "endDate", "getDailyRecord", "getWeeklyGoal", "insertSteps", "", "stepEntity", "isDateExists", "", "date", "app_debug"})
public final class StepViewModel extends androidx.lifecycle.ViewModel {
    private final com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository stepRepository = null;
    
    public StepViewModel(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.repository.StepRepository stepRepository) {
        super();
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