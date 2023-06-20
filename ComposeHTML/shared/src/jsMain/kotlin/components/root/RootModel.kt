package components.root

import LoginModel
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.interfaces.HomeModel
import components.interfaces.IndexModel
import components.interfaces.ProfileModel
import components.interfaces.SignUpModel

interface RootModel {
    val RootpagesStack: Value<ChildStack<*, Pages>>

    sealed class Pages {
        data class IndexPage(val component: IndexModel) : Pages()
        data class SignUpPage(val component: SignUpModel) : Pages()
        data class SignInPage(val component: LoginModel) : Pages()
        data class HomePage(val component: HomeModel) : Pages()

        data class ProfilePage(val component: ProfileModel) : Pages()

    }

    fun onHomeLinkPressed()
    fun onProfileLinkPressed()
    fun onSignUpLinkPressed()
    fun onSignInLinkPressed()
}