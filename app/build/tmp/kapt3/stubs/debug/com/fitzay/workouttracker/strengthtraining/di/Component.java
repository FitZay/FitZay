package com.fitzay.workouttracker.strengthtraining.di;

import java.lang.System;

@kotlin.OptIn(markerClass = {org.koin.core.component.KoinApiExtension.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%R\u001b\u0010\'\u001a\u00020(8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\b\u001a\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/di/Component;", "Lorg/koin/core/component/KoinComponent;", "()V", "alarmViewModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/AlarmViewModel;", "getAlarmViewModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/AlarmViewModel;", "alarmViewModel$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "preference", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/FitnessPreference;", "getPreference", "()Lcom/fitzay/workouttracker/strengthtraining/core/utils/FitnessPreference;", "preference$delegate", "quotesViewModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/MotivationViewModel;", "getQuotesViewModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/MotivationViewModel;", "quotesViewModel$delegate", "ringtoneModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/RingtoneModel;", "getRingtoneModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/RingtoneModel;", "ringtoneModel$delegate", "sleepViewModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/SleepViewModel;", "getSleepViewModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/SleepViewModel;", "sleepViewModel$delegate", "stepModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/StepViewModel;", "getStepModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/StepViewModel;", "stepModel$delegate", "workOutViewModel", "Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/WorkOutViewModel;", "getWorkOutViewModel", "()Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/WorkOutViewModel;", "workOutViewModel$delegate", "app_debug"})
public final class Component implements org.koin.core.component.KoinComponent {
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.di.Component INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy context$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy workOutViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy quotesViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy stepModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy alarmViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy sleepViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy ringtoneModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy preference$delegate = null;
    
    private Component() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.WorkOutViewModel getWorkOutViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.MotivationViewModel getQuotesViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.StepViewModel getStepModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.AlarmViewModel getAlarmViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.SleepViewModel getSleepViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.viewmodels.RingtoneModel getRingtoneModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.core.utils.FitnessPreference getPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public org.koin.core.Koin getKoin() {
        return null;
    }
}