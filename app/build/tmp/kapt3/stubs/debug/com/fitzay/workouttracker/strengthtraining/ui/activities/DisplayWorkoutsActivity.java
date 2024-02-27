package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/DisplayWorkoutsActivity;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityDisplayWorkoutsBinding;", "interCallback", "", "intent", "Landroid/content/Intent;", "loadAdaptiveNative", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class DisplayWorkoutsActivity extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityDisplayWorkoutsBinding binding;
    private java.lang.String TAG = "_displayactivity";
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.activities.DisplayWorkoutsActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> listofworkmodel;
    
    public DisplayWorkoutsActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void interCallback(android.content.Intent intent) {
    }
    
    private final void loadAdaptiveNative() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/DisplayWorkoutsActivity$Companion;", "", "()V", "listofworkmodel", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "Lkotlin/collections/ArrayList;", "getListofworkmodel", "()Ljava/util/ArrayList;", "setListofworkmodel", "(Ljava/util/ArrayList;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> getListofworkmodel() {
            return null;
        }
        
        public final void setListofworkmodel(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> p0) {
        }
    }
}