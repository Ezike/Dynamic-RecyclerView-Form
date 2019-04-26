package ezike.tobenna.petform.data.local

import android.app.Application
import com.squareup.moshi.Moshi
import ezike.tobenna.petform.data.model.Pet
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val context: Application) : DataSource<Pet> {

    @Inject
    lateinit var moshi: Moshi

    override fun getData() = moshi.adapter(Pet::class.java).fromJson(loadFromJson())

    private fun loadFromJson() = context.assets.open(FILE_NAME).bufferedReader().use {
        it.readText()
    }

    companion object {
        private const val FILE_NAME = "pet_adoption-1.json"
    }

}