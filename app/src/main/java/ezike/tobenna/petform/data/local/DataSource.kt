package ezike.tobenna.petform.data.local

import ezike.tobenna.petform.data.model.Pet

interface DataSource<T> {

     fun getData(): Pet?
}