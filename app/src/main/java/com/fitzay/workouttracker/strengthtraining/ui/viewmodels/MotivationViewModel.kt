package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.fitzay.workouttracker.strengthtraining.core.utils.motivationQuotes
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel

class MotivationViewModel  : ViewModel() {

    fun getDistinctQuotes(context: Context): List<QuotesModel> {
        return context.motivationQuotes().distinctBy { it.type }
    }

    fun getQuotesByType(context: Context, type: String) : List<QuotesModel> {
        return context.motivationQuotes().filter { it.type.equals(type) }
    }
}