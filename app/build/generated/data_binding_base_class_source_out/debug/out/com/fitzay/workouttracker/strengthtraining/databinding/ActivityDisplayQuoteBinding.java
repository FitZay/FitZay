// Generated by view binder compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDisplayQuoteBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final MaterialToolbar materialToolbar;

  @NonNull
  public final RecyclerView recyclerview;

  @NonNull
  public final TextView toolBar;

  private ActivityDisplayQuoteBinding(@NonNull RelativeLayout rootView, @NonNull ImageView ivBack,
      @NonNull MaterialToolbar materialToolbar, @NonNull RecyclerView recyclerview,
      @NonNull TextView toolBar) {
    this.rootView = rootView;
    this.ivBack = ivBack;
    this.materialToolbar = materialToolbar;
    this.recyclerview = recyclerview;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDisplayQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDisplayQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_display_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDisplayQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivBack;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.materialToolbar;
      MaterialToolbar materialToolbar = ViewBindings.findChildViewById(rootView, id);
      if (materialToolbar == null) {
        break missingId;
      }

      id = R.id.recyclerview;
      RecyclerView recyclerview = ViewBindings.findChildViewById(rootView, id);
      if (recyclerview == null) {
        break missingId;
      }

      id = R.id.toolBar;
      TextView toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new ActivityDisplayQuoteBinding((RelativeLayout) rootView, ivBack, materialToolbar,
          recyclerview, toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
