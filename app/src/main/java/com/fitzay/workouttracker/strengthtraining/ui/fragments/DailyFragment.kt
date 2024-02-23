package com.fitzay.workouttracker.strengthtraining.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
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
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
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


class DailyFragment : Fragment(), OnChartValueSelectedListener {

    private lateinit var binding: FragmentDailyBinding

    //variable for our bar data.
    var barData: BarData? = null

    // variable for our bar data set.
    var barDataSet: BarDataSet? = null

    // array list for storing entries.
    var barEntriesArrayList: ArrayList<BarEntry>? = null

    //lateinit var dayList: ArrayList<String>
    var typeClicked = "Daily"

    private lateinit var tooltipView: View
    private lateinit var tvValue: TextView
    private lateinit var popupWindow: PopupWindow

    lateinit var calendar: Calendar
    lateinit var dateFormat: SimpleDateFormat

    var date: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailyBinding.inflate(inflater, container, false)

        calendar = Calendar.getInstance()


        binding.apply {
            tooltipView = layoutInflater.inflate(R.layout.custom_tooltip, null)
            tvValue = tooltipView.findViewById(R.id.tvValue)

            val calendar = Calendar.getInstance().time
            val dateFormat = SimpleDateFormat("dd-MMM", Locale.getDefault())
            date = dateFormat.format(calendar)

            txtDate.text = date

            // Initialize the PopupWindow
            popupWindow = PopupWindow(
                tooltipView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            popupWindow.isOutsideTouchable = true

            sleepChart.setOnChartValueSelectedListener(this@DailyFragment)

            CoroutineScope(Dispatchers.IO).launch {

                com.fitzay.workouttracker.strengthtraining.di.Component.alarmViewModel.alarmRepository.getAlarms(
                    1
                ).collect { result ->

                    if (result.isNotEmpty()) {
                        val totalSleepHours = mutableMapOf<String, Float>()
                        var sumOfFinalStrings = 0f
                        var currentDateDataAvailable = false

                        for (i in result.listIterator().iterator()) {

                            withContext(Dispatchers.Main) {
                                if (i.date!!.equals(requireActivity().getSimpleDate())) {
                                    currentDateDataAvailable =
                                        true // Set flag to true if current date data is found

                                    val regex = Regex("\\d+")
                                    val matchResults = regex.findAll(i.totalSleepingHr!!)
                                    val numericValues = matchResults.map { it.value }.toList()
                                    val finalString =
                                        numericValues.joinToString(".").replace(" ", "").toFloat()

                                    sumOfFinalStrings += finalString

                                    var day = requireActivity().getDayOfWeek(i.date!!)

                                    //getBarEntries(sumOfFinalStrings, day)
                                    getBarEntriesForDaily(sumOfFinalStrings.toFloat(), day)

                                    barDataSet = BarDataSet(barEntriesArrayList, "")

                                    // passing our bar data set.
                                    barData = BarData(barDataSet)

                                    sleepChart.setData(barData)
                                    sleepChart.barData!!.barWidth =
                                        0.1f // Adjust the value as needed
                                    sleepChart.animateY(1000) // You can adjust the duration as needed

                                    // adding color to our bar data set.
//                                barDataSet!!.setColors(*ColorTemplate.MATERIAL_COLORS)
                                    barDataSet!!.setColors(android.graphics.Color.parseColor("#9CB135"))

                                    // setting text color.
                                    barDataSet!!.valueTextColor =
                                        android.graphics.Color.parseColor("#939292")

                                    // setting text size
                                    barDataSet!!.valueTextSize = 16f
                                    sleepChart.getDescription().setEnabled(false)


                                    // set custom X-axis labels
                                    val xAxis = sleepChart.xAxis
                                    var dayList = arrayListOf<String>(
                                        "Mon",
                                        "Tue",
                                        "Wed",
                                        "Thur",
                                        "Fri",
                                        "Sat",
                                        "Sun"
                                    )
                                    xAxis.valueFormatter = IndexAxisValueFormatter(dayList)
                                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                                    xAxis.granularity = 1f
                                    xAxis.isGranularityEnabled = true
                                    //x Axix Line Remove
                                    xAxis.setDrawGridLines(false)
                                    sleepChart.axisLeft.isEnabled = true
                                    barDataSet!!.setDrawValues(false)
                                    sleepChart.setScaleEnabled(false)
                                    sleepChart.setPinchZoom(false)
                                    sleepChart.axisRight.isEnabled = false
                                    sleepChart.axisLeft.textColor = android.graphics.Color.parseColor("#939292")
                                    xAxis.textColor = android.graphics.Color.parseColor("#939292")


                                    txtMiles.text = i.totalSleepingHr!!

                                } else {
                                    Log.i("TAG", "Else: ")
                                }
                            }

                        }
                        // Check if no data was found for the current date
                        if (!currentDateDataAvailable) {
                            withContext(Dispatchers.Main)
                            {
                                noData()
                            }


                        }
                        Log.i("TAG", "Sum of finalString values: $sumOfFinalStrings")
                    } else {
                        withContext(Dispatchers.Main)
                        {
                            noData()
                        }

                    }
                }


            }
        }
        return binding.root
    }


    private fun noData() {
        binding.apply {


            var list = ArrayList<BarEntry>()
            list!!.add(BarEntry(0f, 0f))
            list!!.add(BarEntry(1f, 0f))
            list!!.add(BarEntry(2f, 0f))
            list!!.add(BarEntry(3f, 0f))
            list!!.add(BarEntry(4f, 0f))
            list!!.add(BarEntry(5f, 0f))
            list!!.add(BarEntry(6f, 0f))
            barDataSet = BarDataSet(list, "")

            // passing our bar data set.
            barData = BarData(barDataSet)

            sleepChart.setData(barData)
            sleepChart.barData!!.barWidth =
                0.1f // Adjust the value as needed
            sleepChart.animateY(1000) // You can adjust the duration as needed

            // adding color to our bar data set.
//                                barDataSet!!.setColors(*ColorTemplate.MATERIAL_COLORS)
            barDataSet!!.setColors(android.graphics.Color.parseColor("#9CB135"))

            // setting text color.
            barDataSet!!.valueTextColor = android.graphics.Color.parseColor("#939292")

            // setting text size
            barDataSet!!.valueTextSize = 16f
            sleepChart.getDescription().setEnabled(false)


            // set custom X-axis labels
            val xAxis = sleepChart.xAxis
            var dayList = arrayListOf<String>(
                "Mon",
                "Tue",
                "Wed",
                "Thur",
                "Fri",
                "Sat",
                "Sun"
            )
            xAxis.valueFormatter = IndexAxisValueFormatter(dayList)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.granularity = 1f
            xAxis.isGranularityEnabled = true
            //x Axix Line Remove
            xAxis.setDrawGridLines(false)
            sleepChart.axisLeft.isEnabled = true
            sleepChart.axisRight.isEnabled = false
            barDataSet!!.setDrawValues(false)
            sleepChart.axisLeft.axisMinimum = 0f
            sleepChart.axisLeft.textColor = android.graphics.Color.parseColor("#939292")
            xAxis.textColor = android.graphics.Color.parseColor("#939292")


            txtMiles.text = "No Data"


        }
    }

    private fun getBarEntriesForDaily(sleepHr: Float, day: String) {
        // creating a new array list
        barEntriesArrayList = ArrayList<BarEntry>()

        var pos = getDayPosition(day)

        barEntriesArrayList!!.add(BarEntry(pos.toFloat(), sleepHr))
    }

    private fun getDayPosition(day: String): Int {
        // You can implement your logic here to map days to positions.
        // For example, if your days are represented as strings like "Monday", "Tuesday", etc.,
        // you can use a map or a when statement to determine the position.
        return when (day.toLowerCase()) {
            "mon" -> 0
            "tue" -> 1
            "wed" -> 2
            "thu" -> 3
            "fri" -> 4
            "sat" -> 5
            "sun" -> 6
            else -> 9 // Handle unknown days
        }
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e != null) {
            val value = e.y
            val xAxisLabel = binding.sleepChart.xAxis.valueFormatter.getFormattedValue(
                e.x,
                binding.sleepChart.xAxis
            )

            val (hours, minutes) = requireActivity().convertDecimalToHoursMinutes(value)

            tvValue.text = "$hours hr $minutes min\nDay: $xAxisLabel"


            val transformer = binding.sleepChart.getTransformer(binding.sleepChart.data.getDataSetByIndex(0).axisDependency)
            val xPos = transformer.getPixelForValues(e.x, e.y).x - tooltipView.width / 2

            // Calculate the Y position for the top center of the graph
//            val yPos = binding.sleepChart.viewPortHandler.contentHeight()

            val yOffset = 80 // Adjust as needed
            val yPos = binding.sleepChart.viewPortHandler.contentHeight() - yOffset

            popupWindow.showAtLocation(
                binding.root, // Use the root layout as the anchor view
                Gravity.START or Gravity.CENTER or Gravity.TOP,
                xPos.toInt(),
                yPos.toInt()
            )

//            barDataSet!!.color = android.graphics.Color.parseColor("#0080FF") // Assuming barDataSet is your BarDataSet variable
            binding.dateLayout.visibility = View.INVISIBLE

        }
    }


    override fun onNothingSelected() {
        // This method is called when nothing is selected in the chart
        popupWindow.dismiss()
        binding.dateLayout.visibility = View.VISIBLE

//        barDataSet!!.color = android.graphics.Color.parseColor("#9CB135") // Assuming barDataSet is your BarDataSet variable

    }
}