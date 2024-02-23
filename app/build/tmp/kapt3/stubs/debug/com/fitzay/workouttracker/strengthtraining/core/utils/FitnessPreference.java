package com.fitzay.workouttracker.strengthtraining.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\bA\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010\r\"\u0004\b(\u0010\u000fR$\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR$\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010\tR\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR$\u00108\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR$\u0010;\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010\u001c\"\u0004\b=\u0010\u001eR$\u0010>\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010\u0015R$\u0010A\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR0\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0D2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0D8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010J\u001a\u00020\n2\u0006\u0010J\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000fR$\u0010N\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020M8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR$\u0010S\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R$\u0010V\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020M8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR$\u0010Y\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015R$\u0010\\\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R$\u0010_\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b`\u0010\r\"\u0004\ba\u0010\u000fR$\u0010b\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015R$\u0010e\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bf\u0010\u0013\"\u0004\bg\u0010\u0015R$\u0010h\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bi\u0010\r\"\u0004\bj\u0010\u000fR$\u0010k\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bl\u0010\u0013\"\u0004\bm\u0010\u0015R$\u0010n\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bo\u0010\u0013\"\u0004\bp\u0010\u0015R$\u0010q\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\br\u0010\u0013\"\u0004\bs\u0010\u0015R$\u0010t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bu\u0010\r\"\u0004\bv\u0010\u000fR$\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bw\u0010\r\"\u0004\bx\u0010\u000fR$\u0010y\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bz\u0010\r\"\u0004\b{\u0010\u000fR$\u0010|\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b}\u0010\r\"\u0004\b~\u0010\u000fR&\u0010\u007f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u0013\"\u0005\b\u0081\u0001\u0010\u0015R\'\u0010\u0082\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0083\u0001\u0010\u0013\"\u0005\b\u0084\u0001\u0010\u0015R\'\u0010\u0085\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010\r\"\u0005\b\u0087\u0001\u0010\u000fR\'\u0010\u0088\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010\r\"\u0005\b\u008a\u0001\u0010\u000fR(\u0010\u008b\u0001\u001a\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u00118F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010\u0013\"\u0005\b\u008d\u0001\u0010\u0015\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/FitnessPreference;", "", "()V", "value", "", "alarmOnOff", "getAlarmOnOff", "()Z", "setAlarmOnOff", "(Z)V", "", "bedTime", "getBedTime", "()Ljava/lang/String;", "setBedTime", "(Ljava/lang/String;)V", "cupCapacity", "", "getCupCapacity", "()I", "setCupCapacity", "(I)V", "currentDate", "getCurrentDate", "setCurrentDate", "currentProgress", "", "getCurrentProgress", "()F", "setCurrentProgress", "(F)V", "editor", "Landroid/content/SharedPreferences$Editor;", "getEditor", "()Landroid/content/SharedPreferences$Editor;", "setEditor", "(Landroid/content/SharedPreferences$Editor;)V", "userName", "fitzayConfig", "getFitzayConfig", "setFitzayConfig", "isFitnessTour", "setFitnessTour", "isIntro", "setIntro", "isPaused", "setPaused", "prefernece", "Landroid/content/SharedPreferences;", "getPrefernece", "()Landroid/content/SharedPreferences;", "setPrefernece", "(Landroid/content/SharedPreferences;)V", "recentExerciseCategory", "getRecentExerciseCategory", "setRecentExerciseCategory", "recentExerciseName", "getRecentExerciseName", "setRecentExerciseName", "recentExercisePercentage", "getRecentExercisePercentage", "setRecentExercisePercentage", "saveDailyGoal", "getSaveDailyGoal", "setSaveDailyGoal", "saveWater", "getSaveWater", "setSaveWater", "", "selectedDays", "getSelectedDays", "()Ljava/util/Set;", "setSelectedDays", "(Ljava/util/Set;)V", "selectedLang", "getSelectedLang", "setSelectedLang", "", "stepCalories", "getStepCalories", "()D", "setStepCalories", "(D)V", "stepCount", "getStepCount", "setStepCount", "stepDistance", "getStepDistance", "setStepDistance", "stepGoal", "getStepGoal", "setStepGoal", "stepProgress", "getStepProgress", "setStepProgress", "stepTime", "getStepTime", "setStepTime", "totalDrink", "getTotalDrink", "setTotalDrink", "userAge", "getUserAge", "setUserAge", "userGender", "getUserGender", "setUserGender", "userHeight", "getUserHeight", "setUserHeight", "userHeightFt", "getUserHeightFt", "setUserHeightFt", "userHeightInch", "getUserHeightInch", "setUserHeightInch", "userHeightType", "getUserHeightType", "setUserHeightType", "getUserName", "setUserName", "userProfilePath", "getUserProfilePath", "setUserProfilePath", "userTargetWeightType", "getUserTargetWeightType", "setUserTargetWeightType", "userTargetWight", "getUserTargetWight", "setUserTargetWight", "userWeight", "getUserWeight", "setUserWeight", "userWeightType", "getUserWeightType", "setUserWeightType", "wakeTime", "getWakeTime", "setWakeTime", "waterGoal", "getWaterGoal", "setWaterGoal", "app_debug"})
public final class FitnessPreference {
    @org.jetbrains.annotations.NotNull
    private android.content.SharedPreferences.Editor editor;
    @org.jetbrains.annotations.NotNull
    private android.content.SharedPreferences prefernece;
    
    public FitnessPreference() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences.Editor getEditor() {
        return null;
    }
    
    public final void setEditor(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences.Editor p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences getPrefernece() {
        return null;
    }
    
    public final void setPrefernece(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getFitzayConfig() {
        return null;
    }
    
    public final void setFitzayConfig(@org.jetbrains.annotations.Nullable
    java.lang.String userName) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Set<java.lang.String> getSelectedDays() {
        return null;
    }
    
    public final void setSelectedDays(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> value) {
    }
    
    public final boolean isFitnessTour() {
        return false;
    }
    
    public final void setFitnessTour(boolean value) {
    }
    
    public final boolean isIntro() {
        return false;
    }
    
    public final void setIntro(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecentExerciseCategory() {
        return null;
    }
    
    public final void setRecentExerciseCategory(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    public final void setCurrentDate(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRecentExerciseName() {
        return null;
    }
    
    public final void setRecentExerciseName(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final float getRecentExercisePercentage() {
        return 0.0F;
    }
    
    public final void setRecentExercisePercentage(float value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserProfilePath() {
        return null;
    }
    
    public final void setUserProfilePath(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserGender() {
        return null;
    }
    
    public final void setUserGender(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserHeightType() {
        return null;
    }
    
    public final void setUserHeightType(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserWeightType() {
        return null;
    }
    
    public final void setUserWeightType(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserTargetWeightType() {
        return null;
    }
    
    public final void setUserTargetWeightType(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final int getUserAge() {
        return 0;
    }
    
    public final void setUserAge(int value) {
    }
    
    public final int getUserHeight() {
        return 0;
    }
    
    public final void setUserHeight(int value) {
    }
    
    public final int getUserHeightFt() {
        return 0;
    }
    
    public final void setUserHeightFt(int value) {
    }
    
    public final int getUserHeightInch() {
        return 0;
    }
    
    public final void setUserHeightInch(int value) {
    }
    
    public final int getUserWeight() {
        return 0;
    }
    
    public final void setUserWeight(int value) {
    }
    
    public final int getUserTargetWight() {
        return 0;
    }
    
    public final void setUserTargetWight(int value) {
    }
    
    public final int getTotalDrink() {
        return 0;
    }
    
    public final void setTotalDrink(int totalDrink) {
    }
    
    public final int getCupCapacity() {
        return 0;
    }
    
    public final void setCupCapacity(int cupCapacity) {
    }
    
    public final int getWaterGoal() {
        return 0;
    }
    
    public final void setWaterGoal(int waterGoal) {
    }
    
    public final float getCurrentProgress() {
        return 0.0F;
    }
    
    public final void setCurrentProgress(float currentProgress) {
    }
    
    public final float getSaveWater() {
        return 0.0F;
    }
    
    public final void setSaveWater(float value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedLang() {
        return null;
    }
    
    public final void setSelectedLang(@org.jetbrains.annotations.NotNull
    java.lang.String selectedLang) {
    }
    
    public final int getStepCount() {
        return 0;
    }
    
    public final void setStepCount(int value) {
    }
    
    public final boolean isPaused() {
        return false;
    }
    
    public final void setPaused(boolean value) {
    }
    
    public final boolean getAlarmOnOff() {
        return false;
    }
    
    public final void setAlarmOnOff(boolean value) {
    }
    
    public final int getSaveDailyGoal() {
        return 0;
    }
    
    public final void setSaveDailyGoal(int value) {
    }
    
    public final int getStepGoal() {
        return 0;
    }
    
    public final void setStepGoal(int value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getStepTime() {
        return null;
    }
    
    public final void setStepTime(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWakeTime() {
        return null;
    }
    
    public final void setWakeTime(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBedTime() {
        return null;
    }
    
    public final void setBedTime(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final double getStepCalories() {
        return 0.0;
    }
    
    public final void setStepCalories(double value) {
    }
    
    public final double getStepDistance() {
        return 0.0;
    }
    
    public final void setStepDistance(double value) {
    }
    
    public final int getStepProgress() {
        return 0;
    }
    
    public final void setStepProgress(int value) {
    }
}