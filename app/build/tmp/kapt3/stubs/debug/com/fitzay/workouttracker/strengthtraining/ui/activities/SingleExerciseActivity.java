package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/SingleExerciseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "arr", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "Lkotlin/collections/ArrayList;", "arrIndex", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivitySingleExerciseBinding;", "isReady", "", "()Z", "setReady", "(Z)V", "loadingHandler", "Landroid/os/Handler;", "runalble", "Ljava/lang/Runnable;", "getReadyForExercise", "", "hideAllLayout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "performExercise", "app_debug"})
public final class SingleExerciseActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivitySingleExerciseBinding binding;
    private android.os.Handler loadingHandler;
    private java.lang.Runnable runalble;
    private java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> arr;
    private int arrIndex = 0;
    private boolean isReady = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "SingleExercise";
    
    public SingleExerciseActivity() {
        super();
    }
    
    public final boolean isReady() {
        return false;
    }
    
    public final void setReady(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getReadyForExercise() {
    }
    
    private final void performExercise() {
    }
    
    private final void hideAllLayout() {
    }
}