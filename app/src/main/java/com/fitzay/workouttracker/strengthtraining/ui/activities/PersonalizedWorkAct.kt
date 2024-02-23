package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPersonalizedWorkBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.AskingHeightActivity

class PersonalizedWorkAct : AppCompatActivity() {

    private lateinit var binding:ActivityPersonalizedWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalizedWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnNext.setOnClickListener {
            }
        }
    }
}