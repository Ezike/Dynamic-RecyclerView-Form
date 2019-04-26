package ezike.tobenna.petform.ui

import androidx.lifecycle.ViewModel
import ezike.tobenna.petform.repository.PetRepository
import javax.inject.Inject

class PetViewModel @Inject constructor(private val repository: PetRepository) : ViewModel() {

    fun getFormData() = repository.getData()
}