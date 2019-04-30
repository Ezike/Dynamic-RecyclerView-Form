package ezike.tobenna.petform.view

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.fragment.app.FragmentActivity
import com.google.android.material.textfield.TextInputEditText
import ezike.tobenna.petform.view.DatePickerFragment.Companion.DATE_PICKER_DOB

class DateEditText(context: Context, attrs: AttributeSet) : TextInputEditText(context, attrs) {

    var dateChangeListener: OnDateChangedListener = object : OnDateChangedListener {
        override fun onDateChanged(date: String) {

        }
    }

    private val fragment = DatePickerFragment()

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
        val args = Bundle()
        args.putString(DATE_PICKER_DOB, dateText)
        fragment.arguments = args
        fragment.listener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            dateText = "$dayOfMonth-$month-$year"
            setText(dateText)
            dateChangeListener.onDateChanged(dateText)
        }
        fragment.show((context as FragmentActivity).supportFragmentManager, "datePicker")
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