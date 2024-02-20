package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDateTime
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.core.utils.getLongDayName
import com.fitzay.workouttracker.strengthtraining.core.utils.getShortDayName
import com.fitzay.workouttracker.strengthtraining.data.model.Sleep
import com.fitzay.workouttracker.strengthtraining.databinding.AlarmShowItemListBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.entities.AlarmEntity
import com.fitzay.workouttracker.strengthtraining.domain.entities.SleepEntity
import com.fitzay.workouttracker.strengthtraining.ui.callback.ShowAlarmItemClick
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class AlarmShowAdapter(
    var context: Context,
    var list: ArrayList<AlarmEntity>,
    var listener: ShowAlarmItemClick
) : RecyclerView.Adapter<AlarmShowAdapter.AlarmShowHolder>() {

    companion object {
        var toggleValue=true
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmShowHolder {
        var binding =
            AlarmShowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmShowHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AlarmShowHolder, position: Int) {

        var item = list[position]
        holder.bind(context, item, listener, holder.absoluteAdapterPosition)
    }

    class AlarmShowHolder(binding: AlarmShowItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var binding: AlarmShowItemListBinding

        init {
            this.binding = binding
        }

        fun bind(
            context: Context,
            model: AlarmEntity,
            listener: ShowAlarmItemClick,
            position: Int
        ) {
            binding.apply {


                if (model.label.equals("Test")) {
                    time.setText("No Alarm")
                    wakeTime.setText("No Alarm")
                    dayName.setText("Tomorrow Morning")
                    dayName.setText("Tomorrow Morning")
                    amPm.visibility= View.INVISIBLE
                    wakeAmPm.visibility= View.INVISIBLE
                    swOnOff.visibility= View.INVISIBLE
                    changeBtn.visibility= View.VISIBLE

                } else {
                    changeBtn.visibility = View.GONE


                    wakeTime.text =  context.convertDateTime(model.time.toString(),"hh:mm")
                    wakeAmPm.text =  context.convertDateTime(model.time.toString(),"aa")

                    //Bed Time
                    time.text =  context.convertDateTime(model.bedTime.toString(),"hh:mm")
                    amPm.text =  context.convertDateTime(model.bedTime.toString(),"aa")

                        //labelName.text = model.label

                    val desiredDays = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

                    if (model.days != null && model.days!!.split(",").map { it.trim() }.containsAll(desiredDays))
                        {
                            dayName.text = "EveryDay"
                        }
                    else {
                            dayName.text = model.days
                        }

                    Log.i("TAG", "Adapter: "+model.days)



                }


                alarmView.setOnClickListener {
                    listener.itemClick(position,model,time,amPm,labelName,dayName,swOnOff)
                }

                alarmView.setOnLongClickListener( {
                    listener.longItemClickForDelete(position,model)
                    true
                })


                swOnOff.setOnCheckedChangeListener { buttonView, isChecked ->
                    listener.switchOnOff(position,model,isChecked)
                }


                swOnOff.isChecked=model.isEnabled



            }

        }
    }

}