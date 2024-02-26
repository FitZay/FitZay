package com.fitzay.workouttracker.strengthtraining.databinding;
import com.fitzay.workouttracker.strengthtraining.R;
import com.fitzay.workouttracker.strengthtraining.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLanguageBindingImpl extends ActivityLanguageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.materialToolbar, 1);
        sViewsWithIds.put(R.id.ivBack, 2);
        sViewsWithIds.put(R.id.tick, 3);
        sViewsWithIds.put(R.id.langTxt, 4);
        sViewsWithIds.put(R.id.languageRv, 5);
        sViewsWithIds.put(R.id.clAds, 6);
        sViewsWithIds.put(R.id.skeletonLayout, 7);
        sViewsWithIds.put(R.id.img001, 8);
        sViewsWithIds.put(R.id.text001, 9);
        sViewsWithIds.put(R.id.cta, 10);
        sViewsWithIds.put(R.id.layoutAd, 11);
        sViewsWithIds.put(R.id.plannerTemplateUp, 12);
        sViewsWithIds.put(R.id.plannerTemplateDown, 13);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityLanguageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityLanguageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.appcompat.widget.AppCompatButton) bindings[10]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (android.widget.RelativeLayout) bindings[11]
            , (android.view.View) bindings[1]
            , (com.google.android.ads.nativetemplates.TemplateView) bindings[13]
            , (com.google.android.ads.nativetemplates.TemplateView) bindings[12]
            , (aglibs.loading.skeleton.layout.SkeletonRelativeLayout) bindings[7]
            , (android.widget.TextView) bindings[9]
            , (android.widget.ImageView) bindings[3]
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