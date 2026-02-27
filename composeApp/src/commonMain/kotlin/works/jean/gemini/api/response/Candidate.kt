package works.jean.gemini.api.response

import works.jean.gemini.api.Content
import kotlinx.serialization.Serializable

@Serializable
data class Candidate(val content: Content)