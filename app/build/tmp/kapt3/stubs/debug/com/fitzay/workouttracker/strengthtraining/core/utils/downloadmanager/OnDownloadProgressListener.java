package com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/downloadmanager/OnDownloadProgressListener;", "", "downloadCancel", "", "downloadFail", "error", "", "downloadStart", "downloadedSuccess", "percent", "", "app_debug"})
public abstract interface OnDownloadProgressListener {
    
    public abstract void percent(int percent);
    
    public abstract void downloadStart();
    
    public abstract void downloadedSuccess();
    
    public abstract void downloadFail(@org.jetbrains.annotations.Nullable
    java.lang.String error);
    
    public abstract void downloadCancel();
}