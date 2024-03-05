package com.fitzay.workouttracker.strengthtraining.ui.questions.start;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/questions/start/HeightandWeightAct;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AppUtil2;", "()V", "age", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityHeightandWeightBinding;", "check", "", "getCheck", "()Z", "setCheck", "(Z)V", "check2", "getCheck2", "setCheck2", "height", "targetweight", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "weight", "cmToInches", "", "cm", "inchesToCm", "inches", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_debug"})
public final class HeightandWeightAct extends com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2 {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityHeightandWeightBinding binding;
    private int age = 0;
    private int weight = 0;
    private int targetweight = 0;
    private int height = 0;
    private boolean check = true;
    private boolean check2 = true;
    @org.jetbrains.annotations.NotNull
    private java.lang.String type = "CM";
    
    public HeightandWeightAct() {
        super();
    }
    
    public final boolean getCheck() {
        return false;
    }
    
    public final void setCheck(boolean p0) {
    }
    
    public final boolean getCheck2() {
        return false;
    }
    
    public final void setCheck2(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getType() {
        return null;
    }
    
    public final void setType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final double cmToInches(double cm) {
        return 0.0;
    }
    
    public final double inchesToCm(double inches) {
        return 0.0;
    }
    
    @java.lang.Override
    protected void onStart() {
    }
}