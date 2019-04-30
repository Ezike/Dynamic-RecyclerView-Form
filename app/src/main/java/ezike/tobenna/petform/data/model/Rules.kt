package ezike.tobenna.petform.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val targets: List<String>
) : Parcelable