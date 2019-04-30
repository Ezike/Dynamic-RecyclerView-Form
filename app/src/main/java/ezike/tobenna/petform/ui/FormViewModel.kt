package ezike.tobenna.petform.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.repository.FormRepository
import javax.inject.Inject

class FormViewModel @Inject constructor(repository: FormRepository) : ViewModel() {

    private val formData = repository.form

    private val _elements = MutableLiveData<List<Elements>>()

    val elements: LiveData<List<Elements>>
        get() = _elements

    init {

        getElements()
    }

    fun getFormData() = formData

    private fun getElements() {

        if (formData != null) {

            for (page in formData.pages.subList(0,1)) {

                for (section in page.sections.subList(0,1)) {

                    _elements.value = section.elements
                }
            }
        }
    }

}