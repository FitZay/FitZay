package com.fitzay.workouttracker.strengthtraining.ui.stepcounter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector;", "", "listener", "Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector$StepListener;", "(Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector$StepListener;)V", "accelRingCounter", "", "accelRingX", "", "accelRingY", "accelRingZ", "lastStepTimeNs", "", "oldVelocityEstimate", "", "velRing", "velRingCounter", "updateAccel", "", "timeNs", "x", "y", "z", "updateAccel$app_debug", "Companion", "StepListener", "app_debug"})
public final class StepDetector {
    private com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepDetector.StepListener listener;
    private int accelRingCounter = 0;
    private final float[] accelRingX = null;
    private final float[] accelRingY = null;
    private final float[] accelRingZ = null;
    private int velRingCounter = 0;
    private final float[] velRing = null;
    private long lastStepTimeNs = 0L;
    private float oldVelocityEstimate = 0.0F;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepDetector.Companion Companion = null;
    private static final int ACCEL_RING_SIZE = 50;
    private static final int VEL_RING_SIZE = 10;
    private static final float STEP_THRESHOLD = 50.0F;
    private static final int STEP_DELAY_NS = 250000000;
    
    public StepDetector(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepDetector.StepListener listener) {
        super();
    }
    
    public final void updateAccel$app_debug(long timeNs, float x, float y, float z) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector$StepListener;", "", "step", "", "timeNs", "", "app_debug"})
    public static abstract interface StepListener {
        
        public abstract void step(long timeNs);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/stepcounter/StepDetector$Companion;", "", "()V", "ACCEL_RING_SIZE", "", "STEP_DELAY_NS", "STEP_THRESHOLD", "", "VEL_RING_SIZE", "dot", "a", "", "b", "norm", "array", "sum", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        private final float sum(float[] array) {
            return 0.0F;
        }
        
        private final float dot(float[] a, float[] b) {
            return 0.0F;
        }
        
        private final float norm(float[] array) {
            return 0.0F;
        }
    }
}