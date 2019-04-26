package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Pet(

    @Json(name = "pages")
    val pages: List<Pages?>,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: String
)