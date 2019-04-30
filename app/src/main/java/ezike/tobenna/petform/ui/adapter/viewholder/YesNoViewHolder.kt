package ezike.tobenna.petform.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.databinding.YesnoQuestionItemBinding

class YesNoViewHolder(private val binding: YesnoQuestionItemBinding) : BaseViewHolder(binding) {

    override fun bind(item: Elements) {
        binding.element = item
        super.bind(item)
    }

    companion object {
        fun create(parent: ViewGroup) =
            YesNoViewHolder(YesnoQuestionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}