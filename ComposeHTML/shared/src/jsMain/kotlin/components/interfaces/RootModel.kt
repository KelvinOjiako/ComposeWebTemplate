package components.interfaces

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootModel {
    val RootpagesStack: Value<ChildStack<*, Pages>>

    sealed class Pages {
        data class IndexPage(val component: IndexModel) : Pages()
        data class SignUpPage(val component: SignUpModel) : Pages()
        data class SignInPage(val component: LoginModel) : Pages()
        data class HomePage(val component: HomeComponent) : Pages()

        data class ProfilePage(val component: ProfileModel) : Pages()

    }

    fun onHomeLinkPressed()
    fun onProfileLinkPressed()
    fun onSignUpLinkPressed()
    fun onSignInLinkPressed()
}