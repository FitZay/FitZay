package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPartShouldFocusBinding

class PartShouldFocusActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPartShouldFocusBinding

    private var isArmsbtnClicked = false
    private var isChestbtnClicked = true
    private var isBellybtnClicked = true
    private var isLegbtnClicked = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartShouldFocusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val whitetintColor = ContextCompat.getColor(this, R.color.white)
        val greytintColor = ContextCompat.getColor(this, R.color.outline_color)

        binding?.btnNext?.setOnClickListener {
            val intent = Intent(this@PartShouldFocusActivity, PushUpsDoActivity::class.java).apply {
                Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)

        }
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding?.clArms?.setOnClickListener {
            if (isArmsbtnClicked){
                isArmsbtnClicked = false
                binding?.clArms?.setStrokeColor(ContextCompat.getColor(this , R.color.white))
                binding?.tvArms?.setTextColor(ContextCompat.getColor(this , R.color.white))
                binding?.ivArms?.setColorFilter(whitetintColor, PorterDuff.Mode.SRC_IN)
            }
            else {
                isArmsbtnClicked = true
                binding?.clArms?.setStrokeColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.tvArms?.setTextColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.ivArms?.setColorFilter(greytintColor, PorterDuff.Mode.SRC_IN)
            }


        }

        binding?.clChest?.setOnClickListener {
            if (isChestbtnClicked){
                isChestbtnClicked = false
                binding?.clChest?.setStrokeColor(ContextCompat.getColor(this , R.color.white))
                binding?.tvChest?.setTextColor(ContextCompat.getColor(this , R.color.white))
                binding?.ivChest?.setColorFilter(whitetintColor, PorterDuff.Mode.SRC_IN)
            }
            else {
                isChestbtnClicked = true
                binding?.clChest?.setStrokeColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.tvChest?.setTextColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.ivChest?.setColorFilter(greytintColor, PorterDuff.Mode.SRC_IN)
            }

        }

        binding?.clBelly?.setOnClickListener {

            if (isBellybtnClicked){
                isBellybtnClicked = false
                binding?.clBelly?.setStrokeColor(ContextCompat.getColor(this , R.color.white))
                binding?.tvBelly?.setTextColor(ContextCompat.getColor(this , R.color.white))
                binding?.ivBelly?.setColorFilter(whitetintColor, PorterDuff.Mode.SRC_IN)
            }
            else {
                isBellybtnClicked = true
                binding?.clBelly?.setStrokeColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.tvBelly?.setTextColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.ivBelly?.setColorFilter(greytintColor, PorterDuff.Mode.SRC_IN)
            }
        }

        binding?.clLeg?.setOnClickListener {
            if (isLegbtnClicked){
                isLegbtnClicked = false
                binding?.clLeg?.setStrokeColor(ContextCompat.getColor(this , R.color.white))
                binding?.tvLeg?.setTextColor(ContextCompat.getColor(this , R.color.white))
                binding?.ivLeg?.setColorFilter(whitetintColor, PorterDuff.Mode.SRC_IN)
            }
            else {
                isLegbtnClicked = true
                binding?.clLeg?.setStrokeColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.tvLeg?.setTextColor(ContextCompat.getColor(this , R.color.outline_color))
                binding?.ivLeg?.setColorFilter(greytintColor, PorterDuff.Mode.SRC_IN)
            }
        }
    }


}