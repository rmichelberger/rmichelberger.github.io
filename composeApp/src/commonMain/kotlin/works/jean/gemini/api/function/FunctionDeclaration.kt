package works.jean.gemini.api.function

import works.jean.gemini.api.request.JsonSchema
import kotlinx.serialization.Serializable

@Serializable
data class FunctionDeclaration(
    val name: String,
    val description: String? = null,
    val parameters: JsonSchema? = null,
)
