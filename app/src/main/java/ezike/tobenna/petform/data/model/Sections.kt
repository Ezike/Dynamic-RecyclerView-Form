package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Sections(

    @Json(name = "elements")
    val elements: List<Elements>,

    @Json(name = "label")
    val label: String
)