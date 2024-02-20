package com.fitzay.workouttracker.strengthtraining.domain.entities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005B\u0091\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0018J\b\u00105\u001a\u00020$H\u0016J\u0018\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00108\u001a\u00020$H\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001e\"\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010)\"\u0004\b*\u0010+R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001e\u00a8\u0006:"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "sleepId", "", "id", "time", "label", "", "isEnabled", "", "isVibrationEnabled", "soundUri", "allDays", "Landroid/util/SparseBooleanArray;", "bedTime", "selectedDay", "snoozeTime", "totalSleepingHr", "date", "days", "(JJJLjava/lang/String;ZZLjava/lang/String;Landroid/util/SparseBooleanArray;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllDays", "()Landroid/util/SparseBooleanArray;", "getBedTime", "()J", "getDate", "()Ljava/lang/String;", "getDays", "setDays", "(Ljava/lang/String;)V", "getId", "idd", "", "getIdd", "()I", "setIdd", "(I)V", "()Z", "setEnabled", "(Z)V", "getLabel", "getSelectedDay", "getSleepId", "getSnoozeTime", "getSoundUri", "getTime", "setTime", "(J)V", "getTotalSleepingHr", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_debug"})
public final class AlarmEntity implements android.os.Parcelable {
    private final long sleepId = 0L;
    private final long id = 0L;
    private long time;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String label = null;
    private boolean isEnabled;
    private final boolean isVibrationEnabled = false;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String soundUri = null;
    @org.jetbrains.annotations.Nullable
    private final android.util.SparseBooleanArray allDays = null;
    private final long bedTime = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String selectedDay = null;
    private final long snoozeTime = 0L;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String totalSleepingHr = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String date = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String days;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int idd = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity.CREATOR CREATOR = null;
    
    public AlarmEntity(long sleepId, long id, long time, @org.jetbrains.annotations.Nullable
    java.lang.String label, boolean isEnabled, boolean isVibrationEnabled, @org.jetbrains.annotations.Nullable
    java.lang.String soundUri, @org.jetbrains.annotations.Nullable
    android.util.SparseBooleanArray allDays, long bedTime, @org.jetbrains.annotations.Nullable
    java.lang.String selectedDay, long snoozeTime, @org.jetbrains.annotations.Nullable
    java.lang.String totalSleepingHr, @org.jetbrains.annotations.Nullable
    java.lang.String date, @org.jetbrains.annotations.Nullable
    java.lang.String days) {
        super();
    }
    
    public final long getSleepId() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final boolean isEnabled() {
        return false;
    }
    
    public final void setEnabled(boolean p0) {
    }
    
    public final boolean isVibrationEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSoundUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.util.SparseBooleanArray getAllDays() {
        return null;
    }
    
    public final long getBedTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedDay() {
        return null;
    }
    
    public final long getSnoozeTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTotalSleepingHr() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDays() {
        return null;
    }
    
    public final void setDays(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final int getIdd() {
        return 0;
    }
    
    public final void setIdd(int p0) {
    }
    
    public AlarmEntity(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel) {
        super();
    }
    
    public AlarmEntity() {
        super();
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> {
        
        private CREATOR() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity[] newArray(int size) {
            return null;
        }
    }
}