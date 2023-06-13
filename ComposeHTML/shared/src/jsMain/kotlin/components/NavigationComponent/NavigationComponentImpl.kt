package components.NavigationComponent

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.interfaces.RootComponent

class NavigationComponentImpl: NavigationComponent {
    override val pagesStack: Value<ChildStack<*, RootComponent.Pages>>
        get() = TODO("Not yet implemented")

    override fun onHomeLinkPressed() {
        TODO("Not yet implemented")
    }

    override fun onProfileLinkPressed() {
        TODO("Not yet implemented")
    }

    override fun onSignUpLinkPressed() {
        TODO("Not yet implemented")
    }

    override fun onSignInLinkPressed() {
        TODO("Not yet implemented")
    }
}