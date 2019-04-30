package ezike.tobenna.petform.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object DateUtil {

    private val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)

    fun stringToDate(s: String): Date? {
        return try {
            dateFormat.parse(s)
        } catch (e: ParseException) {
            null
        }
    }

    fun formatDate(selectedDate: String): String {

        val monthDate = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        var date: Date? = null
        try {
            date = sdf.parse(selectedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return monthDate.format(date)
    }
}