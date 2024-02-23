package com.fitzay.workouttracker.strengthtraining.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityBmiBinding

class BmiAct : AppCompatActivity() {
    private lateinit var binding:ActivityBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnNext.setOnClickListener {
            }
        }
    }
}