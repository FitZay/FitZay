package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPartShouldFocusBinding
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPushUpsDoBinding

class PushUpsDoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPushUpsDoBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPushUpsDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding?.btnNext?.setOnClickListener {
            startActivity(Intent(this , FirstNameActivity :: class.java))
            finish()
        }
    }
}