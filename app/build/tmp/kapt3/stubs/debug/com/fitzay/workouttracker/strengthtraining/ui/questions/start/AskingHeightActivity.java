package com.fitzay.workouttracker.strengthtraining.ui.questions.start;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120 2\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020%H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006*"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/questions/start/AskingHeightActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityAskingHeightBinding;", "checkType", "", "getCheckType", "()Ljava/lang/String;", "setCheckType", "(Ljava/lang/String;)V", "cm", "", "getCm", "()D", "setCm", "(D)V", "ft", "", "getFt", "()I", "setFt", "(I)V", "inch", "getInch", "setInch", "isCM", "", "()Z", "setCM", "(Z)V", "centimeterToFeet", "Lkotlin/Pair;", "centemeter", "feetToCentimeter", "feet", "loadAdaptiveNative", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_debug"})
public final class AskingHeightActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityAskingHeightBinding binding;
    private boolean isCM = true;
    private double cm = 0.0;
    private int ft = 0;
    private double inch = 0.0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String checkType = "CM";
    
    public AskingHeightActivity() {
        super();
    }
    
    public final boolean isCM() {
        return false;
    }
    
    public final void setCM(boolean p0) {
    }
    
    public final double getCm() {
        return 0.0;
    }
    
    public final void setCm(double p0) {
    }
    
    public final int getFt() {
        return 0;
    }
    
    public final void setFt(int p0) {
    }
    
    public final double getInch() {
        return 0.0;
    }
    
    public final void setInch(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCheckType() {
        return null;
    }
    
    public final void setCheckType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String feetToCentimeter(@org.jetbrains.annotations.NotNull
    java.lang.String feet) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Integer, java.lang.Integer> centimeterToFeet(@org.jetbrains.annotations.Nullable
    java.lang.String centemeter) {
        return null;
    }
    
    private final void loadAdaptiveNative() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
}