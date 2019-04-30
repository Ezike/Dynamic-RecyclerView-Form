package ezike.tobenna.petform.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.data.model.Pages
import ezike.tobenna.petform.databinding.FragmentFormBinding
import ezike.tobenna.petform.ui.adapter.FormAdapter
import ezike.tobenna.petform.ui.base.BaseFragment
import ezike.tobenna.petform.utils.getViewModel

class FormFragment : BaseFragment() {

    private lateinit var binding: FragmentFormBinding

    private val page by lazy { arguments!!.getParcelable<Pages>(PAGE_ITEM_KEY) }

    private val pageNumber by lazy { arguments!!.getInt(PAGE_NUMBER_KEY) }

    private val pagePosition by lazy { arguments!!.getInt(PAGE_POSITION_KEY) }

    private lateinit var elements: ArrayList<Elements>

    private val formAdapter = FormAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val currentPage = pageNumber + 1

        binding = FragmentFormBinding.inflate(inflater, container, false).apply {
            pageNo.text = "$currentPage"
            section = page!!.sections[pageNumber]
            viewModel = getViewModel<FormViewModel>()

            recyclerView.apply {
                setHasFixedSize(true)
                adapter = formAdapter
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        getElements()

        binding.viewModel?.setElements(elements)

    }

    private fun getElements() {

        elements = ArrayList()

        page!!.sections.forEach {

            elements.addAll(it.elements)
        }

    }

    companion object {

        private const val PAGE_ITEM_KEY = "page_item_key"
        private const val PAGE_NUMBER_KEY = "page_number_key"
        private const val PAGE_POSITION_KEY = "page_position_key"

        fun newInstance(page: Pages, pageNumber: Int, pagePosition: Int) = FormFragment().apply {

            val args = Bundle().apply {
                putParcelable(PAGE_ITEM_KEY, page)
                putInt(PAGE_NUMBER_KEY, pageNumber)
                putInt(PAGE_POSITION_KEY, pagePosition)
            }

            arguments = args
        }
    }

}
