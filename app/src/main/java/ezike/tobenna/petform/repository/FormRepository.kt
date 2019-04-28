package ezike.tobenna.petform.repository

import ezike.tobenna.petform.data.local.DataSource
import ezike.tobenna.petform.data.model.Form
import javax.inject.Inject

class FormRepository @Inject constructor(private val dataSource: DataSource<Form>) {

    fun getData() = dataSource.getData()

}