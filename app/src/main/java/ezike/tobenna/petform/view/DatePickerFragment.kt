package ezike.tobenna.petform.view

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ezike.tobenna.petform.utils.DateUtil
import java.util.*

class DatePickerFragment : DialogFragment() {

    private val date: Date? by lazy { DateUtil.stringToDate(arguments?.getString(DATE_PICKER_DOB)!!) }

    lateinit var listener: DatePickerDialog.OnDateSetListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = date?.run {
            Calendar.getInstance().apply {
                set(Calendar.YEAR, get(Calendar.YEAR))
                set(Calendar.MONTH, get(Calendar.MONTH))
                set(Calendar.DAY_OF_MONTH, get(Calendar.DAY_OF_WEEK))
            }
        } ?: Calendar.getInstance()

        return DatePickerDialog(
            context!!, listener, calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    companion object {
        const val DATE_PICKER_DOB = "date_picker_dob"
    }

}