package com.fitzay.workouttracker.strengthtraining.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.AppUtil2
import com.fitzay.workouttracker.strengthtraining.core.utils.InAppPurchaseUtil
import com.fitzay.workouttracker.strengthtraining.core.utils.LanguageManager
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityPremiumBinding
import com.fitzay.workouttracker.strengthtraining.ui.MainActivity


class PremiumActivity : AppUtil2() {

    private var binding: ActivityPremiumBinding? = null
    private var selecteditem = "fitzay_yearly_premium"

    companion object {
        var activitytype = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPremiumBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        LanguageManager(this@PremiumActivity)
        binding?.closeBtn?.setOnClickListener {
            if (activitytype == "splash") {
                startActivity(Intent(this@PremiumActivity, MainActivity::class.java))
                finish()
            } else {
                finish()
            }
        }

        binding?.cancelBtn?.setOnClickListener {
            if (activitytype == "splash") {
                startActivity(Intent(this@PremiumActivity, MainActivity::class.java))
                finish()
            } else {
                finish()
            }
        }

        if (AppController.weeklyvalue != "") {
            binding?.weeklytext?.text = AppController.weeklyvalue
        } else {
            InAppPurchaseUtil.onlygetPrice(this@PremiumActivity, "fitzay_weekly_premium") {
                binding?.weeklytext?.text = it
            }
        }

        if (AppController.monthlyvalue != "") {
            try {
                val currencySymbol = extractCurrencySymbol(AppController.monthlyvalue)
                val numericalPart =
                    AppController.monthlyvalue.substring(3).replace(",", "").toDouble()
                val result = numericalPart / 4.2
                val formattedResult = "%s %.0f".format(currencySymbol, result)
                binding?.monthlytext?.text = "$formattedResult/week"
            } catch (e: Exception) {
                binding?.monthlytext?.text = AppController.monthlyvalue
            }

        } else {
            InAppPurchaseUtil.onlygetPrice(
                this@PremiumActivity,
                "fitzay_monthly_premium"
            ) { price ->
                try {
                    val currencySymbol = extractCurrencySymbol(price)
                    val numericalPart = price.substring(3).replace(",", "").toDouble()
                    val result = numericalPart / 4.2
                    val formattedResult = "%s %.0f".format(currencySymbol, result)
                    binding?.monthlytext?.text = "$formattedResult/week"
                } catch (e: Exception) {
                    binding?.monthlytext?.text = price
                }

            }
        }


        if (AppController.yearlyvalue != "") {
            try {
                val currencySymbol = extractCurrencySymbol(AppController.yearlyvalue)
                val numericalPart =
                    AppController.yearlyvalue.substring(3).replace(",", "").toDouble()
                val result = numericalPart / 52.2
                val formattedResult = "%s %.0f".format(currencySymbol, result)
                binding?.yearlytext?.text = "$formattedResult/week"
            } catch (e: Exception) {
                binding?.yearlytext?.text = AppController.yearlyvalue
            }

        } else {
            InAppPurchaseUtil.onlygetPrice(this@PremiumActivity, "fitzay_yearly_premium") {
                try {
                    val currencySymbol = extractCurrencySymbol(it)
                    val numericalPart = it.substring(3).replace(",", "").toDouble()
                    val result = numericalPart / 52.2
                    val formattedResult = "%s %.0f".format(currencySymbol, result)
                    binding?.yearlytext?.text = "$formattedResult/week"
                } catch (e: Exception) {
                    binding?.yearlytext?.text = it
                }


            }
        }

        binding?.manageSubscriptionBtn?.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/account/subscriptions")
            )
            startActivity(browserIntent)
        }

        binding?.privacyPolicyBtn?.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://sites.google.com/view/all-recover-deleted-messages/fitzay")
                )
            )
        }



        binding?.weeklyBtn?.setOnClickListener {
            selecteditem = "fitzay_weekly_premium"
            binding?.radioBtnWeekly?.let { it1 -> selectAnOption(it1) }
            InAppPurchaseUtil.openPurchaseDialog(this, selecteditem)
        }

        binding?.montlyBtn?.setOnClickListener {
            selecteditem = "fitzay_monthly_premium"
            binding?.radioMonthly?.let { it1 -> selectAnOption(it1) }
            InAppPurchaseUtil.openPurchaseDialog(this, selecteditem)
        }

        binding?.yearlyBtn?.setOnClickListener {
            selecteditem = "fitzay_yearly_premium"
            binding?.radioYearly?.let { it1 -> selectAnOption(it1) }
            InAppPurchaseUtil.openPurchaseDialog(this, selecteditem)
        }

        binding?.submitBtn?.setOnClickListener {
            InAppPurchaseUtil.openPurchaseDialog(this, selecteditem)
        }
    }

    fun extractCurrencySymbol(input: String): String {
        val regex =
            Regex("^\\D+") // Matches any non-digit characters at the beginning of the string
        val matchResult = regex.find(input)
        return matchResult?.value
            ?: "" // Returns the matched currency symbol or an empty string if not found
    }

    override fun onBackPressed() {
        if (activitytype == "splash") {
            startActivity(Intent(this@PremiumActivity, MainActivity::class.java))
            finish()
        } else {
            finish()
        }
    }

    fun selectAnOption(view: ImageView) {
        binding?.radioBtnWeekly?.setImageResource(R.drawable.ic_radiobtn_unchecked)
        binding?.radioMonthly?.setImageResource(R.drawable.ic_radiobtn_unchecked)
        binding?.radioYearly?.setImageResource(R.drawable.ic_radiobtn_unchecked)
        view.setImageResource(R.drawable.ic_selectedbutton)

    }
}


