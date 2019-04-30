package ezike.tobenna.petform.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pages(

    @Json(name = "label")
    val label: String,

    @Json(name = "sections")
    val sections: List<Sections>
) : Parcelable