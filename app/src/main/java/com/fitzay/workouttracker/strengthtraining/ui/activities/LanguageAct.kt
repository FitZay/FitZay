package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper
import com.fitzay.workouttracker.strengthtraining.core.utils.setLocale
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityLanguageBinding
import com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity
import com.fitzay.workouttracker.strengthtraining.ui.adapters.LanguageShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.adapters.RingToneShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.callback.LanguageItemClick
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.GenderActivity
import com.fitzay.workouttracker.strengthtraining.ui.questions.start.PartShouldFocusActivity
import java.util.Locale

class LanguageAct : AppCompatActivity(),LanguageItemClick {


    private lateinit var binding:ActivityLanguageBinding
    private  var adapter:LanguageShowAdapter?=null
    private  var list=ArrayList<LanguageM>()
    lateinit var sharedPreferencesHelper:SharedPreferencesHelper

    var lang="English"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language)

        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)



        list.add(LanguageM("English", R.drawable.english__usa_, false))
        list.add(LanguageM("Arabic", R.drawable.arabic, false))
        list.add(LanguageM("Hindi", R.drawable.india__in__1, false))
        list.add(LanguageM("Mandarin Chinese", R.drawable.mandarin_chinese, false))
        list.add(LanguageM("Spanish", R.drawable.spanish, false))
        list.add(LanguageM("French", R.drawable.french, false))
        list.add(LanguageM("Italian", R.drawable.italy__it__1, false))
        list.add(LanguageM("Russian", R.drawable.russian, false))
        list.add(LanguageM("Portuguese", R.drawable.portugal, false))
        list.add(LanguageM("Japanese", R.drawable.japanese, false))


        binding.apply {
            sharedPreferencesHelper = SharedPreferencesHelper(this@LanguageAct)
            var la=intent.getStringExtra("invisibleKey")
            if (la=="invisible")
            {
                  ivBack.visibility=View.INVISIBLE
            }
            else {
                ivBack.visibility = View.VISIBLE
            }
        languageRv.layoutManager = LinearLayoutManager(
            this@LanguageAct,
            LinearLayoutManager.VERTICAL,
            false
        )
        adapter = LanguageShowAdapter(
            this@LanguageAct,
            list,this@LanguageAct
        )
        languageRv.adapter = adapter

            tick.setOnClickListener {
                when(lang) {
                    "English" -> lang = "en"
                    "Arabic" -> lang = "ar"
                    "Hindi" -> lang = "hi"
                    "Mandarin Chinese" -> lang = "zh"
                    "Spanish" -> lang = "en"
                    "French" -> lang = "fr"
                    "Italian" -> lang = "it"
                    "Russian" -> lang = "ru"
                    "Portuguese" -> lang = "pt"
                    "Japanese" -> lang = "ja"

                }
                setLocale(this@LanguageAct,lang)
                val editor = sharedPref.edit()
                editor.putString("key", lang)
                editor.apply()

                val intent = Intent(this@LanguageAct, GenderActivity::class.java).apply {
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                startActivity(intent)

            }


    }
    }
    override fun itemClick(position: Int, model: LanguageM, check: RadioButton) {

        sharedPreferencesHelper.setPosition(position)

        adapter!!.notifyDataSetChanged()

        Log.i("TAG", "itemClick: "+model.languageName)
        lang=model.languageName
    }

//    private fun setLocale(lang: String) {
//        updateBaseContextLocale(this@LanguageAct, lang)
//    }
//
//    private fun updateBaseContextLocale(context: Context?, language: String): Context {
//        val locale = Locale(language)
//        Locale.setDefault(locale)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            updateResourcesLocale(context!!, locale)
//            return updateResourcesLocaleLegacy(context, locale)
//        }
//        return updateResourcesLocaleLegacy(context!!, locale)
//    }
//
//
//    private fun updateResourcesLocale(context: Context, locale: Locale): Context {
//        val configuration = context.resources.configuration
//        configuration.setLocale(locale)
//        return context.createConfigurationContext(configuration)
//    }
//
//    private fun updateResourcesLocaleLegacy(context: Context, locale: Locale): Context {
//        val resources = context.resources
//        val configuration = resources.configuration
//        configuration.locale = locale
//        resources.updateConfiguration(configuration, resources.displayMetrics)
//        return context
//    }
}