package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Rules(

    @Json(name = "otherwise")
    val otherwise: String,

    @Json(name = "condition")
    val condition: String,

    @Json(name = "action")
    val action: String,

    @Json(name = "value")
    val value: String,

    @Json(name = "targets")
    val targets: List<String?>
)