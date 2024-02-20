package com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/core/utils/downloadmanager/Decompress;", "", "()V", "BUFFER_SIZE", "", "TAG", "", "dirChecker", "", "destination", "dir", "unzip", "stream", "Ljava/io/InputStream;", "zipFile", "location", "unzipFromAssets", "context", "Landroid/content/Context;", "app_debug"})
public final class Decompress {
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.Decompress INSTANCE = null;
    private static final int BUFFER_SIZE = 10240;
    private static final java.lang.String TAG = "Decompress";
    
    private Decompress() {
        super();
    }
    
    public final void unzipFromAssets(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String zipFile, @org.jetbrains.annotations.Nullable
    java.lang.String destination) {
    }
    
    public final void unzip(@org.jetbrains.annotations.Nullable
    java.lang.String zipFile, @org.jetbrains.annotations.Nullable
    java.lang.String location) {
    }
    
    public final void unzip(@org.jetbrains.annotations.Nullable
    java.io.InputStream stream, @org.jetbrains.annotations.Nullable
    java.lang.String destination) {
    }
    
    private final void dirChecker(java.lang.String destination, java.lang.String dir) {
    }
}