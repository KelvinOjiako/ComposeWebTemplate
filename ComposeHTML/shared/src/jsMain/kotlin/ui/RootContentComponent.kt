package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import components.NavigationComponent.NavigationBar
import components.root.RootModel

@Composable
fun RootContentComposable(rootModel: RootModel){

    val pageStack by rootModel.RootpagesStack.subscribeAsState()

    Column {
        NavigationBar(rootModel)

        Children(pageStack){
            when(val child = it.instance){
                is RootModel.Pages.HomePage -> HomeComposable()
                is RootModel.Pages.IndexPage -> IndexComposable()
                is RootModel.Pages.ProfilePage -> UserProfile()
                is RootModel.Pages.SignInPage -> SignInComposable()
                is RootModel.Pages.SignUpPage -> SignUpComposable()
            }
        }
    }
}