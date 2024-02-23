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
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.fitzay.workouttracker.strengthtraining.R
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

class ProfileAct : AppCompatActivity() {

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            saveItems.setOnClickListener {
                when {
                    binding.tvFullName.text.isNullOrEmpty() -> {
                        binding.tvFullName.error = "Name Must not be empty"
                    }

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
                        Component.preference.userHeight =
                            binding.etHeightInput.text.toString().toInt()
                        Component.preference.userWeight =
                            binding.etWeightInput.text.toString().toInt()
                        Component.preference.userTargetWight =
                            binding.etTargetWeightInput.text.toString().toInt()

                    }
                }
            }

        }

        setDefaults()

    }


    private fun setDefaults() {


        binding.apply {
            Log.e(TAG, "setDefaults: " + Component.preference.userHeight)



            if (Component.preference.userName != "empty") {
                tvFullName.setText(Component.preference.userName)
            }
            if (Component.preference.userGender != "empty") {
                etGenderInput.setText(Component.preference.userGender)
            }
            if (Component.preference.userAge != 0) {
                etAgeInput.setText(Component.preference.userAge.toString())
            }
            if (Component.preference.userHeight != 0) {
                etHeightInput.setText(Component.preference.userHeight.toString())
                Log.i("TAG", "Height: " + Component.preference.userHeight.toString())
            }
            if (Component.preference.userWeight != 0) {
                etWeightInput.setText(Component.preference.userWeight.toString())
            }

            if (Component.preference.userTargetWight != 0) {
                etTargetWeightInput.setText(Component.preference.userTargetWight.toString())
            }

//        if (Component.preference.userTargetWight != 0) {
//            binding.etTargetWeightInput.setText(Component.preference.userName)
//        }

            if (Component.preference.userProfilePath != "empty") {
                ivCamera.visibility = View.GONE
                Glide.with(this@ProfileAct)
                    .load(Component.preference.userProfilePath)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(ivProfile)
            } else {
                ivCamera.visibility = View.VISIBLE
            }


            //Radio Button set If User set value ft or cm
            if (Component.preference.userHeightType == "FT" && Component.preference.userHeightFt != 0) {
                ft.isChecked = true
                cm.isChecked = false
                etHeightInput.setText(Component.preference.userHeightFt.toString() + "." + Component.preference.userHeightInch.toString())
                val feetAndInches = Pair(
                    Component.preference.userHeightFt.toInt(),
                    Component.preference.userHeightInch.toDouble()
                )
                convertFtInchToCentiMeter = feetAndInches.toCentimeters()

            } else {
                ft.isChecked = false
                cm.isChecked = true
                etHeightInput.setText(Component.preference.userHeight.toString())

                val centimeters = Component.preference.userHeight.toString().toDouble()
                var cn = centimeterToFeet(centimeters.toString())

                convertCentiToFtInch_1st = cn.first.toString().toInt()
                convertCentiToFtInch_2nd = cn.second.toString().toInt()

            }

            //Radio Button set If User set value kg or lbs
            if (Component.preference.userWeightType == "KG" && Component.preference.userWeight != 0) {
                kg.isChecked = true
                lbs.isChecked = false
                etWeightInput.setText(Component.preference.userWeight.toString())

                kgToP = Component.preference.userWeight!!.toDouble().toPounds()

            } else {
                kg.isChecked = false
                lbs.isChecked = true
                etWeightInput.setText(Component.preference.userWeight.toString())

                pToKg = Component.preference.userWeight!!.toDouble().toKilograms()

            }

            cm.setOnClickListener {
                if (Component.preference.userHeightType == "FT" && Component.preference.userHeightFt != 0) {
                    etHeightInput.setText(convertFtInchToCentiMeter.toString())
                    Log.i(TAG, "setDefaults---FT: ")
                } else {

                    etHeightInput.setText(Component.preference.userHeight.toString())
                    Log.i(TAG, "setDefaults---Not FT: ")
                }


            }

            ft.setOnClickListener {

                if (Component.preference.userHeightType == "FT" && Component.preference.userHeightFt != 0) {
                    Log.i(TAG, "setDefaults--888-ft: ")
                    etHeightInput.setText(Component.preference.userHeightFt.toString()+"."+Component.preference.userHeightInch.toString())


                } else {
                    Log.i(TAG, "setDefaults--99-ft: ")
                    etHeightInput.setText(convertCentiToFtInch_1st.toString()+"."+convertCentiToFtInch_2nd.toString())
                }

            }

            kg.setOnClickListener {

                if (Component.preference.userWeightType == "KG" && Component.preference.userWeight != 0) {
                    etWeightInput.setText(Component.preference.userWeight.toString())
                    Log.i(TAG, "setDefaults0-----if kg: ")
                } else {
                    etWeightInput.setText(pToKg.toString())
                    Log.i(TAG, "setDefaults0-----if not kg: ")
                }

            }


            lbs.setOnClickListener {
                if (Component.preference.userWeightType == "KG" && Component.preference.userWeight != 0) {

                    etWeightInput.setText(kgToP.toString())
                    Log.i(TAG, "setDefaults0-----if kg00000: ")

                }
                else
                {
                    etWeightInput.setText(Component.preference.userWeight.toString())

                }

            }

        }

        //disableBtn()


    }

    fun centimeterToFeet(centemeter: String?): Pair<Int, Int> {
        var feetPart = 0
        var inchesPart = 0
        if (!TextUtils.isEmpty(centemeter)) {
            val dCentimeter = java.lang.Double.valueOf(centemeter)
            feetPart = floor(dCentimeter / 2.54 / 12).toInt()
            println(dCentimeter / 2.54 - feetPart * 12)
            inchesPart = ceil(dCentimeter / 2.54 - feetPart * 12).toInt()
        }
        return Pair(feetPart, inchesPart)
        //  return String.format("%d %d", feetPart, inchesPart)
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
}