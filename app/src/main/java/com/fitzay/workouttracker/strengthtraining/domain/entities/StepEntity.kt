package com.fitzay.workouttracker.strengthtraining.domain.entities

import android.os.Parcel
import android.os.Parcelable

class StepEntity(
    val steps: Int,
    val time: String?,
    val calories: Double,
    val distance: Double,
    val date: String?,
    val stepGoal: Int,
    val caloriesGoal: Double,
    val distanceGoal: Double,
    val timeGoal: String?
): Parcelable {
    var id: Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()
    ) {
        id = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(steps)
        parcel.writeString(time)
        parcel.writeDouble(calories)
        parcel.writeDouble(distance)
        parcel.writeString(date)
        parcel.writeInt(stepGoal)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StepEntity> {

        override fun createFromParcel(parcel: Parcel): StepEntity {
            return StepEntity(parcel)
        }

        override fun newArray(size: Int): Array<StepEntity?> {
            return arrayOfNulls(size)
        }
    }
}