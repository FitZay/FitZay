// Generated by view binder compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAbsUnfinishBottomBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CircularProgressIndicator circularProgressIndicator2;

  @NonNull
  public final ConstraintLayout constraintLayout13;

  @NonNull
  public final ConstraintLayout constraintLayout14;

  @NonNull
  public final MaterialCardView materialCardView6;

  @NonNull
  public final MaterialCardView materialCardView7;

  @NonNull
  public final TextView textView8;

  private FragmentAbsUnfinishBottomBinding(@NonNull ConstraintLayout rootView,
      @NonNull CircularProgressIndicator circularProgressIndicator2,
      @NonNull ConstraintLayout constraintLayout13, @NonNull ConstraintLayout constraintLayout14,
      @NonNull MaterialCardView materialCardView6, @NonNull MaterialCardView materialCardView7,
      @NonNull TextView textView8) {
    this.rootView = rootView;
    this.circularProgressIndicator2 = circularProgressIndicator2;
    this.constraintLayout13 = constraintLayout13;
    this.constraintLayout14 = constraintLayout14;
    this.materialCardView6 = materialCardView6;
    this.materialCardView7 = materialCardView7;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAbsUnfinishBottomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAbsUnfinishBottomBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_abs_unfinish_bottom, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAbsUnfinishBottomBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.circularProgressIndicator2;
      CircularProgressIndicator circularProgressIndicator2 = ViewBindings.findChildViewById(rootView, id);
      if (circularProgressIndicator2 == null) {
        break missingId;
      }

      id = R.id.constraintLayout13;
      ConstraintLayout constraintLayout13 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout13 == null) {
        break missingId;
      }

      id = R.id.constraintLayout14;
      ConstraintLayout constraintLayout14 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout14 == null) {
        break missingId;
      }

      id = R.id.materialCardView6;
      MaterialCardView materialCardView6 = ViewBindings.findChildViewById(rootView, id);
      if (materialCardView6 == null) {
        break missingId;
      }

      id = R.id.materialCardView7;
      MaterialCardView materialCardView7 = ViewBindings.findChildViewById(rootView, id);
      if (materialCardView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new FragmentAbsUnfinishBottomBinding((ConstraintLayout) rootView,
          circularProgressIndicator2, constraintLayout13, constraintLayout14, materialCardView6,
          materialCardView7, textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
