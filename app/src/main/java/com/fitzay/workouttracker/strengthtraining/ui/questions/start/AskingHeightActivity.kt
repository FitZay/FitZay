package com.fitzay.workouttracker.strengthtraining.ui.questions.start

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.*
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityAskingHeightBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlin.math.ceil
import kotlin.math.floor


class AskingHeightActivity : AppUtil2() {

    private lateinit var binding: ActivityAskingHeightBinding
    var isCM = true

    var cm: Double = 0.0
    var ft: Int = 0
    var inch: Double = 0.0

    var checkType="CM"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeHeight?.ctacolor
        binding = ActivityAskingHeightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ivBack.setOnClickListener {
                onBackPressed()
            }

            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeHeight.showAd) {
                clAds.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            txtSkip.setOnClickListener {


                val intent = Intent(this@AskingHeightActivity, AskingWeightActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                val anim = ActivityOptions.makeCustomAnimation(this@AskingHeightActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                startActivity(intent)

            }


            rbFeetInch.setOnClickListener {
                llCm.visibility = View.GONE
                llFeetInch.visibility = View.VISIBLE
                checkType="FT"

                if (checkType=="FT" && !etInputCm.text.isNullOrEmpty())
                {
                    val centimeters = etInputCm.text.toString().toDouble()
                        val cn = centimeterToFeet(centimeters.toString())
                        etInputFeet.setText(cn.first.toString())
                        etInputInch.setText(cn.second.toString())


                }
                else
                {
                    Log.i("TAG", "5555555555: ")
                }
                etInputFeet.requestFocus();
                etInputFeet.setSelection(etInputFeet.length())

            }
            rbCm.setOnClickListener {
                try {
                    llCm.visibility = View.VISIBLE
                    llFeetInch.visibility = View.GONE
                    checkType = "CM"

                    if (checkType == "CM" && !etInputFeet.text.isNullOrEmpty() && !etInputFeet.text.isNullOrEmpty()) {
                        val feetAndInches = Pair(
                            etInputFeet.text.toString().toInt(),
                            etInputInch.text.toString().toDouble()
                        )
                        val con = feetAndInches.toCentimeters()
                        etInputCm.setText(con.toString())
                        Log.i("TAG", "onCreateCON: " + con)

                    } else {
                        Log.i("TAG", "888888888: ")

                    }
//                    etInputCm.requestFocus();
//                    etInputCm.setSelection(etInputCm.length())
                } catch (e:Exception)
                {
                    Log.i("TAG", "onCreate: "+e.message)
                }
            }
//            rbOptions.setOnCheckedChangeListener { group, checkedId ->
//                if (checkedId == R.id.rbCm) {
//                    isCM = true
//                    llCm.visibility = View.VISIBLE
//                    llFeetInch.visibility = View.GONE
//
//                    if (!etInputFeet.text.isNullOrEmpty() && !etInputInch.text.isNullOrEmpty()) {
//
//                        val feetAndInches = Pair(etInputFeet.text.toString().toInt(), etInputInch.text.toString().toDouble())
//                        val con=feetAndInches.toCentimeters()
//                        cm=con
//                        Log.e("Ft_", "onCreate: $con")
//                       etInputCm.setText(con.toString())
//
//                    }
//
//                }
//                else {
//                    isCM = false
//                    llCm.visibility = View.GONE
//                    llFeetInch.visibility = View.VISIBLE
//
//                    if (!etInputCm.text.isNullOrEmpty()) {
//                        val centimeters = etInputCm.text.toString().toDouble()
//                        val cn = centimeterToFeet(centimeters.toString())
//                        Log.e("Ft_", "New Conv : $cn")
//                        ft=cn.first
//                        inch=cn.second.toDouble()
//
//                        etInputFeet.setText(cn.first.toString())
//                        etInputInch.setText(cn.second.toString())
//                    }
//
//                }
//            }

//            if (Component.preference.userHeightType == "CM") {
//                etInputCm.setText(Component.preference.userHeight.toString())
//            } else if (Component.preference.userHeightType == "FT") {
//                etInputFeet.setText(Component.preference.userHeightFt.toString())
//                etInputInch.setText(Component.preference.userHeightInch.toString())
//            }

            btnNext.setOnClickListener {

                try {
                    if (checkType=="CM" && !etInputCm.text.isNullOrEmpty())
                    {
                        cm=etInputCm.text.toString().toDouble()
                        Component.preference.userHeight = cm.roundToNearestWhole()
                        Log.i("TAG", "onCreate: "+cm)


                        val intent = Intent(this@AskingHeightActivity, AskingWeightActivity::class.java).apply {
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        }
                        val anim = ActivityOptions.makeCustomAnimation(this@AskingHeightActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                        startActivity(intent)

                        Component.preference.userHeightType = checkType
                    }
                    else if (checkType=="FT" && !etInputFeet.text.isNullOrEmpty())
                    {
                        Component.preference.userHeightType = checkType
                        ft = etInputFeet.text.toString().toInt()


                        if (etInputInch.text.toString().isEmpty())
                        {
                            etInputInch.setText("0").toString().toDouble()
                        }
                        else
                        {
                            inch = etInputInch.text.toString().toDouble()
                        }

                        Component.preference.userHeightFt = ft
                        Component.preference.userHeightInch = inch.toInt()

                        Log.i("TAG", "onCreate: "+ft)
                        Log.i("TAG", "onCreate: "+etInputInch.text.toString())
                        val intent = Intent(this@AskingHeightActivity, AskingWeightActivity::class.java).apply {
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        }
                        val anim = ActivityOptions.makeCustomAnimation(this@AskingHeightActivity, R.anim.slide_in_right, R.anim.slide_out_left).toBundle()
                        startActivity(intent)
                    }
                }
                catch (e: NumberFormatException){
                    Log.e("Exception", "onCreate: "+e.message )
                    Log.i("TAG", "onCreate: "+etInputInch.text.toString())
                    if (etInputInch.text.toString().isEmpty())
                    {
                        etInputInch.setText("0").toString().toDouble()
                    }

                    Toast.makeText(this@AskingHeightActivity, "Enter a valid number", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()

                }
//                try {
//                    if (isCM && !etInputCm.text.isNullOrEmpty()) {
//                        Component.preference.userHeightType = "CM"
//                        if (cm==0.0){
//                            cm=etInputCm.text.toString().toDouble()
//                        }
//                        Component.preference.userHeight = cm.roundToNearestWhole()
//                        Log.e("CM", "onCreate: " +cm )
//                        startActivity(Intent(this@AskingHeightActivity, AskingWeightActivity::class.java))
//                        // finish()
//                    } else if (!isCM && !etInputFeet.text.isNullOrEmpty()) {
//                        Component.preference.userHeightType = "FT"
//                        Component.preference.userHeightFt = etInputFeet.text.toString().toInt()
//                        Component.preference.userHeightInch = etInputInch.text.toString().toInt()
//
////                        Component.preference.userHeightFt = ft
////                        Component.preference.userHeightInch = inch.toInt()
//                        startActivity(Intent(this@AskingHeightActivity, AskingWeightActivity::class.java))
//                        /// finish()
//
//                        Log.e("FT", "onCreate: " +Component.preference.userHeightFt )
//                        Log.e("FT", "onCreate: " +Component.preference.userHeightInch )
//                    } else {
//                        showToast("Add Your Height!")
//                    }
//                } catch (e: NumberFormatException) {
//                    Log.e("Exception", "onCreate: "+e.message )
//                    Toast.makeText(this@AskingHeightActivity, "Enter a valid number", Toast.LENGTH_SHORT).show()
//                    e.printStackTrace()
//                }
            }



            etInputFeet.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && etInputFeet.text.toString().isNullOrEmpty()) {
                        etInputFeet.setHint("")
                }

            }

            etInputInch.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus && etInputInch.text.toString().isNullOrEmpty()) {
                        etInputInch.setHint("")
                }

            }

            etInputFeet.requestFocus();
            etInputInch.requestFocus();
            etInputCm.requestFocus();
            etInputFeet.setSelection(etInputFeet.length())
            etInputInch.setSelection(etInputInch.length())
            etInputCm.setSelection(etInputCm.length())
        }




    }


    fun feetToCentimeter(feet: String): String? {
        var dCentimeter = 0.0

            if (feet.contains("'")) {
                val tempfeet = feet.substring(0, feet.indexOf("'"))
                if (!TextUtils.isEmpty(tempfeet)) {
                    dCentimeter += java.lang.Double.valueOf(tempfeet) * 30.48
                }
            }
            if (feet.contains("\"")) {
                val tempinch = feet.substring(feet.indexOf("'") + 1, feet.indexOf("\""))
                if (!TextUtils.isEmpty(tempinch)) {
                    dCentimeter += java.lang.Double.valueOf(tempinch) * 2.54
                }
            }

        return dCentimeter.toString()
        //Format to decimal digit as per your requirement
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

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (AppController.fitzayModel!!.FitzayNativeHeight.ctalocation == "up") {
                plannerTemplateDown.visibility = View.GONE
                plannerTemplateUp.visibility = View.VISIBLE
                plannerTemplateUp
            } else {
                plannerTemplateDown.visibility = View.VISIBLE
                plannerTemplateUp.visibility = View.GONE
                plannerTemplateDown
            }

            if (AppController.fitzayModel != null) {
                val adLoader =
                    AdLoader.Builder(
                        this@AskingHeightActivity,
                        AppController.fitzayModel!!.FitzayNativeHeight.adID
                    )
                        .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                            template.setNativeAd(NativeAd)
                            skeletonLayout.visibility = View.GONE
                            clAds.visibility = View.VISIBLE
                            layoutAd.visibility = View.VISIBLE

                        }.withAdListener(object : AdListener() {
                            override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                                super.onAdFailedToLoad(loadAdError)
                                clAds.visibility = View.GONE
                                layoutAd.visibility = View.GONE
                            }
                        })
                        .withNativeAdOptions(
                            NativeAdOptions.Builder()
                                .setRequestCustomMuteThisAd(true)
                                .setAdChoicesPlacement(NativeAdOptions.ADCHOICES_TOP_LEFT)
                                .build()
                        )
                        .build()

                adLoader.loadAd(AdRequest.Builder().build())
            }
        }

    }

//    override fun finish() {
//        super.finish()
//        val intent = Intent(this@AskingHeightActivity, AskingAgeActivity::class.java).apply {
//            Intent.FLAG_ACTIVITY_SINGLE_TOP
//        }
//        val anim = ActivityOptions.makeCustomAnimation(this@AskingHeightActivity, R.anim.slide_in_left, R.anim.slide_out_right).toBundle()
//        startActivity(intent)
//    }

    override fun onStart() {
        super.onStart()
        LanguageManager(this@AskingHeightActivity)
        binding.apply {
        if (Component.preference.userHeight != 0 || Component.preference.userHeightFt != 0 || Component.preference.userHeightInch != 0) {
            //if (Component.preference.userHeightType == "CM") {
           etInputCm.setText(Component.preference.userHeight.toString())
//        } else if (Component.preference.userHeightType == "FT") {
           etInputFeet.setText(Component.preference.userHeightFt.toString())
            etInputInch.setText(Component.preference.userHeightInch.toString())
           etInputFeet.setSelection(etInputFeet.length())
            etInputInch.setSelection(etInputInch.length())
           etInputCm.setSelection(etInputCm.length())
        }
    }
    }
}