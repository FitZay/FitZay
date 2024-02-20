package com.fitzay.workouttracker.strengthtraining.core.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.android.billingclient.api.AcknowledgePurchaseParams
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.QueryPurchasesParams
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.ui.activities.LoadingActivity
import java.util.LinkedList


object InAppPurchaseUtil {

    var weeklyPrice = ""
    var monthlyPrice = ""
    var yearlyPrice = ""
    var howManyDaysTrial = ""
    var AfterFreeTrial = ""
    val TAG = "PurchaseUtils"
    val Pricecheck = "Pricecheck"

    private lateinit var billingClient: BillingClient
    var productDetailsList: MutableList<ProductDetails>? = null
    private val priceRequestQueue = LinkedList<Pair<String, (String) -> Unit>>()


    fun openPurchaseDialog(context: Activity, key: String) {
        //Initialize Billing Client
        billingClient = BillingClient
            .newBuilder(context)
            .enablePendingPurchases()
            .setListener { billingResult, purchaseList ->
                if (purchaseList != null && billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                    purchaseList.forEach {
                        verfityPurchase(context, it)
                    }
                } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
                    // Handle an error caused by a user cancelling the purchase flow.
                    Toast.makeText(
                        context,
                        context.getString(R.string.purchase_cancel_by_user),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {

                    // Handle any other error codes.
                    Toast.makeText(context,
                        context.getString(R.string.item_not_found), Toast.LENGTH_SHORT)
                        .show()
                }
            }
            .build()
        showPriceProducts(context, true, key) {

        }

    }

    fun onlygetPrice(context: Context, key: String, callback: (String) -> Unit) {
        try {
            billingClient = BillingClient.newBuilder(context)
                .enablePendingPurchases()
                .setListener { billingResult, list ->
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && list != null) {
                        Log.d(TAG, "onlygetPrice: ")
                    }
                }.build()
            showPriceProducts(context, false, key) { weeklyPrice ->
                callback(weeklyPrice)
            }
        } catch (ex: Throwable) {
            ex.printStackTrace()
            Log.d(TAG, "showPrice ${ex.message}")
        }
    }


    private fun showPriceProducts(
        context: Context,
        onlyProduct: Boolean,
        key: String,
        callback: (String) -> Unit
    ) {

        try {

            billingClient.startConnection(object : BillingClientStateListener {
                override fun onBillingSetupFinished(billingResult: BillingResult) {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                        productDetailsList = ArrayList()

                        val productList: MutableList<QueryProductDetailsParams.Product> =
                            mutableListOf(
                                QueryProductDetailsParams.Product.newBuilder()
                                    .setProductId(key)
                                    .setProductType(BillingClient.ProductType.SUBS)
                                    .build(),
                            )
                        val params = QueryProductDetailsParams.newBuilder()
                            .setProductList(productList)
                            .build()
                        billingClient.queryProductDetailsAsync(
                            params
                        ) { _: BillingResult?, prodDetailsList: List<ProductDetails?> ->
                            if (prodDetailsList.isNotEmpty()) { // checking if there's a product returned then set the product(s)
                                for (qRSkuDetail in prodDetailsList) {
                                    if (qRSkuDetail!!.subscriptionOfferDetails!![0].pricingPhases.pricingPhaseList.size >= 1) {
                                        Log.d(
                                            Pricecheck,
                                            "Listner is called onBillingSetupFinished ${qRSkuDetail!!.subscriptionOfferDetails!![0].pricingPhases.pricingPhaseList[0].formattedPrice}")
                                        howManyDaysTrial =
                                            qRSkuDetail.subscriptionOfferDetails!![0].pricingPhases.pricingPhaseList[0].billingPeriod
                                            weeklyPrice =
                                                qRSkuDetail.subscriptionOfferDetails!![0].pricingPhases.pricingPhaseList[0].formattedPrice
                                            callback(weeklyPrice)
                                    }
                                    if (onlyProduct)
                                        qRSkuDetail?.let {
                                            launchPurchaseFlow(
                                                context as Activity,
                                                it
                                            )
                                        }

                                }
                            }
                            else{
                                Log.d(Pricecheck , "Qr is empty")
                            }
                        }
                    }
                }

                override fun onBillingServiceDisconnected() {
                    Log.e(TAG, "onBillingServiceDisconnected: ")
                    Log.d(TAG, "Listner is called disconnected")
                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            showPriceProducts(context, onlyProduct, key) {

                            }
                        },
                        1000
                    )
                }
            })
        } catch (e: Exception) {
            Log.e(TAG, "Exception: " + e.message)
        }


    }

    private fun verfityPurchase(context: Context, purchases: Purchase) {
        val acknowledgePurchaseParams: AcknowledgePurchaseParams = AcknowledgePurchaseParams
            .newBuilder()
            .setPurchaseToken(purchases.purchaseToken)
            .build()
        billingClient.acknowledgePurchase(acknowledgePurchaseParams) { billingResult ->
            if (billingResult.responseCode === BillingClient.BillingResponseCode.OK) {
                val intent =
                    context.packageManager.getLaunchIntentForPackage(context.packageName)
                intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                context.startActivity(intent)
            }
        }
    }

    private fun launchPurchaseFlow(context: Activity, productDetails: ProductDetails) {
        assert(productDetails.subscriptionOfferDetails != null)
        val productDetailsParamsList: MutableList<BillingFlowParams.ProductDetailsParams> =
            mutableListOf(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                    .setProductDetails(productDetails)
                    .setOfferToken(productDetails.subscriptionOfferDetails!![0].offerToken)
                    .build()
            )
        val billingFlowParams = BillingFlowParams.newBuilder()
            .setProductDetailsParamsList(productDetailsParamsList)
            .build()
        billingClient.launchBillingFlow(context, billingFlowParams)
    }


    fun isPurchaseSubscribed(context: Activity) {
        val billingClient = BillingClient.newBuilder(context).enablePendingPurchases()
            .setListener { billingResult: BillingResult?, list: List<Purchase?>? -> }
            .build()
        val finalBillingClient = billingClient
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingServiceDisconnected() {}
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    finalBillingClient.queryPurchasesAsync(
                        QueryPurchasesParams.newBuilder()
                            .setProductType(BillingClient.ProductType.SUBS).build()
                    ) { billingResult1: BillingResult, list: List<Purchase> ->
                        if (billingResult1.responseCode == BillingClient.BillingResponseCode.OK) {
                            var purchasePref = context.intent.getBooleanExtra("billing", false)
                            purchasePref = list.isNotEmpty()
                            LoadingActivity.ispurchased = purchasePref
                        }
                    }
                }
            }
        })
    }
}

