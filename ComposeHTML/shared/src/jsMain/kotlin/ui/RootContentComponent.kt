package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.AuthenticationComponents.CallBackHandler
import components.Implementations.LoginComponent
import components.NavigationComponent.NavigationBar
import components.root.RootModel
import ktorClient.LoginService

@Composable
fun RootContentComposable(componentContext: ComponentContext, rootModel: RootModel){

    val pageStack by rootModel.RootpagesStack.subscribeAsState()

    Column {
        NavigationBar(rootModel)

        Children(pageStack){
            when(val child = it.instance){
                is RootModel.Pages.HomePage -> HomeComposable()
                is RootModel.Pages.IndexPage -> IndexComposable()
                is RootModel.Pages.ProfilePage -> UserProfile()
                is RootModel.Pages.SignInPage -> SignInComposable(component = LoginComponent(componentContext), loginService = LoginService(), rootModel)
                is RootModel.Pages.SignUpPage -> SignUpComposable()
                is RootModel.Pages.CallBackPage -> CallBackHandler(rootModel)
            }
        }
    }
}