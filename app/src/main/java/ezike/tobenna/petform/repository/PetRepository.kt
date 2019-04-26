package ezike.tobenna.petform.repository

import ezike.tobenna.petform.data.local.DataSource
import ezike.tobenna.petform.data.model.Pet
import javax.inject.Inject

class PetRepository @Inject constructor(private val dataSource: DataSource<Pet>) {

    fun getData() = dataSource.getData()

}