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
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeek
import com.fitzay.workouttracker.strengthtraining.core.utils.getDayOfWeekName
import com.fitzay.workouttracker.strengthtraining.core.utils.getShortDayName
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
//            txtDate.text = calendar.time.toString() + " " + weekEnd.time
            val currentDate = Date()
            txtDate.text = this@StepWeeklyFragment.dateFormat.format(currentDate).toString()+" "+this@StepWeeklyFragment.dateFormat.format(weekEnd).toString()



            when (StepDailyFragment.btnCheck)
            {
                "Step" -> {
                    i=1
                    unSelectSub()
                    imgStep.setBackgroundResource(R.drawable.bg_selected)
                    previousWeek(txtDate)
                    check="Step"
                    StepDailyFragment.btnCheck="Step"

                }
                "Location" -> {
                    i=2
                    unSelectSub()
                    imgLocation.setBackgroundResource(R.drawable.bg_selected)
                    check="Distance"
                    previousWeek(txtDate)
                    StepDailyFragment.btnCheck="Location"

                }
                "Calories" -> {
                    i=3
                    unSelectSub()
                    imgCalories.setBackgroundResource(R.drawable.bg_selected)
                    check="Calories"
                    previousWeek(txtDate)
                    StepDailyFragment.btnCheck="Calories"
                }
                "Time" -> {
                    i=4
                    check="Time"
                    unSelectSub()
                    imgTime.setBackgroundResource(R.drawable.bg_selected)
                    previousWeek(txtDate)
                    StepDailyFragment.btnCheck="Time"
                }

            }



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
                check="Step"
                if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
                    setBarData(i,SimpleDateFormat("EE", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                else
                {
                    setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }

                StepDailyFragment.btnCheck="Step"


            }
            binding.imgLocation.setOnClickListener {
                unSelectSub()
                imgLocation.setBackgroundResource(R.drawable.bg_selected)
                i=2
                check="Distance"
                if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
                    setBarData(i,SimpleDateFormat("EE", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                else
                {
                    setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                StepDailyFragment.btnCheck="Location"
            }
            binding.imgCalories.setOnClickListener {
                unSelectSub()
                imgCalories.setBackgroundResource(R.drawable.bg_selected)
                i=3
                check="Calories"
                if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
                    setBarData(i,SimpleDateFormat("EE", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                else
                {
                    setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }

                StepDailyFragment.btnCheck="Calories"


            }

            binding.imgTime.setOnClickListener {
                unSelectSub()
                imgTime.setBackgroundResource(R.drawable.bg_selected)
                i=4
                check="Time"
                if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
                    setBarData(i,SimpleDateFormat("EE", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                else
                {
                    setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

                }
                StepDailyFragment.btnCheck="Time"





            }
        }

        return binding.root
    }

    private fun previousWeek(textView: TextView) {
        binding.apply {
            var pattern:SimpleDateFormat?=null
            if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
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




            setBarData(i,pattern, textView,isCurrentWeek(this@StepWeeklyFragment.calendar))


        }


    }

    private fun nextWeek(textView: TextView) {
        var pattern:SimpleDateFormat?=null
        if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
            pattern = SimpleDateFormat("EE", Locale.getDefault())
        }
        else
        {
            pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())

        }

//        val pattern = SimpleDateFormat("dd-MMM", Locale.getDefault())
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

        //textView.text = weekForwardFormatStart + "," + weekForwardFormatEnd
        if (calendarCopy.time <= currentDate.time) {
            calendarCopy.add(Calendar.DAY_OF_YEAR, 7)
            Log.i("TAG", "nextWeek--if: ")

            if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
                binding.nextDate.visibility = View.GONE
                setBarData(i,pattern, textView,isCurrentWeek(this@StepWeeklyFragment.calendar))
            }
            else
            {
                binding.nextDate.visibility = View.VISIBLE
                setBarData(i,pattern, textView,isCurrentWeek(this@StepWeeklyFragment.calendar))
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
            setBarData(i,pattern, textView,isCurrentWeek(this@StepWeeklyFragment.calendar))
        }


    }

    private fun unSelectSub() {
        binding.imgStep.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgLocation.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgCalories.setBackgroundResource(R.drawable.bg_unselected_options)
        binding.imgTime.setBackgroundResource(R.drawable.bg_unselected_options)
    }

    private fun setBarData(i:Int,pattern: SimpleDateFormat, txt: TextView,displayAsWeekdays:Boolean) {
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

                            // Add the last date to the list
                            allDatesOfWeek.add(calendar.time)

                    // Remove the first date from the list
                    allDatesOfWeek.removeAt(0)

                    val weekdays = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

                    // Sort the dates based on weekdays
                    val sortedDates = allDatesOfWeek.sortedBy {
                        if (displayAsWeekdays) {
                            // pattern.format(it)
                            weekdays.indexOf(SimpleDateFormat("EEE", Locale.getDefault()).format(it))
                        }  else {
                            weekdays.indexOf(SimpleDateFormat("dd-MMM", Locale.getDefault()).format(it))
                        }


                    }

                            var barEntriesArrayList = ArrayList<BarEntry>()
                            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())


                    val formattedDates = sortedDates.map {
                        if (displayAsWeekdays) {
                            // pattern.format(it)
                            SimpleDateFormat("EEE", Locale.getDefault()).format(it)
                        }  else {
                            SimpleDateFormat("dd-MMM", Locale.getDefault()).format(it)
                        }
                    }.toTypedArray()

                            var avg = 0
                            var sumOfFinalStrings = 0
                              sortedDates.forEachIndexed { index, date ->
                                val dateFormatted = dateFormat.format(date)
                                val dataForDate = result.find { it.date == dateFormatted }
                                var name=requireActivity().getDayOfWeekName(date)
                                Log.i("8976--", "setBarData999: "+index+"-"+name)

                                if (dataForDate != null) {

                                    when(i)
                                    {
                                        1->
                                        {

                                            barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.steps.toFloat()))
                                            sumOfFinalStrings += dataForDate.steps
                                            avg = sumOfFinalStrings / 7
                                        }
                                        2->{
                                            barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.distance.toFloat()))
                                            sumOfFinalStrings += dataForDate.distance.toInt()
                                            avg = sumOfFinalStrings / 7
                                        }
                                        3->
                                            {
                                            barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.calories.toFloat()))
                                                sumOfFinalStrings += dataForDate.calories.toInt()
                                                avg = sumOfFinalStrings / 7
                                            }
                                        4->
                                            {
                                            barEntriesArrayList.add(BarEntry(index.toFloat(), dataForDate.time.convertTimeToSeconds().toFloat()))
                                                sumOfFinalStrings += dataForDate.time.convertTimeToSeconds()
                                                avg = sumOfFinalStrings / 7
                                            }
                                    }


                                }
                                else {

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

                                txt.text = startWeek + "," + endWeek
                                when(i)
                                {
                                    1->
                                    {

                                        txtMiles.text=avg.toString()+" "+ getString(R.string.steps)
                                    }
                                    2->{

                                        txtMiles.text=avg.toString()+" "+ getString(R.string.distance)
                                    }
                                    3->
                                    {

                                        txtMiles.text=avg.toString()+" "+ getString(R.string.calories)
                                    }
                                    4->
                                    {

                                        txtMiles.text=avg.toString()+" "+ getString(R.string.time)
                                    }
                                }
                                val dataSet = BarDataSet(barEntriesArrayList, "")
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


    @SuppressLint("SetTextI18n")
    override fun onValueSelected(e: Entry?, h: Highlight?) {
        if (e != null) {
            binding.dateLayout.visibility = View.INVISIBLE

            val value = e.y
            val xAxisLabel = binding.sleepChartWeekly.xAxis.valueFormatter.getFormattedValue(
                e.x,
                binding.sleepChartWeekly.xAxis
            )


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

            val yOffset = 270 // Adjust as needed
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


    private fun common(i:Int,txtDate: TextView){

        if (isCurrentMonth(this@StepWeeklyFragment.calendar)) {
            setBarData(i,SimpleDateFormat("EE", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

        }
        else
        {
            setBarData(i,SimpleDateFormat("dd-MMM", Locale.getDefault()), txtDate,isCurrentWeek(this@StepWeeklyFragment.calendar))

        }
    }
}