package com.fitzay.workouttracker.strengthtraining.core.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\u00c0\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010+\u001a\u00020,\u001a\u0006\u0010-\u001a\u00020.\u001a\u0006\u0010/\u001a\u00020.\u001a\u0006\u00100\u001a\u000201\u001a\u0018\u00102\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0007H\u0002\u001a\u0010\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0001H\u0002\u001a\u0016\u00108\u001a\u00020\u00072\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010:H\u0002\u001a\u000e\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0001\u001a\u0015\u0010=\u001a\u0004\u0018\u00010\u00012\u0006\u0010>\u001a\u00020\u0007\u00a2\u0006\u0002\u0010?\u001a\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0001H\u0002\u001a\u000e\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u0007\u001a\u000e\u0010D\u001a\u00020 2\u0006\u0010C\u001a\u00020\u0007\u001a\u000e\u0010E\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0007\u001a\u000e\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u001c\u001a\u000e\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u001c\u001a\u0010\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u0010K\u001a\u00020\u0001\u001a\'\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020N2\u0012\u0010O\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0017\"\u00020\u0007\u00a2\u0006\u0002\u0010P\u001a\u0006\u0010Q\u001a\u00020,\u001a\u000e\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c\u001a\u000e\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001c\u001a\u0006\u0010V\u001a\u00020\u0007\u001a\u000e\u0010W\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020\u001c\u001a\u0016\u0010Y\u001a\u00020.2\u0006\u0010Z\u001a\u0002012\u0006\u0010[\u001a\u00020\u0007\u001a\u0010\u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]*\u00020N\u001a\"\u0010_\u001a\u00020.*\u00020`2\b\b\u0002\u0010a\u001a\u00020 2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020.0c\u001a\u001c\u0010d\u001a\u00020\u0007*\u00020N2\u0006\u0010e\u001a\u00020\u00072\b\u0010f\u001a\u0004\u0018\u00010\u0007\u001a\u001e\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010h*\u00020N2\u0006\u0010i\u001a\u00020j\u001a\u0011\u0010k\u001a\u0004\u0018\u00010\u001c*\u00020\u0007\u00a2\u0006\u0002\u0010l\u001a\u0012\u0010m\u001a\u00020 *\u00020N2\u0006\u0010n\u001a\u00020\u0007\u001a\u001e\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010h*\u00020N2\u0006\u0010n\u001a\u00020\u0007\u001a\f\u0010p\u001a\u00020\u0001*\u0004\u0018\u00010\u0007\u001a\f\u0010q\u001a\u00020.*\u00020NH\u0002\u001a@\u0010r\u001a\u00020s\"\u0004\b\u0000\u0010t*\u00020u2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020.0c2\f\u0010w\u001a\b\u0012\u0004\u0012\u0002Ht0c2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002Ht\u0012\u0004\u0012\u00020.0y\u001a\u0010\u0010z\u001a\b\u0012\u0004\u0012\u00020{0]*\u00020N\u001a\u001c\u0010|\u001a\u00020\u0007*\u00020N2\u0006\u0010}\u001a\u00020 2\b\u0010f\u001a\u0004\u0018\u00010\u0007\u001a\n\u0010~\u001a\u00020 *\u00020N\u001a \u0010\u007f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010h*\u00020N2\u0006\u0010>\u001a\u00020\u0007\u001a\u0013\u0010\u0080\u0001\u001a\u00020\u0007*\u00020N2\u0006\u0010>\u001a\u00020\u0007\u001a\u0016\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007*\u00020N2\u0007\u0010\u0082\u0001\u001a\u00020\u0007\u001a\u0014\u0010\u0083\u0001\u001a\u00020\u0007*\u00020N2\u0007\u0010\u0084\u0001\u001a\u00020\u0001\u001a\u0014\u0010\u0085\u0001\u001a\u00020\u0007*\u00020N2\u0007\u0010\u0084\u0001\u001a\u00020\u0001\u001a\u000b\u0010\u0086\u0001\u001a\u00020\u0007*\u00020N\u001a\u0012\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0088\u00010]*\u00020N\u001a\u0012\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010]*\u00020N\u001a\u000b\u0010\u008b\u0001\u001a\u00020\u0007*\u00020N\u001a\u000b\u0010\u008c\u0001\u001a\u00020\u0001*\u00020\u001c\u001a\u0014\u0010\u008d\u0001\u001a\u00020.*\u00020N2\u0007\u0010\u008e\u0001\u001a\u00020\u0007\u001a\f\u0010\u008f\u0001\u001a\u00030\u0090\u0001*\u00020N\u001a\u0017\u0010\u0091\u0001\u001a\u00020\u001c*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001c0h\u001a\u0017\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001c0h*\u00020\u001c\u001a\u000b\u0010\u0093\u0001\u001a\u00020\u001c*\u00020\u001c\u001a\u000b\u0010\u0094\u0001\u001a\u00020\u001c*\u00020\u001c\u001a\u0012\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010]*\u00020N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006\u0097\u0001"}, d2 = {"ALL_PERMISSIONS_CAMERA", "", "ALL_PERMISSIONS_GALLERY", "BUFFER_SIZE", "CAMERA_PERMISSION_REQUEST_CODE", "CAMERA_REQUEST_CODE", "FITNESS_ACTION_PAUSE_STEP_COUNTING", "", "FITNESS_ACTION_RESUME_STEP_COUNTING", "FITNESS_ACTION_STEP_COUNT", "FITNESS_EXTRA_BURNED_CALORIES", "FITNESS_EXTRA_BURNED_CALORIES_GOAL", "FITNESS_EXTRA_DISTANCE", "FITNESS_EXTRA_DISTANCE_GOAL", "FITNESS_EXTRA_STEP_COUNT", "FITNESS_EXTRA_TIME", "FITNESS_EXTRA_TIME_GOAL", "GALLERY_PERMISSION_REQUEST_CODE", "GALLERY_REQUEST_CODE", "KEY_ALARM", "KEY_BUNDLE_ALARM", "LOG_TAG", "MAKE_PERMISSIONS", "", "getMAKE_PERMISSIONS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "METERS_IN_MILE", "", "NOTIFICATION_CHANNEL_ID", "STEP_COUNTER_NOTIFICATION_ID", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "lineChartToolTipFormat", "Ljava/text/SimpleDateFormat;", "getLineChartToolTipFormat", "()Ljava/text/SimpleDateFormat;", "setLineChartToolTipFormat", "(Ljava/text/SimpleDateFormat;)V", "checkForInternet", "", "decrypt", "", "encrypt", "exercisePath", "Ljava/io/File;", "extractFile", "inputStream", "Ljava/io/InputStream;", "destFilePath", "formatDuration", "duration", "formatSelectedDays", "days", "", "formatTime", "seconds", "getDayIndex", "dateString", "(Ljava/lang/String;)Ljava/lang/Integer;", "getDayName", "dayOfWeek", "getFitzayRemoteBoolean", "remoteKey", "getFitzayRemoteLong", "getFitzayRemoteString", "getFormattedCalories", "calories", "getFormattedDistance", "distance", "getWeekDayWithDateA", "position", "hasPermissions", "context", "Landroid/content/Context;", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isLocationPermissionAllowed", "metersToMiles", "meters", "milesToMeters", "miles", "pathExerciseMen", "poundsToKilograms", "pounds", "unzip", "zipFilePath", "destDirectory", "categories", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/CategoriesModel;", "clickWithThrottle", "Landroid/view/View;", "throttleTime", "action", "Lkotlin/Function0;", "convertDateTime", "dateInMilliseconds", "dateFormat", "convertDecimalToHoursMinutes", "Lkotlin/Pair;", "decimalHours", "", "convertStringToDouble", "(Ljava/lang/String;)Ljava/lang/Double;", "convertTimeToMilliseconds", "timeString", "convertTimeToMillisecondsHrAndMin", "convertTimeToSeconds", "downloadStart", "executeAsyncTask", "Lkotlinx/coroutines/Job;", "R", "Lkotlinx/coroutines/CoroutineScope;", "onPreExecute", "doInBackground", "onPostExecute", "Lkotlin/Function1;", "fullcategoriesbegginer", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/FullbodyCategoriesModel;", "getDate", "milliSeconds", "getDateInMillis", "getDayNameAndValue", "getDayOfWeek", "getJsonDataFromAsset", "fileName", "getLongDayName", "dayNumber", "getShortDayName", "getSimpleDate", "listRingtones", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/RingTone;", "motivationQuotes", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/QuotesModel;", "pathExerciseWomen", "roundToNearestWhole", "showToast", "message", "systemDefaultAlarmTone", "Landroid/net/Uri;", "toCentimeters", "toFeetAndInches", "toKilograms", "toPounds", "workOuts", "Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "app_debug"})
public final class ExtentionKt {
    public static final int STEP_COUNTER_NOTIFICATION_ID = 1001;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String NOTIFICATION_CHANNEL_ID = "step_counter_channel";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_ALARM = "alarm";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String KEY_BUNDLE_ALARM = "bundle_alarm";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String LOG_TAG = "Alarm";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_ACTION_STEP_COUNT = "ACTION_STEP_COUNT";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_STEP_COUNT = "extra_step_count";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_DISTANCE = "extra_distance";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_DISTANCE_GOAL = "extra_distance_goal";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_TIME = "extra_time";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_TIME_GOAL = "extra_time_goal";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_BURNED_CALORIES = "extra_burned_calories";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_EXTRA_BURNED_CALORIES_GOAL = "extra_burned_calories_goal";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_ACTION_PAUSE_STEP_COUNTING = "ACTION_PAUSE_STEP_COUNTING";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String FITNESS_ACTION_RESUME_STEP_COUNTING = "ACTION_RESUME_STEP_COUNTING";
    public static final int BUFFER_SIZE = 4096;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 1001;
    public static final int GALLERY_PERMISSION_REQUEST_CODE = 1002;
    public static final int CAMERA_REQUEST_CODE = 1003;
    public static final int GALLERY_REQUEST_CODE = 1004;
    public static final int ALL_PERMISSIONS_CAMERA = 111;
    public static final int ALL_PERMISSIONS_GALLERY = 222;
    public static final double METERS_IN_MILE = 1609.344;
    private static long lastClickTime = 0L;
    @org.jetbrains.annotations.NotNull
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    private static java.text.SimpleDateFormat lineChartToolTipFormat;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] MAKE_PERMISSIONS = null;
    
    public static final double metersToMiles(double meters) {
        return 0.0;
    }
    
    public static final double milesToMeters(double miles) {
        return 0.0;
    }
    
    public static final double toKilograms(double $this$toKilograms) {
        return 0.0;
    }
    
    public static final double toPounds(double $this$toPounds) {
        return 0.0;
    }
    
    public static final int roundToNearestWhole(double $this$roundToNearestWhole) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Double convertStringToDouble(@org.jetbrains.annotations.NotNull
    java.lang.String $this$convertStringToDouble) {
        return null;
    }
    
    public static final long getLastClickTime() {
        return 0L;
    }
    
    public static final void setLastClickTime(long p0) {
    }
    
    public static final void clickWithThrottle(@org.jetbrains.annotations.NotNull
    android.view.View $this$clickWithThrottle, long throttleTime, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final kotlin.Pair<java.lang.Integer, java.lang.Double> toFeetAndInches(double $this$toFeetAndInches) {
        return null;
    }
    
    public static final double toCentimeters(@org.jetbrains.annotations.NotNull
    kotlin.Pair<java.lang.Integer, java.lang.Double> $this$toCentimeters) {
        return 0.0;
    }
    
    public static final boolean getFitzayRemoteBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String remoteKey) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getFitzayRemoteString(@org.jetbrains.annotations.NotNull
    java.lang.String remoteKey) {
        return null;
    }
    
    public static final long getFitzayRemoteLong(@org.jetbrains.annotations.NotNull
    java.lang.String remoteKey) {
        return 0L;
    }
    
    public static final boolean checkForInternet() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.text.SimpleDateFormat getLineChartToolTipFormat() {
        return null;
    }
    
    public static final void setLineChartToolTipFormat(@org.jetbrains.annotations.NotNull
    java.text.SimpleDateFormat p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String getWeekDayWithDateA(int position) {
        return null;
    }
    
    public static final double poundsToKilograms(double pounds) {
        return 0.0;
    }
    
    public static final int convertTimeToSeconds(@org.jetbrains.annotations.Nullable
    java.lang.String $this$convertTimeToSeconds) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String[] getMAKE_PERMISSIONS() {
        return null;
    }
    
    public static final boolean isLocationPermissionAllowed() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatTime(int seconds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.io.File exercisePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String pathExerciseMen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String pathExerciseWomen(@org.jetbrains.annotations.NotNull
    android.content.Context $this$pathExerciseWomen) {
        return null;
    }
    
    public static final long convertTimeToMilliseconds(@org.jetbrains.annotations.NotNull
    android.content.Context $this$convertTimeToMilliseconds, @org.jetbrains.annotations.NotNull
    java.lang.String timeString) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final kotlin.Pair<java.lang.Integer, java.lang.Integer> convertTimeToMillisecondsHrAndMin(@org.jetbrains.annotations.NotNull
    android.content.Context $this$convertTimeToMillisecondsHrAndMin, @org.jetbrains.annotations.NotNull
    java.lang.String timeString) {
        return null;
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class, java.security.NoSuchAlgorithmException.class, javax.crypto.NoSuchPaddingException.class, java.security.InvalidKeyException.class})
    public static final void encrypt() throws java.io.IOException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException {
    }
    
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class, java.security.NoSuchAlgorithmException.class, javax.crypto.NoSuchPaddingException.class, java.security.InvalidKeyException.class})
    public static final void decrypt() throws java.io.IOException, java.security.NoSuchAlgorithmException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException {
    }
    
    public static final void unzip(@org.jetbrains.annotations.NotNull
    java.io.File zipFilePath, @org.jetbrains.annotations.NotNull
    java.lang.String destDirectory) {
    }
    
    private static final void extractFile(java.io.InputStream inputStream, java.lang.String destFilePath) {
    }
    
    public static final boolean hasPermissions(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String... permissions) {
        return false;
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.String getJsonDataFromAsset(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getJsonDataFromAsset, @org.jetbrains.annotations.NotNull
    java.lang.String fileName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel> workOuts(@org.jetbrains.annotations.NotNull
    android.content.Context $this$workOuts) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel> categories(@org.jetbrains.annotations.NotNull
    android.content.Context $this$categories) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel> fullcategoriesbegginer(@org.jetbrains.annotations.NotNull
    android.content.Context $this$fullcategoriesbegginer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel> motivationQuotes(@org.jetbrains.annotations.NotNull
    android.content.Context $this$motivationQuotes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getFormattedDistance(double distance) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getFormattedCalories(double calories) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <R extends java.lang.Object>kotlinx.coroutines.Job executeAsyncTask(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope $this$executeAsyncTask, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onPreExecute, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<? extends R> doInBackground, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super R, kotlin.Unit> onPostExecute) {
        return null;
    }
    
    private static final void downloadStart(android.content.Context $this$downloadStart) {
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String convertDateTime(@org.jetbrains.annotations.NotNull
    android.content.Context $this$convertDateTime, @org.jetbrains.annotations.NotNull
    java.lang.String dateInMilliseconds, @org.jetbrains.annotations.Nullable
    java.lang.String dateFormat) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.models.RingTone> listRingtones(@org.jetbrains.annotations.NotNull
    android.content.Context $this$listRingtones) {
        return null;
    }
    
    private static final java.lang.String formatDuration(int duration) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final android.net.Uri systemDefaultAlarmTone(@org.jetbrains.annotations.NotNull
    android.content.Context $this$systemDefaultAlarmTone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getShortDayName(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getShortDayName, int dayNumber) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getLongDayName(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getLongDayName, int dayNumber) {
        return null;
    }
    
    public static final long getDateInMillis(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getDateInMillis) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getSimpleDate(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getSimpleDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getDayOfWeek(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getDayOfWeek, @org.jetbrains.annotations.NotNull
    java.lang.String dateString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final kotlin.Pair<java.lang.Integer, java.lang.Integer> convertDecimalToHoursMinutes(@org.jetbrains.annotations.NotNull
    android.content.Context $this$convertDecimalToHoursMinutes, float decimalHours) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final kotlin.Pair<java.lang.String, java.lang.Integer> getDayNameAndValue(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getDayNameAndValue, @org.jetbrains.annotations.NotNull
    java.lang.String dateString) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer getDayIndex(@org.jetbrains.annotations.NotNull
    java.lang.String dateString) {
        return null;
    }
    
    private static final java.lang.String getDayName(int dayOfWeek) {
        return null;
    }
    
    private static final java.lang.String formatSelectedDays(java.util.Set<java.lang.Integer> days) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getDate(@org.jetbrains.annotations.NotNull
    android.content.Context $this$getDate, long milliSeconds, @org.jetbrains.annotations.Nullable
    java.lang.String dateFormat) {
        return null;
    }
}