package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.media.RingtoneManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.fitzay.workouttracker.strengthtraining.databinding.ActivitySingleExerciseBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel

class SingleExerciseActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleExerciseBinding

    private lateinit var loadingHandler: Handler
    private lateinit var runalble: Runnable
    private lateinit var arr: ArrayList<WorkOutModel>
    private var arrIndex = 0
    var isReady = false

    val TAG = "SingleExercise"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingHandler = Handler(Looper.getMainLooper()!!)

        val id = intent.getIntExtra("EXTRA_ID", 0)
        arr = Component.workOutViewModel.getWorkoutWithID(
            this@SingleExerciseActivity,
            id
        ) as ArrayList<WorkOutModel>

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        Glide.with(this)
            .load(("file:///android_asset/men/" + arr[arrIndex].exGif))
            .into(binding.exImage)

        binding.txtToolbar.text = arr[arrIndex].exTitle

        binding.exTime.text = arr[arrIndex].exTime.toString()
        binding.description.text = arr[arrIndex].exDescription.toString()

        binding.cardFinish.setOnClickListener {
            finish()
        }

        binding.btnNext.setOnClickListener {
//            if (::loadingHandler.isInitialized)
//            loadingHandler.removeCallbacks(runalble)
            isReady = true
            performExercise()
        }

        getReadyForExercise()
    }

    private fun getReadyForExercise() {
        hideAllLayout()
        binding.layoutReady.visibility = View.VISIBLE
        var percent = 0
        var rest = 15
        binding.progressBar.max = 15
        //     binding.progressBar.progress = 15
        Thread {
            while (percent < 15) {
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                runalble = Runnable {
                    try {
                        if (percent < 15) {
                            rest--
                            binding.progressBar.progress = percent
                            binding.txtProgress.text = "$rest"
                        } else {
                            if (!isReady)
                                performExercise()
                        }
                    } catch (e: RuntimeException) {
                        e.printStackTrace()
                    }
                }
                percent++
                loadingHandler.post(runalble)
            }
        }.start()
    }

    private fun performExercise() {
        hideAllLayout()

        binding.apply {
            layoutExercise.visibility = View.VISIBLE
            exNameTwo.text = arr[arrIndex].exTitle

            Glide.with(this@SingleExerciseActivity)
                .load(("file:///android_asset/men/" + arr[arrIndex].exGif))
                .into(exImage)

            if (arr[arrIndex].isTime!!) {
                exTime.text = "00:" + arr[arrIndex].exTime.toString()
            } else {
                exTime.text = "X" + arr[arrIndex].exTime.toString()
            }

            if (arr[arrIndex].isTime!!) {
                var percent = 0
                var rest = arr[arrIndex].exTime
                progressBar.max = arr[arrIndex].exTime!!
                progressBar.progress = arr[arrIndex].exTime!!
                Thread {
                    while (percent < arr[arrIndex].exTime!!) {
                        try {
                            Thread.sleep(1000)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                        runalble = Runnable {
                            try {
                                if (percent < arr[arrIndex].exTime!!) {
                                    rest = rest!! - 1
                                    progressBar.progress = rest as Int

                                    // Format the seconds with leading zeros
                                    val formattedRest = String.format("%02d", rest)
                                    exTime.text = "00:$formattedRest"

                                    if (rest==1)
                                    {
                                        Component.ringtoneModel.playMedia(this@SingleExerciseActivity)

                                    }
                                } else {
                                    //arrIndex++
                                    ///    if (arrIndex < arr.size)
                                    ///  takeRestForNextEx()
                                }
                            } catch (e: RuntimeException) {
                                e.printStackTrace()
                            }
                        }
                        percent++
                        loadingHandler.post(runalble)
                    }
                }.start()
            }
        }

    }

    private fun hideAllLayout() {
        binding.layoutReady.visibility = View.GONE
        binding.layoutExercise.visibility = View.GONE
    }
}