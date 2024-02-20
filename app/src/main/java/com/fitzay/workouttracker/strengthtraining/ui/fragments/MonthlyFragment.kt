package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.core.utils.convertDecimalToHoursMinutes
import com.fitzay.workouttracker.strengthtraining.databinding.FragmentMonthlyBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Locale


class MonthlyFragment : Fragment(),OnChartValueSelectedListener {


    private lateinit var binding: FragmentMonthlyBinding


    // array list for storing entries.
    var barEntriesArrayList: ArrayList<BarEntry>? = null

    //lateinit var dayList: ArrayList<String>

    private lateinit var tooltipView: View
    private lateinit var tvValue: TextView
    private lateinit var popupWindow: PopupWindow

    //    private lateinit var lineView: View
    lateinit var calendar: Calendar
    lateinit var calendar_2: Calendar
    lateinit var currentMonth: LocalDate
    lateinit var calendarCopy: Calendar
    lateinit var calendarCopy2: Calendar
    lateinit var dateFormat: SimpleDateFormat
//    var date: String = ""

    var averageSleep = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMonthlyBinding.inflate(inflater, container, false)

        binding.apply {
            tooltipView = layoutInflater.inflate(R.layout.custom_tooltip, null)
            tvValue = tooltipView.findViewById(R.id.tvValue)



            currentMonth = LocalDate.now()
            calendar = Calendar.getInstance()
            calendar_2 = Calendar.getInstance()
            calendarCopy = Calendar.getInstance()
            calendarCopy2 = Calendar.getInstance()
            val monthForwardFormat = SimpleDateFormat("MMM", Locale.getDefault()).format(calendar.time)

            txtDate.text = monthForwardFormat

            // Initialize the PopupWindow
            popupWindow = PopupWindow(
                tooltipView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            popupWindow.isOutsideTouchable = true

            sleepChartMonthly.setOnChartValueSelectedListener(this@MonthlyFragment)


            CoroutineScope(Dispatchers.IO).launch {
                val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1 // Adding 1 because months are zero-based

                com.fitzay.workouttracker.strengthtraining.di.Component.alarmViewModel.alarmRepository.getAlarms(
                    1
                ).collect { result ->
                    var currentDateDataAvailable = false

                    val alarmsForCurrentMonth = result.filter { alarm ->
                        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                        val date = dateFormat.parse(alarm.date)
                        val calendar = Calendar.getInstance()
                        calendar.time = date
                        calendar.get(Calendar.MONTH) + 1 == currentMonth // Adding 1 because months are zero-based
                    }


                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                    Log.i("TAG", "da: " + maxDays)
                    var barEntriesArrayList = ArrayList<BarEntry>()
                    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    val daysOfWeek = arrayOf(
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                        "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
                    )
                    var sumOfFinalStrings = 0f
                    alarmsForCurrentMonth.forEach {

                        val dayOfMonth = SimpleDateFormat("dd", Locale.getDefault()).format(dateFormat.parse(it.date)!!)
                        val regex = Regex("\\d+")
                        val matchResults = regex.findAll(it.totalSleepingHr!!)
                        val numericValues = matchResults.map { it.value }.toList()
                        val finalString = numericValues.joinToString(".").replace(" ", "").toFloat()

                        sumOfFinalStrings += finalString


                        barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat()-1, finalString))

                        for (i in 1..maxDays) {
                            val dayOfMonth = i.toString()
                            if (!barEntriesArrayList.any { it.x == dayOfMonth.toFloat() }) {
                                barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat(), 0f))
                            }
                        }



                        withContext(Dispatchers.Main)
                        {
                            txtMiles.text = it.totalSleepingHr!!
                            val dataSet = BarDataSet(barEntriesArrayList, "")
//                            dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                            dataSet.setColors(android.graphics.Color.parseColor("#9CB135"))
                            // setting text color.
                            dataSet.valueTextColor = android.graphics.Color.parseColor("#939292")
                            dataSet.valueTextSize = 14f // Set text size if needed
                            val xAxis = sleepChartMonthly.xAxis
                            xAxis.position = XAxis.XAxisPosition.BOTTOM
                            val formatter = IndexAxisValueFormatter(daysOfWeek)
                            xAxis.valueFormatter = formatter
                            val barData = BarData(dataSet)
                            barData.setBarWidth(0.2f); // Adjust the width as needed
                            xAxis.setDrawGridLines(false);
                            sleepChartMonthly.axisLeft.isEnabled = true
                            sleepChartMonthly.axisRight.isEnabled = false
                            sleepChartMonthly.setScaleEnabled(false)
                            sleepChartMonthly.setPinchZoom(false)
                            dataSet.setDrawValues(false)
                            sleepChartMonthly.setDrawBorders(false)   //All Line Remove
                            sleepChartMonthly.axisLeft.textColor =
                                android.graphics.Color.parseColor("#939292")
                            xAxis.textColor = android.graphics.Color.parseColor("#939292")

                            sleepChartMonthly.getDescription().setEnabled(false);
                            sleepChartMonthly.animateY(1000);

                            barData.isHighlightEnabled=true

// Set the color for the selected bar
//                            barData.setH(Color.RED);

                            sleepChartMonthly.data = barData
                            sleepChartMonthly.notifyDataSetChanged();
                            sleepChartMonthly.invalidate();
                        }

                    }

                    if (alarmsForCurrentMonth.isEmpty()) {

                        barEntriesArrayList.add(BarEntry(0f,0f))

                        for (i in 1..maxDays) {
                            val dayOfMonth = i.toString()
                            if (!barEntriesArrayList.any { it.x == dayOfMonth.toFloat() }) {
                                barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat(), 0f))
                            }

                        }



                        withContext(Dispatchers.Main)
                        {
                            txtMiles.text ="No Data"

                            val dataSet = BarDataSet(barEntriesArrayList, "")
//                            dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                            dataSet.setColors(android.graphics.Color.parseColor("#9CB135"))

                            // setting text color.
                            dataSet.valueTextColor = android.graphics.Color.parseColor("#939292")
                            dataSet.valueTextSize = 14f // Set text size if needed
                            val xAxis = sleepChartMonthly.xAxis
                            xAxis.position = XAxis.XAxisPosition.BOTTOM
                            val formatter = IndexAxisValueFormatter(daysOfWeek)
                            xAxis.valueFormatter = formatter
                            val barData = BarData(dataSet)
                            barData.setBarWidth(0.2f); // Adjust the width as needed
                            xAxis.setDrawGridLines(false);
                            sleepChartMonthly.axisLeft.isEnabled = true
                            sleepChartMonthly.axisRight.isEnabled = false
                            sleepChartMonthly.setScaleEnabled(false)
                            sleepChartMonthly.setPinchZoom(false)
                            dataSet.setDrawValues(false)

                            sleepChartMonthly.setDrawBorders(false)   //All Line Remove
                            sleepChartMonthly.axisLeft.textColor =
                                android.graphics.Color.parseColor("#939292")
                            xAxis.textColor = android.graphics.Color.parseColor("#939292")

                            sleepChartMonthly.getDescription().setEnabled(false);
                            sleepChartMonthly.animateY(1000);

                            sleepChartMonthly.data = barData

                            sleepChartMonthly.notifyDataSetChanged();
                            sleepChartMonthly.invalidate();
                        }
                        Log.i("TAG", "No data available for the current month")
                        return@collect
                    }


                }

            }



            binding.previousDate.setOnClickListener {
                binding.nextDate.visibility = View.VISIBLE
                calendar_2.add(Calendar.MONTH, -1)

                // Check if current month is equal to the month user clicked
                val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
                val clickedMonth = calendar_2.get(Calendar.MONTH)
                if (currentMonth == clickedMonth) {
                    binding.nextDate.visibility = View.GONE

                    Log.i("TAG", "if-pre: ")
                }
                else{
                    Log.i("TAG", "else-pre: ")
                }

                updateUI(binding.txtDate,calendar_2.get(Calendar.MONTH)+1)

            }
            binding.nextDate.setOnClickListener {

                calendar_2.add(Calendar.MONTH, 1)
                // Check if current month is equal to the month user clicked
                val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
                val clickedMonth = calendar_2.get(Calendar.MONTH)
                if (currentMonth == clickedMonth) {
                    binding.nextDate.visibility = View.GONE
                    Log.i("TAG", "if-nex: ")

                } else {
                    binding.nextDate.visibility = View.VISIBLE
                    Log.i("TAG", "else-nex: ")

                }
                updateUI(binding.txtDate,calendar_2.get(Calendar.MONTH)+1)
            }

            return binding.root
        }
    }
    private fun updateUI(textView: TextView,month:Int) {
        // Update your UI based on the current month in the calendar object
        val currentMonth = calendar_2.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
        // For example, set a TextView to display the current month
        textView.text = currentMonth

        binding.apply {
            CoroutineScope(Dispatchers.IO).launch {
                //  val currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1 // Adding 1 because months are zero-based

                com.fitzay.workouttracker.strengthtraining.di.Component.alarmViewModel.alarmRepository.getAlarms(
                    1
                ).collect { result ->

                    val alarmsForCurrentMonth = result.filter { alarm ->
                        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                        val date = dateFormat.parse(alarm.date)
                        val calendar = Calendar.getInstance()
                        calendar.time = date
                        calendar.get(Calendar.MONTH) + 1 == month // Adding 1 because months are zero-based
                    }



                    val calendar = Calendar.getInstance()
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                    Log.i("TAG", "da: " + maxDays)
                    var barEntriesArrayList = ArrayList<BarEntry>()
                    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    val daysOfWeek = arrayOf(
                        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                        "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
                    )
                    var sumOfFinalStrings = 0f


                      // If there are no data for the current month, update the UI accordingly
                    if (alarmsForCurrentMonth.isEmpty()) {

                        barEntriesArrayList.add(BarEntry(0f,0f))

                        for (i in 1..maxDays) {
                            val dayOfMonth = i.toString()
                            if (!barEntriesArrayList.any { it.x == dayOfMonth.toFloat() }) {
                                barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat(), 0f))
                            }

                        }



                        withContext(Dispatchers.Main)
                        {
                            txtMiles.text ="No Data"

                            val dataSet = BarDataSet(barEntriesArrayList, "")
//                            dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                            dataSet.setColors(android.graphics.Color.parseColor("#9CB135"))

                            // setting text color.
                            dataSet.valueTextColor = android.graphics.Color.parseColor("#939292")
                            dataSet.valueTextSize = 14f // Set text size if needed
                            val xAxis = sleepChartMonthly.xAxis
                            xAxis.position = XAxis.XAxisPosition.BOTTOM
                            val formatter = IndexAxisValueFormatter(daysOfWeek)
                            xAxis.valueFormatter = formatter
                            val barData = BarData(dataSet)
                            barData.setBarWidth(0.2f); // Adjust the width as needed
                            xAxis.setDrawGridLines(false);
                            sleepChartMonthly.axisLeft.isEnabled = true
                            sleepChartMonthly.axisRight.isEnabled = false
                            sleepChartMonthly.setScaleEnabled(false)
                            sleepChartMonthly.setPinchZoom(false)
                            dataSet.setDrawValues(false)

                            sleepChartMonthly.setDrawBorders(false)   //All Line Remove
                            sleepChartMonthly.axisLeft.textColor =
                                android.graphics.Color.parseColor("#939292")
                            xAxis.textColor = android.graphics.Color.parseColor("#939292")

                            sleepChartMonthly.getDescription().setEnabled(false);
                            sleepChartMonthly.animateY(1000);

                            sleepChartMonthly.data = barData

                            sleepChartMonthly.notifyDataSetChanged();
                            sleepChartMonthly.invalidate();
                        }
                        Log.i("TAG", "No data available for the current month")
                        return@collect
                    }
                    else {
                        alarmsForCurrentMonth.forEach {

                            val dayOfMonth = SimpleDateFormat("dd", Locale.getDefault()).format(dateFormat.parse(it.date)!!)
                            val regex = Regex("\\d+")
                            val matchResults = regex.findAll(it.totalSleepingHr!!)
                            val numericValues = matchResults.map { it.value }.toList()
                            val finalString = numericValues.joinToString(".").replace(" ", "").toFloat()

                            sumOfFinalStrings += finalString


                            barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat()-1, finalString))

                            for (i in 1..maxDays) {
                                val dayOfMonth = i.toString()
                                if (!barEntriesArrayList.any { it.x == dayOfMonth.toFloat() }) {
                                    barEntriesArrayList.add(BarEntry(dayOfMonth.toFloat(), 0f))
                                }

                            }

                            var aver=sumOfFinalStrings/30
                            Log.i("TAG", "updateUI: "+sumOfFinalStrings)
                            withContext(Dispatchers.Main)
                            {
                                val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(aver)

                                txtMiles.text ="$hours hr $minutes min"

                                val dataSet = BarDataSet(barEntriesArrayList, "")
//                                dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
                                dataSet.setColors(android.graphics.Color.parseColor("#9CB135"))

                                // setting text color.
                                dataSet.valueTextColor = android.graphics.Color.parseColor("#939292")
                                dataSet.valueTextSize = 14f // Set text size if needed
                                val xAxis = sleepChartMonthly.xAxis
                                xAxis.position = XAxis.XAxisPosition.BOTTOM
                                val formatter = IndexAxisValueFormatter(daysOfWeek)
                                xAxis.valueFormatter = formatter
                                val barData = BarData(dataSet)
                                barData.setBarWidth(0.2f); // Adjust the width as needed
                                xAxis.setDrawGridLines(false);
                                dataSet.setDrawValues(false)
                                sleepChartMonthly.axisLeft.isEnabled = true
                                sleepChartMonthly.axisRight.isEnabled = false


                                sleepChartMonthly.setScaleEnabled(false)
                                sleepChartMonthly.setPinchZoom(false)
                                sleepChartMonthly.setDrawBorders(false)   //All Line Remove
                                sleepChartMonthly.axisLeft.textColor = android.graphics.Color.parseColor("#939292")
                                xAxis.textColor = android.graphics.Color.parseColor("#939292")

                                sleepChartMonthly.getDescription().setEnabled(false);
                                sleepChartMonthly.animateY(1000);

                                sleepChartMonthly.data = barData

                                sleepChartMonthly.notifyDataSetChanged();
                                sleepChartMonthly.invalidate();
                            }




                        }
                    }



                }

            }
        }

    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {


        if (e != null) {

            val value = e.y
            val xAxisLabel = binding.sleepChartMonthly.xAxis.valueFormatter.getFormattedValue(
                e.x,
                binding.sleepChartMonthly.xAxis
            )

            val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(value)

            tvValue.text = "$hours hr $minutes min\nDay: $xAxisLabel"


            val transformer = binding.sleepChartMonthly.getTransformer(binding.sleepChartMonthly.data.getDataSetByIndex(0).axisDependency)
            val xPos = transformer.getPixelForValues(e.x, e.y).x - tooltipView.width / 2


            val yOffset = 80 // Adjust as needed
            val yPos = binding.sleepChartMonthly.viewPortHandler.contentHeight() - yOffset

            popupWindow.showAtLocation(
                binding.root, // Use the root layout as the anchor view
                Gravity.START or Gravity.CENTER or Gravity.TOP,
                xPos.toInt(),
                yPos.toInt()
            )

            Log.i("KKKKK", "onValueSelected: "+h)
            Log.i("KKKKK", "onValueSelected: "+value)
            binding.dateLayout.visibility = View.INVISIBLE

        }

    }

    override fun onNothingSelected() {
        // This method is called when nothing is selected in the chart
        popupWindow.dismiss()
        binding.dateLayout.visibility = View.VISIBLE

    }

}