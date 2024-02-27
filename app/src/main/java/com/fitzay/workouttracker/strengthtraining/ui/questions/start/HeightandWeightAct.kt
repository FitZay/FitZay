package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.toCentimeters
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityHeightandWeightBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.activities.PersonalizedWorkAct
import com.fitzay.workouttracker.strengthtraining.ui.activities.ProfileAct
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round
import kotlin.math.roundToInt

class HeightandWeightAct : AppUtil2() {

    private lateinit var binding: ActivityHeightandWeightBinding
    private var age = 0
    private var weight = 0
    private var targetweight = 0
    private var height = 0

    var check=true
    var check2=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeightandWeightBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            ivBack.setOnClickListener {
                onBackPressed()
            }

//            ftBtn.setOnClickListener {
//
//                val feetAndInches = Pair(
//                    height.toInt(),
//                    height.toDouble()
//                )
//            }
//
//            cmBtn.setOnClickListener {
//
//                centimeterToFeet(height.toString())
//            }
            btnNext.setOnClickListener {
                Component.preference.userAge=age
                Component.preference.userWeight=weight
                Component.preference.userHeight=height
                Component.preference.userTargetWight=targetweight
                startActivity(Intent(this@HeightandWeightAct, PersonalizedWorkAct::class.java))
                finish()
            }


            ageplusBtn.setOnClickListener {
                check=true
                check2=true
                age++
                ageText.text = age.toString()
            }

            ageminusBtn.setOnClickListener {
                if (age > 0) {
                    check=true
                    check2=true
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
                try {
                    if (!valueText.text.isNullOrEmpty())
                    {
                        if (check){
                            check = false
                            check2 = true
                            val centimeters = valueText.text.toString().toDouble()
                            val cn =inchesToCm(centimeters)
                            valueText.setText(cn.toString())
                        }
                    }

                    cmBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.green))
                    ftBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.lightgrey))
                    cmText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.white))
                    ftText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.textcolor))
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }

            }


            ftBtn.setOnClickListener {
                try {
                    if (!valueText.text.isNullOrEmpty()) {
                        if (check2){
                            check2 = false
                            check = true
                            val con = cmToInches(valueText.text.toString().toDouble())
                            valueText.setText(con.toString())
                        }
                    }
                    ftBtn.setBackgroundColor(
                        ContextCompat.getColor(
                            this@HeightandWeightAct,
                            R.color.green
                        )
                    )
                    cmBtn.setBackgroundColor(
                        ContextCompat.getColor(
                            this@HeightandWeightAct,
                            R.color.lightgrey
                        )
                    )
                    ftText.setTextColor(
                        ContextCompat.getColor(
                            this@HeightandWeightAct,
                            R.color.white
                        )
                    )
                    cmText.setTextColor(
                        ContextCompat.getColor(
                            this@HeightandWeightAct,
                            R.color.textcolor
                        )
                    )
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }
            }

        }

    }


    fun cmToInches(cm: Double): Double {
        var result =  cm / 2.54
        return round(result * 100.0) / 100.0
    }

    fun inchesToCm(inches: Double): Double {
        val result = inches * 2.54
        return round(result * 100.0) / 100.0
    }

    override fun onStart() {
        super.onStart()
        LanguageManager(this@HeightandWeightAct)
    }
}