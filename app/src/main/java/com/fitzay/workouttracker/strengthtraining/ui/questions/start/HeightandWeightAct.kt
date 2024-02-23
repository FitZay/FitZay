package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityHeightandWeightBinding

class HeightandWeightAct : AppCompatActivity() {

    private lateinit var binding: ActivityHeightandWeightBinding
    private var age = 0
    private var weight = 0
    private var targetweight = 0
    private var height = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeightandWeightBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ageplusBtn?.setOnClickListener {
            age++
            binding?.ageText?.text = age.toString()
        }

        binding?.ageminusBtn?.setOnClickListener {
            if (age > 0) {
                age--
                binding?.ageText?.text = age.toString()
            }
        }


        binding?.weightplusBtn?.setOnClickListener {
            weight++
            binding?.weightText?.text = weight.toString()
        }

        binding?.weightminlusBtn?.setOnClickListener {
            if (weight > 0) {
                weight--
                binding?.weightText?.text = weight.toString()
            }
        }


        binding?.targetweightplusBtn?.setOnClickListener {
            targetweight++
            binding?.targetweightText?.text = targetweight.toString()
        }

        binding?.targetweightminusBtn?.setOnClickListener {
            if (targetweight > 0) {
                targetweight--
                binding?.targetweightText?.text = targetweight.toString()
            }
        }


        binding?.heightPlusBtn?.setOnClickListener {
            height++
            binding?.valueText?.text = height.toString()
        }

        binding?.heightminusBtn?.setOnClickListener {
            if (height > 0) {
                height--
                binding?.valueText?.text = height.toString()
            }
        }


        binding?.cmBtn?.setOnClickListener {
            binding?.cmBtn?.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            binding?.ftBtn?.setBackgroundColor(ContextCompat.getColor(this, R.color.lightgrey))
            binding?.cmText?.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding?.ftText?.setTextColor(ContextCompat.getColor(this, R.color.textcolor))
        }


        binding?.ftBtn?.setOnClickListener {
            binding?.ftBtn?.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
            binding?.cmBtn?.setBackgroundColor(ContextCompat.getColor(this, R.color.lightgrey))
            binding?.ftText?.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding?.cmText?.setTextColor(ContextCompat.getColor(this, R.color.textcolor))
        }

    }
}