package ezike.tobenna.petform.ui.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ezike.tobenna.petform.R
import ezike.tobenna.petform.data.model.Elements

open class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: Elements) {

        if (this is TextViewHolder) {

            val context = binding.textInput.context

            if (item.isMandatory) {

                binding.textInput.helperText = context.getString(R.string.required)

            }

        }

        binding.executePendingBindings()
    }

}
