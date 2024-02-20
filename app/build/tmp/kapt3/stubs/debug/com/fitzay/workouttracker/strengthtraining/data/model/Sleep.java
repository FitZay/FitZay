package com.fitzay.workouttracker.strengthtraining.data.model;

import java.lang.System;

@androidx.room.Entity
@androidx.annotation.Keep
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0017H\u00d6\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\bH\u00d6\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0017H\u0016R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "time", "", "label", "", "(JLjava/lang/String;)V", "id", "getId", "()J", "setId", "(J)V", "getLabel", "()Ljava/lang/String;", "getTime", "setTime", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toDomain", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "toString", "writeToParcel", "", "flags", "CREATOR", "app_debug"})
public final class Sleep implements android.os.Parcelable {
    private long time;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String label = null;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private long id = 0L;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.data.model.Sleep.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.data.model.Sleep copy(long time, @org.jetbrains.annotations.Nullable
    java.lang.String label) {
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
    
    public Sleep(long time, @org.jetbrains.annotations.Nullable
    java.lang.String label) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final void setTime(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLabel() {
        return null;
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    public Sleep(@org.jetbrains.annotations.NotNull
    android.os.Parcel parcel) {
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
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity toDomain() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromDomain", "alarmEntity", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/SleepEntity;", "newArray", "", "size", "", "(I)[Lcom/fitzay/workouttracker/strengthtraining/data/model/Sleep;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.fitzay.workouttracker.strengthtraining.data.model.Sleep> {
        
        private CREATOR() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.fitzay.workouttracker.strengthtraining.data.model.Sleep fromDomain(@org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity alarmEntity) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Sleep createFromParcel(@org.jetbrains.annotations.NotNull
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public com.fitzay.workouttracker.strengthtraining.data.model.Sleep[] newArray(int size) {
            return null;
        }
    }
}