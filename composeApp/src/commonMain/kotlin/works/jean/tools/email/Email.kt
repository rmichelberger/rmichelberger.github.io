package works.jean.tools.email

data class Email(
    val recipients: List<String> = emptyList(),
    val subject: String? = null,
    val body: String? = null,
    val isHtml: Boolean = false
)