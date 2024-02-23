package com.fitzay.workouttracker.strengthtraining.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "backToExitPressedOnce", "", "getBackToExitPressedOnce", "()Z", "setBackToExitPressedOnce", "(Z)V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityMainBinding;", "currentFragment", "drawerOpen", "isClicked", "setClicked", "navListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "callRequireFragment", "", "position", "", "interCallback", "navClicks", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityMainBinding binding;
    private boolean backToExitPressedOnce = false;
    private boolean drawerOpen = false;
    private boolean isClicked = false;
    private java.lang.String currentFragment = "Planning";
    private final java.lang.String TAG = "MainActivity";
    private final com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener navListener = null;
    
    public MainActivity() {
        super();
    }
    
    public final boolean getBackToExitPressedOnce() {
        return false;
    }
    
    public final void setBackToExitPressedOnce(boolean p0) {
    }
    
    public final boolean isClicked() {
        return false;
    }
    
    public final void setClicked(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navClicks() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    private final void interCallback(int position) {
    }
    
    public final void callRequireFragment(int position) {
    }
}