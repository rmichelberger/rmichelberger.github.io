package works.jean.gemini.api.function

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
@SerialName("functionCall")
data class FunctionCall(
    @SerialName("name")
    val name: String,
    /**
     * Gemini returns this as a JSON object (see sample), and the schema depends on the called function.
     * Keeping it as [JsonElement] allows callers to decode it further based on [name].
     */
    @SerialName("args")
    val args: JsonElement? = null,
)
