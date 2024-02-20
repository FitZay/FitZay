package com.fitzay.workouttracker.strengthtraining.ui.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/AlarmShowAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/AlarmShowAdapter$AlarmShowHolder;", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getListener", "()Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "setListener", "(Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AlarmShowHolder", "Companion", "app_debug"})
public final class AlarmShowAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter.AlarmShowHolder> {
    @org.jetbrains.annotations.NotNull
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> list;
    @org.jetbrains.annotations.NotNull
    private com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick listener;
    @org.jetbrains.annotations.NotNull
    public static final com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter.Companion Companion = null;
    private static boolean toggleValue = true;
    
    public AlarmShowAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> list, @org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick listener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick getListener() {
        return null;
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter.AlarmShowHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.fitzay.workouttracker.strengthtraining.ui.adapters.AlarmShowAdapter.AlarmShowHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/AlarmShowAdapter$AlarmShowHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/fitzay/workouttracker/strengthtraining/databinding/AlarmShowItemListBinding;", "(Lcom/fitzay/workouttracker/strengthtraining/databinding/AlarmShowItemListBinding;)V", "getBinding", "()Lcom/fitzay/workouttracker/strengthtraining/databinding/AlarmShowItemListBinding;", "setBinding", "bind", "", "context", "Landroid/content/Context;", "model", "Lcom/fitzay/workouttracker/strengthtraining/domain/entities/AlarmEntity;", "listener", "Lcom/fitzay/workouttracker/strengthtraining/ui/callback/ShowAlarmItemClick;", "position", "", "app_debug"})
    public static final class AlarmShowHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding binding;
        
        public AlarmShowHolder(@org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity model, @org.jetbrains.annotations.NotNull
        com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick listener, int position) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/fitzay/workouttracker/strengthtraining/ui/adapters/AlarmShowAdapter$Companion;", "", "()V", "toggleValue", "", "getToggleValue", "()Z", "setToggleValue", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getToggleValue() {
            return false;
        }
        
        public final void setToggleValue(boolean p0) {
        }
    }
}