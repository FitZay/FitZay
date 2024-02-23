package com.fitzay.workouttracker.strengthtraining.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/AppController;", "Landroid/app/Application;", "()V", "TAG", "", "fetchAndActivate", "", "onCreate", "setupNetworkCallback", "Companion", "app_debug"})
public final class AppController extends android.app.Application {
    private final java.lang.String TAG = "AppController";
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.core.AppController.Companion Companion = null;
    private static int fitAdCount = 0;
    private static int fitAdTotal = 2;
    @org.jetbrains.annotations.Nullable
    private static com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayModel fitzayModel;
    private static boolean isFirstOpen = true;
    @org.jetbrains.annotations.Nullable
    private static com.google.firebase.remoteconfig.FirebaseRemoteConfig remoteFitzayConfig;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String weeklyvalue = "";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String monthlyvalue = "";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String yearlyvalue = "";
    private static boolean inappflow = false;
    
    public AppController() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void setupNetworkCallback() {
    }
    
    private final void fetchAndActivate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/AppController$Companion;", "", "()V", "fitAdCount", "", "getFitAdCount", "()I", "setFitAdCount", "(I)V", "fitAdTotal", "getFitAdTotal", "setFitAdTotal", "fitzayModel", "Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayModel;", "getFitzayModel", "()Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayModel;", "setFitzayModel", "(Lcom/fitzay/workouttracker/strengthtraining/domain/remote/FitzayModel;)V", "inappflow", "", "getInappflow", "()Z", "setInappflow", "(Z)V", "isFirstOpen", "setFirstOpen", "monthlyvalue", "", "getMonthlyvalue", "()Ljava/lang/String;", "setMonthlyvalue", "(Ljava/lang/String;)V", "remoteFitzayConfig", "Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "getRemoteFitzayConfig", "()Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;", "setRemoteFitzayConfig", "(Lcom/google/firebase/remoteconfig/FirebaseRemoteConfig;)V", "weeklyvalue", "getWeeklyvalue", "setWeeklyvalue", "yearlyvalue", "getYearlyvalue", "setYearlyvalue", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getFitAdCount() {
            return 0;
        }
        
        public final void setFitAdCount(int p0) {
        }
        
        public final int getFitAdTotal() {
            return 0;
        }
        
        public final void setFitAdTotal(int p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayModel getFitzayModel() {
            return null;
        }
        
        public final void setFitzayModel(@org.jetbrains.annotations.Nullable
        com.fitzay.workouttracker.strengthtraining.domain.remote.FitzayModel p0) {
        }
        
        public final boolean isFirstOpen() {
            return false;
        }
        
        public final void setFirstOpen(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.google.firebase.remoteconfig.FirebaseRemoteConfig getRemoteFitzayConfig() {
            return null;
        }
        
        public final void setRemoteFitzayConfig(@org.jetbrains.annotations.Nullable
        com.google.firebase.remoteconfig.FirebaseRemoteConfig p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getWeeklyvalue() {
            return null;
        }
        
        public final void setWeeklyvalue(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMonthlyvalue() {
            return null;
        }
        
        public final void setMonthlyvalue(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getYearlyvalue() {
            return null;
        }
        
        public final void setYearlyvalue(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
        
        public final boolean getInappflow() {
            return false;
        }
        
        public final void setInappflow(boolean p0) {
        }
    }
}