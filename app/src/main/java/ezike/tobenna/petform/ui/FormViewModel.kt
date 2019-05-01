package ezike.tobenna.petform.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.data.model.Pages
import ezike.tobenna.petform.repository.FormRepository
import javax.inject.Inject

class FormViewModel @Inject constructor(repository: FormRepository) : ViewModel() {

    private val formData = repository.getData()

    private var currentPageNumber = 0

    private lateinit var page: Pages

    private val _elements = MutableLiveData<List<Elements>>()

    val elements: LiveData<List<Elements>>
        get() = _elements

    private val currentPageNumberLiveData = MutableLiveData<Int>()

    val elementLiveData: LiveData<Pages> = Transformations.map(currentPageNumberLiveData) {
        formData!!.pages[it]
    }

    fun getFormData() = formData

    fun setElements(elements: List<Elements>) {
        _elements.value = elements
    }

    fun nextStep() {
        if (hasNext()) {
            currentPageNumber++
            currentPageNumberLiveData.value = currentPageNumber
        }
    }

    fun previousStep() {
        if (hasPrevious()) {
            currentPageNumber--
            currentPageNumberLiveData.value = currentPageNumber
        }
    }

    fun hasNext(): Boolean {
        return currentPageNumber < formData!!.pages.lastIndex
    }

    fun hasPrevious(): Boolean {
        return currentPageNumber > 0
    }

    fun getCurrentPage(): Pages {
        page = formData!!.pages[currentPageNumber]
        return page
    }

}