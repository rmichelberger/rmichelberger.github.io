package works.jean.tools.email

import android.content.Intent
import androidx.core.net.toUri

actual class EmailComposer {
    actual fun sendEmail(email: Email): Boolean {
        val recipients = email.recipients.map { it.trim() }.filter { it.isNotBlank() }

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = "mailto:".toUri()
            putExtra(Intent.EXTRA_EMAIL, recipients.toTypedArray())

            email.subject
                ?.takeIf { it.isNotBlank() }
                ?.let { putExtra(Intent.EXTRA_SUBJECT, it) }

            email.body
                ?.takeIf { it.isNotBlank() }
                ?.let { putExtra(Intent.EXTRA_TEXT, it) }

            // Android email clients interpret EXTRA_TEXT as plain text; HTML support is client-specific.
        }

        // In KMP we usually don't have access to an Activity/Context here; use the system default.
        // The intent will need FLAG_ACTIVITY_NEW_TASK when started from a non-Activity context.
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        return runCatching {
            // Uses the system to resolve an email app; if none exists, just no-op.
            EmailComposerAndroidContextHolder
                .applicationContext
                ?.startActivity(intent)
        }.isSuccess
    }
}

/**
 * Holds an Android application context for launching implicit intents from non-UI KMP code.
 *
 * Initialized in MainActivity.
 */
internal object EmailComposerAndroidContextHolder {
    @Volatile
    var applicationContext: android.content.Context? = null
}