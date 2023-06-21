package components.Implementations

import LoginModel

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.*

import core.model.LoginDetails

class LoginComponent(componentContext: ComponentContext): LoginModel, ComponentContext by componentContext {

    private val _userDetails = MutableValue(LoginDetails(userName = "", password = ""))

    private val _error = MutableValue("none")
    override val error: Value<String> = _error

    private val _loading = MutableValue(false)
    override val loading: Value<Boolean> = _loading



    override val loginDetails: MutableValue<LoginDetails> = _userDetails

    override fun onUserNameChanged(userName: String) {
        _userDetails.update { it.copy(userName = it.userName) }
        _error.update { "none" }
    }

    override fun onPasswordChanged(password: String) {
        _userDetails.update { it.copy(password = it.password) }
        _error.update { "none" }
    }

    override fun onLoginClicked() {
        TODO("Not yet implemented")
    }
}