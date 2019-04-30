package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Elements(

        @Json(name = "unique_id")
        val uniqueId: String,

        @Json(name = "rules")
        val rules: List<Rules>,

        @Json(name = "label")
        val label: String,

        @Json(name = "value")
        val type: String,

        @Json(name = "isMandatory")
        val isMandatory: Boolean,

        @Json(name = "file")
        val file: String,

        @Json(name = "keyboard")
        val keyboard: String,

        @Json(name = "formattedNumeric")
        val format: String,

        @Json(name = "mode")
        val mode: String,

        val emptyText: String = "No views available"
)
