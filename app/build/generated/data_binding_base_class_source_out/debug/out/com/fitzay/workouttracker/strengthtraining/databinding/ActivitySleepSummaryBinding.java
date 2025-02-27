// Generated by data binding compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import aglibs.loading.skeleton.layout.SkeletonRelativeLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySleepSummaryBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView alarmRv;

  @NonNull
  public final ConstraintLayout clAds;

  @NonNull
  public final AppCompatButton cta;

  @NonNull
  public final FrameLayout dailyContainer;

  @NonNull
  public final ImageView img001;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final RelativeLayout layoutAd;

  @NonNull
  public final LinearLayout layoutChoice;

  @NonNull
  public final MaterialToolbar materialToolbar;

  @NonNull
  public final TemplateView plannerTemplateDown;

  @NonNull
  public final TemplateView plannerTemplateUp;

  @NonNull
  public final ConstraintLayout root;

  @NonNull
  public final SkeletonRelativeLayout skeletonLayout;

  @NonNull
  public final TextView text001;

  @NonNull
  public final TextView textlay;

  @NonNull
  public final TextView txtDaily;

  @NonNull
  public final TextView txtMonthly;

  @NonNull
  public final TextView txtToolbar;

  @NonNull
  public final TextView txtWeekly;

  protected ActivitySleepSummaryBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RecyclerView alarmRv, ConstraintLayout clAds, AppCompatButton cta, FrameLayout dailyContainer,
      ImageView img001, ImageView ivBack, RelativeLayout layoutAd, LinearLayout layoutChoice,
      MaterialToolbar materialToolbar, TemplateView plannerTemplateDown,
      TemplateView plannerTemplateUp, ConstraintLayout root, SkeletonRelativeLayout skeletonLayout,
      TextView text001, TextView textlay, TextView txtDaily, TextView txtMonthly,
      TextView txtToolbar, TextView txtWeekly) {
    super(_bindingComponent, _root, _localFieldCount);
    this.alarmRv = alarmRv;
    this.clAds = clAds;
    this.cta = cta;
    this.dailyContainer = dailyContainer;
    this.img001 = img001;
    this.ivBack = ivBack;
    this.layoutAd = layoutAd;
    this.layoutChoice = layoutChoice;
    this.materialToolbar = materialToolbar;
    this.plannerTemplateDown = plannerTemplateDown;
    this.plannerTemplateUp = plannerTemplateUp;
    this.root = root;
    this.skeletonLayout = skeletonLayout;
    this.text001 = text001;
    this.textlay = textlay;
    this.txtDaily = txtDaily;
    this.txtMonthly = txtMonthly;
    this.txtToolbar = txtToolbar;
    this.txtWeekly = txtWeekly;
  }

  @NonNull
  public static ActivitySleepSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sleep_summary, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySleepSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySleepSummaryBinding>inflateInternal(inflater, R.layout.activity_sleep_summary, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySleepSummaryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_sleep_summary, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySleepSummaryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySleepSummaryBinding>inflateInternal(inflater, R.layout.activity_sleep_summary, null, false, component);
  }

  public static ActivitySleepSummaryBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivitySleepSummaryBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySleepSummaryBinding)bind(component, view, R.layout.activity_sleep_summary);
  }
}
