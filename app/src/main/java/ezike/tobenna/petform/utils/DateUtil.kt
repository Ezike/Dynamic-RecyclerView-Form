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
}