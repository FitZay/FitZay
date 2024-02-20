package com.fitzay.workouttracker.strengthtraining.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fitzay.workouttracker.strengthtraining.domain.entities.StepEntity

@Entity
data class Step(
    val steps: Int,
    val time: String?,
    val calories: Double,
    val distance: Double,
    val date: String?,
    val stepGoal: Int,
    val caloriesGoal: Double,
    val distanceGoal: Double,
    val timeGoal: String?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
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
        parcel.readString(),
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


    fun toDomain(): StepEntity {
        return StepEntity(
            this.steps,
            this.time,
            this.calories,
            this.distance,
            this.date,
            this.stepGoal,
            this.caloriesGoal,
            this.distanceGoal,
            this.timeGoal
        )
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Step> {


        fun fromDomain(stepEntity: StepEntity): Step {
            return Step(
                stepEntity.steps,
                stepEntity.time,
                stepEntity.calories,
                stepEntity.distance,
                stepEntity.date,
                stepEntity.stepGoal,
                stepEntity.caloriesGoal,
                stepEntity.distanceGoal,
                stepEntity.timeGoal
            )
        }

        override fun createFromParcel(parcel: Parcel): Step {
            return Step(parcel)
        }

        override fun newArray(size: Int): Array<Step?> {
            return arrayOfNulls(size)
        }
    }

}