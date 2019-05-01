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
import timber.log.Timber

class FormFragment : BaseFragment() {

    private lateinit var binding: FragmentFormBinding

    private val page by lazy { arguments!!.getParcelable<Pages>(PAGE_ITEM_KEY) }

    private val pageNumber by lazy { Integer.valueOf(page!!.label.substring(5, 6)) }

    private lateinit var elements: ArrayList<Elements>

    private val formAdapter = FormAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Timber.d("onCreateView")

        Timber.d("$pageNumber")

        binding = FragmentFormBinding.inflate(inflater, container, false).apply {

            pageNo.text = "$pageNumber"

            section = page!!.sections[0]

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

        Timber.d("onActivityCreated")

        getElements()

        binding.viewModel?.setElements(elements)

        binding.nextBtn.setOnClickListener {
            binding.viewModel?.nextStep()
        }

        binding.prevBtn.setOnClickListener {
            binding.viewModel?.previousStep()
        }

    }

    private fun getElements() {

        elements = ArrayList()

        page!!.sections.forEach {

            elements.addAll(it.elements)
        }

    }

    companion object {

        private const val PAGE_ITEM_KEY = "page_item_key"

        fun newInstance(page: Pages) = FormFragment().apply {

            val args = Bundle().apply {
                putParcelable(PAGE_ITEM_KEY, page)
            }

            arguments = args
        }
    }

}
