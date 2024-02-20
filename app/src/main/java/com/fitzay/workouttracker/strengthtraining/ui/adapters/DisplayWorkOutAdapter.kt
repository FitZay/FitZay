package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.ads.FitnessInterstitialAd
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteLong
import com.fitzay.workouttracker.strengthtraining.databinding.DisplayWorkoutsLayoutBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel
import com.fitzay.workouttracker.strengthtraining.ui.activities.SingleExerciseActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback

class DisplayWorkOutAdapter(var context: Activity,var data: ArrayList<WorkOutModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var binding: DisplayWorkoutsLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = DisplayWorkoutsLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val lp = binding.root.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            lp.isFullSpan = false
        }
        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder1: RecyclerView.ViewHolder, position: Int) {

        binding.apply {
            exName.text = data[position].exTitle

            if (data[position].isTime!!) {
               exTime.text = "00:"+ data[position].exTime.toString()
            } else {
               exTime.text = "X"+data[position].exTime.toString()
            }

            Glide.with(Component.context)
                .load(( "file:///android_asset/men/" + data[position].exGif))
                .into(exImage)


            layoutHolder.setOnClickListener {
                val id=  data[position].exId
                interCallback(context, id!!)
            }
        }


    }

    // total number of cells
    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    private fun interCallback(context:Activity,id: Int) {
        AppController.fitAdCount++
        if (AppController.fitAdCount >= AppController.fitAdTotal) {
            AppController.fitAdCount = 0
            if (FitnessInterstitialAd.mInterstitialAd != null) {
                FitnessInterstitialAd.mInterstitialAd!!.show(context)
                FitnessInterstitialAd.mInterstitialAd?.fullScreenContentCallback =
                    object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent()
                            FitnessInterstitialAd.mInterstitialAd = null
                            FitnessInterstitialAd.getInstance(context)!!.loadAdMobInterAd()
                            callNext(context, id)
                        }

                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                            super.onAdFailedToShowFullScreenContent(p0)
                            callNext(context, id)

                        }

                        override fun onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent()
                        }
                    }
            } else {
                callNext(context, id)
            }
        }else{
            callNext(context, id)
        }
    }

    private fun callNext(context: Activity, id:Int){
        val intent =
            Intent(
                context,
                SingleExerciseActivity::class.java
            ).apply {
                putExtra("EXTRA_FROM", true)
                putExtra("EXTRA_ID",id)
            }
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        context.startActivity(intent)
    }
}