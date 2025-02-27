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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomTooltipBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvValue;

  private CustomTooltipBinding(@NonNull ConstraintLayout rootView, @NonNull TextView tvValue) {
    this.rootView = rootView;
    this.tvValue = tvValue;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomTooltipBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomTooltipBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_tooltip, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomTooltipBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvValue;
      TextView tvValue = ViewBindings.findChildViewById(rootView, id);
      if (tvValue == null) {
        break missingId;
      }

      return new CustomTooltipBinding((ConstraintLayout) rootView, tvValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
