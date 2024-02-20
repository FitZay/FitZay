package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentUnlockPremiumBottomBinding
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import com.fitzay.workouttracker.strengthtraining.ui.activities.PremiumActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Objects

class UnlockPremiumBottomFragment : BottomSheetDialogFragment() {

    private val binding: FragmentUnlockPremiumBottomBinding by lazy {
        FragmentUnlockPremiumBottomBinding.inflate(layoutInflater)
    }
    var closeactivity = true
    private var rewardedAd: RewardedAd? = null
    private var TAG = "_UnlockPremiumBottomFragment"
    private var waiting_dialog : Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        waiting_dialog = Dialog(requireContext())
        binding?.closeBtn?.setOnClickListener {
            closeactivity = true
            dismiss()
        }

        binding?.premiumBtn?.setOnClickListener {
            startActivity(Intent(requireActivity() , PremiumActivity :: class.java))
        }

        binding?.watchadBtn?.setOnClickListener {
            if (AppController.fitzayModel != null && AppController.fitzayModel!!.FitzayRewardedAdvance.showAd && !LoadingActivity.ispurchased) {
                loadRewardedAd(AppController.fitzayModel!!.FitzayRewardedAdvance.adID)
            }
        }

        return binding.root

    }

//    override fun onDismiss(dialog: DialogInterface) {
//        super.onDismiss(dialog)
//        if (closeactivity)
////            requireActivity().finish()
//    }

    companion object {

        fun show(fragmentManager: FragmentManager) {
            val bottomSheetFragment = UnlockPremiumBottomFragment()
            bottomSheetFragment.show(fragmentManager, bottomSheetFragment.tag)
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { setupBottomSheet(it) }
        return dialog
    }

    private fun setupBottomSheet(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
            com.google.android.material.R.id.design_bottom_sheet
        )
            ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }



    fun loadRewardedAd(adId : String){
        showWaitingDialog()
        if (rewardedAd == null) {
            var adRequest = AdRequest.Builder().build()
            RewardedAd.load(
                requireActivity(),
                adId,
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        adError?.toString()?.let { Log.d(TAG, it) }
                        rewardedAd = null
                        if (isAdded){
                            waiting_dialog?.dismiss()
                            Toast.makeText(requireContext() , "Ad is not available yet" , Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onAdLoaded(ad: RewardedAd) {
                        Log.d(TAG, "Ad was loaded.")
                        rewardedAd = ad
                        waiting_dialog?.dismiss()
                        showRewardedAd()
                    }
                })
        }
    }


    fun showRewardedAd(){
        rewardedAd?.let { ad ->
            ad.show(requireActivity()) { rewardItem ->
                Log.d(TAG, "User earned the reward.")
                closeactivity = false
                dismiss()
            }
        } ?: run {

        }
        rewardedAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                Log.d(TAG, "Ad dismissed fullscreen content.")
                rewardedAd = null
                dismiss()
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.")
                dismiss()
            }
        }
    }

    private fun showWaitingDialog() {
        Objects.requireNonNull<Window>(waiting_dialog?.window)
            .setBackgroundDrawableResource(android.R.color.transparent)
        waiting_dialog?.setContentView(R.layout.ad_loading_dialog)
        waiting_dialog?.setCancelable(false)
        waiting_dialog?.show()
    }

}