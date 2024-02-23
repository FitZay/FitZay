package com.fitzay.workouttracker.strengthtraining.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0012J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t\u00a8\u0006\u0015"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/WorkOutViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fullbodygetCat", "", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/FullbodyCategoriesModel;", "context", "Landroid/content/Context;", "week", "", "day", "getCat", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/CategoriesModel;", "type", "getFullbodyWorkouts", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "id", "ex_id", "", "getWorkoutWithID", "getWorkouts", "app_debug"})
public final class WorkOutViewModel extends androidx.lifecycle.ViewModel {
    
    public WorkOutViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel> getCat(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel> fullbodygetCat(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String week, @org.jetbrains.annotations.NotNull
    java.lang.String day) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> getWorkouts(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> getFullbodyWorkouts(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String id, int ex_id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> getWorkoutWithID(@org.jetbrains.annotations.NotNull
    android.content.Context context, int id) {
        return null;
    }
}