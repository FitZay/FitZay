package com.fitzay.workouttracker.strengthtraining.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\tH\u0017J\u0013\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/ActionLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "observe", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "postAction", "data", "(Ljava/lang/Object;)V", "sendAction", "app_debug"})
public class ActionLiveData<T extends java.lang.Object> extends androidx.lifecycle.MutableLiveData<T> {
    
    public ActionLiveData() {
        super(null);
    }
    
    @androidx.annotation.MainThread
    @java.lang.Override
    public void observe(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.Observer<? super T> observer) {
    }
    
    @androidx.annotation.MainThread
    public final void sendAction(T data) {
    }
    
    public final void postAction(T data) {
    }
}