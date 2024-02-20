package com.fitzay.workouttracker.strengthtraining.domain.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0086\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108H\u00d6\u0003J\t\u00109\u001a\u00020\u0003H\u00d6\u0001J\t\u0010:\u001a\u00020\u0005H\u00d6\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\"\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u000e\u0010#\"\u0004\b$\u0010%R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u000b\u0010#\"\u0004\b\'\u0010%R\"\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001b\u00a8\u0006;"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "Ljava/io/Serializable;", "exId", "", "exTitle", "", "catId", "exTime", "exRest", "exGif", "exDescription", "isTime", "", "timeSaved", "isRecommended", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getCatId", "()Ljava/lang/String;", "setCatId", "(Ljava/lang/String;)V", "getExDescription", "setExDescription", "getExGif", "setExGif", "getExId", "()Ljava/lang/Integer;", "setExId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExRest", "setExRest", "getExTime", "setExTime", "getExTitle", "setExTitle", "()Ljava/lang/Boolean;", "setRecommended", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setTime", "getTimeSaved", "setTimeSaved", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/fitzay/workouttracker/strengthtraining/domain/models/WorkOutModel;", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class WorkOutModel implements java.io.Serializable {
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_id")
    private java.lang.Integer exId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_title")
    private java.lang.String exTitle;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "cat_id")
    private java.lang.String catId;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_time")
    private java.lang.Integer exTime;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_rest")
    private java.lang.Integer exRest;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_gif")
    private java.lang.String exGif;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "ex_description")
    private java.lang.String exDescription;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "isTime")
    private java.lang.Boolean isTime;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "timeSaved")
    private java.lang.Integer timeSaved;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "isRecommended")
    private java.lang.Boolean isRecommended;
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel copy(@org.jetbrains.annotations.Nullable
    java.lang.Integer exId, @org.jetbrains.annotations.Nullable
    java.lang.String exTitle, @org.jetbrains.annotations.Nullable
    java.lang.String catId, @org.jetbrains.annotations.Nullable
    java.lang.Integer exTime, @org.jetbrains.annotations.Nullable
    java.lang.Integer exRest, @org.jetbrains.annotations.Nullable
    java.lang.String exGif, @org.jetbrains.annotations.Nullable
    java.lang.String exDescription, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isTime, @org.jetbrains.annotations.Nullable
    java.lang.Integer timeSaved, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isRecommended) {
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
    
    public WorkOutModel() {
        super();
    }
    
    public WorkOutModel(@org.jetbrains.annotations.Nullable
    java.lang.Integer exId, @org.jetbrains.annotations.Nullable
    java.lang.String exTitle, @org.jetbrains.annotations.Nullable
    java.lang.String catId, @org.jetbrains.annotations.Nullable
    java.lang.Integer exTime, @org.jetbrains.annotations.Nullable
    java.lang.Integer exRest, @org.jetbrains.annotations.Nullable
    java.lang.String exGif, @org.jetbrains.annotations.Nullable
    java.lang.String exDescription, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isTime, @org.jetbrains.annotations.Nullable
    java.lang.Integer timeSaved, @org.jetbrains.annotations.Nullable
    java.lang.Boolean isRecommended) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getExId() {
        return null;
    }
    
    public final void setExId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getExTitle() {
        return null;
    }
    
    public final void setExTitle(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getCatId() {
        return null;
    }
    
    public final void setCatId(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getExTime() {
        return null;
    }
    
    public final void setExTime(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getExRest() {
        return null;
    }
    
    public final void setExRest(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getExGif() {
        return null;
    }
    
    public final void setExGif(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getExDescription() {
        return null;
    }
    
    public final void setExDescription(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean isTime() {
        return null;
    }
    
    public final void setTime(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getTimeSaved() {
        return null;
    }
    
    public final void setTimeSaved(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Boolean isRecommended() {
        return null;
    }
    
    public final void setRecommended(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
}