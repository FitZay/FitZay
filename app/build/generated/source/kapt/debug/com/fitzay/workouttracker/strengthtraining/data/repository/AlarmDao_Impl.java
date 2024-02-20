package com.fitzay.workouttracker.strengthtraining.data.repository;

import android.database.Cursor;
import android.util.SparseBooleanArray;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fitzay.workouttracker.strengthtraining.data.model.Alarm;
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Alarm> __insertionAdapterOfAlarm;

  private final AlarmConverters __alarmConverters = new AlarmConverters();

  private final EntityInsertionAdapter<Alarm> __insertionAdapterOfAlarm_1;

  private final EntityDeletionOrUpdateAdapter<Alarm> __deletionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __updateAdapterOfAlarm;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItem;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarm = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Alarm` (`sleepId`,`id`,`time`,`label`,`isEnabled`,`isVibrationEnabled`,`soundUri`,`allDays`,`bedTime`,`selectedDay`,`snoozeTime`,`totalSleepingHr`,`date`,`idd`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getSleepId());
        stmt.bindLong(2, value.getId());
        stmt.bindLong(3, value.getTime());
        if (value.getLabel() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLabel());
        }
        final int _tmp = value.isEnabled() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isVibrationEnabled() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getSoundUri() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSoundUri());
        }
        final String _tmp_2 = __alarmConverters.fromSparseBooleanArray(value.getAllDays());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
        stmt.bindLong(9, value.getBedTime());
        if (value.getSelectedDay() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSelectedDay());
        }
        stmt.bindLong(11, value.getSnoozeTime());
        if (value.getTotalSleepingHr() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTotalSleepingHr());
        }
        if (value.getDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDate());
        }
        stmt.bindLong(14, value.getIdd());
      }
    };
    this.__insertionAdapterOfAlarm_1 = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Alarm` (`sleepId`,`id`,`time`,`label`,`isEnabled`,`isVibrationEnabled`,`soundUri`,`allDays`,`bedTime`,`selectedDay`,`snoozeTime`,`totalSleepingHr`,`date`,`idd`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getSleepId());
        stmt.bindLong(2, value.getId());
        stmt.bindLong(3, value.getTime());
        if (value.getLabel() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLabel());
        }
        final int _tmp = value.isEnabled() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isVibrationEnabled() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getSoundUri() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSoundUri());
        }
        final String _tmp_2 = __alarmConverters.fromSparseBooleanArray(value.getAllDays());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
        stmt.bindLong(9, value.getBedTime());
        if (value.getSelectedDay() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSelectedDay());
        }
        stmt.bindLong(11, value.getSnoozeTime());
        if (value.getTotalSleepingHr() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTotalSleepingHr());
        }
        if (value.getDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDate());
        }
        stmt.bindLong(14, value.getIdd());
      }
    };
    this.__deletionAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Alarm` WHERE `idd` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getIdd());
      }
    };
    this.__updateAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Alarm` SET `sleepId` = ?,`id` = ?,`time` = ?,`label` = ?,`isEnabled` = ?,`isVibrationEnabled` = ?,`soundUri` = ?,`allDays` = ?,`bedTime` = ?,`selectedDay` = ?,`snoozeTime` = ?,`totalSleepingHr` = ?,`date` = ?,`idd` = ? WHERE `idd` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getSleepId());
        stmt.bindLong(2, value.getId());
        stmt.bindLong(3, value.getTime());
        if (value.getLabel() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLabel());
        }
        final int _tmp = value.isEnabled() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        final int _tmp_1 = value.isVibrationEnabled() ? 1 : 0;
        stmt.bindLong(6, _tmp_1);
        if (value.getSoundUri() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSoundUri());
        }
        final String _tmp_2 = __alarmConverters.fromSparseBooleanArray(value.getAllDays());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_2);
        }
        stmt.bindLong(9, value.getBedTime());
        if (value.getSelectedDay() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSelectedDay());
        }
        stmt.bindLong(11, value.getSnoozeTime());
        if (value.getTotalSleepingHr() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTotalSleepingHr());
        }
        if (value.getDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDate());
        }
        stmt.bindLong(14, value.getIdd());
        stmt.bindLong(15, value.getIdd());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Alarm WHERE sleepId=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Alarm SET id=?,time = ?, label=?, isEnabled=?,isVibrationEnabled=?,soundUri=?,bedTime=?,selectedDay=?,snoozeTime=?,totalSleepingHr=?,date=? WHERE sleepId = ? AND date=?";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(final List<? extends Alarm> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarm.insert(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Alarm... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarm_1.insert(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Alarm... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll(final List<? extends Alarm> list) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handleMultiple(list);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Alarm... t) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAlarm.handleMultiple(t);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public void updateItem(final long sleepId, final long currentTime, final long alarmTime,
      final String alarmLable, final boolean alarmEnable, final boolean alarmVibrate,
      final String soundUri, final long alarmBT, final String selectedDays,
      final long alarmSnoozeTime, final String sleepHr, final String alarmDate) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItem.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, currentTime);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, alarmTime);
    _argIndex = 3;
    if (alarmLable == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, alarmLable);
    }
    _argIndex = 4;
    final int _tmp = alarmEnable ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 5;
    final int _tmp_1 = alarmVibrate ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp_1);
    _argIndex = 6;
    if (soundUri == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, soundUri);
    }
    _argIndex = 7;
    _stmt.bindLong(_argIndex, alarmBT);
    _argIndex = 8;
    if (selectedDays == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, selectedDays);
    }
    _argIndex = 9;
    _stmt.bindLong(_argIndex, alarmSnoozeTime);
    _argIndex = 10;
    if (sleepHr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sleepHr);
    }
    _argIndex = 11;
    if (alarmDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, alarmDate);
    }
    _argIndex = 12;
    _stmt.bindLong(_argIndex, sleepId);
    _argIndex = 13;
    if (alarmDate == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, alarmDate);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateItem.release(_stmt);
    }
  }

  @Override
  public List<Alarm> getPaging() {
    final String _sql = "SELECT * FROM alarm ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSleepId = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepId");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
      final int _cursorIndexOfIsVibrationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isVibrationEnabled");
      final int _cursorIndexOfSoundUri = CursorUtil.getColumnIndexOrThrow(_cursor, "soundUri");
      final int _cursorIndexOfAllDays = CursorUtil.getColumnIndexOrThrow(_cursor, "allDays");
      final int _cursorIndexOfBedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "bedTime");
      final int _cursorIndexOfSelectedDay = CursorUtil.getColumnIndexOrThrow(_cursor, "selectedDay");
      final int _cursorIndexOfSnoozeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTime");
      final int _cursorIndexOfTotalSleepingHr = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSleepingHr");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfIdd = CursorUtil.getColumnIndexOrThrow(_cursor, "idd");
      final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Alarm _item;
        final long _tmpSleepId;
        _tmpSleepId = _cursor.getLong(_cursorIndexOfSleepId);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final boolean _tmpIsEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
        _tmpIsEnabled = _tmp != 0;
        final boolean _tmpIsVibrationEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsVibrationEnabled);
        _tmpIsVibrationEnabled = _tmp_1 != 0;
        final String _tmpSoundUri;
        if (_cursor.isNull(_cursorIndexOfSoundUri)) {
          _tmpSoundUri = null;
        } else {
          _tmpSoundUri = _cursor.getString(_cursorIndexOfSoundUri);
        }
        final SparseBooleanArray _tmpAllDays;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfAllDays)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfAllDays);
        }
        _tmpAllDays = __alarmConverters.toSparseBooleanArray(_tmp_2);
        final long _tmpBedTime;
        _tmpBedTime = _cursor.getLong(_cursorIndexOfBedTime);
        final String _tmpSelectedDay;
        if (_cursor.isNull(_cursorIndexOfSelectedDay)) {
          _tmpSelectedDay = null;
        } else {
          _tmpSelectedDay = _cursor.getString(_cursorIndexOfSelectedDay);
        }
        final long _tmpSnoozeTime;
        _tmpSnoozeTime = _cursor.getLong(_cursorIndexOfSnoozeTime);
        final String _tmpTotalSleepingHr;
        if (_cursor.isNull(_cursorIndexOfTotalSleepingHr)) {
          _tmpTotalSleepingHr = null;
        } else {
          _tmpTotalSleepingHr = _cursor.getString(_cursorIndexOfTotalSleepingHr);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new Alarm(_tmpSleepId,_tmpId,_tmpTime,_tmpLabel,_tmpIsEnabled,_tmpIsVibrationEnabled,_tmpSoundUri,_tmpAllDays,_tmpBedTime,_tmpSelectedDay,_tmpSnoozeTime,_tmpTotalSleepingHr,_tmpDate);
        final int _tmpIdd;
        _tmpIdd = _cursor.getInt(_cursorIndexOfIdd);
        _item.setIdd(_tmpIdd);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Alarm> getAllEnabled() {
    final String _sql = "SELECT * FROM alarm WHERE isEnabled";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSleepId = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepId");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
      final int _cursorIndexOfIsVibrationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isVibrationEnabled");
      final int _cursorIndexOfSoundUri = CursorUtil.getColumnIndexOrThrow(_cursor, "soundUri");
      final int _cursorIndexOfAllDays = CursorUtil.getColumnIndexOrThrow(_cursor, "allDays");
      final int _cursorIndexOfBedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "bedTime");
      final int _cursorIndexOfSelectedDay = CursorUtil.getColumnIndexOrThrow(_cursor, "selectedDay");
      final int _cursorIndexOfSnoozeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTime");
      final int _cursorIndexOfTotalSleepingHr = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSleepingHr");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfIdd = CursorUtil.getColumnIndexOrThrow(_cursor, "idd");
      final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Alarm _item;
        final long _tmpSleepId;
        _tmpSleepId = _cursor.getLong(_cursorIndexOfSleepId);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final boolean _tmpIsEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
        _tmpIsEnabled = _tmp != 0;
        final boolean _tmpIsVibrationEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsVibrationEnabled);
        _tmpIsVibrationEnabled = _tmp_1 != 0;
        final String _tmpSoundUri;
        if (_cursor.isNull(_cursorIndexOfSoundUri)) {
          _tmpSoundUri = null;
        } else {
          _tmpSoundUri = _cursor.getString(_cursorIndexOfSoundUri);
        }
        final SparseBooleanArray _tmpAllDays;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfAllDays)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfAllDays);
        }
        _tmpAllDays = __alarmConverters.toSparseBooleanArray(_tmp_2);
        final long _tmpBedTime;
        _tmpBedTime = _cursor.getLong(_cursorIndexOfBedTime);
        final String _tmpSelectedDay;
        if (_cursor.isNull(_cursorIndexOfSelectedDay)) {
          _tmpSelectedDay = null;
        } else {
          _tmpSelectedDay = _cursor.getString(_cursorIndexOfSelectedDay);
        }
        final long _tmpSnoozeTime;
        _tmpSnoozeTime = _cursor.getLong(_cursorIndexOfSnoozeTime);
        final String _tmpTotalSleepingHr;
        if (_cursor.isNull(_cursorIndexOfTotalSleepingHr)) {
          _tmpTotalSleepingHr = null;
        } else {
          _tmpTotalSleepingHr = _cursor.getString(_cursorIndexOfTotalSleepingHr);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new Alarm(_tmpSleepId,_tmpId,_tmpTime,_tmpLabel,_tmpIsEnabled,_tmpIsVibrationEnabled,_tmpSoundUri,_tmpAllDays,_tmpBedTime,_tmpSelectedDay,_tmpSnoozeTime,_tmpTotalSleepingHr,_tmpDate);
        final int _tmpIdd;
        _tmpIdd = _cursor.getInt(_cursorIndexOfIdd);
        _item.setIdd(_tmpIdd);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlarmEntity> getAlarmForADay(final String day) {
    final String _sql = "SELECT * FROM alarm WHERE selectedDay=? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (day == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, day);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSleepId = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepId");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
      final int _cursorIndexOfIsVibrationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isVibrationEnabled");
      final int _cursorIndexOfSoundUri = CursorUtil.getColumnIndexOrThrow(_cursor, "soundUri");
      final int _cursorIndexOfAllDays = CursorUtil.getColumnIndexOrThrow(_cursor, "allDays");
      final int _cursorIndexOfBedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "bedTime");
      final int _cursorIndexOfSelectedDay = CursorUtil.getColumnIndexOrThrow(_cursor, "selectedDay");
      final int _cursorIndexOfSnoozeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTime");
      final int _cursorIndexOfTotalSleepingHr = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSleepingHr");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfIdd = CursorUtil.getColumnIndexOrThrow(_cursor, "idd");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final long _tmpSleepId;
        _tmpSleepId = _cursor.getLong(_cursorIndexOfSleepId);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final boolean _tmpIsEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
        _tmpIsEnabled = _tmp != 0;
        final boolean _tmpIsVibrationEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsVibrationEnabled);
        _tmpIsVibrationEnabled = _tmp_1 != 0;
        final String _tmpSoundUri;
        if (_cursor.isNull(_cursorIndexOfSoundUri)) {
          _tmpSoundUri = null;
        } else {
          _tmpSoundUri = _cursor.getString(_cursorIndexOfSoundUri);
        }
        final SparseBooleanArray _tmpAllDays;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfAllDays)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfAllDays);
        }
        _tmpAllDays = __alarmConverters.toSparseBooleanArray(_tmp_2);
        final long _tmpBedTime;
        _tmpBedTime = _cursor.getLong(_cursorIndexOfBedTime);
        final String _tmpSelectedDay;
        if (_cursor.isNull(_cursorIndexOfSelectedDay)) {
          _tmpSelectedDay = null;
        } else {
          _tmpSelectedDay = _cursor.getString(_cursorIndexOfSelectedDay);
        }
        final long _tmpSnoozeTime;
        _tmpSnoozeTime = _cursor.getLong(_cursorIndexOfSnoozeTime);
        final String _tmpTotalSleepingHr;
        if (_cursor.isNull(_cursorIndexOfTotalSleepingHr)) {
          _tmpTotalSleepingHr = null;
        } else {
          _tmpTotalSleepingHr = _cursor.getString(_cursorIndexOfTotalSleepingHr);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new AlarmEntity(_tmpSleepId,_tmpId,_tmpTime,_tmpLabel,_tmpIsEnabled,_tmpIsVibrationEnabled,_tmpSoundUri,_tmpAllDays,_tmpBedTime,_tmpSelectedDay,_tmpSnoozeTime,_tmpTotalSleepingHr,_tmpDate,null);
        final int _tmpIdd;
        _tmpIdd = _cursor.getInt(_cursorIndexOfIdd);
        _item.setIdd(_tmpIdd);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AlarmEntity> getAlarmBySleepId(final long id) {
    final String _sql = "SELECT * FROM alarm WHERE sleepId=? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSleepId = CursorUtil.getColumnIndexOrThrow(_cursor, "sleepId");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "label");
      final int _cursorIndexOfIsEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isEnabled");
      final int _cursorIndexOfIsVibrationEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "isVibrationEnabled");
      final int _cursorIndexOfSoundUri = CursorUtil.getColumnIndexOrThrow(_cursor, "soundUri");
      final int _cursorIndexOfAllDays = CursorUtil.getColumnIndexOrThrow(_cursor, "allDays");
      final int _cursorIndexOfBedTime = CursorUtil.getColumnIndexOrThrow(_cursor, "bedTime");
      final int _cursorIndexOfSelectedDay = CursorUtil.getColumnIndexOrThrow(_cursor, "selectedDay");
      final int _cursorIndexOfSnoozeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "snoozeTime");
      final int _cursorIndexOfTotalSleepingHr = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSleepingHr");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfIdd = CursorUtil.getColumnIndexOrThrow(_cursor, "idd");
      final List<AlarmEntity> _result = new ArrayList<AlarmEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AlarmEntity _item;
        final long _tmpSleepId;
        _tmpSleepId = _cursor.getLong(_cursorIndexOfSleepId);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpTime;
        _tmpTime = _cursor.getLong(_cursorIndexOfTime);
        final String _tmpLabel;
        if (_cursor.isNull(_cursorIndexOfLabel)) {
          _tmpLabel = null;
        } else {
          _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
        }
        final boolean _tmpIsEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsEnabled);
        _tmpIsEnabled = _tmp != 0;
        final boolean _tmpIsVibrationEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsVibrationEnabled);
        _tmpIsVibrationEnabled = _tmp_1 != 0;
        final String _tmpSoundUri;
        if (_cursor.isNull(_cursorIndexOfSoundUri)) {
          _tmpSoundUri = null;
        } else {
          _tmpSoundUri = _cursor.getString(_cursorIndexOfSoundUri);
        }
        final SparseBooleanArray _tmpAllDays;
        final String _tmp_2;
        if (_cursor.isNull(_cursorIndexOfAllDays)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getString(_cursorIndexOfAllDays);
        }
        _tmpAllDays = __alarmConverters.toSparseBooleanArray(_tmp_2);
        final long _tmpBedTime;
        _tmpBedTime = _cursor.getLong(_cursorIndexOfBedTime);
        final String _tmpSelectedDay;
        if (_cursor.isNull(_cursorIndexOfSelectedDay)) {
          _tmpSelectedDay = null;
        } else {
          _tmpSelectedDay = _cursor.getString(_cursorIndexOfSelectedDay);
        }
        final long _tmpSnoozeTime;
        _tmpSnoozeTime = _cursor.getLong(_cursorIndexOfSnoozeTime);
        final String _tmpTotalSleepingHr;
        if (_cursor.isNull(_cursorIndexOfTotalSleepingHr)) {
          _tmpTotalSleepingHr = null;
        } else {
          _tmpTotalSleepingHr = _cursor.getString(_cursorIndexOfTotalSleepingHr);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item = new AlarmEntity(_tmpSleepId,_tmpId,_tmpTime,_tmpLabel,_tmpIsEnabled,_tmpIsVibrationEnabled,_tmpSoundUri,_tmpAllDays,_tmpBedTime,_tmpSelectedDay,_tmpSnoozeTime,_tmpTotalSleepingHr,_tmpDate,null);
        final int _tmpIdd;
        _tmpIdd = _cursor.getInt(_cursorIndexOfIdd);
        _item.setIdd(_tmpIdd);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
