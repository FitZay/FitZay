package com.fitzay.workouttracker.strengthtraining.ui.waterintake

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityCupCapacityBinding
import com.fitzay.workouttracker.strengthtraining.databinding.DialogWaterCapacityBinding
import com.fitzay.workouttracker.strengthtraining.di.Component

class CupCapacityActivity : AppUtil2() {
    private lateinit var binding: ActivityCupCapacityBinding
    lateinit var languageManager: LanguageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCupCapacityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        languageManager = LanguageManager(this@CupCapacityActivity)

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        binding.cup50.setOnClickListener {
            Component.preference.cupCapacity = 50
            finish()
        }
        binding.cup100.setOnClickListener {
            Component.preference.cupCapacity = 100
            finish()
        }
        binding.cup200.setOnClickListener {
            Component.preference.cupCapacity = 200
            finish()
        }
        binding.cup300.setOnClickListener {
            Component.preference.cupCapacity = 300
            finish()
        }
        binding.cup500.setOnClickListener {
            Component.preference.cupCapacity = 500
            finish()
        }
        binding.cupAdd.setOnClickListener { addWater() }

    }

    private fun addWater() {

        val dialog = Dialog(this@CupCapacityActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val waterBinding = DialogWaterCapacityBinding.inflate(layoutInflater)
        dialog.setContentView(waterBinding.root) //get layout from ExitDialog folder
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)


        waterBinding.btnSave.setOnClickListener {
            if (!waterBinding.tvCapacity.text.isEmpty()) {
                Component.preference.cupCapacity = waterBinding.tvCapacity.text.toString().toInt()
                dialog.dismiss()
                finishAfterTransition()
            }
            else
            {
                Toast.makeText(this@CupCapacityActivity,"Enter Value", Toast.LENGTH_SHORT).show()

            }


        }
        waterBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }
}