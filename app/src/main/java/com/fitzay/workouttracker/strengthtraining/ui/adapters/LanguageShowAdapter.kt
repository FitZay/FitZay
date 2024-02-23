package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitzay.workouttracker.strengthtraining.core.utils.SharedPreferencesHelper
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDateTime
import com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding
import com.fitzay.workouttracker.strengthtraining.databinding.LanguageShowListBinding
import com.fitzay.workouttracker.strengthtraining.databinding.RingtoneShowListBinding
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.models.LanguageM
import com.fitzay.workouttracker.strengthtraining.domain.models.RingTone
import com.fitzay.workouttracker.strengthtraining.ui.callback.LanguageItemClick
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowRingToneItemClick

class LanguageShowAdapter(var context:Context, var list:ArrayList<LanguageM>,var listener:LanguageItemClick):RecyclerView.Adapter<LanguageShowAdapter.LanguageShowHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageShowHolder {
        var binding=LanguageShowListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LanguageShowHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LanguageShowHolder, position: Int) {

        var item=list[position]
        holder.bind(context,item,listener,holder.absoluteAdapterPosition,list)

    }

    class LanguageShowHolder(binding: LanguageShowListBinding):RecyclerView.ViewHolder(binding.root){

        var binding:LanguageShowListBinding

        init {
            this.binding=binding
        }

        fun bind(context:Context,model: LanguageM,listener:LanguageItemClick,position: Int,list:ArrayList<LanguageM>) {
            binding.apply {

                langName.text=model.languageName
                flag.setImageResource(model.flag)

                check.setOnCheckedChangeListener(null)
                if (SharedPreferencesHelper(context).getPosition() == position) {
                    check.isChecked = true

                } else {
                    check.isChecked = false
                }


                check.setOnCheckedChangeListener { buttonView, isChecked ->
                    list[position].selection = !list[position].selection

                    listener.itemClick(position, model, check)
                }

                alarmView.setOnClickListener {
                    list[position].selection = !list[position].selection

                    listener.itemClick(position, model, check)
                }
            }

        }
    }

}