package ezike.tobenna.petform.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.ui.adapter.viewholder.*
import ezike.tobenna.petform.utils.ViewType


class FormAdapter(private val elements: List<Elements>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), BindableAdapter<List<Elements>> {

    override fun setData(data: List<Elements>) {
        with(this.elements as ArrayList) {
            clear()
            addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when {
            elements[position].type == ViewType.TEXT.value -> TEXT_FIELD
            elements[position].type == ViewType.NUMERIC.value -> TEXT_NUMERIC_FIELD
            elements[position].type == ViewType.DATETIME.value -> DATETIME_FIELD
            elements[position].type == ViewType.IMAGE.value -> IMAGE_FIELD
            elements[position].type == ViewType.YESNO.value -> YESNO_FIELD

            else -> return EMPTY_VIEW
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {

            TEXT_FIELD -> TextViewHolder.create(parent)
            TEXT_NUMERIC_FIELD -> NumericViewHolder.create(parent)
            DATETIME_FIELD -> DateTimeViewHolder.create(parent)
            IMAGE_FIELD -> ImageViewHolder.create(parent)
            YESNO_FIELD -> YesNoViewHolder.create(parent)

            else -> EmptyStateViewHolder.create(parent)
        }
    }

    override fun getItemCount() = elements.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is TextViewHolder -> holder.bind(elements[position])
            is NumericViewHolder -> holder.bind(elements[position])
            is DateTimeViewHolder -> holder.bind(elements[position])
            is ImageViewHolder -> holder.bind(elements[position])
            is YesNoViewHolder -> holder.bind(elements[position])
            is EmptyStateViewHolder-> holder.bind(elements[position])

        }
    }

    companion object {

        private const val EMPTY_VIEW = 0
        private const val TEXT_FIELD = 1
        private const val TEXT_NUMERIC_FIELD = 2
        private const val DATETIME_FIELD = 3
        private const val IMAGE_FIELD = 4
        private const val YESNO_FIELD = 5

    }
}