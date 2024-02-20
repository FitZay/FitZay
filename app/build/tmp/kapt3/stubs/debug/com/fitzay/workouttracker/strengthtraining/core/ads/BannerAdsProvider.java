package com.fitzay.workouttracker.strengthtraining.core.ads;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bJ\u0012\u0010&\u001a\u00020\u001b2\b\u0010\u0002\u001a\u0004\u0018\u00010\'H\u0002J\b\u0010(\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020#H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/ads/BannerAdsProvider;", "", "context", "Landroid/app/Activity;", "bannerGoogleAdContainer", "Landroid/widget/FrameLayout;", "llLoading", "Landroid/widget/LinearLayout;", "llAds", "(Landroid/app/Activity;Landroid/widget/FrameLayout;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;)V", "TAG", "", "adSize", "Lcom/google/android/gms/ads/AdSize;", "getAdSize", "()Lcom/google/android/gms/ads/AdSize;", "getBannerGoogleAdContainer", "()Landroid/widget/FrameLayout;", "setBannerGoogleAdContainer", "(Landroid/widget/FrameLayout;)V", "getContext", "()Landroid/app/Activity;", "setContext", "(Landroid/app/Activity;)V", "googleBannerAdView", "Lcom/google/android/gms/ads/AdView;", "initialLayoutComplete", "", "getLlAds", "()Landroid/widget/LinearLayout;", "setLlAds", "(Landroid/widget/LinearLayout;)V", "getLlLoading", "setLlLoading", "callBothBannerAds", "", "adId", "type", "isNetworkAvailable", "Landroid/content/Context;", "loadCollapasableGoogleBannerFunction", "loadGoogleBannerAds", "loadGoogleBannerFunction", "app_debug"})
public final class BannerAdsProvider {
    @org.jetbrains.annotations.NotNull
    private android.app.Activity context;
    @org.jetbrains.annotations.NotNull
    private android.widget.FrameLayout bannerGoogleAdContainer;
    @org.jetbrains.annotations.NotNull
    private android.widget.LinearLayout llLoading;
    @org.jetbrains.annotations.NotNull
    private android.widget.LinearLayout llAds;
    private com.google.android.gms.ads.AdView googleBannerAdView;
    private boolean initialLayoutComplete = false;
    private final java.lang.String TAG = "BannerAds";
    
    public BannerAdsProvider(@org.jetbrains.annotations.NotNull
    android.app.Activity context, @org.jetbrains.annotations.NotNull
    android.widget.FrameLayout bannerGoogleAdContainer, @org.jetbrains.annotations.NotNull
    android.widget.LinearLayout llLoading, @org.jetbrains.annotations.NotNull
    android.widget.LinearLayout llAds) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.app.Activity getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.FrameLayout getBannerGoogleAdContainer() {
        return null;
    }
    
    public final void setBannerGoogleAdContainer(@org.jetbrains.annotations.NotNull
    android.widget.FrameLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.LinearLayout getLlLoading() {
        return null;
    }
    
    public final void setLlLoading(@org.jetbrains.annotations.NotNull
    android.widget.LinearLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.widget.LinearLayout getLlAds() {
        return null;
    }
    
    public final void setLlAds(@org.jetbrains.annotations.NotNull
    android.widget.LinearLayout p0) {
    }
    
    public final void callBothBannerAds(@org.jetbrains.annotations.NotNull
    java.lang.String adId, @org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    private final void loadGoogleBannerAds(java.lang.String adId, java.lang.String type) {
    }
    
    private final void loadGoogleBannerFunction() {
    }
    
    private final void loadCollapasableGoogleBannerFunction() {
    }
    
    private final com.google.android.gms.ads.AdSize getAdSize() {
        return null;
    }
    
    private final boolean isNetworkAvailable(android.content.Context context) {
        return false;
    }
}