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
fun NavigationBar(component: RootComponent){
    Row {
        TextButton(onClick = { component.onHomeLinkPressed() }){Text("home") }
        TextButton(onClick = { component.onSignUpLinkPressed() }){Text("SignUp") }
        TextButton(onClick = { component.onProfileLinkPressed()  }){Text("profile") }
    }
}