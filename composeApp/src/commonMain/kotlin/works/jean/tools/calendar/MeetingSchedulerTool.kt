package works.jean.tools.calendar

import be.vandeas.kalendar.kit.CalendarEventManager
import be.vandeas.kalendar.kit.Event
import works.jean.gemini.api.function.FunctionCall
import works.jean.gemini.api.function.FunctionDeclaration
import works.jean.gemini.api.request.JsonSchema
import works.jean.tools.ToolItem
import works.jean.tools.calendar.MeetingSchedulerTool.Companion.FUNCTION_NAME
import works.jean.tools.function.FunctionCallable
import works.jean.tools.function.stringOrNull
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class MeetingSchedulerTool(private val calendarEventManager: CalendarEventManager) :
    FunctionCallable {

    override suspend fun handleFunctionCall(functionCall: FunctionCall): Boolean =
        functionCall.event?.let { createEvent(event = it) } ?: false

    override val functionDeclaration: FunctionDeclaration = FunctionDeclaration(
        name = FUNCTION_NAME,
        description = "Schedules an event with optional attendees at a given time and date.",
        parameters = JsonSchema(
            type = "object",
            properties = mapOf(
                "title" to JsonSchema(
                    type = "string",
                    description = "The title, subject or topic of the event.",
                ),
                "start_date" to JsonSchema(
                    type = "string",
                    description = "Start date and time of the event, with 'yyyy-MM-ddTHH:mm' format (e.g., '2026-08-30T18:43')",
                ),
                "end_date" to JsonSchema(
                    type = "string",
                    description = "End date and time of the event, with 'yyyy-MM-ddTHH:mm' format (e.g., '2026-08-30T18:43')",
                ),
                "notes" to JsonSchema(
                    type = "string",
                    description = "Additional note (e.g., 'Let's discuss the Q3 planning.')",
                ),
                "location" to JsonSchema(
                    type = "string",
                    description = "Location of the event (e.g., 'Meeting Room 3', 'Thai Restaurant', 'Teams Call')",
                ),
                "url" to JsonSchema(
                    type = "string",
                    description = "Link to the online event (e.g., 'https://teams.microsoft.com/l/meetup-join/123abc')",
                ),
            ),
            required = listOf("title", "start_date", "end_date"),
        )
    )

    override val associatedToolItem = TOOL_ITEM

    private suspend fun createEvent(event: Event): Boolean = calendarEventManager.createEvent(event)

    companion object {
        const val FUNCTION_NAME = "schedule_meeting"

        val TOOL_ITEM = ToolItem(
            id = FUNCTION_NAME,
            name = "Schedule meeting",
            iconResName = "calendar_add",
            enabled = false
        )
    }
}

val FunctionCall.event: Event?
    get() = if (name == FUNCTION_NAME) {
        val title = args?.jsonObject["title"]?.jsonPrimitive?.stringOrNull ?: return null
        val startDate = args.jsonObject["start_date"]?.jsonPrimitive?.stringOrNull?.let {
            LocalDateTime.Formats.ISO.parse(it)
        } ?: return null
        val endDate = args.jsonObject["end_date"]?.jsonPrimitive?.stringOrNull?.let {
            LocalDateTime.Formats.ISO.parse(it)
        } ?: return null
        val notes = args.jsonObject["notes"]?.jsonPrimitive?.stringOrNull
        val location = args.jsonObject["location"]?.jsonPrimitive?.stringOrNull
        val url = args.jsonObject["url"]?.jsonPrimitive?.stringOrNull
        Event(
            title = title,
            startDate = startDate,
            endDate = endDate,
            notes = notes,
            location = location,
            url = url
        )
    } else null