package com.fitzay.workouttracker.strengthtraining.data.datasource;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao;
import com.fitzay.workouttracker.strengthtraining.data.repository.AlarmDao_Impl;
import com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao;
import com.fitzay.workouttracker.strengthtraining.data.repository.SleepDao_Impl;
import com.fitzay.workouttracker.strengthtraining.data.repository.StepDao;
import com.fitzay.workouttracker.strengthtraining.data.repository.StepDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class Database_Impl extends Database {
  private volatile StepDao _stepDao;

  private volatile AlarmDao _alarmDao;

  private volatile SleepDao _sleepDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Step` (`steps` INTEGER NOT NULL, `time` TEXT, `calories` REAL NOT NULL, `distance` REAL NOT NULL, `date` TEXT, `stepGoal` INTEGER NOT NULL, `caloriesGoal` REAL NOT NULL, `distanceGoal` REAL NOT NULL, `timeGoal` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Alarm` (`sleepId` INTEGER NOT NULL, `id` INTEGER NOT NULL, `time` INTEGER NOT NULL, `label` TEXT, `isEnabled` INTEGER NOT NULL, `isVibrationEnabled` INTEGER NOT NULL, `soundUri` TEXT, `allDays` TEXT, `bedTime` INTEGER NOT NULL, `selectedDay` TEXT, `snoozeTime` INTEGER NOT NULL, `totalSleepingHr` TEXT, `date` TEXT, `idd` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Sleep` (`time` INTEGER NOT NULL, `label` TEXT, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '85eebc0c33de470d9bda254a6ec4642f')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Step`");
        _db.execSQL("DROP TABLE IF EXISTS `Alarm`");
        _db.execSQL("DROP TABLE IF EXISTS `Sleep`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsStep = new HashMap<String, TableInfo.Column>(10);
        _columnsStep.put("steps", new TableInfo.Column("steps", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("calories", new TableInfo.Column("calories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("distance", new TableInfo.Column("distance", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("stepGoal", new TableInfo.Column("stepGoal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("caloriesGoal", new TableInfo.Column("caloriesGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("distanceGoal", new TableInfo.Column("distanceGoal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("timeGoal", new TableInfo.Column("timeGoal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStep.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStep = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStep = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStep = new TableInfo("Step", _columnsStep, _foreignKeysStep, _indicesStep);
        final TableInfo _existingStep = TableInfo.read(_db, "Step");
        if (! _infoStep.equals(_existingStep)) {
          return new RoomOpenHelper.ValidationResult(false, "Step(com.fitzay.workouttracker.strengthtraining.data.model.Step).\n"
                  + " Expected:\n" + _infoStep + "\n"
                  + " Found:\n" + _existingStep);
        }
        final HashMap<String, TableInfo.Column> _columnsAlarm = new HashMap<String, TableInfo.Column>(14);
        _columnsAlarm.put("sleepId", new TableInfo.Column("sleepId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("isVibrationEnabled", new TableInfo.Column("isVibrationEnabled", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("soundUri", new TableInfo.Column("soundUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("allDays", new TableInfo.Column("allDays", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("bedTime", new TableInfo.Column("bedTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("selectedDay", new TableInfo.Column("selectedDay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("snoozeTime", new TableInfo.Column("snoozeTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("totalSleepingHr", new TableInfo.Column("totalSleepingHr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlarm.put("idd", new TableInfo.Column("idd", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlarm = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAlarm = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAlarm = new TableInfo("Alarm", _columnsAlarm, _foreignKeysAlarm, _indicesAlarm);
        final TableInfo _existingAlarm = TableInfo.read(_db, "Alarm");
        if (! _infoAlarm.equals(_existingAlarm)) {
          return new RoomOpenHelper.ValidationResult(false, "Alarm(com.fitzay.workouttracker.strengthtraining.data.model.Alarm).\n"
                  + " Expected:\n" + _infoAlarm + "\n"
                  + " Found:\n" + _existingAlarm);
        }
        final HashMap<String, TableInfo.Column> _columnsSleep = new HashMap<String, TableInfo.Column>(3);
        _columnsSleep.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleep.put("label", new TableInfo.Column("label", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSleep.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSleep = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSleep = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSleep = new TableInfo("Sleep", _columnsSleep, _foreignKeysSleep, _indicesSleep);
        final TableInfo _existingSleep = TableInfo.read(_db, "Sleep");
        if (! _infoSleep.equals(_existingSleep)) {
          return new RoomOpenHelper.ValidationResult(false, "Sleep(com.fitzay.workouttracker.strengthtraining.data.model.Sleep).\n"
                  + " Expected:\n" + _infoSleep + "\n"
                  + " Found:\n" + _existingSleep);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "85eebc0c33de470d9bda254a6ec4642f", "433c1a97016a69494d2de35d8df1c242");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Step","Alarm","Sleep");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Step`");
      _db.execSQL("DELETE FROM `Alarm`");
      _db.execSQL("DELETE FROM `Sleep`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(StepDao.class, StepDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SleepDao.class, SleepDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public StepDao getStepDao() {
    if (_stepDao != null) {
      return _stepDao;
    } else {
      synchronized(this) {
        if(_stepDao == null) {
          _stepDao = new StepDao_Impl(this);
        }
        return _stepDao;
      }
    }
  }

  @Override
  public AlarmDao getAlarmDao() {
    if (_alarmDao != null) {
      return _alarmDao;
    } else {
      synchronized(this) {
        if(_alarmDao == null) {
          _alarmDao = new AlarmDao_Impl(this);
        }
        return _alarmDao;
      }
    }
  }

  @Override
  public SleepDao getSleepDao() {
    if (_sleepDao != null) {
      return _sleepDao;
    } else {
      synchronized(this) {
        if(_sleepDao == null) {
          _sleepDao = new SleepDao_Impl(this);
        }
        return _sleepDao;
      }
    }
  }
}
