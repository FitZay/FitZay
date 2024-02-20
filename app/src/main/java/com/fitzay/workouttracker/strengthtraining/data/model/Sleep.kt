package com.fitzay.workouttracker.strengthtraining.data.model

import android.os.Parcel
import android.os.Parcelable
import android.util.SparseBooleanArray
import androidx.annotation.Keep
import androidx.core.util.containsValue
import androidx.core.util.forEach
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity
import java.text.DateFormatSymbols
import java.util.*

@Keep
@Entity
data class Sleep(
//    @PrimaryKey(autoGenerate = true)
//    val id: Long,
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


    fun toDomain(): SleepEntity {
        return SleepEntity(
            this.time,
            this.label
        )
    }

    companion object CREATOR : Parcelable.Creator<Sleep> {
        fun fromDomain(alarmEntity: SleepEntity): Sleep {
            return Sleep(
                alarmEntity.time,
                alarmEntity.label,
            )
        }
        override fun createFromParcel(parcel: Parcel): Sleep {
            return Sleep(parcel)
        }

        override fun newArray(size: Int): Array<Sleep?> {
            return arrayOfNulls(size)
        }
    }


}