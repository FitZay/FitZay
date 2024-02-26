package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.CurrentStatus
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDecimalToHoursMinutes
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToSeconds
import com.fitzay.workouttracker.strengthtraining.core.utils.getWeekDayWithDateA
import com.fitzay.workouttracker.strengthtraining.databinding.ActivityStepSummeryBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.ui.fragments.DailyFragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.TemporalAdjusters
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


class StepSummeryActivity : AppCompatActivity(), OnChartValueSelectedListener {

    private val TAG = "StepSum"
    var typeClicked = "Daily"
    var currentPosition = 1


    private lateinit var binding: ActivityStepSummeryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStepSummeryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideAllLayouts()
        binding.layoutToday.visibility = View.VISIBLE
//        dailyReport(1)

        binding.txtAverage.text = getString(R.string.daily)
        binding.txtMiles.text = "" + (Component.preference.stepGoal * 100) / Component.preference.stepGoal + " Steps"


        binding.apply {

            ivBack.setOnClickListener { onBackPressed() }

            supportFragmentManager.beginTransaction().replace(R.id.container, StepDailyFragment()).commit()


            txtDaily.setOnClickListener {
                unSelect()
                txtDaily.setBackgroundResource(R.drawable.bg_selected)
                typeClicked = "Daily"
                txtAverage.text = getString(R.string.daily)
                txtMiles.text = "" + (Component.preference.stepGoal * 100) / Component.preference.stepGoal + " Steps"
                imgStep.performClick()

                supportFragmentManager.beginTransaction().replace(R.id.container, StepDailyFragment()).commit()

            }

            txtWeekly.setOnClickListener {
                unSelect()
                txtWeekly.setBackgroundResource(R.drawable.bg_selected)
                typeClicked = "Weekly"
                txtAverage.text = getString(R.string.weekly)
                imgStep.performClick()

                supportFragmentManager.beginTransaction().replace(R.id.container, StepWeeklyFragment()).commit()

            }

        }






        binding.txtMonthly.setOnClickListener {
            unSelect()
            binding.txtMonthly.setBackgroundResource(R.drawable.bg_selected)
            typeClicked = "Monthly"
            binding.txtAverage.text = getString(R.string.monthly)
            binding.imgStep.performClick()
            supportFragmentManager.beginTransaction().replace(R.id.container, StepMonthlyFragment()).commit()

        }

//        binding.imgStep.setOnClickListener {
//            unSelectSub()
//            binding.imgStep.setBackgroundResource(R.drawable.bg_selected)
//            clickedButton(1)
//        }
//        binding.imgLocation.setOnClickListener {
//            unSelectSub()
//            binding.imgLocation.setBackgroundResource(R.drawable.bg_selected)
//            clickedButton(2)
//        }
//        binding.imgCalories.setOnClickListener {
//            unSelectSub()
//            binding.imgCalories.setBackgroundResource(R.drawable.bg_selected)
//            clickedButton(3)
//        }
//
//        binding.imgTime.setOnClickListener {
//            unSelectSub()
//            binding.imgTime.setBackgroundResource(R.drawable.bg_selected)
//            clickedButton(4)
//        }

    }


    private fun clickedButton(isChoice: Int) {
        currentPosition = isChoice
        when (typeClicked) {
            "Daily" -> {
                hideAllLayouts()
                binding.layoutToday.visibility = View.VISIBLE
                //dailyReport(isChoice)
            }

            "Weekly" -> {
                hideAllLayouts()
                binding.chart.visibility = View.VISIBLE
                weekReport(isChoice)
            }

            "Monthly" -> {
                hideAllLayouts()
                binding.chart.visibility = View.VISIBLE
                monthlyReport(isChoice)
            }
        }
    }

    private fun unSelect() {
        binding.txtDaily.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.txtWeekly.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.txtMonthly.setBackgroundResource(R.drawable.bg_unselected_options)
    }

//    private fun unSelectSub() {
//        binding.imgStep.setBackgroundResource(R.drawable.bg_unselected_options)
//        binding.imgLocation.setBackgroundResource(R.drawable.bg_unselected_options)
//        binding.imgCalories.setBackgroundResource(R.drawable.bg_unselected_options)
//        binding.imgTime.setBackgroundResource(R.drawable.bg_unselected_options)
//    }

    private fun hideAllLayouts() {
        binding.layoutToday.visibility = View.GONE
        binding.chart.visibility = View.GONE
    }

    private fun weekReport(isChoice: Int) {
        val calendar = Calendar.getInstance()
        val currentDate = Date()
        calendar.time = currentDate
        calendar.add(Calendar.DAY_OF_YEAR, 6)
        var weekEnd = calendar.time

        var weekStart = currentDate
        val DbDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        calendar.time = weekStart
        calendar.add(Calendar.DAY_OF_YEAR, -7) // Subtract 7 days to go back a week
        weekStart = calendar.time
        val weekBackStart = DbDateFormat.format(weekStart)
        calendar.time = weekEnd
        calendar.add(Calendar.DAY_OF_YEAR, -7)
        weekEnd = calendar.time
        val weekBackEnd = DbDateFormat.format(weekEnd)

        setLineChart()

        Component.stepModel.getAverageStepsBetweenDates(weekBackStart, weekBackEnd).observe(this) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {
                    binding.txtMiles.text = it.data.toString() + " Steps"
                }

                CurrentStatus.ERROR -> {
                    Log.e(TAG, "weekReport: Error To Find Weekly Average")
                }
            }
        }




        Component.stepModel.getWeeklyGoal(weekBackStart, weekBackEnd).observe(this) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {

                    calendar.time = currentDate

                    when (isChoice) {
                        1 -> {
                            val values: ArrayList<Entry> = ArrayList()
                            var i = 0
                            it.data!!.forEach { it1 ->
                                val progress = (it1.steps.toDouble() / it1.stepGoal.toDouble()) * 100
                                values.add(Entry(i.toFloat(), it1.steps.toFloat()))
                                i++

                                Log.i("TAG", "weekReport: "+it1.steps)
                            }

//                            var calendar = Calendar.getInstance().time
//                            var dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//                            var date = dateFormat.format(calendar)
//
////                            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//                            val daysOfWeek = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
//
//
//                            it.data!!.forEach {itt->
//
//
//                                    var date = dateFormat.parse(date)
//                                    val dayOfWeek = SimpleDateFormat("EE", Locale.getDefault()).format(date)
//
//                                    when (dayOfWeek) {
//                                        "Mon" -> {
//                                            values.add(BarEntry(0f, itt.steps.toFloat()))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Tue" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, itt.steps.toFloat()))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Wed" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, itt.steps.toFloat()))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Thu" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, itt.steps.toFloat()))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Fri" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, itt.steps.toFloat()))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Sat" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, itt.steps.toFloat()))
//                                            values.add(BarEntry(6f, null))
//                                        }
//
//                                        "Sun" -> {
//                                            values.add(BarEntry(0f, null))
//                                            values.add(BarEntry(1f, null))
//                                            values.add(BarEntry(2f, null))
//                                            values.add(BarEntry(3f, null))
//                                            values.add(BarEntry(4f, null))
//                                            values.add(BarEntry(5f, null))
//                                            values.add(BarEntry(6f, itt.steps.toFloat()))
//                                        }
//                                    }
//
//                                    Log.i("TAG", "weekReport: "+itt.date!!)
//                                    setData(values)
//
//                                Log.i("TAG", "k: "+it.data.size)
//                                Log.i("TAG", "k: "+it.data)
//                            }

                            setData(values)

                        }
                        2 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.distance.toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)
                        }
                        3 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.calories.toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)
                        }
                        4 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.time.convertTimeToSeconds().toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)

                        }
                    }
                }

                CurrentStatus.ERROR -> {
                    Log.e(TAG, "weekReport: " + it.message)
                }
            }
        }
    }

    private fun monthlyReport(isChoice: Int) {


        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, 1) // Move to the next month

        val currentDate = LocalDate.now()
        val previousMonth = currentDate.minusMonths(1)
        val firstDayOfMonth = previousMonth.with(TemporalAdjusters.firstDayOfMonth())
        val lastDayOfMonth = previousMonth.with(TemporalAdjusters.lastDayOfMonth())
        val startMonthDay = firstDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val endMonthDay = lastDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        setLineChart()

        Component.stepModel.getAverageStepsBetweenDates(startMonthDay, endMonthDay).observe(this) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {
                    binding.txtMiles.text = it.data.toString() + " Steps"
                }

                CurrentStatus.ERROR -> {
                    Log.e(TAG, "weekReport: Error To Find Weekly Average")
                }
            }
        }

        Component.stepModel.getWeeklyGoal(startMonthDay, endMonthDay).observe(this) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {
                    when (isChoice) {
                        1 -> {
                            val values: ArrayList<Entry> = ArrayList()
                            var i = 0
                            it.data!!.forEach { it1 ->
                                val progress =
                                    (it1.steps.toDouble() / it1.stepGoal.toDouble()) * 100

                                values.add(Entry(i.toFloat(), it1.steps.toFloat()))
                                i++
                            }
                            setData(values)

                        }
                        2 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.distance.toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)
                        }
                        3 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.calories.toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)
                        }
                        4 -> {
                            var i = 0
                            val values: ArrayList<Entry> = ArrayList()
                            it.data!!.forEach { it1 ->
                                values.add(
                                    Entry(
                                        i.toFloat(),
                                        it1.time.convertTimeToSeconds().toFloat()
                                    )
                                )
                                i++
                            }
                            setData(values)

                        }
                    }
                }
                CurrentStatus.ERROR -> {
                    Log.e(TAG, "weekReport: " + it.message)
                }
            }
        }
    }

//    private fun dailyReport(isChoice: Int) {
//
//        val currentDate = Date()
//        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//        val today = dateFormat.format(currentDate)
//
//        Component.stepModel.getDailyRecord(today).observe(this) {
//            when (it.status) {
//                CurrentStatus.SUCCESS -> {
//
//                    val animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
//
//                    when (isChoice) {
//                        1 -> {
//                            it.data!!.forEach { it1 ->
//                                val progress = (it1.steps.toDouble() / it1.stepGoal.toDouble()) * 100
//                                binding.stepProgress.progress = progress.toInt()
//                                binding.typeName.text = "STEPS"
//                                binding.userSteps.text = Component.preference.stepCount.toString()
//                                binding.userSteps.startAnimation(animZoomIn)
//                                binding.userGoal.text =
//                                    "Goal :" + Component.preference.stepGoal.toString()
//                            }
//                        }
//
//                        2 -> {
//                            it.data!!.forEach { it1 ->
//                                val progress = (it1.distance / it1.distanceGoal) * 100
//                                binding.stepProgress.progress = progress.toInt()
//                                binding.typeName.text = "DISTANCE"
//                                binding.userSteps.text = it1.distance.toString()
//                                binding.userSteps.startAnimation(animZoomIn)
//                                binding.userGoal.text =
//                                    "Goal: " + it1.distanceGoal.toString()
//                            }
//                        }
//
//                        3 -> {
//                            it.data!!.forEach { it1 ->
//                                val progress = (it1.calories / it1.caloriesGoal) * 100
//                                binding.stepProgress.progress = progress.toInt()
//                                binding.typeName.text = "CALORIES"
//                                binding.userSteps.text = it1.calories.toString()
//                                binding.userSteps.startAnimation(animZoomIn)
//                                binding.userGoal.text =
//                                    "Goal :" + it1.caloriesGoal.toString()
//                            }
//                        }
//
//                        4 -> {
//                            it.data!!.forEach { it1 ->
//                                val progress = (it1.time.convertTimeToSeconds()
//                                    .toDouble() / it1.timeGoal.convertTimeToSeconds()
//                                    .toDouble()) * 100
//                                binding.stepProgress.progress = progress.toInt()
//                                binding.typeName.text = "TIME"
//                                binding.userSteps.text = it1.time.toString()
//                                binding.userSteps.startAnimation(animZoomIn)
//                                binding.userGoal.text = "Goal: " + it1.timeGoal.toString()
//                            }
//                        }
//                    }
//
//                }
//
//                CurrentStatus.ERROR -> {
//
//                }
//            }
//        }
//    }


    private fun setData(values: ArrayList<Entry>) {

        val set1: LineDataSet
        if (binding.chart.data != null &&
            binding.chart.data.dataSetCount > 0
        ) {
            set1 = binding.chart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            set1.notifyDataSetChanged()
            binding.chart.data.notifyDataChanged()
            binding.chart.notifyDataSetChanged()
        } else {
            // create a dataset and give it a type
            set1 = LineDataSet(values, "DataSet 1")
            set1.setDrawIcons(false)

            set1.mode = LineDataSet.Mode.CUBIC_BEZIER
            set1.color = Color.BLUE // Set the line color

            // black lines and points
            set1.color = Color.YELLOW
            set1.setCircleColor(Color.WHITE)


            ///  set1.color = Color.BLUE // Set line color
            set1.valueTextColor = Color.WHITE // Set value (text) color
            set1.valueTextSize = 12f // Set value text size


            // line thickness and point size
            set1.lineWidth = 1f
            set1.circleRadius = 3f


            // draw points as solid circles
            set1.setDrawCircleHole(true)


            // text size of values
            set1.valueTextSize = 9f
            set1.highLightColor = Color.WHITE


            // set the filled area
            set1.setDrawFilled(true)
            set1.fillFormatter =
                IFillFormatter { _, _ -> binding.chart.axisLeft.axisMinimum }

            val drawable = ContextCompat.getDrawable(this, R.drawable.bg_graph)
            set1.fillDrawable = drawable


            val dataSets: ArrayList<ILineDataSet> = ArrayList()
            dataSets.add(set1) // add the data sets


            // create a data object with the data sets
            val data = LineData(dataSets)

            binding.chart.invalidate()

            setLineChart()

            // set data
            binding.chart.data = data


        }
    }

    private fun setLineChart() {
        binding.chart.highlightValues(null)
        resetLineChart()

        val typeface = ResourcesCompat.getFont(this, R.font.eina_02_regular)

        val xAxis = binding.chart.xAxis
        xAxis.typeface = typeface
        xAxis.textColor = ContextCompat.getColor(this, R.color.tab_not_selected)
        xAxis.textSize = 11f
        xAxis.setDrawAxisLine(false)
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.yOffset = 20f


        val axisLeft = binding.chart.axisLeft
        axisLeft.typeface = typeface
        axisLeft.textColor = ContextCompat.getColor(this, R.color.tab_not_selected)
        axisLeft.setDrawAxisLine(false)
        axisLeft.textSize = 11f
        axisLeft.setDrawTopYLabelEntry(true)
        axisLeft.xOffset = 20f
        axisLeft.gridColor = ContextCompat.getColor(this, R.color.dark_gray)
        axisLeft.gridLineWidth = 1f

        val axisRight = binding.chart.axisRight
        axisRight?.setDrawAxisLine(false)
        axisRight?.setDrawGridLines(false)
        axisRight?.isEnabled = false


        binding.chart.description?.isEnabled = false
        binding.chart.setDrawBorders(false)
        binding.chart.setBackgroundColor(Color.TRANSPARENT) //set whatever color you prefer
        binding.chart.legend?.isEnabled = false
        binding.chart.setDrawGridBackground(false)
        binding.chart.setPinchZoom(false)
        binding.chart.isDoubleTapToZoomEnabled = false


        binding.chart.xAxis.granularity = 1f
        binding.chart.extraBottomOffset = 10f
        binding.chart.extraTopOffset = 30f
        binding.chart.extraRightOffset = 30f
        binding.chart.axisLeft.axisMinimum = 0f

        binding.chart.isDragDecelerationEnabled = false
        binding.chart.invalidate()
    }

    fun resetLineChart() {
        binding.chart.fitScreen()
        binding.chart.data?.clearValues()
        binding.chart.xAxis.valueFormatter = null
        binding.chart.notifyDataSetChanged()
        binding.chart.clear()
        binding.chart.invalidate()
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        val lineSets = binding.chart.lineData?.dataSets

        for (i in 0 until lineSets?.size!!) {
            for (j in 0 until lineSets[i].entryCount) {
                lineSets[i].getEntryForIndex(j).icon = null
            }
        }

        val data = ArrayList<ChartHoverModel>()
        for (i in 0 until lineSets.size) {
            val chartHoverModel = ChartHoverModel()
            chartHoverModel.value = DecimalFormat("#0.00").format(lineSets[i].getEntryForIndex(e?.x!!.toInt()).y)
            chartHoverModel.name = lineSets[i].label
            chartHoverModel.yAxisLabel = getWeekDayWithDateA(e.x.toInt())

            chartHoverModel.color = lineSets[i].color
            data.add(chartHoverModel)

            val barColor = lineSets[i].color
            chartHoverModel.color = barColor

//            for (j in 0 until lineSets[i].entryCount) {
//                if (e.x.toInt() == j) {
//                    lineSets[i].getEntryForIndex(j).icon =
//                       getDrawableUsingPosition(this, i)
//                    Log.e("fkdlkfd",i.toString())
//                }
//            }

        }
        window.decorView.performHapticFeedback(
            HapticFeedbackConstants.VIRTUAL_KEY,
            HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
        )
        binding.chart.invalidate()

        val mv = CustomMarkerViewForLineChart(
            this,
            R.layout.marker_view_line_chart,
            binding.chart.height,
            data
        )

        // Set the marker to the chart
        mv.chartView = binding.chart
        binding.chart.markerView = mv

    }


    override fun onNothingSelected() {
        val lineSets = binding.chart.lineData?.dataSets

        for (i in 0 until lineSets?.size!!) {
            for (j in 0 until lineSets[i].entryCount) {
                lineSets[i].getEntryForIndex(j).icon = null
            }
        }
    }

//    private fun setData(values: ArrayList<BarEntry>) {
//
//        binding.apply {
//            val dataSet = BarDataSet(values, "")
//            dataSet.setColors(Color.parseColor("#9CB135"))
//            val daysOfWeek = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
//
//            // setting text color.
//            dataSet.valueTextColor = Color.parseColor("#939292")
//            dataSet.valueTextSize = 14f // Set text size if needed
//            val xAxis = chart.xAxis
//            xAxis.position = XAxis.XAxisPosition.BOTTOM
//            val formatter = IndexAxisValueFormatter(daysOfWeek)
//            xAxis.valueFormatter = formatter
//            val barData = BarData(dataSet)
//            barData.setBarWidth(0.2f); // Adjust the width as needed
//            xAxis.setDrawGridLines(false);
//            chart.axisLeft.isEnabled = true
//            chart.axisRight.isEnabled = false
//            chart.setScaleEnabled(true)
//            chart.setPinchZoom(true)
//            chart.setDrawBorders(false)   //All Line Remove
//            chart.axisLeft.textColor = Color.parseColor("#939292")
//            xAxis.textColor = Color.parseColor("#939292")
//
//            chart.getDescription().setEnabled(false);
//            chart.animateY(1000);
//
//            chart.data = barData
//
//            chart.notifyDataSetChanged();
//            chart.invalidate();
//
//        }
//    }
//
//    private fun setLineChart() {
//        // Configure the bar chart
//        binding.chart.apply {
//            description.isEnabled = false
//            setDrawBorders(false)
//            setBackgroundColor(Color.TRANSPARENT)
//            legend.isEnabled = false
//            setDrawGridBackground(false)
//            setPinchZoom(false)
//            isDoubleTapToZoomEnabled = false
//            xAxis.granularity = 1f
//            extraBottomOffset = 10f
//            extraTopOffset = 30f
//            extraRightOffset = 30f
//            axisLeft.axisMinimum = 0f
//            isDragDecelerationEnabled = false
//            notifyDataSetChanged()
//            invalidate()
//        }
//    }
//
//    fun resetBarChart() {
//        binding.chart.fitScreen()
//        binding.chart.data?.clearValues()
//        binding.chart.xAxis.valueFormatter = null
//        binding.chart.notifyDataSetChanged()
//        binding.chart.clear()
//        binding.chart.invalidate()
//    }

}