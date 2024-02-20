package com.fitzay.workouttracker.strengthtraining.core.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.fitzay.workouttracker.strengthtraining.core.AppController
import com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.Decompress
import com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.DownloadManager
import com.fitzay.workouttracker.strengthtraining.core.utils.downloadmanager.OnDownloadProgressListener
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.CategoriesModel
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel
import com.fitzay.workouttracker.strengthtraining.domain.models.RingTone
import com.fitzay.workouttracker.strengthtraining.domain.models.WorkOutModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.*
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipFile
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.SecretKeySpec
import kotlin.math.roundToInt


const val STEP_COUNTER_NOTIFICATION_ID = 1001
const val NOTIFICATION_CHANNEL_ID = "step_counter_channel"

const val KEY_ALARM = "alarm"
const val KEY_BUNDLE_ALARM = "bundle_alarm"
const val LOG_TAG = "Alarm"


const val FITNESS_ACTION_STEP_COUNT = "ACTION_STEP_COUNT"
const val FITNESS_EXTRA_STEP_COUNT = "extra_step_count"
const val FITNESS_EXTRA_DISTANCE = "extra_distance"
const val FITNESS_EXTRA_DISTANCE_GOAL = "extra_distance_goal"
const val FITNESS_EXTRA_TIME = "extra_time"
const val FITNESS_EXTRA_TIME_GOAL = "extra_time_goal"
const val FITNESS_EXTRA_BURNED_CALORIES = "extra_burned_calories"
const val FITNESS_EXTRA_BURNED_CALORIES_GOAL = "extra_burned_calories_goal"
const val FITNESS_ACTION_PAUSE_STEP_COUNTING = "ACTION_PAUSE_STEP_COUNTING"
const val FITNESS_ACTION_RESUME_STEP_COUNTING = "ACTION_RESUME_STEP_COUNTING"

const val BUFFER_SIZE = 4096

const val CAMERA_PERMISSION_REQUEST_CODE = 1001
const val GALLERY_PERMISSION_REQUEST_CODE = 1002
const val CAMERA_REQUEST_CODE = 1003
const val GALLERY_REQUEST_CODE = 1004


const val ALL_PERMISSIONS_CAMERA = 111
const val ALL_PERMISSIONS_GALLERY = 222

const val METERS_IN_MILE = 1609.344

fun metersToMiles(meters: Double): Double {
    return meters / METERS_IN_MILE
}

fun milesToMeters(miles: Double): Double {
    return miles * METERS_IN_MILE
}

fun Double.toKilograms(): Double {
    return this * 0.453592
}

fun Double.toPounds(): Double {
    return this * 2.20462
}

fun Double.roundToNearestWhole(): Int {
    return this.roundToInt()
}

fun String.convertStringToDouble(): Double? {
    return try {
        // Replace any commas with periods to ensure proper conversion
        val sanitizedValue = this.replace(',', '.')
        sanitizedValue.toDouble()
    } catch (e: NumberFormatException) {
        // Handle invalid input
        null
    }
}

var lastClickTime: Long = 0

fun View.clickWithThrottle(throttleTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener {
        val currentTime = SystemClock.elapsedRealtime()
        if (currentTime - lastClickTime >= throttleTime) {
            lastClickTime = currentTime
            action()
        }
    }
}

fun Double.toFeetAndInches(): Pair<Int, Double> {

    val dCentimeter = java.lang.Double.valueOf(this)
    val feetPart = (dCentimeter / 2.54 / 12).toInt()
    val inchesPart = dCentimeter / 2.54 - feetPart * 12

    return Pair(feetPart, inchesPart)
}

fun Pair<Int, Double>.toCentimeters(): Double {
    val totalInches = (first * 12) + second
    return totalInches * 2.54
}


fun getFitzayRemoteBoolean(remoteKey: String): Boolean {
    val returnValue = try {
        AppController.remoteFitzayConfig!!.getBoolean(remoteKey)
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
    return returnValue
}

fun getFitzayRemoteString(remoteKey: String): String {
    val returnValue = try {
        AppController.remoteFitzayConfig!!.getString(remoteKey)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
    return returnValue
}

fun getFitzayRemoteLong(remoteKey: String): Long {
    val returnValue = try {
        AppController.remoteFitzayConfig!!.getLong(remoteKey)
    } catch (e: Exception) {
        e.printStackTrace()
        2
    }
    return returnValue
}


fun checkForInternet(): Boolean {
    val connectivityManager =
        Component.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        // if the android version is below M
        @Suppress("DEPRECATION") val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}

@SuppressLint("SimpleDateFormat")
var lineChartToolTipFormat = SimpleDateFormat("MMM dd, yyyy")

fun getWeekDayWithDateA(position: Int): String? {
    val c = Calendar.getInstance()
    c.firstDayOfWeek = Calendar.MONDAY
    when (position) {
        0 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.MONDAY
        }
        1 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.TUESDAY
        }
        2 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.WEDNESDAY
        }
        3 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.THURSDAY
        }
        4 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.FRIDAY
        }
        5 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.SATURDAY
        }
        6 -> {
            c[Calendar.DAY_OF_WEEK] = Calendar.SUNDAY
        }
    }
    val df: DateFormat = lineChartToolTipFormat
    return df.format(c.time)
}


fun poundsToKilograms(pounds: Double): Double {
    // 1 pound is approximately equal to 0.45359237 kilograms
    val kilograms = pounds * 0.45359237
    return kilograms
}

fun String?.convertTimeToSeconds(): Int {
    if (this.isNullOrEmpty().not()) {
        val units = this?.split(":")?.toTypedArray()
        if (units?.isNotEmpty() == true && units.size >= 3) {
            val hours = units[0].toInt()
            val minutes = units[1].toInt()
            val seconds = units[2].toInt()
            return (3660 * hours) + (60 * minutes) + seconds
        }
    }
    return 0
}

val MAKE_PERMISSIONS =
    mutableListOf(Manifest.permission.CAMERA).apply {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            add(Manifest.permission.READ_MEDIA_IMAGES)
        } else {
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }.toTypedArray()


fun isLocationPermissionAllowed(): Boolean {
    if (ActivityCompat.checkSelfPermission(
            Component.context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return false
    }
    return true
}

fun formatTime(seconds: Int): String {
    val hours = seconds / 3600
    val minutes = (seconds % 3600) / 60
    val sec = seconds % 60
    return String.format("%02d:%02d:%02d", hours, minutes, sec)
}

fun exercisePath(): File {
    val path = File(pathExerciseMen(), "men")
    if (!path.exists()) {
        path.mkdirs()
        Decompress.unzipFromAssets(Component.context, "men.zip", pathExerciseMen())
    }
    return path
}

fun pathExerciseMen(): String {
    val pathMen = File(Component.context.getExternalFilesDir("/" + "ExercisesMen")!!.absolutePath)
    val path = if (!pathMen.exists()) {
        pathMen.mkdirs()
        pathMen
    } else {
        pathMen
    }
    return path.toString()
}

fun Context.pathExerciseWomen(): String {

    val pathMen = File(getExternalFilesDir("/" + "ExercisesWomen")!!.absolutePath)
    val path = if (!pathMen.exists()) {
        pathMen.mkdirs()
        pathMen
    } else {
        pathMen
    }
    return path.toString()
}
fun Context.convertTimeToMilliseconds(timeString: String): Long {
    val inputFormat = SimpleDateFormat("hh:mm a")
    val date: Date = inputFormat.parse(timeString)
    return date.time
}
fun Context.convertTimeToMillisecondsHrAndMin(timeString: String): Pair<Int, Int> {
    val inputFormat = SimpleDateFormat("hh:mm a")
    val date: Date = inputFormat.parse(timeString)
    val calendar = Calendar.getInstance()
    calendar.time = date
    val hr = calendar.get(Calendar.HOUR_OF_DAY)
    val min = calendar.get(Calendar.MINUTE)
    return Pair(hr, min)
}



@Throws(
    IOException::class,
    NoSuchAlgorithmException::class,
    NoSuchPaddingException::class,
    InvalidKeyException::class
)
fun encrypt() {
    // Here you read the cleartext.
    val extStore: File = Environment.getExternalStorageDirectory()
    val fis = FileInputStream("$extStore/sampleFile")
    // This stream write the encrypted text. This stream will be wrapped by
    // another stream.
    val fos = FileOutputStream("$extStore/encrypted")

    // Length is 16 byte
    val sks = SecretKeySpec(
        "MyDifficultPassw".toByteArray(),
        "AES"
    )
    // Create cipher
    val cipher: Cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, sks)
    // Wrap the output stream
    val cos = CipherOutputStream(fos, cipher)
    // Write bytes
    var b: Int
    val d = ByteArray(8)
    while (fis.read(d).also { b = it } != -1) {
        cos.write(d, 0, b)
    }
    // Flush and close streams.
    cos.flush()
    cos.close()
    fis.close()
}

@Throws(
    IOException::class,
    NoSuchAlgorithmException::class,
    NoSuchPaddingException::class,
    InvalidKeyException::class
)
fun decrypt() {
    val extStore: File = Environment.getExternalStorageDirectory()
    val fis = FileInputStream("$extStore/encrypted")
    val fos = FileOutputStream("$extStore/decrypted")
    val sks = SecretKeySpec(
        "MyDifficultPassw".toByteArray(),
        "AES"
    )
    val cipher: Cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.DECRYPT_MODE, sks)
    val cis = CipherInputStream(fis, cipher)
    var b: Int
    val d = ByteArray(8)
    while (cis.read(d).also { b = it } != -1) {
        fos.write(d, 0, b)
    }
    fos.flush()
    fos.close()
    cis.close()
}

fun unzip(zipFilePath: File, destDirectory: String) {
    File(destDirectory).run {
        if (!exists()) {
            mkdirs()
        }
    }
    ZipFile(zipFilePath).use { zip ->
        zip.entries().asSequence().forEach { entry ->
            zip.getInputStream(entry).use { input ->
                val filePath = destDirectory + File.separator + entry.name
                if (!entry.isDirectory) {
                    // if the entry is a file, extracts it
                    extractFile(
                        input,
                        filePath
                    )
                } else {
                    // if the entry is a directory, make the directory
                    val dir = File(filePath)
                    dir.mkdir()
                }

            }

        }
    }
}

private fun extractFile(inputStream: InputStream, destFilePath: String) {
    val bos = BufferedOutputStream(FileOutputStream(destFilePath))
    val bytesIn = ByteArray(BUFFER_SIZE)
    var read: Int
    while (inputStream.read(bytesIn).also { read = it } != -1) {
        bos.write(bytesIn, 0, read)
    }
    bos.close()
}

fun hasPermissions(context: Context, vararg permissions: String): Boolean =
    permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }


fun Context.showToast(message: String) {
    val appLocale = Locale.getDefault()
    val configuration = this.resources.configuration
    val originalLocale = configuration.locale

    configuration.setLocale(appLocale)
    this.resources.updateConfiguration(configuration, this.resources.displayMetrics)

    val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)

    toast.show()

    configuration.setLocale(originalLocale)
    this.resources.updateConfiguration(configuration, this.resources.displayMetrics)
}


fun Context.getJsonDataFromAsset(fileName: String): String? {

    val jsonString: String
    try {
        jsonString = this.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun Context.workOuts(): ArrayList<WorkOutModel> {
    val gson = Gson()
    val listPersonType = object : TypeToken<List<WorkOutModel>>() {}.type
    val jsonFileString = this.getJsonDataFromAsset("workout_men.json")
    return gson.fromJson(jsonFileString, listPersonType)
}

fun Context.categories(): ArrayList<CategoriesModel> {
    val gson = Gson()
    val listPersonType = object : TypeToken<List<CategoriesModel>>() {}.type
    val jsonFileString = this.getJsonDataFromAsset("categories.json")
    return gson.fromJson(jsonFileString, listPersonType)
}

fun Context.motivationQuotes(): ArrayList<QuotesModel> {
    val gson = Gson()
    val listPersonType = object : TypeToken<List<QuotesModel>>() {}.type
    val jsonFileString = this.getJsonDataFromAsset("motivational_quotes.json")
    return gson.fromJson(jsonFileString, listPersonType)
}


fun getFormattedDistance(distance: Double): String {
    return String.format("%.2f", distance)
}

fun getFormattedCalories(calories: Double): String {
    return String.format("%.1f", calories)
}

fun <R> CoroutineScope.executeAsyncTask(
    onPreExecute: () -> Unit,
    doInBackground: () -> R,
    onPostExecute: (R) -> Unit,
) = launch {
    onPreExecute() // runs in Main Thread
    val result = withContext(Dispatchers.IO) {
        doInBackground() // runs in background thread without blocking the Main Thread
    }
    onPostExecute(result) // runs in Main Thread

}

private fun Context.downloadStart() {
//    val downloadLink = resources.getString(R.string.firebase_storage_path)
    val downloadPath = pathExerciseMen()
    val dlManager =
        DownloadManager("", downloadPath, object : OnDownloadProgressListener {
            override fun downloadStart() {

            }

            override fun downloadedSuccess() {

            }

            override fun downloadCancel() {

            }

            override fun downloadFail(error: String?) {

            }

            override fun percent(percent: Int) {

            }
        })

    dlManager.execute()



}

fun Context.convertDateTime(dateInMilliseconds: String, dateFormat: String?): String {
    var formatter = android.icu.text.SimpleDateFormat(dateFormat);
    return  formatter.format(Date(dateInMilliseconds.toLong()))
}

fun Context.listRingtones():ArrayList<RingTone>{
    var list=ArrayList<RingTone>()
    val manager = RingtoneManager(this)
    manager.setType(RingtoneManager.TYPE_RINGTONE)
    // manager.setType(RingtoneManager.TYPE_RINGTONE);//For Get System Ringtone
    val cursor = manager.cursor
    while (cursor.moveToNext()) {
        val title = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
        val uri= manager.getRingtoneUri(cursor.position)
        val ringtoneName = cursor.getString(cursor.getColumnIndex("title"))
        val mediaPlayer = MediaPlayer.create(this, uri)

        // Check if mediaPlayer is not null
        mediaPlayer?.let {
            val duration = it.duration
            val formattedDuration = formatDuration(duration)
            list.add(RingTone(0,ringtoneName, uri, formattedDuration))
            it.release()
        }
       // list.add(RingTone(ringtoneName,uri))
        Log.e("All Data", "getNotifications: $title-=---$uri------$ringtoneName")
        // Do something with the title and the URI of ringtone
    }
    return list

}

private fun formatDuration(duration: Int): String {
    val minutes = duration / 60000
    val seconds = (duration % 60000) / 1000
    return String.format("%02d:%02d", minutes, seconds)
}

fun Context.systemDefaultAlarmTone():Uri{

    return RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
}

fun Context.getShortDayName(dayNumber: Int): String {
    return when (dayNumber) {
        1 -> "Sun"
        2 -> "Mon"
        3 -> "Tue"
        4 -> "Wed"
        5 -> "Thu"
        6 -> "Fri"
        7 -> "Sat"
        else -> throw IllegalArgumentException("Invalid day number: $dayNumber")
    }
}
fun Context.getLongDayName(dayNumber: Int): String {
    return when (dayNumber) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thusday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> throw IllegalArgumentException("Invalid day number: $dayNumber")
    }



}
fun Context.getDateInMillis(): Long {
    val currentDate = Date()
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    val formattedDate = dateFormat.format(currentDate)
    val parsedDate = dateFormat.parse(formattedDate)
    return parsedDate?.time ?: 0L

}

fun Context.getSimpleDate(): String {
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    return dateFormat.format(Date())

}

fun Context.getDayOfWeek(dateString: String): String {
    val sdf = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val date: Date = sdf.parse(dateString) ?: return "Invalid Date"

    val calendar = Calendar.getInstance()
    calendar.time = date

    val dayOfWeek = when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> "Sun"
        Calendar.MONDAY -> "Mon"
        Calendar.TUESDAY -> "Tue"
        Calendar.WEDNESDAY -> "Wed"
        Calendar.THURSDAY -> "Thu"
        Calendar.FRIDAY -> "Fri"
        Calendar.SATURDAY -> "Sat"
        else -> "Invalid Day"
    }

    return dayOfWeek
}

fun Context.convertDecimalToHoursMinutes(decimalHours: Float): Pair<Int, Int> {
    val hours = decimalHours.toInt() // Extract integer part as hours
    val minutesDecimal = decimalHours - hours // Extract fractional part as minutes

    // Convert fractional part to minutes (60 minutes in an hour)
    val minutes = (minutesDecimal * 60).toInt()

    return Pair(hours, minutes)
}

fun Context.getDayNameAndValue(dateString: String): Pair<String, Int>? {
    try {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)
        val calendar = Calendar.getInstance()
        date?.let { calendar.time = it }

        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val dayName = when (dayOfWeek) {
            Calendar.SUNDAY -> "Sunday"
            Calendar.MONDAY -> "Monday"
            Calendar.TUESDAY -> "Tuesday"
            Calendar.WEDNESDAY -> "Wednesday"
            Calendar.THURSDAY -> "Thursday"
            Calendar.FRIDAY -> "Friday"
            Calendar.SATURDAY -> "Saturday"
            else -> ""
        }

        val dayValue = calendar.get(Calendar.DAY_OF_MONTH)

        return Pair(dayName, dayValue)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun getDayIndex(dateString: String): Int? {
    try {
        val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)
        val calendar = Calendar.getInstance()
        date?.let { calendar.time = it }
        Log.i("MY_TAG", "itemClick123: " + calendar.get(Calendar.DAY_OF_WEEK)+"====${Calendar.SUNDAY} ===== ${((calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY) % 7)+1}")

        return ((calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY) % 7)+1
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

private fun getDayName(dayOfWeek: Int): String {
    return when (dayOfWeek) {
        Calendar.MONDAY -> "Mon"
        Calendar.TUESDAY -> "Tue"
        Calendar.WEDNESDAY -> "Wed"
        Calendar.THURSDAY -> "Thu"
        Calendar.FRIDAY -> "Fri"
        Calendar.SATURDAY -> "Sat"
        Calendar.SUNDAY -> "Sun"
        else -> ""
    }
}

private fun formatSelectedDays(days: Set<Int>): String {
    val dayNames = days.map { getDayName(it) }
    return dayNames.joinToString(", ")
}

fun Context.getDate(milliSeconds: Long, dateFormat: String?): String {
    // Create a DateFormatter object for displaying date in specified format.
    val formatter = SimpleDateFormat(dateFormat)

    // Create a calendar object that will convert the date and time value in milliseconds to date.
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = milliSeconds
    return formatter.format(calendar.time)
}
