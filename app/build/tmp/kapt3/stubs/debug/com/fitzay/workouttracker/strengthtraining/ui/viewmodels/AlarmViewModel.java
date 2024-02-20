package com.fitzay.workouttracker.strengthtraining.ui.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u00010*J\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0011Jv\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*J\u000e\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020*J\u000e\u0010I\u001a\u0002072\u0006\u0010<\u001a\u00020\u001eJ\u0014\u0010J\u001a\u0002012\n\b\u0002\u0010K\u001a\u0004\u0018\u000101H\u0002J\u000e\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020\u001aJ\u0016\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u000bJ\u000e\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u0002072\u0006\u0010A\u001a\u00020\u000bJ\u000e\u0010U\u001a\u0002072\u0006\u0010M\u001a\u00020\u001aJ\b\u0010V\u001a\u000207H\u0002Jf\u0010W\u001a\u0002072\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u001e2\u0006\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020\u001e2\u0006\u0010_\u001a\u00020*2\u0006\u0010`\u001a\u00020*Jv\u0010a\u001a\u0002072\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*R3\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001f\u0010\'\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u000b0\u000b0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001c\u00a8\u0006b"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/viewmodels/AlarmViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "alarmRepository", "Lcom/fitzay/workouttracker/strengthtraining/domain/repository/AlarmRepository;", "(Lcom/fitzay/workouttracker/strengthtraining/domain/repository/AlarmRepository;)V", "actionListener", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/ActionLiveData;", "Lkotlin/Pair;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/AlarmAction;", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/UpdateStatus;", "", "getActionListener", "()Lcom/fitzay/workouttracker/strengthtraining/core/utils/ActionLiveData;", "actionListener$delegate", "Lkotlin/Lazy;", "alarm", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "getAlarm", "()Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "setAlarm", "(Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;)V", "getAlarmRepository", "()Lcom/fitzay/workouttracker/strengthtraining/domain/repository/AlarmRepository;", "bedTime", "Landroidx/lifecycle/MutableLiveData;", "Ljava/time/LocalTime;", "getBedTime", "()Landroidx/lifecycle/MutableLiveData;", "count", "", "getCount", "()J", "setCount", "(J)V", "isCreateMode", "()Z", "setCreateMode", "(Z)V", "isVibrationEnabled", "kotlin.jvm.PlatformType", "label", "", "getLabel", "soundUri", "getSoundUri", "wakeTime", "getWakeTime", "weekDays", "Landroid/util/SparseBooleanArray;", "getWeekDays", "convertDate", "dateInMilliseconds", "dateFormat", "deleteAlarm", "", "deleteItem", "item", "generateAlarm", "sleepId", "id", "selectedDay", "alarmTime", "snooze", "vibration", "isEnabled", "dayOfWeek", "", "number", "totalSleepingHr", "date", "getAlamByADay", "day", "getAlamBySleepId", "initWeekDays", "array", "setBedTime", "time", "setSelectedDay", "dayIndex", "isSelected", "setSoundUri", "uri", "Landroid/net/Uri;", "setVibrationEnable", "setWakeTime", "updateAlarm", "updateItem", "currentTime", "alarmLable", "alarmEnable", "alarmVibrate", "alarmBT", "selectedDays", "alarmSnoozeTime", "sleepHr", "alarmDate", "updateOrCreateAlarm", "app_debug"})
public final class AlarmViewModel extends androidx.lifecycle.ViewModel implements androidx.lifecycle.LifecycleObserver {
    @org.jetbrains.annotations.NotNull
    private final com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository alarmRepository = null;
    @org.jetbrains.annotations.Nullable
    private com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity alarm;
    private boolean isCreateMode = true;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy actionListener$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.time.LocalTime> bedTime = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.time.LocalTime> wakeTime = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> label = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> soundUri = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isVibrationEnabled = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<android.util.SparseBooleanArray> weekDays = null;
    private long count = 0L;
    
    public AlarmViewModel(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository alarmRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.repository.AlarmRepository getAlarmRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity getAlarm() {
        return null;
    }
    
    public final void setAlarm(@org.jetbrains.annotations.Nullable
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity p0) {
    }
    
    public final boolean isCreateMode() {
        return false;
    }
    
    public final void setCreateMode(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.core.utils.ActionLiveData<kotlin.Pair<com.fitzay.workouttracker.strengthtraining.core.utils.AlarmAction, com.fitzay.workouttracker.strengthtraining.core.utils.UpdateStatus<java.lang.Boolean>>> getActionListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.time.LocalTime> getBedTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.time.LocalTime> getWakeTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSoundUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isVibrationEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<android.util.SparseBooleanArray> getWeekDays() {
        return null;
    }
    
    public final long getCount() {
        return 0L;
    }
    
    public final void setCount(long p0) {
    }
    
    public final void setBedTime(@org.jetbrains.annotations.NotNull
    java.time.LocalTime time) {
    }
    
    public final void setWakeTime(@org.jetbrains.annotations.NotNull
    java.time.LocalTime time) {
    }
    
    public final void setVibrationEnable(boolean isEnabled) {
    }
    
    public final void setSoundUri(@org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
    }
    
    public final void updateOrCreateAlarm(long sleepId, long id, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDay, long bedTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, @org.jetbrains.annotations.NotNull
    java.lang.String label, long snooze, boolean vibration, boolean isEnabled, int dayOfWeek, int number, @org.jetbrains.annotations.NotNull
    java.lang.String totalSleepingHr, @org.jetbrains.annotations.NotNull
    java.lang.String date) {
    }
    
    public final void setSelectedDay(int dayIndex, boolean isSelected) {
    }
    
    private final void updateAlarm() {
    }
    
    public final void deleteAlarm() {
    }
    
    public final void deleteItem(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity item) {
    }
    
    public final void getAlamBySleepId(long id) {
    }
    
    public final void getAlamByADay(@org.jetbrains.annotations.NotNull
    java.lang.String day) {
    }
    
    public final void updateItem(long sleepId, long currentTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String alarmLable, boolean alarmEnable, boolean alarmVibrate, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, long alarmBT, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDays, long alarmSnoozeTime, @org.jetbrains.annotations.NotNull
    java.lang.String sleepHr, @org.jetbrains.annotations.NotNull
    java.lang.String alarmDate) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String convertDate(@org.jetbrains.annotations.NotNull
    java.lang.String dateInMilliseconds, @org.jetbrains.annotations.Nullable
    java.lang.String dateFormat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity generateAlarm(long sleepId, long id, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDay, long bedTime, long alarmTime, @org.jetbrains.annotations.NotNull
    java.lang.String soundUri, @org.jetbrains.annotations.NotNull
    java.lang.String label, long snooze, boolean vibration, boolean isEnabled, int dayOfWeek, int number, @org.jetbrains.annotations.NotNull
    java.lang.String totalSleepingHr, @org.jetbrains.annotations.NotNull
    java.lang.String date) {
        return null;
    }
    
    private final android.util.SparseBooleanArray initWeekDays(android.util.SparseBooleanArray array) {
        return null;
    }
}