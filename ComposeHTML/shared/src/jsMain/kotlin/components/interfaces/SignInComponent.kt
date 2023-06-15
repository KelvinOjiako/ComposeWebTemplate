package components.interfaces

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

interface SignInComponent {
    // A value that holds the current state of the login screen
    val state: SignState



    // A sealed class that represents the possible states of the login screen
    sealed class SignState: Parcelable  {
        data class Input(val username: String, val password: String) : SignState()
        object Loading : SignState()
        data class Error(val message: String) : SignState()
    }

    // A function that handles the username input change
    fun onUsernameChanged(username: String)

    // A function that handles the password input change
    fun onPasswordChanged(password: String)

    // A function that handles the login button click
    fun onLoginClicked()

    // A function that handles the sign up link click
    fun onSignUpClicked()

    // A function that handles the forgot password link click
    fun onForgotPasswordClicked()
}