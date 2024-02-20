package com.fitzay.workouttracker.strengthtraining.domain.entities

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseBooleanArray
import androidx.room.PrimaryKey

class SleepEntity(
    var time: Long, // second unit
    val label: String? = null,

) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L
    constructor(parcel: Parcel) : this(

        parcel.readLong(),
        parcel.readString(),

    ) {
        id = parcel.readLong()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeLong(time)
        parcel.writeString(label)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SleepEntity> {


        override fun createFromParcel(parcel: Parcel): SleepEntity {
            return SleepEntity(parcel)
        }

        override fun newArray(size: Int): Array<SleepEntity?> {
            return arrayOfNulls(size)
        }
    }

}