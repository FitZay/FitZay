package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteString
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentPlanBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.quotes.QuotesCategoryActivity
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepTrackerActivity
import com.fitzay.workouttracker.strengthtraining.ui.sleeptacker.SleepTrackerHomeScreen
import com.fitzay.workouttracker.strengthtraining.ui.stepcounter.StepCounterActivity
import com.fitzay.workouttracker.strengthtraining.ui.waterintake.WaterIntakeActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAdOptions


class PlanFragment : Fragment() {


    private var _binding: FragmentPlanBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
      _binding = FragmentPlanBinding.inflate(inflater, container, false)

        binding.clStepCounter.setOnClickListener {

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                val permission = Manifest.permission.POST_NOTIFICATIONS;
                if (ActivityCompat.checkSelfPermission(
                        requireContext(),
                        permission
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(requireContext(), StepCounterActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                } else if (shouldShowRequestPermissionRationale(permission)) {
                    Log.e("Permission_", "onCreateView: Permission Denied" )
                    openSettings()
                } else {
                    requestNotificationPermission.launch(permission);
                }
            } else {// handle below android 13 , just call showNotification()
                val intent = Intent(requireContext(), StepCounterActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            }
        }

        binding.clWaterReminder.setOnClickListener {
            val intent = Intent(requireContext(), WaterIntakeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }

        binding.clDailyMotivation.setOnClickListener {
            val intent = Intent(requireContext(), QuotesCategoryActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
        binding.clSleepTracker.setOnClickListener {
            val intent = Intent(requireContext(), SleepTrackerHomeScreen::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }



        return binding.root

    }

    private fun openSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", requireActivity().packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private val requestNotificationPermission: ActivityResultLauncher<String> =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                val intent = Intent(requireContext(), StepCounterActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                startActivity(intent)
            } else {
                Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }


    override fun onResume() {
        super.onResume()

        binding.stepTaken.text = Component.preference.stepCount.toString()
    }

}