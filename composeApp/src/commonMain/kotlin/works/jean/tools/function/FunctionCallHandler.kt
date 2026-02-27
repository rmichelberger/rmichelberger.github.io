package works.jean.tools.function

import works.jean.gemini.api.function.FunctionCall
import works.jean.tools.ToolItem

class FunctionCallHandler(private val tools: List<FunctionCallable>) {

    suspend fun handleFunctionCall(functionCall: FunctionCall): Boolean {
        for (tool in tools) {
            if (tool.handleFunctionCall(functionCall = functionCall)) {
                return true
            }
        }
        return false
    }

    fun toolItemForFunctionCall(functionCall: FunctionCall): ToolItem? =
        tools.firstOrNull { it.functionDeclaration.name == functionCall.name }?.associatedToolItem
}