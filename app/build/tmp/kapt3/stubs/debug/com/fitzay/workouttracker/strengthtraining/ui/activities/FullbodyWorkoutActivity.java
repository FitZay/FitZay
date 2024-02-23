package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/FullbodyWorkoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityFullbodyWorkoutBinding;", "movetonextActivity", "", "week", "", "exId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class FullbodyWorkoutActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityFullbodyWorkoutBinding binding;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.activities.FullbodyWorkoutActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel> listoffullbodies;
    
    public FullbodyWorkoutActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void movetonextActivity(@org.jetbrains.annotations.NotNull
    java.lang.String week, @org.jetbrains.annotations.NotNull
    java.lang.String exId) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/FullbodyWorkoutActivity$Companion;", "", "()V", "listoffullbodies", "", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/FullbodyCategoriesModel;", "getListoffullbodies", "()Ljava/util/List;", "setListoffullbodies", "(Ljava/util/List;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel> getListoffullbodies() {
            return null;
        }
        
        public final void setListoffullbodies(@org.jetbrains.annotations.NotNull
        java.util.List<com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel> p0) {
        }
    }
}