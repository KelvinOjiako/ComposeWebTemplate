package components.NavigationComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import components.componentImpl.HomeComponentImpl
import components.componentImpl.ProfileComponentImpl
import components.componentImpl.SignUpComponentImpl
import components.interfaces.RootComponent

@Composable
fun NavigationBar(componentStack: StackNavigation<RootComponent.Pages>){
    Row {
        componentStack.push(RootComponent.Pages.SignUpPage(SignUpComponentImpl()))

        TextButton(onClick = { componentStack.push(RootComponent.Pages.HomePage(HomeComponentImpl())) }){Text("home") }
        TextButton(onClick = { componentStack.push(RootComponent.Pages.SignUpPage(SignUpComponentImpl())) }){Text("SignUp") }
        TextButton(onClick = { componentStack.push(RootComponent.Pages.ProfilePage(ProfileComponentImpl()))  }){Text("profile") }
    }
}