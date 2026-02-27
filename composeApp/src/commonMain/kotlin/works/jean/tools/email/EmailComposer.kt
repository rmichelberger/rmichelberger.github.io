package works.jean.tools.email

expect class EmailComposer {
    constructor()
    fun sendEmail(email: Email): Boolean
}