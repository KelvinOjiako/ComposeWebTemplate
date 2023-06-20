package ktorClient

import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class AuthSetupWorker(val clientID: String, val client: HttpClient = HttpClient(Js){ followRedirects = false }) {
    fun createAuthorizationQuery() =  parameters {
        append("client_id", clientID)
        append("scope", "https://www.googleapis.com/auth/userinfo.profile")
        append("response_type", "code")
        append("redirect_uri", "http://127.0.0.1:8080")
        append("access_type", "offline")
    }.formUrlEncode()

    fun getAuthorizationLink(): String  {
        val query = createAuthorizationQuery()
        return "https://accounts.google.com/o/oauth2/auth?$query"
    }

    suspend fun retrieveAuthorizationCode(): String? {
        val authResponse: HttpResponse = client.request("http://localhost:8080/callback")

        return authResponse.request.url.parameters["token"]
    }
}