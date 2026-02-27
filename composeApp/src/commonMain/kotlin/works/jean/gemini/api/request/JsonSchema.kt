package works.jean.gemini.api.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Minimal JSON Schema representation used by Gemini function declarations.
 */
@Serializable
data class JsonSchema(
    val type: String,
    val properties: Map<String, JsonSchema>? = null,
    val items: JsonSchema? = null,
    val description: String? = null,
    val required: List<String>? = null,
    @SerialName("enum")
    val enumValues: List<String>? = null,
)

