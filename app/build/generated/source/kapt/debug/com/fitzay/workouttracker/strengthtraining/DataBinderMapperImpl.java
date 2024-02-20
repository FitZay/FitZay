package com.fitzay.workouttracker.strengthtraining;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepSummaryBindingImpl;
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySleepTrackerHomeScreenBindingImpl;
import com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBindingImpl;
import com.fitzay.workouttracker.strengthtraining.databinding.LayoutWeekdaysBindingImpl;
import com.fitzay.workouttracker.strengthtraining.databinding.RingtoneShowListBindingImpl;
import com.fitzay.workouttracker.strengthtraining.databinding.ScheduleAlarmShowItemListBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYSLEEPSUMMARY = 1;

  private static final int LAYOUT_ACTIVITYSLEEPTRACKERHOMESCREEN = 2;

  private static final int LAYOUT_ALARMSHOWITEMLIST = 3;

  private static final int LAYOUT_LAYOUTWEEKDAYS = 4;

  private static final int LAYOUT_RINGTONESHOWLIST = 5;

  private static final int LAYOUT_SCHEDULEALARMSHOWITEMLIST = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.activity_sleep_summary, LAYOUT_ACTIVITYSLEEPSUMMARY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.activity_sleep_tracker_home_screen, LAYOUT_ACTIVITYSLEEPTRACKERHOMESCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.alarm_show_item_list, LAYOUT_ALARMSHOWITEMLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.layout_weekdays, LAYOUT_LAYOUTWEEKDAYS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.ringtone_show_list, LAYOUT_RINGTONESHOWLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.fitzay.workouttracker.strengthtraining.R.layout.schedule_alarm_show_item_list, LAYOUT_SCHEDULEALARMSHOWITEMLIST);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYSLEEPSUMMARY: {
          if ("layout/activity_sleep_summary_0".equals(tag)) {
            return new ActivitySleepSummaryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sleep_summary is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSLEEPTRACKERHOMESCREEN: {
          if ("layout/activity_sleep_tracker_home_screen_0".equals(tag)) {
            return new ActivitySleepTrackerHomeScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_sleep_tracker_home_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ALARMSHOWITEMLIST: {
          if ("layout/alarm_show_item_list_0".equals(tag)) {
            return new AlarmShowItemListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for alarm_show_item_list is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTWEEKDAYS: {
          if ("layout/layout_weekdays_0".equals(tag)) {
            return new LayoutWeekdaysBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_weekdays is invalid. Received: " + tag);
        }
        case  LAYOUT_RINGTONESHOWLIST: {
          if ("layout/ringtone_show_list_0".equals(tag)) {
            return new RingtoneShowListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for ringtone_show_list is invalid. Received: " + tag);
        }
        case  LAYOUT_SCHEDULEALARMSHOWITEMLIST: {
          if ("layout/schedule_alarm_show_item_list_0".equals(tag)) {
            return new ScheduleAlarmShowItemListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for schedule_alarm_show_item_list is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(3);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.app.wheelpicker.DataBinderMapperImpl());
    result.add(new com.github.vikramezhil.wheelpicker.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_sleep_summary_0", com.fitzay.workouttracker.strengthtraining.R.layout.activity_sleep_summary);
      sKeys.put("layout/activity_sleep_tracker_home_screen_0", com.fitzay.workouttracker.strengthtraining.R.layout.activity_sleep_tracker_home_screen);
      sKeys.put("layout/alarm_show_item_list_0", com.fitzay.workouttracker.strengthtraining.R.layout.alarm_show_item_list);
      sKeys.put("layout/layout_weekdays_0", com.fitzay.workouttracker.strengthtraining.R.layout.layout_weekdays);
      sKeys.put("layout/ringtone_show_list_0", com.fitzay.workouttracker.strengthtraining.R.layout.ringtone_show_list);
      sKeys.put("layout/schedule_alarm_show_item_list_0", com.fitzay.workouttracker.strengthtraining.R.layout.schedule_alarm_show_item_list);
    }
  }
}
