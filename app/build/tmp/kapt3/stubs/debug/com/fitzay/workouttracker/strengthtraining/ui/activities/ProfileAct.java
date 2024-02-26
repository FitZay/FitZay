package com.fitzay.workouttracker.strengthtraining.ui.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!J\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020;H\u0002J\u000e\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020!J\u000e\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!J\u000e\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020!J\u0010\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0010\u0010E\u001a\u00020;2\u0006\u0010&\u001a\u00020\'H\u0002J\"\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\u00172\b\u0010I\u001a\u0004\u0018\u000100H\u0014J\u0012\u0010J\u001a\u00020;2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J-\u0010M\u001a\u00020;2\u0006\u0010G\u001a\u00020\u00172\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040O2\u0006\u0010P\u001a\u00020QH\u0016\u00a2\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020;2\u0006\u0010T\u001a\u00020\u0017H\u0002J\u0012\u0010U\u001a\u0004\u0018\u00010\u00042\u0006\u0010V\u001a\u00020\'H\u0002J\b\u0010W\u001a\u00020;H\u0002J\b\u0010X\u001a\u00020;H\u0002J\b\u0010Y\u001a\u00020;H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R\u001a\u0010+\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R(\u0010.\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u000100000/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006Z"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/activities/ProfileAct;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/ActivityProfileBinding;", "check", "", "getCheck", "()Z", "setCheck", "(Z)V", "check2", "getCheck2", "setCheck2", "check3", "getCheck3", "setCheck3", "check4", "getCheck4", "setCheck4", "choicer", "", "convertCentiToFtInch_1st", "getConvertCentiToFtInch_1st", "()I", "setConvertCentiToFtInch_1st", "(I)V", "convertCentiToFtInch_2nd", "getConvertCentiToFtInch_2nd", "setConvertCentiToFtInch_2nd", "convertFtInchToCentiMeter", "", "getConvertFtInchToCentiMeter", "()D", "setConvertFtInchToCentiMeter", "(D)V", "imageBitmap", "Landroid/graphics/Bitmap;", "kgToP", "getKgToP", "setKgToP", "pToKg", "getPToKg", "setPToKg", "resultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setResultLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "selectedImageUri", "Landroid/net/Uri;", "cmToInches", "cm", "disableBtn", "", "goToSettings", "inchesToCm", "inches", "kgToLbs", "kg", "lbsToKg", "lbs", "loadBannerAds", "adunit", "loadImage", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openChoiceToUser", "isGalleryOrCamera", "saveUserProfilePic", "bitmap", "showBothSelectorDialog", "showSettingsDialog", "showToast", "app_debug"})
public final class ProfileAct extends androidx.appcompat.app.AppCompatActivity {
    private com.fitzay.workouttracker.strengthtraining.databinding.ActivityProfileBinding binding;
    private android.graphics.Bitmap imageBitmap;
    private android.net.Uri selectedImageUri;
    private int choicer = -1;
    private final java.lang.String TAG = "Profile";
    private double convertFtInchToCentiMeter = 0.0;
    private int convertCentiToFtInch_1st = 0;
    private int convertCentiToFtInch_2nd = 0;
    private double kgToP = 0.0;
    private double pToKg = 0.0;
    private boolean check = true;
    private boolean check2 = true;
    private boolean check3 = true;
    private boolean check4 = true;
    @org.jetbrains.annotations.NotNull
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> resultLauncher;
    
    public ProfileAct() {
        super();
    }
    
    public final double getConvertFtInchToCentiMeter() {
        return 0.0;
    }
    
    public final void setConvertFtInchToCentiMeter(double p0) {
    }
    
    public final int getConvertCentiToFtInch_1st() {
        return 0;
    }
    
    public final void setConvertCentiToFtInch_1st(int p0) {
    }
    
    public final int getConvertCentiToFtInch_2nd() {
        return 0;
    }
    
    public final void setConvertCentiToFtInch_2nd(int p0) {
    }
    
    public final double getKgToP() {
        return 0.0;
    }
    
    public final void setKgToP(double p0) {
    }
    
    public final double getPToKg() {
        return 0.0;
    }
    
    public final void setPToKg(double p0) {
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
    
    public final boolean getCheck3() {
        return false;
    }
    
    public final void setCheck3(boolean p0) {
    }
    
    public final boolean getCheck4() {
        return false;
    }
    
    public final void setCheck4(boolean p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void disableBtn() {
    }
    
    private final void openChoiceToUser(int isGalleryOrCamera) {
    }
    
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void showSettingsDialog() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getResultLauncher() {
        return null;
    }
    
    public final void setResultLauncher(@org.jetbrains.annotations.NotNull
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    private final void showToast() {
    }
    
    private final void goToSettings() {
    }
    
    private final void loadImage(android.graphics.Bitmap imageBitmap) {
    }
    
    private final void showBothSelectorDialog() {
    }
    
    private final java.lang.String saveUserProfilePic(android.graphics.Bitmap bitmap) {
        return null;
    }
    
    private final void loadBannerAds(java.lang.String adunit) {
    }
    
    public final double cmToInches(double cm) {
        return 0.0;
    }
    
    public final double inchesToCm(double inches) {
        return 0.0;
    }
    
    public final double lbsToKg(double lbs) {
        return 0.0;
    }
    
    public final double kgToLbs(double kg) {
        return 0.0;
    }
}