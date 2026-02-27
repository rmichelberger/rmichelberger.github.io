package works.jean.gemini.api.request

import works.jean.gemini.api.Content
import works.jean.gemini.api.GenerationConfig
import works.jean.gemini.api.tool.Tool
import kotlinx.serialization.Serializable

@Serializable
data class Request(
    val contents: List<Content>,
    val generationConfig: GenerationConfig? = null,
    val tools: List<Tool>? = null,
)