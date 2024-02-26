package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityHeightandWeightBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.activities.PersonalizedWorkAct
import com.fitzay.workouttracker.strengthtraining.ui.activities.ProfileAct
import kotlin.math.ceil
import kotlin.math.floor

class HeightandWeightAct : AppCompatActivity() {

    private lateinit var binding: ActivityHeightandWeightBinding
    private var age = 0
    private var weight = 0
    private var targetweight = 0
    private var height = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeightandWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            ivBack.setOnClickListener {
                onBackPressed()
            }

            ftBtn.setOnClickListener {

                val feetAndInches = Pair(
                    height.toInt(),
                    height.toDouble()
                )
            }

            cmBtn.setOnClickListener {

                centimeterToFeet(height.toString())
            }
            btnNext.setOnClickListener {
                Component.preference.userAge=age
                Component.preference.userWeight=weight
                Component.preference.userHeight=height
                Component.preference.userTargetWight=targetweight
                startActivity(Intent(this@HeightandWeightAct, PersonalizedWorkAct::class.java))
                finish()
            }


            ageplusBtn.setOnClickListener {
                age++
                ageText.text = age.toString()
            }

            ageminusBtn.setOnClickListener {
                if (age > 0) {
                    age--
                    ageText.text = age.toString()
                }
            }


            weightplusBtn?.setOnClickListener {
                weight++
                binding.weightText?.text = weight.toString()
            }

            weightminlusBtn.setOnClickListener {
                if (weight > 0) {
                    weight--
                    weightText?.text = weight.toString()
                }
            }


            targetweightplusBtn?.setOnClickListener {
                targetweight++
                targetweightText.text = targetweight.toString()
            }

            targetweightminusBtn?.setOnClickListener {
                if (targetweight > 0) {
                    targetweight--
                    targetweightText.text = targetweight.toString()
                }
            }


            heightPlusBtn.setOnClickListener {
                height++
                binding.valueText.text = height.toString()
            }

            heightminusBtn.setOnClickListener {
                if (height > 0) {
                    height--
                    valueText.text = height.toString()
                }
            }


            cmBtn.setOnClickListener {
                cmBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.green))
                ftBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.lightgrey))
                cmText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.white))
                ftText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.textcolor))
            }


            binding.ftBtn.setOnClickListener {
                ftBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.green))
                cmBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.lightgrey))
                ftText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.white))
                cmText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.textcolor))
            }

        }

    }

    fun centimeterToFeet(centemeter: String?): Pair<Int, Int> {
        var feetPart = 0
        var inchesPart = 0
        if (!TextUtils.isEmpty(centemeter)) {
            val dCentimeter = java.lang.Double.valueOf(centemeter)
            feetPart = floor(dCentimeter / 2.54 / 12).toInt()
            println(dCentimeter / 2.54 - feetPart * 12)
            inchesPart = ceil(dCentimeter / 2.54 - feetPart * 12).toInt()
        }
        return Pair(feetPart, inchesPart)
        //  return String.format("%d %d", feetPart, inchesPart)
    }
}