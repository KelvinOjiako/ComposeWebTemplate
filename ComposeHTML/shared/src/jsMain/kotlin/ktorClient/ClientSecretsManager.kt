package ktorClient

class ClientSecretsManager{

    private val clientID = "150430991817-cgmmc149b9gu3poc5bgo4q4jrpnigand.apps.googleusercontent.com"

    private val clientSecret = "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"

    fun getClientSecret() = clientSecret

    fun getClientID() = clientID
}