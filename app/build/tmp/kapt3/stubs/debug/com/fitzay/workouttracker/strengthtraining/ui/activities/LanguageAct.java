package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/LanguageAct;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "Lcom/fitzay/workouttracker/strengthtraining/ui/callback/LanguageItemClick;", "()V", "adapter", "Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/LanguageShowAdapter;", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityLanguageBinding;", "languageManager", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/LanguageManager;", "getLanguageManager", "()Lcom/fitzay/workouttracker/strengthtraining/core/utils/LanguageManager;", "setLanguageManager", "(Lcom/fitzay/workouttracker/strengthtraining/core/utils/LanguageManager;)V", "list", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/LanguageM;", "sharedPreferencesHelper", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/SharedPreferencesHelper;", "getSharedPreferencesHelper", "()Lcom/fitzay/workouttracker/strengthtraining/core/utils/SharedPreferencesHelper;", "setSharedPreferencesHelper", "(Lcom/fitzay/workouttracker/strengthtraining/core/utils/SharedPreferencesHelper;)V", "itemClick", "", "position", "", "model", "check", "Landroid/widget/RadioButton;", "loadAdaptiveNative", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restartApp", "app_debug"})
public final class LanguageAct extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 implements com.fitzay.workouttracker.strengthtraining.ui.callback.LanguageItemClick {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityLanguageBinding binding;
    private com.fitzay.workouttracker.strengthtraining.ui.adapters.LanguageShowAdapter adapter;
    private java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM> list;
    public com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper sharedPreferencesHelper;
    public com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager languageManager;
    
    public LanguageAct() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper getSharedPreferencesHelper() {
        return null;
    }
    
    public final void setSharedPreferencesHelper(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager getLanguageManager() {
        return null;
    }
    
    public final void setLanguageManager(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void itemClick(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM model, @org.jetbrains.annotations.NotNull
    android.widget.RadioButton check) {
    }
    
    private final void loadAdaptiveNative() {
    }
    
    private final void restartApp() {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
}