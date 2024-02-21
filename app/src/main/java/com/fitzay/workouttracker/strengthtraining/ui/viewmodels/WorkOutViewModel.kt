package com.fitzay.workouttracker.strengthtraining.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.fitzay.workouttracker.strengthtraining.core.utils.categories
import com.fitzay.workouttracker.strengthtraining.core.utils.fullcategoriesbegginer
import com.fitzay.workouttracker.strengthtraining.core.utils.workOuts
import com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel
import com.fitzay.workouttracker.strengthtraining.domain.models.FullbodyCategoriesModel
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel

class WorkOutViewModel : ViewModel() {
    fun getCat(context: Context, type: String): List<CategoriesModel> {
        return context.categories().filter { it.catType.equals(type) }
    }

    fun fullbodygetCat(context: Context, week: String , day: String): List<FullbodyCategoriesModel> {
        return context.fullcategoriesbegginer().filter { it.week.equals(week) && it.day.equals(day) }
    }
    fun getWorkouts(context: Context, id: String) : List<WorkOutModel> {
        return context.workOuts().filter { it.catId.equals(id) }
    }

    fun getFullbodyWorkouts(context: Context, id: String , ex_id : Int) : List<WorkOutModel> {
        return context.workOuts().filter { it.catId.equals(id) && it.exId == ex_id}
    }

    fun getWorkoutWithID(context: Context, id: Int) : List<WorkOutModel> {
        return context.workOuts().filter { it.exId!! == id }
    }

}