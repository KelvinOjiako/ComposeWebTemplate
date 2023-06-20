package ktorClient

import core.model.TokenInfo
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*


class LoginService {
    private val authWorker = AuthSetupWorker()
    fun getAuthorizationLink() = authWorker.getAuthorizationLink()

    suspend fun getAuthCode() = authWorker.retrieveAuthorizationCode()

   suspend fun  createAuthClient(authorizationCode: String): HttpClient{

        val client = HttpClient(Js){
           // Plugin #1 being installed for converting content to various forms
           install(ContentNegotiation){
               kotlin.js.json()
           }

           // Step 2: Create a storage for tokens
           val bearerTokenStorage = mutableListOf<BearerTokens>()

           // Step 3: Configure the client for receiving tokens and accessing the protected API
           install(Auth){
               bearer {
                   loadTokens {
                       bearerTokenStorage.last()
                   }

                   refreshTokens {
                       val refreshTokenInfo: TokenInfo = client.submitForm(
                           url = "https://accounts.google.com/o/oauth2/token",
                           formParameters = parameters {
                               append("grant_type", "refresh_token")
                               append("client_id", "")
                               append("refresh_token", oldTokens?.refreshToken ?: "")
                           }
                       ) { markAsRefreshTokenRequest() }.body()
                       bearerTokenStorage.add(BearerTokens(refreshTokenInfo.accessToken, oldTokens?.refreshToken!!))
                       bearerTokenStorage.last()
                   }
                   sendWithoutRequest { request ->
                       request.url.host == "www.googleapis.com"
                   }
               }
           }
       }


        return client
    }
}