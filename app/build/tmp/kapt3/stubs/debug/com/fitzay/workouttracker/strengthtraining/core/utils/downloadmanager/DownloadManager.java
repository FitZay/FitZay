package com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\'\u0010\r\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000f\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0014J%\u0010\u0016\u001a\u00020\u00122\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u000f\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/downloadmanager/DownloadManager;", "Landroid/os/AsyncTask;", "", "downloadLink", "downloadPath", "onDownloadProgressListener", "Lcom/fitzay/workouttracker/strengthtraining/core/utils/downloadmanager/OnDownloadProgressListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/fitzay/workouttracker/strengthtraining/core/utils/downloadmanager/OnDownloadProgressListener;)V", "fail", "", "fileName", "total", "", "doInBackground", "params", "", "([Ljava/lang/String;)Ljava/lang/String;", "onCancelled", "", "onPostExecute", "file_url", "onPreExecute", "onProgressUpdate", "values", "([Ljava/lang/String;)V", "app_debug"})
public final class DownloadManager extends android.os.AsyncTask<java.lang.String, java.lang.String, java.lang.String> {
    private final java.lang.String downloadLink = null;
    private final java.lang.String downloadPath = null;
    private final com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.OnDownloadProgressListener onDownloadProgressListener = null;
    private long total = 0L;
    private boolean fail = false;
    private final java.lang.String fileName = null;
    
    public DownloadManager(@org.jetbrains.annotations.NotNull
    java.lang.String downloadLink, @org.jetbrains.annotations.NotNull
    java.lang.String downloadPath, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.OnDownloadProgressListener onDownloadProgressListener) {
        super();
    }
    
    @java.lang.Override
    protected void onCancelled() {
    }
    
    @java.lang.Override
    protected void onPreExecute() {
    }
    
    @java.lang.Override
    protected void onProgressUpdate(@org.jetbrains.annotations.NotNull
    java.lang.String... values) {
    }
    
    @java.lang.Override
    protected void onPostExecute(@org.jetbrains.annotations.Nullable
    java.lang.String file_url) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    protected java.lang.String doInBackground(@org.jetbrains.annotations.NotNull
    java.lang.String... params) {
        return null;
    }
}