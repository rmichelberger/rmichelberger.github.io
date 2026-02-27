package works.jean.calendar

import be.vandeas.kalendar.kit.CalendarEventManager
import platform.UIKit.UIViewController

class CalendarEventManager {
    companion object {
        val calendarEventManager = CalendarEventManager()
        fun initCalendarEventManager(viewController: UIViewController) {
            calendarEventManager.setPresentingViewController(viewController = viewController)
        }
    }
}