package works.jean.gemini.api

import works.jean.gemini.api.function.FunctionCall
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Part(
    val text: String? = null,
    @SerialName(value = "inline_data") val inlineData: InlineData? = null,
    @SerialName(value = "file_data") val fileData: FileData? = null,
    val functionCall: FunctionCall? = null
)