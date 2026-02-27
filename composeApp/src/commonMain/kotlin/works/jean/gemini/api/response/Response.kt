package works.jean.gemini.api.response

import works.jean.gemini.api.response.Candidate
import kotlinx.serialization.Serializable

@Serializable
data class Response(val candidates: List<Candidate>? = null, val error: ResponseError? = null)