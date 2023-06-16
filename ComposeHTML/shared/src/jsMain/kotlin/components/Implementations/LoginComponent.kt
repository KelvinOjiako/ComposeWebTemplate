package components.Implementations

import LoginModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import core.model.LoginDetails

class LoginComponent(componentContext: ComponentContext): LoginModel, ComponentContext by componentContext {

    private val _userDetails = mutableStateOf(LoginDetails(userName = "", password = ""))

    private val _error = mutableStateOf<String?>(null)
    override val error: State<String?> = _error

    private val _loading = mutableStateOf(false)
    override val loading: State<Boolean> = _loading



    override val loginDetails: State<LoginDetails>
        get() = _userDetails

    override fun onUserNameChanged(userName: String) {
        _userDetails.value.userName = userName
        _error.value = null
    }

    override fun onPasswordChanged(password: String) {
        _userDetails.value.password = password
        _error.value = null
    }

    override fun onLoginClicked() {
        TODO("Not yet implemented")
    }
}