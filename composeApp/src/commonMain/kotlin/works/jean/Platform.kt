package works.jean

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform