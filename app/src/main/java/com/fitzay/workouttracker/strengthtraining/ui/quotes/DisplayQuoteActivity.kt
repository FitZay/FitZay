package com.fitzay.workouttracker.strengthtraining.ui.quotes

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityDisplayQuoteBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel
import com.fitzay.workouttracker.strengthtraining.ui.adapters.DisplayQuotesAdapter

class DisplayQuoteActivity : AppUtil2() {

    private lateinit var binding: ActivityDisplayQuoteBinding
    var extraType =""

    companion object {
        const val ALL_PERMISSIONS = 10
        val REQUIRED_PERMISSIONS =
            mutableListOf(Manifest.permission.INTERNET).apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    add(Manifest.permission.READ_MEDIA_IMAGES)
                } else {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    add(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDisplayQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extraType = intent.getStringExtra("EXTRA_TYPE").toString()
        binding.toolBar.text = extraType

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        if (!hasPermissions(this, *REQUIRED_PERMISSIONS))
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, ALL_PERMISSIONS)
        else
            makeFolder()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            ALL_PERMISSIONS -> {
                if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) makeFolder()
                else finishActivity()
            }
        }
    }
    private fun hasPermissions(context: Context, vararg permissions: String): Boolean =
        permissions.all {
            ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
    private fun makeFolder() {
        try {
            binding.recyclerview.adapter = DisplayQuotesAdapter(this,
                Component.quotesViewModel.getQuotesByType(this, extraType.toString()) as ArrayList<QuotesModel>
            )
        } catch (e: RuntimeException) {
            e.printStackTrace()
        }
    }

    private fun finishActivity() {
        openSettings()
        Toast.makeText(
            this@DisplayQuoteActivity,
            resources.getString(R.string.allow_required_permissions),
            Toast.LENGTH_SHORT
        ).show()
    }

    // navigating user to app settings
    private fun openSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        LanguageManager(this@DisplayQuoteActivity)
    }
}