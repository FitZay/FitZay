// Generated by data binding compiler. Do not edit!
package com.fitzay.workouttracker.strengthtraining.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.fitzay.workouttracker.strengthtraining.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutWeekdaysBinding extends ViewDataBinding {
  @NonNull
  public final MaterialButtonToggleGroup bgWeekdays;

  @NonNull
  public final Button btnDay1;

  @NonNull
  public final Button btnDay2;

  @NonNull
  public final Button btnDay3;

  @NonNull
  public final Button btnDay4;

  @NonNull
  public final Button btnDay5;

  @NonNull
  public final Button btnDay6;

  @NonNull
  public final Button btnDay7;

  protected LayoutWeekdaysBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialButtonToggleGroup bgWeekdays, Button btnDay1, Button btnDay2, Button btnDay3,
      Button btnDay4, Button btnDay5, Button btnDay6, Button btnDay7) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bgWeekdays = bgWeekdays;
    this.btnDay1 = btnDay1;
    this.btnDay2 = btnDay2;
    this.btnDay3 = btnDay3;
    this.btnDay4 = btnDay4;
    this.btnDay5 = btnDay5;
    this.btnDay6 = btnDay6;
    this.btnDay7 = btnDay7;
  }

  @NonNull
  public static LayoutWeekdaysBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_weekdays, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutWeekdaysBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutWeekdaysBinding>inflateInternal(inflater, R.layout.layout_weekdays, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutWeekdaysBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_weekdays, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutWeekdaysBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutWeekdaysBinding>inflateInternal(inflater, R.layout.layout_weekdays, null, false, component);
  }

  public static LayoutWeekdaysBinding bind(@NonNull View view) {
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
  public static LayoutWeekdaysBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutWeekdaysBinding)bind(component, view, R.layout.layout_weekdays);
  }
}
