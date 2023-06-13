package components.interfaces

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {
    val RootpagesStack: Value<ChildStack<*, Pages>>

    sealed class Pages {
        data class IndexPage(val component: IndexComponent) : Pages()
        data class SignUpPage(val component: SignUpComponent) : Pages()
        data class SignInPage(val component: SignInComponent) : Pages()
        data class HomePage(val component: HomeComponent) : Pages()

        data class ProfilePage(val component: ProfileComponent) : Pages()

    }

    fun onHomeLinkPressed()
    fun onProfileLinkPressed()
    fun onSignUpLinkPressed()
    fun onSignInLinkPressed()
}