package ezike.tobenna.petform.data.model

import com.squareup.moshi.Json

data class Sections(

    @Json(name = "elements")
    val elements: List<Elements>,

    @Json(name = "label")
    val label: String

) {

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