package ezike.tobenna.petform.data.local

import ezike.tobenna.petform.data.model.Form

interface DataSource<T> {

    fun getData(): Form?
}