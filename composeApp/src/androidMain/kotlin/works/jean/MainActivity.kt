package works.jean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import works.jean.calendar.createCalendarEventManager
import works.jean.datastore.createDataStore
import works.jean.tools.ToolToFunctionCallableMapper.Dependency
import works.jean.tools.email.EmailComposer
import works.jean.tools.email.EmailComposerAndroidContextHolder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Provide an application context for non-UI KMP code that needs to launch Android intents.
        EmailComposerAndroidContextHolder.applicationContext = applicationContext

        setContent {
            App(
                dataStore = createDataStore(context = this),
                dependency = Dependency(
                    calendarEventManager = createCalendarEventManager(context = this),
                    emailComposer = EmailComposer()
                ),
            )
        }
    }
}