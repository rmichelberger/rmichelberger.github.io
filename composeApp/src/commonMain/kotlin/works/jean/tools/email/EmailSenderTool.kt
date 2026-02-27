package works.jean.tools.email

import works.jean.gemini.api.function.FunctionCall
import works.jean.gemini.api.function.FunctionDeclaration
import works.jean.gemini.api.request.JsonSchema
import works.jean.tools.ToolItem
import works.jean.tools.email.EmailSenderTool.Companion.FUNCTION_NAME
import works.jean.tools.function.FunctionCallable
import works.jean.tools.function.stringOrNull
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class EmailSenderTool(private val emailComposer: EmailComposer) : FunctionCallable {

    override suspend fun handleFunctionCall(functionCall: FunctionCall): Boolean {
        val email = functionCall.email ?: return false
        emailComposer.sendEmail(email)
        return true
    }

    override val functionDeclaration: FunctionDeclaration =
        FunctionDeclaration(
            name = FUNCTION_NAME,
            description = "Composes and sends an email.",
            parameters = JsonSchema(
                type = "object",
                properties = mapOf(
                    "recipients" to JsonSchema(
                        type = "array",
                        description = "List of recipient email addresses.",
                        items = JsonSchema(type = "string")
                    ),
                    "subject" to JsonSchema(
                        type = "string",
                        description = "The email subject line."
                    ),
                    "body" to JsonSchema(
                        type = "string",
                        description = "The email body."
                    ),
                    "is_html" to JsonSchema(
                        type = "boolean",
                        description = "Whether the body is HTML."
                    ),
                ),
            )
        )

    override val associatedToolItem = TOOL_ITEM

    companion object {
        const val FUNCTION_NAME = "send_email"

        val TOOL_ITEM = ToolItem(
            id = FUNCTION_NAME,
            name = "Send Email",
            iconResName = "mail_out",
            enabled = false
        )
    }
}

val FunctionCall.email: Email?
    get() = if (name == FUNCTION_NAME) {
        val recipients = args
            ?.jsonObject
            ?.get("recipients")
            ?.jsonArray
            ?.mapNotNull { it.jsonPrimitive.stringOrNull }
            ?: return null

        val subject = args.jsonObject["subject"]?.jsonPrimitive?.stringOrNull
        val body = args.jsonObject["body"]?.jsonPrimitive?.stringOrNull
        val isHtml =
            args.jsonObject["is_html"]?.jsonPrimitive?.content?.toBooleanStrictOrNull() ?: false

        Email(
            recipients = recipients,
            subject = subject,
            body = body,
            isHtml = isHtml
        )
    } else null
