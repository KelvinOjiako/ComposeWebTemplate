import androidx.compose.runtime.State
import com.arkivanov.decompose.value.Value
import core.model.LoginDetails

interface LoginModel {
    //loginDetails variable holds userName and password of user
    val loginDetails: Value<LoginDetails>
    //error variable is used to show when login failed
    val error: Value<String>
    //loading variable denotes that the authentication process is still ongoing
    val loading: Value<Boolean>

    fun onUserNameChanged(userName: String)
    fun onPasswordChanged(password: String)
    fun onLoginClicked()

}