// Generated by view binder compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFitYouBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnNext;

  @NonNull
  public final ConstraintLayout clBottomNext;

  @NonNull
  public final ConstraintLayout clFit;

  @NonNull
  public final ConstraintLayout clNotVeryFit;

  @NonNull
  public final ConstraintLayout clVeryFit;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivFitChecked;

  @NonNull
  public final ImageView ivNotVeryFitChecked;

  @NonNull
  public final ImageView ivVeryFitChecked;

  @NonNull
  public final MaterialToolbar materialToolbar;

  @NonNull
  public final MaterialTextView tvFit;

  @NonNull
  public final MaterialTextView tvNotVeryFit;

  @NonNull
  public final MaterialTextView tvQuestion;

  @NonNull
  public final MaterialTextView tvVeryFit;

  private ActivityFitYouBinding(@NonNull ConstraintLayout rootView, @NonNull MaterialButton btnNext,
      @NonNull ConstraintLayout clBottomNext, @NonNull ConstraintLayout clFit,
      @NonNull ConstraintLayout clNotVeryFit, @NonNull ConstraintLayout clVeryFit,
      @NonNull ImageView ivBack, @NonNull ImageView ivFitChecked,
      @NonNull ImageView ivNotVeryFitChecked, @NonNull ImageView ivVeryFitChecked,
      @NonNull MaterialToolbar materialToolbar, @NonNull MaterialTextView tvFit,
      @NonNull MaterialTextView tvNotVeryFit, @NonNull MaterialTextView tvQuestion,
      @NonNull MaterialTextView tvVeryFit) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.clBottomNext = clBottomNext;
    this.clFit = clFit;
    this.clNotVeryFit = clNotVeryFit;
    this.clVeryFit = clVeryFit;
    this.ivBack = ivBack;
    this.ivFitChecked = ivFitChecked;
    this.ivNotVeryFitChecked = ivNotVeryFitChecked;
    this.ivVeryFitChecked = ivVeryFitChecked;
    this.materialToolbar = materialToolbar;
    this.tvFit = tvFit;
    this.tvNotVeryFit = tvNotVeryFit;
    this.tvQuestion = tvQuestion;
    this.tvVeryFit = tvVeryFit;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFitYouBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFitYouBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_fit_you, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFitYouBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      MaterialButton btnNext = ViewBindings.findChildViewById(rootView, id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.clBottomNext;
      ConstraintLayout clBottomNext = ViewBindings.findChildViewById(rootView, id);
      if (clBottomNext == null) {
        break missingId;
      }

      id = R.id.clFit;
      ConstraintLayout clFit = ViewBindings.findChildViewById(rootView, id);
      if (clFit == null) {
        break missingId;
      }

      id = R.id.clNotVeryFit;
      ConstraintLayout clNotVeryFit = ViewBindings.findChildViewById(rootView, id);
      if (clNotVeryFit == null) {
        break missingId;
      }

      id = R.id.clVeryFit;
      ConstraintLayout clVeryFit = ViewBindings.findChildViewById(rootView, id);
      if (clVeryFit == null) {
        break missingId;
      }

      id = R.id.ivBack;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.ivFitChecked;
      ImageView ivFitChecked = ViewBindings.findChildViewById(rootView, id);
      if (ivFitChecked == null) {
        break missingId;
      }

      id = R.id.ivNotVeryFitChecked;
      ImageView ivNotVeryFitChecked = ViewBindings.findChildViewById(rootView, id);
      if (ivNotVeryFitChecked == null) {
        break missingId;
      }

      id = R.id.ivVeryFitChecked;
      ImageView ivVeryFitChecked = ViewBindings.findChildViewById(rootView, id);
      if (ivVeryFitChecked == null) {
        break missingId;
      }

      id = R.id.materialToolbar;
      MaterialToolbar materialToolbar = ViewBindings.findChildViewById(rootView, id);
      if (materialToolbar == null) {
        break missingId;
      }

      id = R.id.tvFit;
      MaterialTextView tvFit = ViewBindings.findChildViewById(rootView, id);
      if (tvFit == null) {
        break missingId;
      }

      id = R.id.tvNotVeryFit;
      MaterialTextView tvNotVeryFit = ViewBindings.findChildViewById(rootView, id);
      if (tvNotVeryFit == null) {
        break missingId;
      }

      id = R.id.tvQuestion;
      MaterialTextView tvQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvQuestion == null) {
        break missingId;
      }

      id = R.id.tvVeryFit;
      MaterialTextView tvVeryFit = ViewBindings.findChildViewById(rootView, id);
      if (tvVeryFit == null) {
        break missingId;
      }

      return new ActivityFitYouBinding((ConstraintLayout) rootView, btnNext, clBottomNext, clFit,
          clNotVeryFit, clVeryFit, ivBack, ivFitChecked, ivNotVeryFitChecked, ivVeryFitChecked,
          materialToolbar, tvFit, tvNotVeryFit, tvQuestion, tvVeryFit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
