package ezike.tobenna.petform.repository

import ezike.tobenna.petform.data.local.DataSource
import ezike.tobenna.petform.data.model.Form
import javax.inject.Inject

class FormRepository @Inject constructor(dataSource: DataSource<Form>) {

    private val form = dataSource.getData()

    fun getData() = form
}