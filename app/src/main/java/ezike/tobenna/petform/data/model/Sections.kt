package ezike.tobenna.petform.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sections(

    @Json(name = "elements")
    val elements: List<Elements>,

    @Json(name = "label")
    val label: String

) : Parcelable {

    fun isTarget(): Boolean {

        var isTarget = false

        for (element in elements) {

            for (rule in element.rules) {

                if (rule.targets.contains(element.uniqueId)) {
                    isTarget = true
                }
            }
        }

        return isTarget
    }
}