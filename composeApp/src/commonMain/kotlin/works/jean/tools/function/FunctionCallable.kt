package works.jean.tools.function

import works.jean.gemini.api.function.FunctionCall
import works.jean.gemini.api.function.FunctionDeclaration
import works.jean.tools.ToolItem
import kotlinx.serialization.json.JsonPrimitive

interface FunctionCallable {
    suspend fun handleFunctionCall(functionCall: FunctionCall): Boolean
    val functionDeclaration: FunctionDeclaration
    val associatedToolItem: ToolItem
}

val JsonPrimitive.stringOrNull: String?
    get() = if (isString) content else null