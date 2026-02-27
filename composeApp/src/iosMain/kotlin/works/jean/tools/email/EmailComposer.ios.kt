package works.jean.tools.email

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem
import platform.UIKit.UIApplication

actual class EmailComposer {

    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    actual fun sendEmail(email: Email): Boolean {
        // TODO: use MFMailComposeViewController
        val recipients = email.recipients.filter { it.isNotBlank() }
        val components = NSURLComponents().apply {
            scheme = "mailto"
            path = recipients.joinToString(",")

            val queryItems = mutableListOf<NSURLQueryItem>()

            email.subject
                ?.takeIf { it.isNotBlank() }
                ?.let { queryItems += NSURLQueryItem(name = "subject", value = it) }

            email.body
                ?.takeIf { it.isNotBlank() }
                ?.let { queryItems += NSURLQueryItem(name = "body", value = it) }

            if (queryItems.isNotEmpty()) {
                this.queryItems = queryItems
            }
        }

        println(components)
        val url: NSURL = components.URL ?: return false
        val application = UIApplication.sharedApplication
        println(url)

        return if (application.canOpenURL(url)) {
            application.openURL(url, options = emptyMap<Any?, Any?>(), completionHandler = {

            })
            true
        } else false
    }
}
