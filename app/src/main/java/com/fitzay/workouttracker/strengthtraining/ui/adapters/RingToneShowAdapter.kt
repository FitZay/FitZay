package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDateTime
import com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding
import com.fitzay.workouttracker.strengthtraining.databinding.RingtoneShowListBinding
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.models.RingTone
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowRingToneItemClick

class RingToneShowAdapter(var context:Context, var list:ArrayList<RingTone>,var listener:ShowRingToneItemClick):RecyclerView.Adapter<RingToneShowAdapter.RingToneShowHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RingToneShowHolder {
        var binding=RingtoneShowListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RingToneShowHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RingToneShowHolder, position: Int) {

        var item=list[position]
        holder.bind(context,item,listener,holder.absoluteAdapterPosition)

    }

    class RingToneShowHolder(binding: RingtoneShowListBinding):RecyclerView.ViewHolder(binding.root){

        var binding:RingtoneShowListBinding

        init {
            this.binding=binding
        }

        fun bind(context:Context,model: RingTone,listener: ShowRingToneItemClick,position: Int) {
            binding.apply {

                ringToneName.text=model.ringToneName
                ringToneTime.text=model.duration

//                check.setOnCheckedChangeListener(null)
                if (model.selection) {

                    check.isChecked=true

                } else {
                    check.isChecked=false
                }

                listener.itemClick(position,model,check)


            }

        }
    }

}