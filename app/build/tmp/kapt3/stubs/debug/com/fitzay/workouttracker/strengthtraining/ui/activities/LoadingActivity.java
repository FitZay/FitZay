package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001cH\u0014J\b\u0010%\u001a\u00020\u001cH\u0014J\b\u0010&\u001a\u00020\u001cH\u0014J\b\u0010\'\u001a\u00020\u001cH\u0014J\b\u0010(\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/LoadingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityLoadingBinding;", "handlerLoading", "Landroid/os/Handler;", "isConsentDone", "", "isMobileAdsInitializeCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isStarted", "()Z", "setStarted", "(Z)V", "mInterstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "getMInterstitialAd", "()Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "setMInterstitialAd", "(Lcom/google/android/gms/ads/interstitial/InterstitialAd;)V", "rLoading", "Ljava/lang/Runnable;", "consentForm", "", "initializeMobileAdsSdk", "interAd", "interCallback", "loadNext", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStart", "onStop", "showLoading", "Companion", "app_debug"})
public final class LoadingActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable
    private com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    private boolean isStarted = false;
    private android.os.Handler handlerLoading;
    private java.lang.Runnable rLoading;
    private boolean isConsentDone = false;
    private java.util.concurrent.atomic.AtomicBoolean isMobileAdsInitializeCalled;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity.Companion Companion = null;
    private static boolean ispurchased = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "LoadingActivity";
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityLoadingBinding binding;
    
    public LoadingActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.gms.ads.interstitial.InterstitialAd getMInterstitialAd() {
        return null;
    }
    
    public final void setMInterstitialAd(@org.jetbrains.annotations.Nullable
    com.google.android.gms.ads.interstitial.InterstitialAd p0) {
    }
    
    public final boolean isStarted() {
        return false;
    }
    
    public final void setStarted(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void interAd() {
    }
    
    private final void interCallback() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    private final void loadNext() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    private final void showLoading() {
    }
    
    private final void consentForm() {
    }
    
    private final void initializeMobileAdsSdk() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/LoadingActivity$Companion;", "", "()V", "ispurchased", "", "getIspurchased", "()Z", "setIspurchased", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getIspurchased() {
            return false;
        }
        
        public final void setIspurchased(boolean p0) {
        }
    }
}