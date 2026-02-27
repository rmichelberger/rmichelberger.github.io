package works.jean.gemini.api.tool

import works.jean.gemini.api.function.FunctionDeclaration
import kotlinx.serialization.Serializable

@Serializable
data class Tool(
    val functionDeclarations: List<FunctionDeclaration>,
)