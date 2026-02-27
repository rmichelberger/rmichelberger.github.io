package works.jean.gemini.api

import works.jean.gemini.api.request.JsonSchema
import kotlinx.serialization.Serializable

@Serializable
data class GenerationConfig(
    val responseMimeType: String,
    val responseJsonSchema: JsonSchema
)