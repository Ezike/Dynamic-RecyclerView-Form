package ezike.tobenna.petform.view

import android.app.DatePickerDialog
import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.google.android.material.textfield.TextInputEditText
import ezike.tobenna.petform.utils.DateUtil
import java.util.*

class DateEditText(context: Context, attrs: AttributeSet) : TextInputEditText(context, attrs) {

    var dateChangeListener: OnDateChangedListener = object : OnDateChangedListener {
        override fun onDateChanged(date: String) {

        }
    }

    var dateText = ""

    init {
        keyListener = null
        setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                showPicker()
            }
        }
        setOnClickListener {
            if (hasFocus()) showPicker()
        }

    }

    private fun showPicker() {

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val startDateDialog = DatePickerDialog(context, { _, year1, month1, day1 ->
            val selDate = year1.toString() + "-" + (month1 + 1) + "-" + day1
            setText(DateUtil.formatDate(selDate))
        }, year, month, day)
        calendar.time = Date()
        calendar.add(Calendar.YEAR, 0)
        startDateDialog.datePicker.maxDate = calendar.timeInMillis
        startDateDialog.show()
    }

    interface OnDateChangedListener {

        fun onDateChanged(date: String)

    }
}

@BindingAdapter("dateChangeListener")
fun DateEditText.setDateChangeListener(attrChange: InverseBindingListener) {
    dateChangeListener = object : DateEditText.OnDateChangedListener {
        override fun onDateChanged(date: String) {
            attrChange.onChange()
        }
    }
}

@BindingAdapter("dateText")
fun DateEditText.setDateText(date: String?) {
    date?.let {
        if (it != dateText) {
            dateText = it
            setText(dateText)
        }
    }
}

@InverseBindingAdapter(attribute = "dateText", event = "dateChangeListener")
fun DateEditText.getDateText() = dateText