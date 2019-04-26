package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Pages(

    @Json(name = "label")
    val label: String,

    @Json(name = "sections")
    val sections: List<Sections>
)