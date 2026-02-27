package works.jean

import androidx.compose.ui.window.ComposeUIViewController
import works.jean.calendar.CalendarEventManager
import works.jean.datastore.createDataStore
import works.jean.tools.ToolToFunctionCallableMapper.Dependency
import works.jean.tools.email.EmailComposer

fun MainViewController() = ComposeUIViewController {
    App(
        dataStore = createDataStore(),
        dependency = Dependency(
            calendarEventManager = CalendarEventManager.calendarEventManager,
            emailComposer = EmailComposer()
        ),
    )
}