package components.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.NavigationComponent.NavigationBar
import components.interfaces.RootComponent

@Composable
fun RootContentComposable(rootComponent: RootComponent){

    val pageStack by rootComponent.RootpagesStack.subscribeAsState()

    Column {
        NavigationBar(rootComponent)

        Children(pageStack){
            when(val child = it.instance){
                is RootComponent.Pages.HomePage -> HomeComposable()
                is RootComponent.Pages.IndexPage -> IndexComposable()
                is RootComponent.Pages.ProfilePage -> UserProfile()
                is RootComponent.Pages.SignInPage -> SignInComposable()
                is RootComponent.Pages.SignUpPage -> SignUpComposable()
            }
        }
    }
}