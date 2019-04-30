package ezike.tobenna.petform.ui.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ezike.tobenna.petform.data.model.Elements

open class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: Elements) {
        binding.executePendingBindings()
    }

}
