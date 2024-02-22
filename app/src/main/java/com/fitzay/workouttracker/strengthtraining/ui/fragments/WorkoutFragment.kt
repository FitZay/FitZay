package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.ads.BannerAdsProvider
import com.fitzay.workouttracker.strengthtraining.core.ads.FitnessInterstitialAd
import com.fitzay.workouttracker.strengthtraining.core.utils.checkForInternet
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentWorkoutBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel
import com.fitzay.workouttracker.strengthtraining.ui.activities.FullbodyWorkoutActivity
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import com.fitzay.workouttracker.strengthtraining.ui.adapters.CategoriesAdapter
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions

class WorkoutFragment : Fragment() {

    val TAG = "WorkoutFragment"

    private var _binding: FragmentWorkoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        TemplateView.ctacolor = AppController.fitzayModel?.FitzayNativeExercise?.ctacolor
        _binding = FragmentWorkoutBinding.inflate(inflater, container, false)
        if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayBannerWorkout.showAd && checkForInternet() && !LoadingActivity.ispurchased) {
            binding?.linearLayoutAds?.visibility = View.VISIBLE
            loadBannerAds()
        }
        else {
            binding?.linearLayoutAds?.visibility = View.GONE
        }


        binding.apply {
            txtBeginner.setBackgroundResource(R.drawable.bg_selected_options_tab)
            val adapter = CategoriesAdapter(
                Component.workOutViewModel.getCat(
                    requireContext(),
                    "BEGINNER"
                ) as ArrayList<CategoriesModel> , "BEGINNER"
            )
            recyclerview.adapter = adapter

            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayNativeExercise.showAd && checkForInternet() && !LoadingActivity.ispurchased) {
                loadAdaptiveNative()
            } else {
                clAds.visibility = View.GONE
            }

            cardRecent()

            txtBeginner.setOnClickListener {
                unSelect()
                txtBeginner.setBackgroundResource(R.drawable.bg_selected_options_tab)
                recyclerview.adapter = CategoriesAdapter(
                    Component.workOutViewModel.getCat(
                        requireContext(),
                        "BEGINNER"
                    ) as ArrayList<CategoriesModel> , "BEGINNER"
                )
            }

            txtIntermediate.setOnClickListener {
                unSelect()
                txtIntermediate.setBackgroundResource(R.drawable.bg_selected_options_tab)
                recyclerview.adapter = CategoriesAdapter(
                    Component.workOutViewModel.getCat(
                        requireContext(),
                        "INTERMEDIATE"
                    ) as ArrayList<CategoriesModel> , "INTERMEDIATE"
                )

            }

            txtAdvance.setOnClickListener {
                unSelect()
                txtAdvance.setBackgroundResource(R.drawable.bg_selected_options_tab)
                recyclerview.adapter = CategoriesAdapter(
                    Component.workOutViewModel.getCat(
                        requireContext(),
                        "ADVANCE"
                    ) as ArrayList<CategoriesModel> , "ADVANCE"
                )
            }

            fullbodychBtn.setOnClickListener {
                startActivity(Intent(requireActivity() , FullbodyWorkoutActivity :: class.java))
            }
        }


        return binding.root
    }

    private fun loadAdaptiveNative() {

        binding.apply {
            layoutAd.visibility = View.GONE

            val template = if (getFitzayRemoteString("fitzay_cta_location") == "up") {
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
                        requireContext(),
                        AppController.fitzayModel!!.FitzayNativeExercise.adID
                    )
                        .forNativeAd { NativeAd: com.google.android.gms.ads.nativead.NativeAd ->
                            template.setNativeAd(NativeAd)

                            clAds.visibility = View.VISIBLE
                            skeletonLayout.visibility = View.GONE
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

    private fun cardRecent() {
        binding.apply {
            if (Component.preference.recentExerciseCategory != "empty") {
                recentEx.text = Component.preference.recentExerciseName
                txtRecent.visibility = View.VISIBLE
                recentExCat.text = Component.preference.recentExerciseCategory
                recentExPercent.text = Component.preference.recentExercisePercentage.toString() + " %"
                progressBar.progress =
                    Component.preference.recentExercisePercentage.toInt()
            } else {
                txtRecent.visibility = View.GONE
                cardRecent.visibility = View.GONE
            }
        }

    }

    private fun unSelect() {
        binding.apply {
            txtBeginner.setBackgroundResource(R.drawable.bg_unselected_options)
            txtIntermediate.setBackgroundResource(R.drawable.bg_unselected_options)
            txtAdvance.setBackgroundResource(R.drawable.bg_unselected_options)
        }

    }


    override fun onResume() {
        super.onResume()
        cardRecent()
    }

    private fun loadBannerAds() {
        val frameLayout: FrameLayout = binding.frameBannerContainer
        val linearLayout: LinearLayout = binding.layoutShowBannerAds
        val linearLayoutAds: LinearLayout = binding.linearLayoutAds
        val loading: LinearLayout = binding.layoutloading
        binding?.skeletonLayout1?.startLoading()
        val wifiBannerAds = BannerAdsProvider(
            requireActivity(),
            frameLayout, loading, linearLayout
        )
        wifiBannerAds.callBothBannerAds(AppController.fitzayModel!!.FitzayBannerWorkout.adID , "simple")
    }
}