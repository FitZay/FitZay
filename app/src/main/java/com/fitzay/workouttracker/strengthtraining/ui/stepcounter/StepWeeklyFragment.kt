package com.fitzay.workouttracker.strengthtraining.ui.stepcounter

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.HapticFeedbackConstants
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.CurrentStatus
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDecimalToHoursMinutes
import com.fitzay.workouttracker.strengthtraining.core.utils.convertTimeToSeconds
import com.fitzay.workouttracker.strengthtraining.core.utils.getWeekDayWithDateA
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentStepWeeklyBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.github.mikephil.charting.components.XAxis
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Calendar
import java.util.Date
import java.util.Locale


class StepWeeklyFragment : Fragment() , OnChartValueSelectedListener {


    private lateinit var binding:FragmentStepWeeklyBinding

    lateinit var calendarCopy: Calendar
    lateinit var calendar: Calendar
    lateinit var calendarCopy2: Calendar
    lateinit var weekStart: Date
    lateinit var weekEnd: Date
    lateinit var dateFormat: SimpleDateFormat
    var date: String = ""
    private lateinit var tooltipView: View
    private lateinit var tvValue: TextView
    private lateinit var popupWindow: PopupWindow

    private var check="Step"
    private var TAG="StepWeeklyFragment"
    var i=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentStepWeeklyBinding.inflate(inflater,container,false)



        binding.apply {

            tooltipView = layoutInflater.inflate(R.layout.custom_tooltip, null)
            tvValue = tooltipView.findViewById(R.id.tvValue)

            // Initialize the PopupWindow
            popupWindow = PopupWindow(
                tooltipView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            popupWindow.isOutsideTouchable = true

            sleepChartWeekly.setOnChartValueSelectedListener(this@StepWeeklyFragment)


            calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, 6)
            weekStart = Date()   // Current Date
            weekEnd = calendar.time

            dateFormat = SimpleDateFormat("dd-MMM", Locale.getDefault())
            calendarCopy = Calendar.getInstance()
            calendarCopy2 = Calendar.getInstance()

            val calendar = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            date = dateFormat.format(calendar)
//            txtDate.text = calendar.time.toString() + " " + weekEnd.time
            val currentDate = Date()
            txtDate.text = this@StepWeeklyFragment.dateFormat.format(currentDate).toString()+" "+this@StepWeeklyFragment.dateFormat.format(weekEnd).toString()

            //Not Selected By Default 1 Show
            //weekReport(1)

            //1st time or Current Data
            previousWeek(txtDate)

            previousDate.setOnClickListener {
                previousWeek(txtDate)
                nextDate.visibility = View.VISIBLE


            }
            nextDate.setOnClickListener {
                nextWeek(txtDate)
            }

            imgStep.setOnClickListener {
                unSelectSub()
                imgStep.setBackgroundResource(R.drawable.bg_selected)
                i=1
                setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate)

                check="Step"
            }
            binding.imgLocation.setOnClickListener {
                unSelectSub()
                imgLocation.setBackgroundResource(R.drawable.bg_selected)
                i=2
                setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate)
                check="Distance"

            }
            binding.imgCalories.setOnClickListener {
                unSelectSub()
                i=3
                imgCalories.setBackgroundResource(R.drawable.bg_selected)
                setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate)

                check="Calories"


            }

            binding.imgTime.setOnClickListener {
                unSelectSub()
                imgTime.setBackgroundResource(R.drawable.bg_selected)
                i=4
                setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate)

                check="Time"


            }
        }

        return binding.root
    }

    private fun previousWeek(textView: TextView) {
        binding.apply {


            val pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())
            calendar.time = weekStart
            calendar.add(Calendar.DAY_OF_YEAR, -7) // Subtract 7 days to go back a week
            calendarCopy.add(Calendar.DAY_OF_YEAR, -7)
            weekStart = calendar.time
            val weekBackFormatStart = dateFormat.format(weekStart)
            val weekBackStart = pattern.format(weekStart)
            calendar.time = weekEnd
            calendar.add(Calendar.DAY_OF_YEAR, -7)
            weekEnd = calendar.time
            val weekBackFormatEnd = dateFormat.format(weekEnd)
            val weekBackEnd = pattern.format(weekEnd)


//            textView.text = weekBackFormatStart + "," + weekBackFormatEnd

            setBarData(i,pattern, textView)

            Log.i("TAG", "previousWeek: " + weekBackFormatStart)
            Log.i("TAG", "previousWeek: " + weekBackFormatEnd)

        }


    }


    private fun nextWeek(textView: TextView) {
        val pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())
        calendar.time = weekStart
        Log.i("TAG", "calendar.time: " + calendar.time)
        calendar.add(Calendar.DAY_OF_YEAR, 7) // Add 7 days to go next a week
        calendarCopy.time = calendar.time
        Log.i("TAG", "calendarCopy.time: " + calendarCopy.time)
        weekStart = calendar.time
        Log.i("TAG", "weekStart: " + weekStart)

        val weekForwardFormatStart = dateFormat.format(weekStart)
        Log.i("TAG", "weekForwardFormatStart: " + weekForwardFormatStart)

        val weekBackStart2 = pattern.format(weekStart)
        Log.i("TAG", "weekBackStart2: " + weekBackStart2)
        calendar.time = weekEnd

        Log.i("TAG", "calendar.time: " + calendar.time)
        calendar.add(Calendar.DAY_OF_YEAR, 7)
        weekEnd = calendar.time

        Log.i("TAG", "weekEnd: " + weekEnd)
        val weekForwardFormatEnd = dateFormat.format(weekEnd)
        Log.i("TAG", "weekForwardFormatEnd: " + weekForwardFormatEnd)
        val weekBackEnd2 = pattern.format(weekEnd)
        Log.i("TAG", "weekBackEnd2: " + weekBackEnd2)

        val startDate = weekBackStart2
        Log.i("TAG", "startDate: " + startDate)

        val endDate = weekBackEnd2
        Log.i("TAG", "endDate: " + endDate)

        val currentDate = Calendar.getInstance()
        calendarCopy2.time = calendarCopy.time

        textView.text = weekForwardFormatStart + "," + weekForwardFormatEnd
        if (calendarCopy.time <= currentDate.time) {
            calendarCopy.add(Calendar.DAY_OF_YEAR, 7)
            Log.i("TAG", "nextWeek--if: ")

            setBarData(i,pattern, textView)
        } else {
            binding.nextDate.visibility = View.GONE
            Log.i("TAG", "nextWeek--else: ")

        }
        calendarCopy2.add(Calendar.DAY_OF_YEAR, 7)
        if (calendarCopy2.time > currentDate.time) {
            binding.nextDate.visibility = View.GONE
            Log.i("TAG", "nextWeek--iff: ")
            textView.text = weekForwardFormatStart

        }


    }

    private fun unSelectSub() {
        binding.imgStep.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgLocation.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgCalories.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgTime.setBackgroundResource(R.drawable.bg_unselected_options)
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

        Component.stepModel.getAverageStepsBetweenDates(weekBackStart, weekBackEnd).observe(requireActivity()) {
            when (it.status) {
                CurrentStatus.SUCCESS -> {
                    //binding.txtMiles.text = it.data.toString() + " Steps"
                    Log.i(TAG, "weekReport: "+it.data.toString())
                }

                CurrentStatus.ERROR -> {
                    Log.e(TAG, "weekReport: Error To Find Weekly Average")
                }
            }
        }




        Component.stepModel.getWeeklyGoal(weekBackStart, weekBackEnd).observe(requireActivity()) {
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
    private fun setBarData(i:Int,pattern: SimpleDateFormat, txt: TextView) {
        binding.apply {
            CoroutineScope(Dispatchers.IO).launch {

                Component.stepModel.stepRepository.getAllRecordsF(1).collect{result->


                            val calendar = Calendar.getInstance()
                            calendar.time = weekStart
                            val allDatesOfWeek = mutableListOf<Date>()

                            while (calendar.time <= weekEnd) {
                                allDatesOfWeek.add(calendar.time)
                                calendar.add(Calendar.DAY_OF_YEAR, 1)
                            }


// Remove the first date from the list
                            allDatesOfWeek.removeAt(0)

                            // Add the last date to the list
                            allDatesOfWeek.add(calendar.time)

                            Log.i("TAG", "NEW DATE: " + calendar.time)
                            Log.i("TAG", "NEW DATE: " + weekEnd)
                            Log.i("TAG", "NEW DATE: " + weekStart)
                            Log.i("TAG", "NEW DATE: " + allDatesOfWeek)
                            var barEntriesArrayList = ArrayList<BarEntry>()
                            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            val formattedDates = allDatesOfWeek.map { pattern.format(it) }.toTypedArray()
                            var avg = 0f
                            var sumOfFinalStrings = 0f
                            allDatesOfWeek.forEachIndexed { index, date ->
                                val dateFormatted = dateFormat.format(date)
                                val dataForDate = result.find { it.date == dateFormatted }
                                Log.i(TAG, "setBarData999: "+dateFormatted)

                                if (dataForDate != null) {
                                    // Data exists for this date, process it
//                                    val regex = Regex("\\d+")
//                                    val matchResults = regex.findAll(dataForDate.totalSleepingHr!!)
//                                    val numericValues = matchResults.map { it.value }.toList()
//                                    val finalValue = numericValues.joinToString(".").replace(" ", "").toFloat()
//                                    sumOfFinalStrings += finalValue
//                                    avg = sumOfFinalStrings / 7
                                    when(i)
                                    {
                                        1->barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.steps.toFloat()))
                                        2->barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.distance.toFloat()))
                                        3->barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.calories.toFloat()))
                                        4->barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.time.convertTimeToSeconds().toFloat()))
                                    }

                                }
                                else {
                                    // Data does not exist for this date, handle accordingly
                                    // For example, you could add a default value or leave the bar empty
                                    barEntriesArrayList.add(
                                        BarEntry(
                                            index.toFloat(),
                                            0f
                                        )
                                    ) // Add a default value of 0


                                }


                            }
                            // Get the first date
                            val firstDate = allDatesOfWeek.first()
                            val lastDate = allDatesOfWeek.last()

                            val startWeek = pattern.format(firstDate)
                            val endWeek = pattern.format(lastDate)



                            Log.i("TAG", "setBarData: " + result.size)

                            withContext(Dispatchers.Main) {
                                val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(avg)

                                if (avg.equals(0f)) {
                                    //txtMiles.text = "No Data"

                                } else {
                                   // txtMiles.text = "$hours hr $minutes min"

                                }
                                txt.text = startWeek + "," + endWeek

                                val dataSet = BarDataSet(barEntriesArrayList, "")
//                        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                                dataSet.setColors(Color.parseColor("#9CB135"))


                                // setting text color.
                                dataSet.valueTextColor = Color.parseColor("#939292")
                                dataSet.valueTextSize = 14f // Set text size if needed
                                val xAxis = sleepChartWeekly.xAxis
                                xAxis.position = XAxis.XAxisPosition.BOTTOM
                                val formatter = IndexAxisValueFormatter(formattedDates)
                                xAxis.valueFormatter = formatter
                                val barData = BarData(dataSet)
                                barData.setBarWidth(0.2f); // Adjust the width as needed
                                xAxis.setDrawGridLines(false);
                                dataSet.setDrawValues(false)
                                sleepChartWeekly.axisLeft.axisMinimum = 0f
                                sleepChartWeekly.axisLeft.isEnabled = true
                                sleepChartWeekly.axisRight.isEnabled = false
                                sleepChartWeekly.setScaleEnabled(false)
                                sleepChartWeekly.setPinchZoom(false)
                                sleepChartWeekly.setDrawBorders(false)   //All Line Remove
                                sleepChartWeekly.axisLeft.textColor = Color.parseColor("#939292")
                                xAxis.textColor = Color.parseColor("#939292")

                                sleepChartWeekly.getDescription().setEnabled(false);
                                sleepChartWeekly.animateY(1000);

                                sleepChartWeekly.data = barData

                                sleepChartWeekly.notifyDataSetChanged();
                                sleepChartWeekly.invalidate();

                        }


                }
            }
        }
    }

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

            val drawable = ContextCompat.getDrawable(requireActivity(), R.drawable.bg_graph)
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

        val typeface = ResourcesCompat.getFont(requireActivity(), R.font.eina_02_regular)

        val xAxis = binding.chart.xAxis
        xAxis.typeface = typeface
        xAxis.textColor = ContextCompat.getColor(requireActivity(), R.color.tab_not_selected)
        xAxis.textSize = 11f
        xAxis.setDrawAxisLine(false)
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.yOffset = 20f


        val axisLeft = binding.chart.axisLeft
        axisLeft.typeface = typeface
        axisLeft.textColor = ContextCompat.getColor(requireActivity(), R.color.tab_not_selected)
        axisLeft.setDrawAxisLine(false)
        axisLeft.textSize = 11f
        axisLeft.setDrawTopYLabelEntry(true)
        axisLeft.xOffset = 20f
        axisLeft.gridColor = ContextCompat.getColor(requireActivity(), R.color.dark_gray)
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

//    override fun onValueSelected(e: Entry?, h: Highlight?) {
//        val lineSets = binding.chart.lineData?.dataSets
//
//        for (i in 0 until lineSets?.size!!) {
//            for (j in 0 until lineSets[i].entryCount) {
//                lineSets[i].getEntryForIndex(j).icon = null
//            }
//        }
//
//        val data = ArrayList<ChartHoverModel>()
//        for (i in 0 until lineSets.size) {
//            val chartHoverModel = ChartHoverModel()
//            chartHoverModel.value = DecimalFormat("#0.00").format(lineSets[i].getEntryForIndex(e?.x!!.toInt()).y)
//            chartHoverModel.name = lineSets[i].label
//            chartHoverModel.yAxisLabel = getWeekDayWithDateA(e.x.toInt())
//
//            chartHoverModel.color = lineSets[i].color
//            data.add(chartHoverModel)
//
//            val barColor = lineSets[i].color
//            chartHoverModel.color = barColor
//
////            for (j in 0 until lineSets[i].entryCount) {
////                if (e.x.toInt() == j) {
////                    lineSets[i].getEntryForIndex(j).icon =
////                       getDrawableUsingPosition(this, i)
////                    Log.e("fkdlkfd",i.toString())
////                }
////            }
//
//        }
//        requireActivity().window.decorView.performHapticFeedback(
//            HapticFeedbackConstants.VIRTUAL_KEY,
//            HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
//        )
//        binding.chart.invalidate()
//
//        val mv = CustomMarkerViewForLineChart(
//            requireActivity(),
//            R.layout.marker_view_line_chart,
//            binding.chart.height,
//            data
//        )
//
//        // Set the marker to the chart
//        mv.chartView = binding.chart
//        binding.chart.markerView = mv
//
//    }
//
//
//    override fun onNothingSelected() {
//        val lineSets = binding.chart.lineData?.dataSets
//
//        for (i in 0 until lineSets?.size!!) {
//            for (j in 0 until lineSets[i].entryCount) {
//                lineSets[i].getEntryForIndex(j).icon = null
//            }
//        }
//    }

    @SuppressLint("SetTextI18n")
    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e != null) {
            val value = e.y
            val xAxisLabel = binding.sleepChartWeekly.xAxis.valueFormatter.getFormattedValue(
                e.x,
                binding.sleepChartWeekly.xAxis
            )

            val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(value)

            when(check)
            {
                "Step"-> tvValue.text = "${value.toInt()} Steps $xAxisLabel"
                "Distance"-> tvValue.text = "${value.toInt()} Distance $xAxisLabel"
                "Calories"-> tvValue.text = "${value.toInt()} Calories $xAxisLabel"
                "Time"-> tvValue.text = "${value.toInt()} Time $xAxisLabel"
            }



            val transformer = binding.sleepChartWeekly.getTransformer(binding.sleepChartWeekly.data.getDataSetByIndex(0).axisDependency)
            val xPos = transformer.getPixelForValues(e.x, e.y).x - tooltipView.width / 2

            // Calculate the Y position for the top center of the graph
//            val yPos = binding.sleepChart.viewPortHandler.contentHeight()

            val yOffset = 100 // Adjust as needed
            val yPos = binding.sleepChartWeekly.viewPortHandler.contentHeight() - yOffset

            popupWindow.showAtLocation(
                binding.root, // Use the root layout as the anchor view
                Gravity.START or Gravity.CENTER or Gravity.TOP,
                xPos.toInt(),
                yPos.toInt()
            )

//            barDataSet!!.color = android.graphics.Color.parseColor("#0080FF") // Assuming barDataSet is your BarDataSet variable

        }
    }


    override fun onNothingSelected() {
        // This method is called when nothing is selected in the chart
        popupWindow.dismiss()

//        barDataSet!!.color = android.graphics.Color.parseColor("#9CB135") // Assuming barDataSet is your BarDataSet variable

    }

}