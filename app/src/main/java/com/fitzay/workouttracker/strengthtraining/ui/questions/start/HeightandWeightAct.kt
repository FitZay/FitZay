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
    private var age = 5
    private var weight = 25
    private var targetweight = 50
    private var height = 0

    var check=true
    var check2=true
    var type="CM"
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
                try {

                Component.preference.userAge = age
                Component.preference.userWeight = weight
                Component.preference.userTargetWight = targetweight
                if (type == "CM" && valueText.text.isNotEmpty() && valueText.text != "") {
                    Component.preference.userHeightType = type
                    Component.preference.userHeight = valueText.text.toString().toDouble().toInt()
                } else {
                    if (type == "FT" && valueText.text.isNotEmpty() && valueText.text != "") {
                        Component.preference.userHeightFt = valueText.text.toString().toDouble().toInt()
                    } else {

                        Component.preference.userHeight = 0
                    }
                    Component.preference.userHeightType = type
                }
                startActivity(Intent(this@HeightandWeightAct, PersonalizedWorkAct::class.java))
                finish()

                    Log.i("TAG---", "onCreate: "+age)
            }
                catch (e:Exception){}
            }

            //userAge.setSelectedItemPosition(Component.preference.userAge)
            Log.i("TAG---", "onCreate: "+Component.preference.userAge)

            ageplusBtn.setOnClickListener {
                check=true
                check2=true
//                age++
//                ageText.text = age.toString()
                age=userAge.getCurrentSelectedItemPosition()
                userAge.setSelectedItemPosition(age + 1)
                age=userAge.getCurrentSelectedItem()!!.toInt()
            }

            ageminusBtn.setOnClickListener {
               // if (age > 0) {
                    check=true
                    check2=true
//                    age--
//                    ageText.text = age.toString()
               // }
                age = userAge.getCurrentSelectedItemPosition()
                if (age > 0) {
                    userAge.setSelectedItemPosition(age - 1)
                    age = userAge.getCurrentSelectedItem()!!.toInt()
                }
            }


            weightplusBtn?.setOnClickListener {
//                weight++
//                binding.weightText?.text = weight.toString()

                weight=weightWh.getCurrentSelectedItemPosition()
                weightWh.setSelectedItemPosition(weight + 1)
                weight=weightWh.getCurrentSelectedItem()!!.toInt()
            }

            weightminlusBtn.setOnClickListener {
//                if (weight > 0) {
//                    weight--
//                    weightText?.text = weight.toString()
//                }
                weight = weightWh.getCurrentSelectedItemPosition()
                if (weight > 0) {
                    weightWh.setSelectedItemPosition(weight - 1)
                    weight = weightWh.getCurrentSelectedItem()!!.toInt()
                }
            }


            targetweightplusBtn?.setOnClickListener {
//                targetweight++
//                targetweightText.text = targetweight.toString()

                targetweight=targetWeight.getCurrentSelectedItemPosition()
                targetWeight.setSelectedItemPosition(targetweight + 1)
                targetweight=targetWeight.getCurrentSelectedItem()!!.toInt()
            }

            targetweightminusBtn?.setOnClickListener {
//                if (targetweight > 0) {
//                    targetweight--
//                    targetweightText.text = targetweight.toString()
//                }
                targetweight = targetWeight.getCurrentSelectedItemPosition()
                if (targetweight > 0) {
                    targetWeight.setSelectedItemPosition(targetweight - 1)
                    targetweight = targetWeight.getCurrentSelectedItem()!!.toInt()
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
                    var cn=0.0
                    if (!valueText.text.isNullOrEmpty())
                    {
                        if (check){
                            type="CM"
                            check = false
                            check2 = true
                            val centimeters = valueText.text.toString().toDouble()
                            cn =inchesToCm(centimeters)
                            valueText.setText(cn.toString())
                            Component.preference.userHeight = cn.toInt()


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
                var con=0.0
                try {
                    if (!valueText.text.isNullOrEmpty()) {
                        if (check2){
                            type="FT"

                            check2 = false
                            check = true
                            con = cmToInches(valueText.text.toString().toDouble())
                            valueText.setText(con.toString())
                            Component.preference.userHeight = con.toInt()

                        }
                    }
                    ftBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.green))
                    cmBtn.setBackgroundColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.lightgrey))
                    ftText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.white))
                    cmText.setTextColor(ContextCompat.getColor(this@HeightandWeightAct, R.color.textcolor))
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