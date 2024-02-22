// Generated by view binder compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPartShouldFocusBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnNext;

  @NonNull
  public final ConstraintLayout clArms;

  @NonNull
  public final ConstraintLayout clBelly;

  @NonNull
  public final ConstraintLayout clBottomNext;

  @NonNull
  public final ConstraintLayout clChest;

  @NonNull
  public final ConstraintLayout clMenuBottomLayout;

  @NonNull
  public final ConstraintLayout clThighs;

  @NonNull
  public final ImageView ivArms;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivBelly;

  @NonNull
  public final ImageView ivChest;

  @NonNull
  public final ImageView ivModel;

  @NonNull
  public final ImageView ivThighs;

  @NonNull
  public final Guideline midHorizontalGuide;

  @NonNull
  public final Guideline midVerticalGuide;

  @NonNull
  public final MaterialToolbar toolbar;

  @NonNull
  public final TextView tvArms;

  @NonNull
  public final TextView tvBelly;

  @NonNull
  public final TextView tvChest;

  @NonNull
  public final MaterialTextView tvQuestion;

  @NonNull
  public final TextView tvThighs;

  private ActivityPartShouldFocusBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnNext, @NonNull ConstraintLayout clArms,
      @NonNull ConstraintLayout clBelly, @NonNull ConstraintLayout clBottomNext,
      @NonNull ConstraintLayout clChest, @NonNull ConstraintLayout clMenuBottomLayout,
      @NonNull ConstraintLayout clThighs, @NonNull ImageView ivArms, @NonNull ImageView ivBack,
      @NonNull ImageView ivBelly, @NonNull ImageView ivChest, @NonNull ImageView ivModel,
      @NonNull ImageView ivThighs, @NonNull Guideline midHorizontalGuide,
      @NonNull Guideline midVerticalGuide, @NonNull MaterialToolbar toolbar,
      @NonNull TextView tvArms, @NonNull TextView tvBelly, @NonNull TextView tvChest,
      @NonNull MaterialTextView tvQuestion, @NonNull TextView tvThighs) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.clArms = clArms;
    this.clBelly = clBelly;
    this.clBottomNext = clBottomNext;
    this.clChest = clChest;
    this.clMenuBottomLayout = clMenuBottomLayout;
    this.clThighs = clThighs;
    this.ivArms = ivArms;
    this.ivBack = ivBack;
    this.ivBelly = ivBelly;
    this.ivChest = ivChest;
    this.ivModel = ivModel;
    this.ivThighs = ivThighs;
    this.midHorizontalGuide = midHorizontalGuide;
    this.midVerticalGuide = midVerticalGuide;
    this.toolbar = toolbar;
    this.tvArms = tvArms;
    this.tvBelly = tvBelly;
    this.tvChest = tvChest;
    this.tvQuestion = tvQuestion;
    this.tvThighs = tvThighs;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPartShouldFocusBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPartShouldFocusBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_part_should_focus, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPartShouldFocusBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      MaterialButton btnNext = ViewBindings.findChildViewById(rootView, id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.clArms;
      ConstraintLayout clArms = ViewBindings.findChildViewById(rootView, id);
      if (clArms == null) {
        break missingId;
      }

      id = R.id.clBelly;
      ConstraintLayout clBelly = ViewBindings.findChildViewById(rootView, id);
      if (clBelly == null) {
        break missingId;
      }

      id = R.id.clBottomNext;
      ConstraintLayout clBottomNext = ViewBindings.findChildViewById(rootView, id);
      if (clBottomNext == null) {
        break missingId;
      }

      id = R.id.clChest;
      ConstraintLayout clChest = ViewBindings.findChildViewById(rootView, id);
      if (clChest == null) {
        break missingId;
      }

      id = R.id.clMenuBottomLayout;
      ConstraintLayout clMenuBottomLayout = ViewBindings.findChildViewById(rootView, id);
      if (clMenuBottomLayout == null) {
        break missingId;
      }

      id = R.id.clThighs;
      ConstraintLayout clThighs = ViewBindings.findChildViewById(rootView, id);
      if (clThighs == null) {
        break missingId;
      }

      id = R.id.ivArms;
      ImageView ivArms = ViewBindings.findChildViewById(rootView, id);
      if (ivArms == null) {
        break missingId;
      }

      id = R.id.ivBack;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.ivBelly;
      ImageView ivBelly = ViewBindings.findChildViewById(rootView, id);
      if (ivBelly == null) {
        break missingId;
      }

      id = R.id.ivChest;
      ImageView ivChest = ViewBindings.findChildViewById(rootView, id);
      if (ivChest == null) {
        break missingId;
      }

      id = R.id.ivModel;
      ImageView ivModel = ViewBindings.findChildViewById(rootView, id);
      if (ivModel == null) {
        break missingId;
      }

      id = R.id.ivThighs;
      ImageView ivThighs = ViewBindings.findChildViewById(rootView, id);
      if (ivThighs == null) {
        break missingId;
      }

      id = R.id.midHorizontalGuide;
      Guideline midHorizontalGuide = ViewBindings.findChildViewById(rootView, id);
      if (midHorizontalGuide == null) {
        break missingId;
      }

      id = R.id.midVerticalGuide;
      Guideline midVerticalGuide = ViewBindings.findChildViewById(rootView, id);
      if (midVerticalGuide == null) {
        break missingId;
      }

      id = R.id.toolbar;
      MaterialToolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvArms;
      TextView tvArms = ViewBindings.findChildViewById(rootView, id);
      if (tvArms == null) {
        break missingId;
      }

      id = R.id.tvBelly;
      TextView tvBelly = ViewBindings.findChildViewById(rootView, id);
      if (tvBelly == null) {
        break missingId;
      }

      id = R.id.tvChest;
      TextView tvChest = ViewBindings.findChildViewById(rootView, id);
      if (tvChest == null) {
        break missingId;
      }

      id = R.id.tvQuestion;
      MaterialTextView tvQuestion = ViewBindings.findChildViewById(rootView, id);
      if (tvQuestion == null) {
        break missingId;
      }

      id = R.id.tvThighs;
      TextView tvThighs = ViewBindings.findChildViewById(rootView, id);
      if (tvThighs == null) {
        break missingId;
      }

      return new ActivityPartShouldFocusBinding((ConstraintLayout) rootView, btnNext, clArms,
          clBelly, clBottomNext, clChest, clMenuBottomLayout, clThighs, ivArms, ivBack, ivBelly,
          ivChest, ivModel, ivThighs, midHorizontalGuide, midVerticalGuide, toolbar, tvArms,
          tvBelly, tvChest, tvQuestion, tvThighs);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}