package works.jean.calendar

import android.content.Context
import be.vandeas.kalendar.kit.CalendarEventManager

fun createCalendarEventManager(context: Context): CalendarEventManager {
    val calendarEventManager = CalendarEventManager()
    calendarEventManager.setup(context)
    return calendarEventManager
}
