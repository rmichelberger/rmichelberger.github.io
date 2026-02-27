package works.jean.revenuecat

import works.jean.BuildConfig

internal actual fun revenueCatApiKey(): String =
    if (BuildConfig.DEBUG) {
        "test_sKpYcvqJtoGrQiMkNLfWZhFEgnc"
    } else "PROD"

