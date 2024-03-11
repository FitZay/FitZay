package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/ExitScreenActivity;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityExitScreenBinding;", "loadinginterstitial", "", "mInterstitialad", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "getMInterstitialad", "()Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "setMInterstitialad", "(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V", "waiting_dialog", "Landroid/app/Dialog;", "loadSplashInterstitialAd", "", "adId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "resetimages", "showInter", "showWaitingDialog", "app_debug"})
public final class ExitScreenActivity extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityExitScreenBinding binding;
    private android.app.Dialog waiting_dialog;
    @org.jetbrains.annotations.Nullable
    private com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialad;
    private boolean loadinginterstitial = false;
    private final java.lang.String TAG = "ExitScreenActivity";
    
    public ExitScreenActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.gms.ads.interstitial.InterstitialAd getMInterstitialad() {
        return null;
    }
    
    public final void setMInterstitialad(@org.jetbrains.annotations.Nullable
    com.google.android.gms.ads.interstitial.InterstitialAd p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void resetimages() {
    }
    
    public final void loadSplashInterstitialAd(@org.jetbrains.annotations.NotNull
    java.lang.String adId) {
    }
    
    public final void showInter() {
    }
    
    private final void showWaitingDialog() {
    }
}