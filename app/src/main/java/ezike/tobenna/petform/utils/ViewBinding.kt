package ezike.tobenna.petform.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ezike.tobenna.petform.R
import ezike.tobenna.petform.ui.adapter.BindableAdapter
import fr.ganfra.materialspinner.MaterialSpinner

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
    GlideApp.with(context)
        .load(url)
        .placeholder(android.R.color.darker_gray)
        .into(this)
}

@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    if (show)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}

@BindingAdapter("showSubmit")
fun TextView.setBtnText(check: Boolean) {
    val context = this.context
    if (check)
        this.text = context.getString(R.string.next)
    else
        this.text = context.getString(R.string.submit)
}

@BindingAdapter("items")
fun <T> RecyclerView.setItems(data: T) {
    if (adapter is BindableAdapter<*>) {
        with((adapter as BindableAdapter<T>)) {
            setData(data)
        }
    }
}

@BindingAdapter("hint")
fun MaterialSpinner.setCustomHint(hint: String) {
    this.hint = hint
}

