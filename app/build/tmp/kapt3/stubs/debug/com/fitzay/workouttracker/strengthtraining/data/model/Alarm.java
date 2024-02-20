package com.fitzay.workouttracker.strengthtraining.data.model;

import java.lang.System;

@androidx.room.Entity
@androidx.annotation.Keep
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u0016J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u00102\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u00105\u001a\u00020\u0006H\u00c6\u0003J\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\fH\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\u0097\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\b\u0010>\u001a\u00020\u001fH\u0016J\u0013\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010AH\u00d6\u0003J\u0006\u0010B\u001a\u00020\nJ\b\u0010C\u001a\u00020\u001fH\u0002J\b\u0010D\u001a\u00020\u001fH\u0002J\u0006\u0010E\u001a\u00020\u001fJ\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020\fJ\t\u0010J\u001a\u00020\u001fH\u00d6\u0001J\u0006\u0010K\u001a\u00020LJ\t\u0010M\u001a\u00020\nH\u00d6\u0001J\u0018\u0010N\u001a\u00020O2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u001fH\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010$\"\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010$R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010.R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001c\u00a8\u0006R"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Alarm;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sleepId", "", "id", "time", "label", "", "isEnabled", "", "isVibrationEnabled", "soundUri", "allDays", "Landroid/util/SparseBooleanArray;", "bedTime", "selectedDay", "snoozeTime", "totalSleepingHr", "date", "(JJJLjava/lang/String;ZZLjava/lang/String;Landroid/util/SparseBooleanArray;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAllDays", "()Landroid/util/SparseBooleanArray;", "getBedTime", "()J", "getDate", "()Ljava/lang/String;", "getId", "idd", "", "getIdd", "()I", "setIdd", "(I)V", "()Z", "setEnabled", "(Z)V", "getLabel", "getSelectedDay", "getSleepId", "getSnoozeTime", "getSoundUri", "getTime", "setTime", "(J)V", "getTotalSleepingHr", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getDescription", "getHours", "getMinutes", "getNotificationId", "getTimeDisplay", "getTimeForNextAlarm", "Ljava/util/Calendar;", "hasDayAlarm", "hashCode", "toDomain", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "toString", "writeToParcel", "", "flags", "CREATOR", "app_debug"})
public final class Alarm implements android.os.Parcelable {
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
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int idd = 0;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.data.model.Alarm.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.data.model.Alarm copy(long sleepId, long id, long time, @org.jetbrains.annotations.Nullable
    java.lang.String label, boolean isEnabled, boolean isVibrationEnabled, @org.jetbrains.annotations.Nullable
    java.lang.String soundUri, @org.jetbrains.annotations.Nullable
    android.util.SparseBooleanArray allDays, long bedTime, @org.jetbrains.annotations.Nullable
    java.lang.String selectedDay, long snoozeTime, @org.jetbrains.annotations.Nullable
    java.lang.String totalSleepingHr, @org.jetbrains.annotations.Nullable
    java.lang.String date) {
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
    
    public Alarm(long sleepId, long id, long time, @org.jetbrains.annotations.Nullable
    java.lang.String label, boolean isEnabled, boolean isVibrationEnabled, @org.jetbrains.annotations.Nullable
    java.lang.String soundUri, @org.jetbrains.annotations.Nullable
    android.util.SparseBooleanArray allDays, long bedTime, @org.jetbrains.annotations.Nullable
    java.lang.String selectedDay, long snoozeTime, @org.jetbrains.annotations.Nullable
    java.lang.String totalSleepingHr, @org.jetbrains.annotations.Nullable
    java.lang.String date) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getSleepId() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean isEnabled() {
        return false;
    }
    
    public final void setEnabled(boolean p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean isVibrationEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSoundUri() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.util.SparseBooleanArray component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.util.SparseBooleanArray getAllDays() {
        return null;
    }
    
    public final long component9() {
        return 0L;
    }
    
    public final long getBedTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedDay() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final long getSnoozeTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTotalSleepingHr() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDate() {
        return null;
    }
    
    public final int getIdd() {
        return 0;
    }
    
    public final void setIdd(int p0) {
    }
    
    public Alarm(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel) {
        super();
    }
    
    /**
     * return string. ex. 12:00
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimeDisplay() {
        return null;
    }
    
    public final int getNotificationId() {
        return 0;
    }
    
    public final boolean hasDayAlarm() {
        return false;
    }
    
    private final int getHours() {
        return 0;
    }
    
    private final int getMinutes() {
        return 0;
    }
    
    /**
     * return the calendar of next alarm
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.Calendar getTimeForNextAlarm() {
        return null;
    }
    
    /**
     * return: label, Mon Tue ...
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDescription() {
        return null;
    }
    
    @java.lang.Override
    public void writeToParcel(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override
    public int describeContents() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity toDomain() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Alarm$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Alarm;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromDomain", "alarmEntity", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "newArray", "", "size", "", "(I)[Lcom/fitzay/workouttracker/strengthtraining/data/model/Alarm;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.fitzay.workouttracker.strengthtraining.data.model.Alarm> {
        
        private CREATOR() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.fitzay.workouttracker.strengthtraining.data.model.Alarm fromDomain(@org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarmEntity) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Alarm createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Alarm[] newArray(int size) {
            return null;
        }
    }
}