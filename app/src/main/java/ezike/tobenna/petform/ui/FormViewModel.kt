package ezike.tobenna.petform.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ezike.tobenna.petform.data.model.Elements
import ezike.tobenna.petform.repository.FormRepository
import javax.inject.Inject

class FormViewModel @Inject constructor(repository: FormRepository) : ViewModel() {

    private val formData = repository.getData()

    private val _elements = MutableLiveData<List<Elements>>()

    val elements: LiveData<List<Elements>>
        get() = _elements


    fun getFormData() = formData

    fun setElements(elements: List<Elements>) {
        _elements.value = elements
    }

}