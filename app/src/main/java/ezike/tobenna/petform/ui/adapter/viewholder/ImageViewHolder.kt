package ezike.tobenna.petform.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.databinding.EmbeddedphotoItemBinding

class ImageViewHolder(private val binding: EmbeddedphotoItemBinding) : BaseViewHolder(binding) {

    override fun bind(item: Elements) {
        binding.element = item
        super.bind(item)
    }

    companion object {
        fun create(parent: ViewGroup) =
            ImageViewHolder(EmbeddedphotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}