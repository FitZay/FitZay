package com.fitzay.workouttracker.strengthtraining.ui.fragments


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDecimalToHoursMinutes
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.core.utils.getSimpleDate
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentDailyBinding
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentProfileBinding
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentWeeklyBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.components.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class WeeklyFragment : Fragment(), OnChartValueSelectedListener {

    lateinit var binding: FragmentWeeklyBinding


    private lateinit var tooltipView: View
    private lateinit var tvValue: TextView
    private lateinit var popupWindow: PopupWindow

    lateinit var calendarCopy: Calendar
    lateinit var calendar: Calendar
    lateinit var calendarCopy2: Calendar
    lateinit var weekStart: Date
    lateinit var weekEnd: Date
    lateinit var dateFormat: SimpleDateFormat
    var date: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeeklyBinding.inflate(inflater, container, false)

        binding.apply {
            tooltipView = layoutInflater.inflate(R.layout.custom_tooltip, null)
            tvValue = tooltipView.findViewById(R.id.tvValue)

            root.setOnClickListener {
                dateLayout.visibility = View.VISIBLE
            }


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
            txtDate.text = calendar.time.toString() + " " + weekEnd.time

            // Initialize the PopupWindow
            popupWindow = PopupWindow(
                tooltipView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            popupWindow.isOutsideTouchable = true

            sleepChartWeekly.setOnChartValueSelectedListener(this@WeeklyFragment)


            //1st time or Current Data
            previousWeek(txtDate)

            binding.previousDate.setOnClickListener {
                previousWeek(binding.txtDate)
                binding.nextDate.visibility = View.VISIBLE


            }
            binding.nextDate.setOnClickListener {
                nextWeek(binding.txtDate)
            }


        }

        return binding.root
    }


    private fun previousWeek(textView: TextView) {
        binding.apply {

            var pattern:SimpleDateFormat?=null
            if (isCurrentMonth(this@WeeklyFragment.calendar)) {
                pattern = SimpleDateFormat("EE", Locale.getDefault())

                Log.i("TAG--", "previousWeek: "+pattern)
            }
            else
            {
                pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())

            }
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


            setBarData(pattern, textView,isCurrentWeek(this@WeeklyFragment.calendar))

            Log.i("TAG", "previousWeek: " + weekBackFormatStart)
            Log.i("TAG", "previousWeek: " + weekBackFormatEnd)

        }


    }

    private fun nextWeek(textView: TextView) {
        var pattern:SimpleDateFormat?=null
        if (isCurrentMonth(this@WeeklyFragment.calendar)) {
            pattern = SimpleDateFormat("EE", Locale.getDefault())
        }
        else
        {
            pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())

        }
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

//        textView.text = weekForwardFormatStart + "," + weekForwardFormatEnd
        if (calendarCopy.time <= currentDate.time) {
            calendarCopy.add(Calendar.DAY_OF_YEAR, 7)
            Log.i("TAG", "nextWeek--if: ")

            if (isCurrentMonth(this@WeeklyFragment.calendar)) {
                binding.nextDate.visibility = View.GONE
                setBarData(pattern, textView,isCurrentWeek(this@WeeklyFragment.calendar))
            }
            else
            {
                binding.nextDate.visibility = View.VISIBLE
                setBarData(pattern, textView,isCurrentWeek(this@WeeklyFragment.calendar))
            }

        }
        else {
            binding.nextDate.visibility = View.GONE
            Log.i("TAG", "nextWeek--else: ")

        }
        calendarCopy2.add(Calendar.DAY_OF_YEAR, 7)
        if (calendarCopy2.time >= currentDate.time) {
            binding.nextDate.visibility = View.GONE
            Log.i("TAG", "nextWeek--iff: ")
            //textView.text = weekForwardFormatStart
            setBarData(pattern, textView,isCurrentWeek(this@WeeklyFragment.calendar))
        }


    }

    private fun setBarData(pattern: SimpleDateFormat, txt: TextView,displayAsWeekdays:Boolean) {
        binding.apply {
            CoroutineScope(Dispatchers.IO).launch {
                com.fitzay.workouttracker.strengthtraining.di.Component.alarmViewModel.alarmRepository.getAlarms(
                    1
                ).collect { result ->

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
                    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    val formattedDates = allDatesOfWeek.map {
                        if (displayAsWeekdays) {
                            // pattern.format(it)
                            SimpleDateFormat("EEE", Locale.getDefault()).format(it)
                        }  else {
                            SimpleDateFormat("dd-MMM", Locale.getDefault()).format(it)
                        }
                    }.toTypedArray()

                    var avg = 0f
                    var sumOfFinalStrings = 0f
                    allDatesOfWeek.forEachIndexed { index, date ->
                        val dateFormatted = dateFormat.format(date)
                        val dataForDate = result.find { it.date == dateFormatted }

                        if (dataForDate != null) {
                            // Data exists for this date, process it
                            val regex = Regex("\\d+")
                            val matchResults = regex.findAll(dataForDate.totalSleepingHr!!)
                            val numericValues = matchResults.map { it.value }.toList()
                            val finalValue =
                                numericValues.joinToString(".").replace(" ", "").toFloat()
                            sumOfFinalStrings += finalValue
                            avg = sumOfFinalStrings / 7
                            barEntriesArrayList.add(BarEntry(index.toFloat(), finalValue))
                        } else {
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

                    val startWeek = SimpleDateFormat("dd-MMM", Locale.getDefault()).format(firstDate)
                    val endWeek =SimpleDateFormat("dd-MMM", Locale.getDefault()).format(lastDate)



                    Log.i("TAG", "setBarData: " + result.size)

                    withContext(Dispatchers.Main) {
                        val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(avg)

                        if (avg.equals(0f)) {
                            txtMiles.text = getString(R.string.no_data)

                        } else {
                            txtMiles.text = "$hours hr $minutes min"

                        }
                        txt.text = startWeek + "," + endWeek

                        val dataSet = BarDataSet(barEntriesArrayList, "")
//                        dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                        dataSet.setColors(android.graphics.Color.parseColor("#9CB135"))


                        // setting text color.
                        dataSet.valueTextColor = android.graphics.Color.parseColor("#939292")
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
                        sleepChartWeekly.axisLeft.textColor = android.graphics.Color.parseColor("#939292")
                        xAxis.textColor = android.graphics.Color.parseColor("#939292")

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

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e != null) {
            binding.dateLayout.visibility = View.INVISIBLE

            val value = e.y
            val xAxisLabel = binding.sleepChartWeekly.xAxis.valueFormatter.
            getFormattedValue(e.x,
                binding.sleepChartWeekly.xAxis
            )

            val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(value)

            tvValue.text = "$hours hr $minutes min\nDay: $xAxisLabel"


            val transformer = binding.sleepChartWeekly.getTransformer(
                binding.sleepChartWeekly.data.getDataSetByIndex(0).axisDependency
            )
            val xPos = transformer.getPixelForValues(e.x, e.y).x - tooltipView.width / 2

            // Calculate the Y position for the top center of the graph
//            val yPos = binding.sleepChartWeekly.viewPortHandler.contentHeight()
            val yOffset = 80 // Adjust as needed
            val yPos = binding.sleepChartWeekly.viewPortHandler.contentHeight() - yOffset
            Log.i("KKKKK", "onValueSelected: "+value)

            Log.i("KKKKK", "onValueSelected: "+h)
            popupWindow.showAtLocation(
                binding.root, // Use the root layout as the anchor view
                Gravity.START or Gravity.CENTER or Gravity.TOP,
                xPos.toInt(),
                yPos.toInt()
            )



        }
    }

    override fun onNothingSelected() {
        // This method is called when nothing is selected in the chart
        popupWindow.dismiss()
        binding.dateLayout.visibility = View.VISIBLE

    }

    private fun isCurrentMonth(calendar: Calendar): Boolean {
        val currentCalendar = Calendar.getInstance()
        return calendar.get(Calendar.MONTH) == currentCalendar.get(Calendar.MONTH)
    }

    private fun isCurrentWeek(calendar: Calendar): Boolean {
        val today = Calendar.getInstance()
        val currentWeek = today.get(Calendar.WEEK_OF_YEAR)
        val givenWeek = calendar.get(Calendar.WEEK_OF_YEAR)
        return currentWeek == givenWeek
    }
}