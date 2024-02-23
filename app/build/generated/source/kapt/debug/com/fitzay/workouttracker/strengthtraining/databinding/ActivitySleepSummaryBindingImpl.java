package com.fitzay.workouttracker.strengthtraining.databinding;
import com.fitzay.workouttracker.strengthtraining.R;
import com.fitzay.workouttracker.strengthtraining.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySleepSummaryBindingImpl extends ActivitySleepSummaryBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.materialToolbar, 1);
        sViewsWithIds.put(R.id.ivBack, 2);
        sViewsWithIds.put(R.id.txtToolbar, 3);
        sViewsWithIds.put(R.id.layoutChoice, 4);
        sViewsWithIds.put(R.id.txtDaily, 5);
        sViewsWithIds.put(R.id.txtWeekly, 6);
        sViewsWithIds.put(R.id.txtMonthly, 7);
        sViewsWithIds.put(R.id.dailyContainer, 8);
        sViewsWithIds.put(R.id.alarmRv, 9);
        sViewsWithIds.put(R.id.clAds, 10);
        sViewsWithIds.put(R.id.skeletonLayout, 11);
        sViewsWithIds.put(R.id.img001, 12);
        sViewsWithIds.put(R.id.text001, 13);
        sViewsWithIds.put(R.id.textlay, 14);
        sViewsWithIds.put(R.id.cta, 15);
        sViewsWithIds.put(R.id.layoutAd, 16);
        sViewsWithIds.put(R.id.plannerTemplateUp, 17);
        sViewsWithIds.put(R.id.plannerTemplateDown, 18);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySleepSummaryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }
    private ActivitySleepSummaryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (android.widget.FrameLayout) bindings[8]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.RelativeLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[4]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[1]
            , (com.google.android.ads.nativetemplates.TemplateView) bindings[18]
            , (com.google.android.ads.nativetemplates.TemplateView) bindings[17]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (aglibs.loading.skeleton.layout.SkeletonRelativeLayout) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[6]
            );
        this.root.setTag(null);
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