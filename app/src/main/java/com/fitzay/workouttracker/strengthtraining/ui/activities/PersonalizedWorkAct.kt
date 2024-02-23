package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPersonalizedWorkBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.AskingHeightActivity

class PersonalizedWorkAct : AppCompatActivity() {

    private lateinit var binding:ActivityPersonalizedWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalizedWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnNext.setOnClickListener {
                if (AppController.inappflow)
            {
                val intent = Intent(this@PersonalizedWorkAct, PremiumActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                startActivity(intent)
            }
                else
                {
                    if (AppController.inappScenario=="2") {
                        val intent =
                            Intent(this@PersonalizedWorkAct, MainActivity::class.java).apply {
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                            }
                        startActivity(intent)
                    }
                    else
                    {
                        if (AppController.inappflow)
                        {
                            val intent = Intent(this@PersonalizedWorkAct, PremiumActivity::class.java).apply {
                                Intent.FLAG_ACTIVITY_SINGLE_TOP
                            }
                            startActivity(intent)
                        }

                        else {
                            val intent =
                                Intent(this@PersonalizedWorkAct, MainActivity::class.java).apply {
                                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                                }
                            startActivity(intent)
                        }
                    }
                }

            }
        }
    }
}