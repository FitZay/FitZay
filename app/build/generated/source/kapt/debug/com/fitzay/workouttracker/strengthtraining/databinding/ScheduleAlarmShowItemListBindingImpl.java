package com.fitzay.workouttracker.strengthtraining.databinding;
import com.fitzay.workouttracker.strengthtraining.R;
import com.fitzay.workouttracker.strengthtraining.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ScheduleAlarmShowItemListBindingImpl extends ScheduleAlarmShowItemListBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.main, 1);
        sViewsWithIds.put(R.id.alarmView, 2);
        sViewsWithIds.put(R.id.swOnOff, 3);
        sViewsWithIds.put(R.id.nextTitle, 4);
        sViewsWithIds.put(R.id.bedIcon, 5);
        sViewsWithIds.put(R.id.labelName, 6);
        sViewsWithIds.put(R.id.alarmIcon, 7);
        sViewsWithIds.put(R.id.wakeLabel, 8);
        sViewsWithIds.put(R.id.wakeTime, 9);
        sViewsWithIds.put(R.id.wake_am_pm, 10);
        sViewsWithIds.put(R.id.time, 11);
        sViewsWithIds.put(R.id.am_pm, 12);
        sViewsWithIds.put(R.id.dayName, 13);
        sViewsWithIds.put(R.id.changeBtn, 14);
        sViewsWithIds.put(R.id.ss, 15);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ScheduleAlarmShowItemListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ScheduleAlarmShowItemListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.view.View) bindings[2]
            , (android.widget.TextView) bindings[12]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[6]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (androidx.appcompat.widget.SwitchCompat) bindings[15]
            , (android.widget.ImageView) bindings[3]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}