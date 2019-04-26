package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Elements(

    @Json(name = "unique_id")
    val uniqueId: String,

    @Json(name = "rules")
    val rules: List<Rules>,

    @Json(name = "label")
    val label: String,

    @Json(name = "type")
    val type: String,

    @Json(name = "isMandatory")
    val isMandatory: Boolean
)