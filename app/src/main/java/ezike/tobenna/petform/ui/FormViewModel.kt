package ezike.tobenna.petform.ui

import androidx.lifecycle.ViewModel
import ezike.tobenna.petform.repository.FormRepository
import javax.inject.Inject

class FormViewModel @Inject constructor(private val repository: FormRepository) : ViewModel() {

    fun getFormData() = repository.getData()
}