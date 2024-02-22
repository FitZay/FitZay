package com.fitzay.workouttracker.strengthtraining.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.ads.FitnessInterstitialAd
import com.fitzay.workouttracker.strengthtraining.core.utils.getFitzayRemoteLong
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityMainBinding
import com.fitzay.workouttracker.strengthtraining.ui.activities.LanguageAct
import com.fitzay.workouttracker.strengthtraining.ui.activities.PremiumActivity
import com.fitzay.workouttracker.strengthtraining.ui.fragments.GraphFragment
import com.fitzay.workouttracker.strengthtraining.ui.fragments.PlanFragment
import com.fitzay.workouttracker.strengthtraining.ui.fragments.ProfileFragment
import com.fitzay.workouttracker.strengthtraining.ui.fragments.WorkoutFragment
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.ump.ConsentInformation
import com.google.android.ump.UserMessagingPlatform

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var backToExitPressedOnce = false
    private var drawerOpen: Boolean = false
    var isClicked = false
    private var currentFragment = "Planning"
    private val TAG="MainActivity"


    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->

        when (item.itemId) {
            R.id.menuPlan -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragmentContainer, PlanFragment()).commit()
                interCallback(1)
            }

            R.id.menuWorkout -> {
                interCallback(0)
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragmentContainer, WorkoutFragment()).commit()
            }

            R.id.menuProfile -> {
                interCallback(3)
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragmentContainer, ProfileFragment()).commit()
            }

            R.id.menuStats -> {
                interCallback(2)
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.fragmentContainer, GraphFragment()).commit()
            }
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FitnessInterstitialAd.getInstance(this)!!.loadAdMobInterAd()
        navClicks()

        binding.apply {
            appBarHome.icMenu.setOnClickListener {
                drawerOpen = if (!drawerOpen) {
                    drawerLayout.openDrawer(GravityCompat.START)
                    false
                } else {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    false
                }
            }

            appBarHome.icPremium.setOnClickListener {
//                AbsUnfinishBottomFragment.show(supportFragmentManager)
                startActivity(Intent(this@MainActivity , PremiumActivity :: class.java))
            }

            navigationView.itemIconTintList = null

            appBarHome.bottomNavigation.setOnNavigationItemSelectedListener(navListener)

            appBarHome.bottomNavigation.setOnNavigationItemReselectedListener {}
        }


        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, WorkoutFragment()).commit()
    }


    private fun navClicks() {

        binding.apply {
            customDrawer.ftHowToUse.setOnClickListener { }
            customDrawer.ftRate.setOnClickListener {
                if (!isClicked) {
                    isClicked = true
                    try {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=com.fitzay.workouttracker.strengthtraining")
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                            )
                        )
                    }
                    drawerLayout.closeDrawer(GravityCompat.START)
                    drawerOpen = true
                }
            }

            val consentInformation: ConsentInformation = UserMessagingPlatform.getConsentInformation(this@MainActivity)
            // Show a privacy options button if required.
            val isPrivacyOptionsRequired: Boolean = consentInformation.privacyOptionsRequirementStatus == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED

            if (isPrivacyOptionsRequired){
                customDrawer.ftConsent.visibility=View.VISIBLE
            }else{
                customDrawer.ftConsent.visibility=View.GONE
            }

            customDrawer.ftConsent.setOnClickListener {
                UserMessagingPlatform.showPrivacyOptionsForm(this@MainActivity) { formError ->
                    formError?.let {
                        // Handle the error.
                        Log.e(TAG, "navClicks: " )
                    }
                }
            }

            customDrawer.ftShareApp.setOnClickListener {
                if (!isClicked) {
                    isClicked = true
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    sharingIntent.putExtra(
                        Intent.EXTRA_SUBJECT,
                        "FitZay Fitness  Application"
                    )
                    sharingIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.fitzay.workouttracker.strengthtraining"
                    )
                    startActivity(Intent.createChooser(sharingIntent, "Share app via"))
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    drawerOpen = true
                }
            }
            customDrawer.ftPrivacy.setOnClickListener {
                if (!isClicked) {
                    isClicked = true
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://sites.google.com/view/all-recover-deleted-messages/fitzay")
                        )
                    )
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    drawerOpen = true
                }
            }
            //
            customDrawer.fitMoreApps.setOnClickListener {
                if (!isClicked) {
                    isClicked = true
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/dev?id=7738249222868946718")
                        )
                    )
                    drawerLayout.closeDrawer(GravityCompat.START)
                    drawerOpen = true
                }
            }

            customDrawer.lang.setOnClickListener {
                if (!isClicked) {
                    isClicked = true
                    val intent = Intent(this@MainActivity, LanguageAct::class.java)
                    intent.putExtra("invisibleKey","")
                    intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    finish()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    drawerOpen = true
                }
            }

        }

    }

    override fun onBackPressed() {
        ////  super.onBackPressed()

        binding.apply {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else if (currentFragment != "Planning") {
                appBarHome.bottomNavigation.menu.getItem(0).isChecked = true
                callRequireFragment(0)
            } else {
                if (backToExitPressedOnce) {
                    finishAffinity()
                }
                backToExitPressedOnce = true
                Toast.makeText(this@MainActivity, "Double tap to exit!", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed(
                    { backToExitPressedOnce = false },
                    2000
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        isClicked = false
    }

    private fun interCallback(position: Int) {
        if (FitnessInterstitialAd.mInterstitialAd != null) {
            AppController.fitAdCount++
            if (AppController.fitAdCount >= getFitzayRemoteLong("fitzay_ad_count") || AppController.isFirstOpen) {
                AppController.fitAdCount = 0
                AppController.isFirstOpen = false
                FitnessInterstitialAd.mInterstitialAd!!.show(this)
                FitnessInterstitialAd.mInterstitialAd?.fullScreenContentCallback =
                    object : FullScreenContentCallback() {
                        override fun onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent()
                            FitnessInterstitialAd.mInterstitialAd = null
                            FitnessInterstitialAd.getInstance(this@MainActivity)!!
                                .loadAdMobInterAd()
                            callRequireFragment(position)
                        }

                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                            super.onAdFailedToShowFullScreenContent(p0)
                            callRequireFragment(position)

                        }

                        override fun onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent()
                        }
                    }
            } else {
                callRequireFragment(position)
            }
        } else {
            FitnessInterstitialAd.getInstance(this@MainActivity)!!.loadAdMobInterAd()
            callRequireFragment(position)
        }
    }

    fun callRequireFragment(position: Int) {
        when (position) {
            0 -> {
                currentFragment = "Planning"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, PlanFragment()).commitNowAllowingStateLoss()

            }

            1 -> {
                currentFragment = "Workout"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, WorkoutFragment()).commitNowAllowingStateLoss()

            }

            2 -> {
                currentFragment = "Graph"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, GraphFragment()).commitNowAllowingStateLoss()

            }

            3 -> {
                currentFragment = "Profile"
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ProfileFragment()).commitNowAllowingStateLoss()

            }
        }
    }


}