package components.NavigationComponent

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.interfaces.RootComponent

interface NavigationComponent {
    val pagesStack: Value<ChildStack<*, RootComponent.Pages>>

    fun onHomeLinkPressed()
    fun onProfileLinkPressed()
    fun onSignUpLinkPressed()
    fun onSignInLinkPressed()
}