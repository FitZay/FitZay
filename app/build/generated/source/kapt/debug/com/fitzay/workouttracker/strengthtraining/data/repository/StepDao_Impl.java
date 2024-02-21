package com.fitzay.workouttracker.strengthtraining.data.repository;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fitzay.workouttracker.strengthtraining.data.model.Step;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StepDao_Impl implements StepDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Step> __insertionAdapterOfStep;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStepTable;

  public StepDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStep = new EntityInsertionAdapter<Step>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Step` (`steps`,`time`,`calories`,`distance`,`date`,`stepGoal`,`caloriesGoal`,`distanceGoal`,`timeGoal`,`id`) VALUES (?,?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Step value) {
        stmt.bindLong(1, value.getSteps());
        if (value.getTime() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTime());
        }
        stmt.bindDouble(3, value.getCalories());
        stmt.bindDouble(4, value.getDistance());
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
        stmt.bindLong(6, value.getStepGoal());
        stmt.bindDouble(7, value.getCaloriesGoal());
        stmt.bindDouble(8, value.getDistanceGoal());
        if (value.getTimeGoal() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeGoal());
        }
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfUpdateStepTable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Step SET steps = ?, distance = ?, time = ?, calories = ?, stepGoal = ?, caloriesGoal=?, distanceGoal=?  WHERE Date = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertStep(final Step step, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStep.insert(step);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateStepTable(final String date, final int newSteps, final double newDistance,
      final String newTime, final double newCalories, final int newStepGoal,
      final double caloriesGoal, final double distanceGoal,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStepTable.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, newSteps);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, newDistance);
        _argIndex = 3;
        if (newTime == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, newTime);
        }
        _argIndex = 4;
        _stmt.bindDouble(_argIndex, newCalories);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, newStepGoal);
        _argIndex = 6;
        _stmt.bindDouble(_argIndex, caloriesGoal);
        _argIndex = 7;
        _stmt.bindDouble(_argIndex, distanceGoal);
        _argIndex = 8;
        if (date == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, date);
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateStepTable.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Object getAllRecords(final Continuation<? super List<Step>> continuation) {
    final String _sql = "SELECT * FROM Step ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Step>>() {
      @Override
      public List<Step> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "stepGoal");
          final int _cursorIndexOfCaloriesGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesGoal");
          final int _cursorIndexOfDistanceGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceGoal");
          final int _cursorIndexOfTimeGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "timeGoal");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Step _item;
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final double _tmpCalories;
            _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
            final double _tmpDistance;
            _tmpDistance = _cursor.getDouble(_cursorIndexOfDistance);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpStepGoal;
            _tmpStepGoal = _cursor.getInt(_cursorIndexOfStepGoal);
            final double _tmpCaloriesGoal;
            _tmpCaloriesGoal = _cursor.getDouble(_cursorIndexOfCaloriesGoal);
            final double _tmpDistanceGoal;
            _tmpDistanceGoal = _cursor.getDouble(_cursorIndexOfDistanceGoal);
            final String _tmpTimeGoal;
            if (_cursor.isNull(_cursorIndexOfTimeGoal)) {
              _tmpTimeGoal = null;
            } else {
              _tmpTimeGoal = _cursor.getString(_cursorIndexOfTimeGoal);
            }
            _item = new Step(_tmpSteps,_tmpTime,_tmpCalories,_tmpDistance,_tmpDate,_tmpStepGoal,_tmpCaloriesGoal,_tmpDistanceGoal,_tmpTimeGoal);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public List<Step> getPaging() {
    final String _sql = "SELECT * FROM Step ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
      final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "stepGoal");
      final int _cursorIndexOfCaloriesGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesGoal");
      final int _cursorIndexOfDistanceGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceGoal");
      final int _cursorIndexOfTimeGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "timeGoal");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Step _item;
        final int _tmpSteps;
        _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        final double _tmpCalories;
        _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
        final double _tmpDistance;
        _tmpDistance = _cursor.getDouble(_cursorIndexOfDistance);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final int _tmpStepGoal;
        _tmpStepGoal = _cursor.getInt(_cursorIndexOfStepGoal);
        final double _tmpCaloriesGoal;
        _tmpCaloriesGoal = _cursor.getDouble(_cursorIndexOfCaloriesGoal);
        final double _tmpDistanceGoal;
        _tmpDistanceGoal = _cursor.getDouble(_cursorIndexOfDistanceGoal);
        final String _tmpTimeGoal;
        if (_cursor.isNull(_cursorIndexOfTimeGoal)) {
          _tmpTimeGoal = null;
        } else {
          _tmpTimeGoal = _cursor.getString(_cursorIndexOfTimeGoal);
        }
        _item = new Step(_tmpSteps,_tmpTime,_tmpCalories,_tmpDistance,_tmpDate,_tmpStepGoal,_tmpCaloriesGoal,_tmpDistanceGoal,_tmpTimeGoal);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Step isStepStepExists(final String date) {
    final String _sql = "SELECT * FROM Step WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
      final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "stepGoal");
      final int _cursorIndexOfCaloriesGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesGoal");
      final int _cursorIndexOfDistanceGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceGoal");
      final int _cursorIndexOfTimeGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "timeGoal");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Step _result;
      if(_cursor.moveToFirst()) {
        final int _tmpSteps;
        _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        final double _tmpCalories;
        _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
        final double _tmpDistance;
        _tmpDistance = _cursor.getDouble(_cursorIndexOfDistance);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final int _tmpStepGoal;
        _tmpStepGoal = _cursor.getInt(_cursorIndexOfStepGoal);
        final double _tmpCaloriesGoal;
        _tmpCaloriesGoal = _cursor.getDouble(_cursorIndexOfCaloriesGoal);
        final double _tmpDistanceGoal;
        _tmpDistanceGoal = _cursor.getDouble(_cursorIndexOfDistanceGoal);
        final String _tmpTimeGoal;
        if (_cursor.isNull(_cursorIndexOfTimeGoal)) {
          _tmpTimeGoal = null;
        } else {
          _tmpTimeGoal = _cursor.getString(_cursorIndexOfTimeGoal);
        }
        _result = new Step(_tmpSteps,_tmpTime,_tmpCalories,_tmpDistance,_tmpDate,_tmpStepGoal,_tmpCaloriesGoal,_tmpDistanceGoal,_tmpTimeGoal);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean isStepDateExists(final String date) {
    final String _sql = "SELECT EXISTS(SELECT * FROM Step WHERE date = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAllStepsCount() {
    final String _sql = "SELECT SUM(steps) FROM Step";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAverageStepCount() {
    final String _sql = "SELECT AVG(steps) FROM Step";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAverageStepForSpecificDate(final String date) {
    final String _sql = "SELECT AVG(steps) FROM Step WHERE date= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAverageStepsBetweenDates(final String startDate, final String endDate) {
    final String _sql = "SELECT AVG(steps) FROM Step WHERE date BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getWeeklyGoal(final String startDate, final String endDate,
      final Continuation<? super List<Step>> continuation) {
    final String _sql = "SELECT * FROM Step WHERE date BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Step>>() {
      @Override
      public List<Step> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "stepGoal");
          final int _cursorIndexOfCaloriesGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesGoal");
          final int _cursorIndexOfDistanceGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceGoal");
          final int _cursorIndexOfTimeGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "timeGoal");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Step _item;
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final double _tmpCalories;
            _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
            final double _tmpDistance;
            _tmpDistance = _cursor.getDouble(_cursorIndexOfDistance);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpStepGoal;
            _tmpStepGoal = _cursor.getInt(_cursorIndexOfStepGoal);
            final double _tmpCaloriesGoal;
            _tmpCaloriesGoal = _cursor.getDouble(_cursorIndexOfCaloriesGoal);
            final double _tmpDistanceGoal;
            _tmpDistanceGoal = _cursor.getDouble(_cursorIndexOfDistanceGoal);
            final String _tmpTimeGoal;
            if (_cursor.isNull(_cursorIndexOfTimeGoal)) {
              _tmpTimeGoal = null;
            } else {
              _tmpTimeGoal = _cursor.getString(_cursorIndexOfTimeGoal);
            }
            _item = new Step(_tmpSteps,_tmpTime,_tmpCalories,_tmpDistance,_tmpDate,_tmpStepGoal,_tmpCaloriesGoal,_tmpDistanceGoal,_tmpTimeGoal);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object getStepForSpecificDate(final String date,
      final Continuation<? super List<Step>> continuation) {
    final String _sql = "SELECT * FROM Step WHERE date= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Step>>() {
      @Override
      public List<Step> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSteps = CursorUtil.getColumnIndexOrThrow(_cursor, "steps");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "calories");
          final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfStepGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "stepGoal");
          final int _cursorIndexOfCaloriesGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesGoal");
          final int _cursorIndexOfDistanceGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceGoal");
          final int _cursorIndexOfTimeGoal = CursorUtil.getColumnIndexOrThrow(_cursor, "timeGoal");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Step _item;
            final int _tmpSteps;
            _tmpSteps = _cursor.getInt(_cursorIndexOfSteps);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            final double _tmpCalories;
            _tmpCalories = _cursor.getDouble(_cursorIndexOfCalories);
            final double _tmpDistance;
            _tmpDistance = _cursor.getDouble(_cursorIndexOfDistance);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpStepGoal;
            _tmpStepGoal = _cursor.getInt(_cursorIndexOfStepGoal);
            final double _tmpCaloriesGoal;
            _tmpCaloriesGoal = _cursor.getDouble(_cursorIndexOfCaloriesGoal);
            final double _tmpDistanceGoal;
            _tmpDistanceGoal = _cursor.getDouble(_cursorIndexOfDistanceGoal);
            final String _tmpTimeGoal;
            if (_cursor.isNull(_cursorIndexOfTimeGoal)) {
              _tmpTimeGoal = null;
            } else {
              _tmpTimeGoal = _cursor.getString(_cursorIndexOfTimeGoal);
            }
            _item = new Step(_tmpSteps,_tmpTime,_tmpCalories,_tmpDistance,_tmpDate,_tmpStepGoal,_tmpCaloriesGoal,_tmpDistanceGoal,_tmpTimeGoal);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
