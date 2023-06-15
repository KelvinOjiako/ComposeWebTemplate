package components.componentImpl

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.statekeeper.consume
import components.interfaces.SignInComponent

class SignInComponentImpl(componentContext: ComponentContext) : SignInComponent, ComponentContext by componentContext {

    // Use stateKeeper to save and restore the username and password values inside Input object which in turn is inside SignState object
    private var componentState_loginDetails: SignInComponent.SignState = stateKeeper.consume("sign_state") ?: SignInComponent.SignState.Input("", "")

    init {
        stateKeeper.register(key ="sign_state"){ componentState_loginDetails }
    }

    // Use mutableStateOf to update the loading status and error message
    private val _isLoading = mutableStateOf(false)
    private val _errorMessage = mutableStateOf<String?>(null)

    // An observable value that holds the current state
    private val _state = MutableValue(componentState_loginDetails)


    override val state = _state.value





    // A function that updates the state and notifies the UI
    private fun setState(newState: SignInComponent.SignState) {
        componentState_loginDetails = newState
    }

     val loadState: SignInComponent.SignState
        get() = when {
            _isLoading.value -> SignInComponent.SignState.Loading
            _errorMessage.value != null -> SignInComponent.SignState.Error(_errorMessage.value!!)
            else -> SignInComponent.SignState.Input("", "")
        }

    override fun onUsernameChanged(username: String) {

    }

    override fun onPasswordChanged(password: String) {

    }
    override fun onLoginClicked() {
        TODO("Not yet implemented")
    }

    override fun onSignUpClicked() {
        TODO("Not yet implemented")
    }

    override fun onForgotPasswordClicked() {
        TODO("Not yet implemented")
    }
}