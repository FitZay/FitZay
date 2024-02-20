package com.fitzay.workouttracker.strengthtraining.data.model;

import java.lang.System;

@androidx.room.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BS\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010$\u001a\u00020\nH\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bH\u00c6\u0003Ji\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\b\u0010,\u001a\u00020\u0006H\u0016J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0006H\u00d6\u0001J\u0006\u00102\u001a\u000203J\t\u00104\u001a\u00020\bH\u00d6\u0001J\u0018\u00105\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u0006H\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001e\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016\u00a8\u00069"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Step;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "steps", "", "time", "", "calories", "", "distance", "date", "stepGoal", "caloriesGoal", "distanceGoal", "timeGoal", "(ILjava/lang/String;DDLjava/lang/String;IDDLjava/lang/String;)V", "getCalories", "()D", "getCaloriesGoal", "getDate", "()Ljava/lang/String;", "getDistance", "getDistanceGoal", "id", "getId", "()I", "setId", "(I)V", "getStepGoal", "getSteps", "getTime", "getTimeGoal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toDomain", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/StepEntity;", "toString", "writeToParcel", "", "flags", "CREATOR", "app_debug"})
public final class Step implements android.os.Parcelable {
    private final int steps = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String time = null;
    private final double calories = 0.0;
    private final double distance = 0.0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String date = null;
    private final int stepGoal = 0;
    private final double caloriesGoal = 0.0;
    private final double distanceGoal = 0.0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String timeGoal = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.data.model.Step.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.data.model.Step copy(int steps, @org.jetbrains.annotations.Nullable
    java.lang.String time, double calories, double distance, @org.jetbrains.annotations.Nullable
    java.lang.String date, int stepGoal, double caloriesGoal, double distanceGoal, @org.jetbrains.annotations.Nullable
    java.lang.String timeGoal) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Step(int steps, @org.jetbrains.annotations.Nullable
    java.lang.String time, double calories, double distance, @org.jetbrains.annotations.Nullable
    java.lang.String date, int stepGoal, double caloriesGoal, double distanceGoal, @org.jetbrains.annotations.Nullable
    java.lang.String timeGoal) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getSteps() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTime() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double getCalories() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double getDistance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDate() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getStepGoal() {
        return 0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getCaloriesGoal() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double getDistanceGoal() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTimeGoal() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public Step(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel) {
        super();
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity toDomain() {
        return null;
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Step$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Step;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromDomain", "stepEntity", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/StepEntity;", "newArray", "", "size", "", "(I)[Lcom/fitzay/workouttracker/strengthtraining/data/model/Step;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.fitzay.workouttracker.strengthtraining.data.model.Step> {
        
        private CREATOR() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.fitzay.workouttracker.strengthtraining.data.model.Step fromDomain(@org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity stepEntity) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Step createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Step[] newArray(int size) {
            return null;
        }
    }
}