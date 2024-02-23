package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPartShouldFocusBinding

class PartShouldFocusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPartShouldFocusBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartShouldFocusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding?.btnNext?.setOnClickListener {
            startActivity(Intent(this , PushUpsDoActivity::class.java))
            finish()
        }
    }
}