package works.jean.tools

import be.vandeas.kalendar.kit.CalendarEventManager
import works.jean.tools.calendar.MeetingSchedulerTool
import works.jean.tools.email.EmailComposer
import works.jean.tools.email.EmailSenderTool
import works.jean.tools.function.FunctionCallable

class ToolToFunctionCallableMapper(private val dependency: Dependency) {
    fun map(toolItem: ToolItem): FunctionCallable? =
        if (toolItem.enabled) {
            when (toolItem.id) {
                MeetingSchedulerTool.TOOL_ITEM.id -> MeetingSchedulerTool(dependency.calendarEventManager)
                EmailSenderTool.TOOL_ITEM.id -> EmailSenderTool(dependency.emailComposer)
                else -> null
            }
        } else null

    data class Dependency(
        val calendarEventManager: CalendarEventManager,
        val emailComposer: EmailComposer
    )
}