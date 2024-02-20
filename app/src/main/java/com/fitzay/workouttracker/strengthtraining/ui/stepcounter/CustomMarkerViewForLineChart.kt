package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import com.fitzay.workouttracker.strengthtraining.R
import com.github.mikephil.charting.components.IMarker
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

@SuppressLint("ViewConstructor")
class CustomMarkerViewForLineChart(
    context: Context,
    layoutResource: Int,
    height: Int,
    chartHoverModelList: ArrayList<ChartHoverModel>
) :
    MarkerView(context, layoutResource), IMarker {
    private val tooltip: TextView = findViewById<View>(R.id.tooltip) as TextView
    private val mChartHoverModelList: ArrayList<ChartHoverModel>
    private val uiScreenHeight = height

    @SuppressLint("SetTextI18n")
    override fun refreshContent(e: Entry, highlight: Highlight) {
        tooltip.text =
            mChartHoverModelList[0].yAxisLabel
        super.refreshContent(e, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-uiScreenHeight).toFloat())
    }

    init {
        mChartHoverModelList = chartHoverModelList
    }
}