package com.fitzay.workouttracker.strengthtraining.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityLanguageBinding
import com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM
import com.fitzay.workouttracker.strengthtraining.ui.adapters.LanguageShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.adapters.RingToneShowAdapter
import com.fitzay.workouttracker.strengthtraining.ui.callback.LanguageItemClick

class LanguageAct : AppCompatActivity(),LanguageItemClick {

    private lateinit var binding:ActivityLanguageBinding
    private  var adapter:LanguageShowAdapter?=null
    private  var list=ArrayList<LanguageM>()
    lateinit var sharedPreferencesHelper:SharedPreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_language)

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
    }
    }
    override fun itemClick(position: Int, model: LanguageM, check: RadioButton) {

        sharedPreferencesHelper.setPosition(position)

        adapter!!.notifyDataSetChanged()

        Log.i("TAG", "itemClick: "+model.languageName)
    }

}