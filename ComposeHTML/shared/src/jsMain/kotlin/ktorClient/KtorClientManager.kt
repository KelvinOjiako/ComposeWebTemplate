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
import kotlin.js.json

class KtorOAuthClientManager{
    private val client = HttpClient(Js){
        // Plugin #1 being installed
        install(ContentNegotiation){
            json()
        }

        //*****Steps involved in using OAuth plugin***********

        // Step 1: Get an authorization code

        val authorizationQueryUrl = createAuthorizationQuery()
        println("https://accounts.google.com/o/oauth2/auth?$authorizationQueryUrl")
        println("Open a link above, get the authorization code, insert it below, and press Enter.")
        val authorizationCode = readln()

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
    fun createAuthorizationQuery() =  parameters {
        append("client_id", "150430991817-cgmmc149b9gu3poc5bgo4q4jrpnigand.apps.googleusercontent.com")
        append("scope", "https://www.googleapis.com/auth/userinfo.profile")
        append("response_type", "code")
        append("redirect_uri", "http://127.0.0.1:8080")
        append("access_type", "offline")
    }.formUrlEncode()

    fun getClient() = client
}