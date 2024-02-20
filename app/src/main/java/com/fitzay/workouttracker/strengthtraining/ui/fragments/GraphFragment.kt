package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.core.utils.getSimpleDate
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentGraphBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepSummaryActivity
import com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepSummeryActivity
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class GraphFragment : Fragment() {

    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGraphBinding.inflate(inflater, container, false)

        binding.apply {

            CoroutineScope(Dispatchers.IO).launch {

                com.fitzay.workouttracker.strengthtraining.di.Component.alarmViewModel.alarmRepository.getAlarms(
                    1
                ).collect { result ->

                    if (result.isNotEmpty()) {

                        for (i in result.listIterator().iterator()) {

                            withContext(Dispatchers.Main) {
                                if (i.date!!.equals(requireActivity().getSimpleDate())) {

                                    val regex = Regex("\\d+")
                                    val matchResults = regex.findAll(i.totalSleepingHr!!)
                                    val numericValues = matchResults.map { it.value }.toList()
                                    val finalString = numericValues.joinToString(".").replace(" ", "").toFloat()



                                    todaySleep.text = i.totalSleepingHr!!

                                } else {
                                    Log.i("TAG", "Else: ")
                                }
                            }

                        }

                    } else {
                        withContext(Dispatchers.Main)
                        {
                            todaySleep.text="Today"
                        }

                    }
                }


            }


            stepCount.text = "${Component.preference.stepCount} Steps"
            //// binding.stepGoal.text=" ${Component.preference.stepGoal.toString()}"

            layoutSleep.setOnClickListener {
                val intent = Intent(requireContext(), SleepSummaryActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            }

            layoutSteps.setOnClickListener {
                val intent = Intent(requireContext(), StepSummeryActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            }


            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeStats.showAd && !LoadingActivity.ispurchased) {
                binding?.clAds?.visibility = View.VISIBLE
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

        }
        return binding.root
    }


    private fun loadAdaptiveNative() {

        binding.layoutAd.visibility = View.GONE
        val template = if (AppController.fitzayModel!!.FitzayNativeStats.ctalocation == "up") {
            binding.plannerTemplateDown.visibility = View.GONE
            binding.plannerTemplateUp.visibility = View.VISIBLE
            binding.plannerTemplateUp
        } else {
            binding.plannerTemplateDown.visibility = View.VISIBLE
            binding.plannerTemplateUp.visibility = View.GONE
            binding.plannerTemplateDown
        }

        if (AppController.fitzayModel != null) {
            val adLoader =
                AdLoader.Builder(
                    requireContext(),
                    AppController.fitzayModel!!.FitzayNativeStats.adID
                )
                    .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                        template.setNativeAd(NativeAd)
                        binding.skeletonLayout.visibility = View.GONE
                        binding.clAds.visibility = View.VISIBLE
                        binding.layoutAd.visibility = View.VISIBLE

                    }.withAdListener(object : AdListener() {
                        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                            super.onAdFailedToLoad(loadAdError)
                            binding.clAds.visibility = View.GONE
                            binding.layoutAd.visibility = View.GONE
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