package com.fitzay.workouttracker.strengthtraining.domain.entities

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseBooleanArray
import androidx.room.Ignore
import androidx.room.PrimaryKey

class AlarmEntity(

    val sleepId: Long,
    val id: Long,
    var time: Long, // second unit
    val label: String? = null,
    var isEnabled: Boolean,
    val isVibrationEnabled: Boolean,
    val soundUri: String? = null,
    val allDays: SparseBooleanArray? = null, // from sunday[1] ... sat[7]
    val bedTime: Long, // second unit
    val selectedDay: String? = null,
    val snoozeTime:Long,
    val totalSleepingHr:String?=null,
    val date:String?=null,
    var days: String? =""
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var idd: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readSparseBooleanArray(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
        idd = parcel.readInt()
    }

    constructor():this(0L,0L,0L,"",false,false,"",null,0L,"",0L,"","")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(sleepId)
        parcel.writeLong(id)
        parcel.writeLong(time)
        parcel.writeString(label)
        parcel.writeByte(if (isEnabled) 1 else 0)
        parcel.writeByte(if (isVibrationEnabled) 1 else 0)
        parcel.writeString(soundUri)
        parcel.writeSparseBooleanArray(allDays)
        parcel.writeLong(bedTime)
        parcel.writeString(selectedDay)
        parcel.writeLong(snoozeTime)
        parcel.writeString(totalSleepingHr)
        parcel.writeString(date)
        parcel.writeString(days)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmEntity> {


        override fun createFromParcel(parcel: Parcel): AlarmEntity {
            return AlarmEntity(parcel)
        }

        override fun newArray(size: Int): Array<AlarmEntity?> {
            return arrayOfNulls(size)
        }
    }

}