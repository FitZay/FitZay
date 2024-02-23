package com.fitzay.workouttracker.strengthtraining.domain.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u00e1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0019J\b\u0010H\u001a\u00020IH\u0016R\u001e\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b\'\u0010\u001dR\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001d\u00a8\u0006J"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayModel;", "", "FitzayBannerProfile", "Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;", "FitzayBannerWorkout", "FitzayInterstitialSplash", "FitzayInterstitialMain", "FitzayInterstitialExcerciseQuit", "FitzayRewardedAdvance", "FitzayNativeSplash", "FitzayNativeExerciseRest", "FitzayNativeStatsSummary", "FitzayNativeGender", "FitzayNativeName", "FitzayNativeAge", "FitzayNativeHeight", "FitzayNativeWeight", "FitzayNativeTargetWeight", "FitzayNativeSleepTracker", "FitzayNativeStepCounter", "FitzayNativeDailyMotivation", "FitzayNativeExercise", "FitzayNativeStats", "FitzayNativeStartExercise", "FitzayAppOpen", "(Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;)V", "getFitzayAppOpen", "()Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;", "setFitzayAppOpen", "(Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayCompareModel;)V", "getFitzayBannerProfile", "setFitzayBannerProfile", "getFitzayBannerWorkout", "setFitzayBannerWorkout", "getFitzayInterstitialExcerciseQuit", "setFitzayInterstitialExcerciseQuit", "getFitzayInterstitialMain", "setFitzayInterstitialMain", "getFitzayInterstitialSplash", "setFitzayInterstitialSplash", "getFitzayNativeAge", "setFitzayNativeAge", "getFitzayNativeDailyMotivation", "setFitzayNativeDailyMotivation", "getFitzayNativeExercise", "setFitzayNativeExercise", "getFitzayNativeExerciseRest", "setFitzayNativeExerciseRest", "getFitzayNativeGender", "setFitzayNativeGender", "getFitzayNativeHeight", "setFitzayNativeHeight", "getFitzayNativeName", "setFitzayNativeName", "getFitzayNativeSleepTracker", "setFitzayNativeSleepTracker", "getFitzayNativeSplash", "setFitzayNativeSplash", "getFitzayNativeStartExercise", "setFitzayNativeStartExercise", "getFitzayNativeStats", "setFitzayNativeStats", "getFitzayNativeStatsSummary", "setFitzayNativeStatsSummary", "getFitzayNativeStepCounter", "setFitzayNativeStepCounter", "getFitzayNativeTargetWeight", "setFitzayNativeTargetWeight", "getFitzayNativeWeight", "setFitzayNativeWeight", "getFitzayRewardedAdvance", "setFitzayRewardedAdvance", "toString", "", "app_debug"})
public final class FitzayModel {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayBannerProfile")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayBannerProfile;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayBannerWorkout")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayBannerWorkout;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayInterstitialSplash")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialSplash;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayInterstitialMain")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialMain;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayInterstitialExcerciseQuit")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialExcerciseQuit;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayRewardedAdvance")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayRewardedAdvance;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeSplash")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeSplash;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeExerciseRest")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeExerciseRest;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeStatsSummary")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStatsSummary;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeGender")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeGender;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeName")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeName;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeAge")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeAge;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeHeight")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeHeight;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeWeight")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeWeight;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeTargetWeight")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeTargetWeight;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeSleepTracker")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeSleepTracker;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeStepCounter")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStepCounter;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeDailyMotivation")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeDailyMotivation;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeExercise")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeExercise;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeStats")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStats;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayNativeStartExercise")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStartExercise;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "FitzayAppOpen")
    private com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayAppOpen;
    
    public FitzayModel() {
        super();
    }
    
    public FitzayModel(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayBannerProfile, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayBannerWorkout, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialSplash, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialMain, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayInterstitialExcerciseQuit, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayRewardedAdvance, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeSplash, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeExerciseRest, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStatsSummary, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeGender, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeName, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeAge, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeHeight, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeWeight, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeTargetWeight, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeSleepTracker, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStepCounter, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeDailyMotivation, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeExercise, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStats, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayNativeStartExercise, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel FitzayAppOpen) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayBannerProfile() {
        return null;
    }
    
    public final void setFitzayBannerProfile(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayBannerWorkout() {
        return null;
    }
    
    public final void setFitzayBannerWorkout(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayInterstitialSplash() {
        return null;
    }
    
    public final void setFitzayInterstitialSplash(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayInterstitialMain() {
        return null;
    }
    
    public final void setFitzayInterstitialMain(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayInterstitialExcerciseQuit() {
        return null;
    }
    
    public final void setFitzayInterstitialExcerciseQuit(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayRewardedAdvance() {
        return null;
    }
    
    public final void setFitzayRewardedAdvance(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeSplash() {
        return null;
    }
    
    public final void setFitzayNativeSplash(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeExerciseRest() {
        return null;
    }
    
    public final void setFitzayNativeExerciseRest(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeStatsSummary() {
        return null;
    }
    
    public final void setFitzayNativeStatsSummary(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeGender() {
        return null;
    }
    
    public final void setFitzayNativeGender(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeName() {
        return null;
    }
    
    public final void setFitzayNativeName(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeAge() {
        return null;
    }
    
    public final void setFitzayNativeAge(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeHeight() {
        return null;
    }
    
    public final void setFitzayNativeHeight(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeWeight() {
        return null;
    }
    
    public final void setFitzayNativeWeight(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeTargetWeight() {
        return null;
    }
    
    public final void setFitzayNativeTargetWeight(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeSleepTracker() {
        return null;
    }
    
    public final void setFitzayNativeSleepTracker(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeStepCounter() {
        return null;
    }
    
    public final void setFitzayNativeStepCounter(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeDailyMotivation() {
        return null;
    }
    
    public final void setFitzayNativeDailyMotivation(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeExercise() {
        return null;
    }
    
    public final void setFitzayNativeExercise(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeStats() {
        return null;
    }
    
    public final void setFitzayNativeStats(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayNativeStartExercise() {
        return null;
    }
    
    public final void setFitzayNativeStartExercise(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel getFitzayAppOpen() {
        return null;
    }
    
    public final void setFitzayAppOpen(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayCompareModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}