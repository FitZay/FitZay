package com.fitzay.workouttracker.strengthtraining.ui.callback;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/callback/LanguageItemClick;", "", "itemClick", "", "position", "", "model", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/LanguageM;", "check", "Landroid/widget/RadioButton;", "app_debug"})
public abstract interface LanguageItemClick {
    
    public abstract void itemClick(int position, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM model, @org.jetbrains.annotations.NotNull
    android.widget.RadioButton check);
}