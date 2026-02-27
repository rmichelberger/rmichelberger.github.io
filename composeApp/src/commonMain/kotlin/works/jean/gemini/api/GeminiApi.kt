package works.jean.gemini.api

import works.jean.gemini.api.request.Request
import works.jean.gemini.api.response.Response
import works.jean.gemini.file.GeminiFileUploader
import works.jean.network.Network
import works.jean.network.Url
import io.ktor.client.call.body
import secrets.Secrets

class GeminiApi(
    private val network: Network,
    private val geminiFileUploader: GeminiFileUploader = GeminiFileUploader(network = network)
) {
    suspend fun uploadFile(
        byteArray: ByteArray, mimeType: String,
        displayName: String,
    ) =
        geminiFileUploader.uploadFile(
            byteArray = byteArray,
            mimeType = mimeType,
            displayName = displayName,
            apiKey = Secrets.API_KEY
        )

    suspend fun generateContent(
        request: Request,
        model: Model = Model.Gemini3FlashPreview,
        apiKey: String
    ): Response = network.post(
        url = Url(
            baseUrl = "https://generativelanguage.googleapis.com/v1beta/models/${model.path}:generateContent",
            headers = mapOf("x-goog-api-key" to apiKey)
        ), body = request
    ).body()

    sealed class Model(val path: String) {
        object Gemini3FlashPreview : Model(path = "gemini-3-flash-preview")
    }
}