package com.fitzay.workouttracker.strengthtraining.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityFullbodyWorkoutBinding

class FullbodyWorkoutActivity : AppCompatActivity() {

    private var binding : ActivityFullbodyWorkoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullbodyWorkoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.backpressBtn?.setOnClickListener {
            finish()
        }
    }
}