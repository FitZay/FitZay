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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBmiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ageH;

  @NonNull
  public final TextView ageValue;

  @NonNull
  public final ImageView back;

  @NonNull
  public final TextView bmiExtreme;

  @NonNull
  public final TextView bmiLow;

  @NonNull
  public final TextView bmiNormal;

  @NonNull
  public final TextView bmiObese;

  @NonNull
  public final TextView bmiOverweight;

  @NonNull
  public final TextView bmiValue;

  @NonNull
  public final ImageView bmiloader;

  @NonNull
  public final MaterialButton btnNext;

  @NonNull
  public final ConstraintLayout clBottomNext;

  @NonNull
  public final TextView des;

  @NonNull
  public final TextView finalVal;

  @NonNull
  public final TextView heightH;

  @NonNull
  public final TextView heightValue;

  @NonNull
  public final View line;

  @NonNull
  public final TextView mainT;

  @NonNull
  public final View mainV;

  @NonNull
  public final TextView profile;

  @NonNull
  public final TextView weightH;

  @NonNull
  public final TextView weightValue;

  private ActivityBmiBinding(@NonNull ConstraintLayout rootView, @NonNull TextView ageH,
      @NonNull TextView ageValue, @NonNull ImageView back, @NonNull TextView bmiExtreme,
      @NonNull TextView bmiLow, @NonNull TextView bmiNormal, @NonNull TextView bmiObese,
      @NonNull TextView bmiOverweight, @NonNull TextView bmiValue, @NonNull ImageView bmiloader,
      @NonNull MaterialButton btnNext, @NonNull ConstraintLayout clBottomNext,
      @NonNull TextView des, @NonNull TextView finalVal, @NonNull TextView heightH,
      @NonNull TextView heightValue, @NonNull View line, @NonNull TextView mainT,
      @NonNull View mainV, @NonNull TextView profile, @NonNull TextView weightH,
      @NonNull TextView weightValue) {
    this.rootView = rootView;
    this.ageH = ageH;
    this.ageValue = ageValue;
    this.back = back;
    this.bmiExtreme = bmiExtreme;
    this.bmiLow = bmiLow;
    this.bmiNormal = bmiNormal;
    this.bmiObese = bmiObese;
    this.bmiOverweight = bmiOverweight;
    this.bmiValue = bmiValue;
    this.bmiloader = bmiloader;
    this.btnNext = btnNext;
    this.clBottomNext = clBottomNext;
    this.des = des;
    this.finalVal = finalVal;
    this.heightH = heightH;
    this.heightValue = heightValue;
    this.line = line;
    this.mainT = mainT;
    this.mainV = mainV;
    this.profile = profile;
    this.weightH = weightH;
    this.weightValue = weightValue;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBmiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBmiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bmi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBmiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ageH;
      TextView ageH = ViewBindings.findChildViewById(rootView, id);
      if (ageH == null) {
        break missingId;
      }

      id = R.id.ageValue;
      TextView ageValue = ViewBindings.findChildViewById(rootView, id);
      if (ageValue == null) {
        break missingId;
      }

      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.bmiExtreme;
      TextView bmiExtreme = ViewBindings.findChildViewById(rootView, id);
      if (bmiExtreme == null) {
        break missingId;
      }

      id = R.id.bmiLow;
      TextView bmiLow = ViewBindings.findChildViewById(rootView, id);
      if (bmiLow == null) {
        break missingId;
      }

      id = R.id.bmiNormal;
      TextView bmiNormal = ViewBindings.findChildViewById(rootView, id);
      if (bmiNormal == null) {
        break missingId;
      }

      id = R.id.bmiObese;
      TextView bmiObese = ViewBindings.findChildViewById(rootView, id);
      if (bmiObese == null) {
        break missingId;
      }

      id = R.id.bmiOverweight;
      TextView bmiOverweight = ViewBindings.findChildViewById(rootView, id);
      if (bmiOverweight == null) {
        break missingId;
      }

      id = R.id.bmiValue;
      TextView bmiValue = ViewBindings.findChildViewById(rootView, id);
      if (bmiValue == null) {
        break missingId;
      }

      id = R.id.bmiloader;
      ImageView bmiloader = ViewBindings.findChildViewById(rootView, id);
      if (bmiloader == null) {
        break missingId;
      }

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

      id = R.id.des;
      TextView des = ViewBindings.findChildViewById(rootView, id);
      if (des == null) {
        break missingId;
      }

      id = R.id.finalVal;
      TextView finalVal = ViewBindings.findChildViewById(rootView, id);
      if (finalVal == null) {
        break missingId;
      }

      id = R.id.heightH;
      TextView heightH = ViewBindings.findChildViewById(rootView, id);
      if (heightH == null) {
        break missingId;
      }

      id = R.id.heightValue;
      TextView heightValue = ViewBindings.findChildViewById(rootView, id);
      if (heightValue == null) {
        break missingId;
      }

      id = R.id.line;
      View line = ViewBindings.findChildViewById(rootView, id);
      if (line == null) {
        break missingId;
      }

      id = R.id.mainT;
      TextView mainT = ViewBindings.findChildViewById(rootView, id);
      if (mainT == null) {
        break missingId;
      }

      id = R.id.mainV;
      View mainV = ViewBindings.findChildViewById(rootView, id);
      if (mainV == null) {
        break missingId;
      }

      id = R.id.profile;
      TextView profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.weightH;
      TextView weightH = ViewBindings.findChildViewById(rootView, id);
      if (weightH == null) {
        break missingId;
      }

      id = R.id.weightValue;
      TextView weightValue = ViewBindings.findChildViewById(rootView, id);
      if (weightValue == null) {
        break missingId;
      }

      return new ActivityBmiBinding((ConstraintLayout) rootView, ageH, ageValue, back, bmiExtreme,
          bmiLow, bmiNormal, bmiObese, bmiOverweight, bmiValue, bmiloader, btnNext, clBottomNext,
          des, finalVal, heightH, heightValue, line, mainT, mainV, profile, weightH, weightValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}