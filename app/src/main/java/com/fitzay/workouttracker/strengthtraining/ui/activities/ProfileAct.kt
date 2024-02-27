package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.ads.BannerAdsProvider
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.core.utils.showToast
import com.fitzay.workouttracker.strengthtraining.core.utils.toCentimeters
import com.fitzay.workouttracker.strengthtraining.core.utils.toKilograms
import com.fitzay.workouttracker.strengthtraining.core.utils.toPounds
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityLoadingBinding
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityProfileBinding
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentProfileBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import java.io.File
import java.io.FileOutputStream
import java.util.Objects
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round

class ProfileAct : AppUtil2() {

    private lateinit var binding:ActivityProfileBinding
    private var imageBitmap: Bitmap? = null
    private lateinit var selectedImageUri: Uri
    private var choicer: Int = -1

    private val TAG = "Profile"
    var convertFtInchToCentiMeter = 0.0
    var convertCentiToFtInch_1st = 0
    var convertCentiToFtInch_2nd = 0
    var kgToP=0.0
    var pToKg = 0.0
    var check=true
    var check2=true

    var check3=true
    var check4=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LanguageManager(this@ProfileAct)
        binding.apply {

            if (AppController.fitzayModel != null && AppController?.fitzayModel?.FitzayBannerProfile?.showAd == true && !LoadingActivity.ispurchased){
                binding?.linearLayoutAds?.visibility = View.VISIBLE
                AppController?.fitzayModel?.FitzayBannerProfile?.adID?.let { loadBannerAds(it) }
            }
            else {
                binding?.linearLayoutAds?.visibility = View.GONE
            }

            saveItems.setOnClickListener {
                when {

                    binding.etGenderInput.text.isNullOrEmpty() -> {
                        binding.etGenderInput.error = "Gender Must not be empty"
                    }

                    binding.etAgeInput.text.isNullOrEmpty() -> {
                        binding.etAgeInput.error = "Age Must not be empty"
                    }

                    binding.etHeightInput.text.isNullOrEmpty() -> {
                        binding.etHeightInput.error = "Height Must not be empty"
                    }

                    binding.etWeightInput.text.isNullOrEmpty() -> {
                        binding.etWeightInput.error = "Weight Must not be empty"
                    }

                    binding.etTargetWeightInput.text.isNullOrEmpty() -> {
                        binding.etTargetWeightInput.error = "Target Wight Must not be empty"
                    }

                    else -> {
                        Toast.makeText(this@ProfileAct, "Saved Successfully", Toast.LENGTH_SHORT)
                            .show()
                        //binding.saveItems.visibility = View.GONE
                        Component.preference.userName = binding.tvFullName.text.toString()
                        Component.preference.userAge = binding.etAgeInput.text.toString().toInt()
                        Component.preference.userGender = binding.etGenderInput.text.toString()
                        Component.preference.userHeight = binding.etHeightInput.text.toString().toInt()
                        Component.preference.userWeight = binding.etWeightInput.text.toString().toInt()
                        Component.preference.userTargetWight = binding.etTargetWeightInput.text.toString().toInt()

                    }
                }
            }

            btnNext.setOnClickListener {
                when {

                    binding.etGenderInput.text.isNullOrEmpty() -> {
                        binding.etGenderInput.error = "Gender Must not be empty"
                    }

                    binding.etAgeInput.text.isNullOrEmpty() -> {
                        binding.etAgeInput.error = "Age Must not be empty"
                    }

                    binding.etHeightInput.text.isNullOrEmpty() -> {
                        binding.etHeightInput.error = "Height Must not be empty"
                    }

                    binding.etWeightInput.text.isNullOrEmpty() -> {
                        binding.etWeightInput.error = "Weight Must not be empty"
                    }

                    binding.etTargetWeightInput.text.isNullOrEmpty() -> {
                        binding.etTargetWeightInput.error = "Target Wight Must not be empty"
                    }

                    else -> {
                        Component.preference.userName = binding.tvFullName.text.toString()
                        Component.preference.userAge = binding.etAgeInput.text.toString().toInt()
                        Component.preference.userGender = binding.etGenderInput.text.toString()
                        Component.preference.userHeight =
                            binding.etHeightInput.text.toString().toInt()
                        Component.preference.userWeight =
                            binding.etWeightInput.text.toString().toInt()
                        Component.preference.userTargetWight =
                            binding.etTargetWeightInput.text.toString().toInt()

                        val intent = Intent(this@ProfileAct, BmiAct::class.java).apply {
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
                        }
                        startActivity(intent)
                        //binding.saveItems.visibility = View.GONE


                    }
                }


            }

            if (Component.preference.userAge!=0  && Component.preference.userHeight!=0 && Component.preference.userWeight!=0 && Component.preference.userTargetWight!=0 )
            {
               etAgeInput.setText(Component.preference.userAge.toString())
                etHeightInput.setText(Component.preference.userHeight.toString())
                etWeightInput.setText(Component.preference.userWeight.toString())
                etTargetWeightInput.setText(Component.preference.userTargetWight.toString())

            }

            back.setOnClickListener {
                onBackPressed()
            }

            cm.setOnClickListener {
                try {
                    if (!etHeightInput.text.isNullOrEmpty())
                    {
                        if (check){
                            check = false
                            check2 = true
                            val centimeters = etHeightInput.text.toString().toDouble()
                            val cn =inchesToCm(centimeters)
                            etHeightInput.setText(cn.toString())
                        }
                    }
                    etHeightInput.requestFocus();
                    etHeightInput.setSelection(etHeightInput.length())
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }

            }
            ft.setOnClickListener {
                try {
                    if (!etHeightInput.text.isNullOrEmpty()) {
                        if (check2){
                            check2 = false
                            check = true
                            val con = cmToInches(etHeightInput.text.toString().toDouble())
                            etHeightInput.setText(con.toString())
                        }
                    }
                    etHeightInput.requestFocus();
                    etHeightInput.setSelection(etHeightInput.length())
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }
            }


            lbs.setOnClickListener {
                try {
                    if (!etWeightInput.text.isNullOrEmpty())
                    {
                        if (check3){
                            check3 = false
                            check4 = true
                            //val centimeters =
                            etWeightInput.setText(lbsToKg(etWeightInput.text.toString().toDouble()).toString())
                        }
                    }
                    etWeightInput.requestFocus();
                    etWeightInput.setSelection(etWeightInput.length())
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }

            }
            kg.setOnClickListener {
                try {
                    if (!etWeightInput.text.isNullOrEmpty()) {
                        if (check4){
                            check4 = false
                            check3 = true
                            etWeightInput.setText(kgToLbs(etWeightInput.text.toString().toDouble()).toString())
                        }
                    }
                    etWeightInput.requestFocus();
                    etWeightInput.setSelection(etWeightInput.length())
                }
                catch (e:Exception){
                    Log.i("TAG", "Error-Catch: "+e.message)
                }
            }
        }



    }






    fun disableBtn() {
        binding.apply {
            tvFullName.isEnabled = false
            tvGender.isEnabled = false
            tvAge.isEnabled = false
            tvHeight.isEnabled = false
            tvWeight.isEnabled = false
            tvTargetWeight.isEnabled = false
        }
    }

    private fun openChoiceToUser(isGalleryOrCamera: Int) {
        if (isGalleryOrCamera == 1) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (!com.fitzay.workouttracker.strengthtraining.core.utils.hasPermissions(
                        this@ProfileAct,
                        *com.fitzay.workouttracker.strengthtraining.core.utils.MAKE_PERMISSIONS
                    )
                ) {
                    ActivityCompat.requestPermissions(
                        this@ProfileAct,
                        com.fitzay.workouttracker.strengthtraining.core.utils.MAKE_PERMISSIONS,
                        com.fitzay.workouttracker.strengthtraining.core.utils.ALL_PERMISSIONS_CAMERA
                    )
                } else {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(
                        cameraIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_REQUEST_CODE
                    )
                }
            } else {
                if (ContextCompat.checkSelfPermission(
                        this@ProfileAct,
                        Manifest.permission.CAMERA
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@ProfileAct,
                        arrayOf(Manifest.permission.CAMERA),
                        com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_PERMISSION_REQUEST_CODE
                    )
                } else {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(
                        cameraIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_REQUEST_CODE
                    )
                }
            }

        }
        if (isGalleryOrCamera == 2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (!com.fitzay.workouttracker.strengthtraining.core.utils.hasPermissions(
                        this@ProfileAct,
                        *com.fitzay.workouttracker.strengthtraining.core.utils.MAKE_PERMISSIONS
                    )
                ) {
                    ActivityCompat.requestPermissions(
                        this@ProfileAct,
                        com.fitzay.workouttracker.strengthtraining.core.utils.MAKE_PERMISSIONS,
                        com.fitzay.workouttracker.strengthtraining.core.utils.ALL_PERMISSIONS_CAMERA
                    )
                } else {
                    val galleryIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(
                        galleryIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_REQUEST_CODE
                    )
                }
            } else {
                if (ContextCompat.checkSelfPermission(
                        this@ProfileAct,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@ProfileAct,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_PERMISSION_REQUEST_CODE
                    )
                } else {
                    val galleryIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(
                        galleryIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_REQUEST_CODE
                    )
                }
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.ALL_PERMISSIONS_CAMERA) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) openChoiceToUser(1)
            else showToast()
        } else if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.ALL_PERMISSIONS_GALLERY) {
            if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) openChoiceToUser(2)
            else showToast()
        }
        if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openChoiceToUser(1)
            } else {
                showSettingsDialog()
            }
        }
        if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openChoiceToUser(2)
            } else {
                showSettingsDialog()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_REQUEST_CODE) {
                try {
                    imageBitmap = data?.extras?.get("data") as Bitmap
                    loadImage(imageBitmap!!)
                    Component.preference.userProfilePath =
                        saveUserProfilePic(imageBitmap!!).toString()
                    binding.ivProfile.setImageBitmap(imageBitmap)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            } else if (requestCode == com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_REQUEST_CODE) {
                try {
                    selectedImageUri = data?.data!!
                    imageBitmap = BitmapFactory.decodeStream(
                        this@ProfileAct.contentResolver.openInputStream(selectedImageUri)
                    )
                    Component.preference.userProfilePath =
                        saveUserProfilePic(imageBitmap!!).toString()
                    loadImage(imageBitmap!!)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun showSettingsDialog() {
        val builder = androidx.appcompat.app.AlertDialog.Builder(this@ProfileAct)
        builder.setTitle(getString(R.string.need_permission))
        builder.setCancelable(false)
        builder.setMessage(getString(R.string.need_per_title))
        builder.setPositiveButton(getString(R.string.goto_settings)) { dialog: DialogInterface, which: Int ->
            dialog.cancel()
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", this@ProfileAct.packageName, null)
            intent.data = uri
            resultLauncher.launch(intent)
        }
        builder.setNegativeButton(
            getString(R.string.cancel)
        ) { dialog: DialogInterface, which: Int ->

            dialog.dismiss()
        }
        builder.show()
    }

    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (ActivityCompat.checkSelfPermission(
                    this@ProfileAct, Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this@ProfileAct, Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Log.e("checkPermission", "denied")
                showSettingsDialog()
            } else {
                if (choicer == 1) {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(
                        cameraIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.CAMERA_REQUEST_CODE
                    )
                } else if (choicer == 2) {
                    val galleryIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(
                        galleryIntent,
                        com.fitzay.workouttracker.strengthtraining.core.utils.GALLERY_REQUEST_CODE
                    )
                }
            }

        }

    private fun showToast() {
        goToSettings()
        this@ProfileAct.showToast(getString(R.string.allow_req_permissions))
    }

    private fun goToSettings() {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri: Uri = Uri.fromParts("package", this@ProfileAct.packageName, null)
        intent.data = uri
        startActivity(intent)
    }

    private fun loadImage(imageBitmap: Bitmap) {
        Glide.with(this)
            .load(imageBitmap)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.ivProfile)
    }

    private fun showBothSelectorDialog() {
        val dialogView =
            LayoutInflater.from(this@ProfileAct).inflate(R.layout.selector_dialog, null)
        val alertDialog = AlertDialog.Builder(this@ProfileAct)
            .setView(dialogView).setCancelable(false).create()
        Objects.requireNonNull<Window>(alertDialog.window)
            .setBackgroundDrawableResource(android.R.color.transparent)
        val cameraButton = dialogView.findViewById<ImageView>(R.id.iv_select_camera)
        val galleryButton = dialogView.findViewById<ImageView>(R.id.iv_select_gallery)
        val closeBtn = dialogView.findViewById<ImageView>(R.id.iv_close)
        cameraButton.setOnClickListener {
            alertDialog.dismiss()
            choicer = 1
            openChoiceToUser(choicer)

        }
        galleryButton.setOnClickListener {
            alertDialog.dismiss()
            choicer = 2
            openChoiceToUser(choicer)
        }
        closeBtn.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.show()
    }


    private fun saveUserProfilePic(bitmap: Bitmap): String? {
        val name = System.currentTimeMillis()
        val path = File(this@ProfileAct.getExternalFilesDir("/" + "UsersDP")!!.absolutePath)
        if (!path.exists())
            path.mkdirs()
        val dest = File(path, "$name.png")
        return try {
            val out = FileOutputStream(dest)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
            out.flush()
            out.close()
            dest.absolutePath
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun loadBannerAds(adunit : String) {
        val frameLayout: FrameLayout = binding.frameBannerContainer
        val linearLayout: LinearLayout = binding.layoutShowBannerAds
        val linearLayoutAds: LinearLayout = binding.linearLayoutAds
        val loading: LinearLayout = binding.layoutloading
        binding?.skeletonLayout?.startLoading()
        val wifiBannerAds = BannerAdsProvider(
            this@ProfileAct,
            frameLayout, loading, linearLayout
        )
        wifiBannerAds.callBothBannerAds(adunit , "simple")
    }

    fun cmToInches(cm: Double): Double {
        var result =  cm / 2.54
        return round(result * 100.0) / 100.0
    }

    fun inchesToCm(inches: Double): Double {
        val result = inches * 2.54
        return round(result * 100.0) / 100.0
    }


    fun lbsToKg(lbs: Double): Double {
        return lbs * 0.45359237
    }

    // Function to convert kilograms to pounds
    fun kgToLbs(kg: Double): Double {
        return kg * 2.2046226218
    }
}