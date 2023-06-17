import androidx.compose.runtime.State
import core.model.LoginDetails

interface LoginModel {
    //loginDetails variable holds userName and password of user
    val loginDetails: State<LoginDetails>
    //error variable is used to show when login failed
    val error: State<String?>
    //loading variable denotes that the authentication process is still ongoing
    val loading: State<Boolean>

    fun onUserNameChanged(userName: String)
    fun onPasswordChanged(password: String)
    fun onLoginClicked()

}