package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.CurrentStatus
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToSeconds
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentStepDailyBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class StepDailyFragment : Fragment() {


    private lateinit var binding:FragmentStepDailyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding= FragmentStepDailyBinding.inflate(inflater, container, false)


        //Not Selected By Default 1 Show
        dailyReport(1)

        binding.apply {
            imgStep.setOnClickListener {
                unSelectSub()
                imgStep.setBackgroundResource(R.drawable.bg_selected)
                dailyReport(1)

            }
            binding.imgLocation.setOnClickListener {
                unSelectSub()
                imgLocation.setBackgroundResource(R.drawable.bg_selected)
                dailyReport(2)

            }
            binding.imgCalories.setOnClickListener {
                unSelectSub()
               imgCalories.setBackgroundResource(R.drawable.bg_selected)
                dailyReport(3)

            }

            binding.imgTime.setOnClickListener {
                unSelectSub()
                imgTime.setBackgroundResource(R.drawable.bg_selected)
                dailyReport(4)

            }
        }

        return binding.root
    }


    private fun unSelectSub() {
        binding.imgStep.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgLocation.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgCalories.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgTime.setBackgroundResource(R.drawable.bg_unselected_options)
    }
    private fun dailyReport(isChoice: Int) {

        val currentDate = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val today = dateFormat.format(currentDate)

        Component.stepModel.getDailyRecord(today).observe(requireActivity()) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {

                    val animZoomIn = AnimationUtils.loadAnimation(requireActivity(), R.anim.zoom_in)

                    when (isChoice) {
                        1 -> {
                            it.data!!.forEach { it1 ->
                                val progress = (it1.steps.toDouble() / it1.stepGoal.toDouble()) * 100
                                binding.stepProgress.progress = progress.toInt()
                                binding.typeName.text = getString(R.string.steps)
                                binding.userSteps.text = Component.preference.stepCount.toString()
                                binding.userSteps.startAnimation(animZoomIn)
                                binding.userGoal.text = getString(R.string.goal)+": " + Component.preference.stepGoal.toString()
                            }
                        }

                        2 -> {
                            it.data!!.forEach { it1 ->
                                val progress = (it1.distance / it1.distanceGoal) * 100
                                binding.stepProgress.progress = progress.toInt()
                                binding.typeName.text = getString(R.string.distance)
                                binding.userSteps.text = it1.distance.toString()
                                binding.userSteps.startAnimation(animZoomIn)
                                binding.userGoal.text =
                                    getString(R.string.goal)+": " + it1.distanceGoal.toString()
                            }
                        }

                        3 -> {
                            it.data!!.forEach { it1 ->
                                val progress = (it1.calories / it1.caloriesGoal) * 100
                                binding.stepProgress.progress = progress.toInt()
                                binding.typeName.text = getString(R.string.calories)
                                binding.userSteps.text = it1.calories.toString()
                                binding.userSteps.startAnimation(animZoomIn)
                                binding.userGoal.text =
                                    getString(R.string.goal)+": " + it1.caloriesGoal.toString()
                            }
                        }

                        4 -> {
                            it.data!!.forEach { it1 ->
                                val progress = (it1.time.convertTimeToSeconds()
                                    .toDouble() / it1.timeGoal.convertTimeToSeconds()
                                    .toDouble()) * 100
                                binding.stepProgress.progress = progress.toInt()
                                binding.typeName.text = getString(R.string.time)
                                binding.userSteps.text = it1.time.toString()
                                binding.userSteps.startAnimation(animZoomIn)
                                binding.userGoal.text = getString(R.string.goal)+": " + it1.timeGoal.toString()
                            }
                        }
                    }

                }

                CurrentStatus.ERROR -> {

                }
            }
        }
    }
}