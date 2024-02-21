package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityFullbodyWorkoutBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel
import com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel

class FullbodyWorkoutActivity : AppCompatActivity() {

    private var binding : ActivityFullbodyWorkoutBinding? = null

    companion object {
        var listoffullbodies :  List<FullbodyCategoriesModel> = listOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullbodyWorkoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//
//        binding?.backpressBtn?.setOnClickListener {
//            finish()
//        }

        listoffullbodies = Component.workOutViewModel.fullbodygetCat(
            this,
            "1",
            "1"
        )

        Log.d("Gotitintheface" ,"${Component.workOutViewModel.fullbodygetCat(
            this,
            "1",
            "1"
        )}" )

        binding?.weekonedayoneBtn?.setOnClickListener {
            movetonextActivity("1" , "1")
        }
    }

    fun movetonextActivity(week : String , exId : String){
        val intent =
            Intent(
                this,
                DisplayWorkoutsActivity::class.java
            ).apply {

                putExtra("EXTRA_NAME", "full")
                putExtra("EXTRA_ID","")
                putExtra("EXTRA_TYPE", "mData[position].catType")
                putExtra("EXTRA_EXERCISE", "excercisetype")
                putExtra("EXTRA_Activity", "fullbody")
                putExtra("EXTRA_WEEk", week)
                putExtra("EXTRA_EXERCISE_ID", exId)

            }
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
    }
}