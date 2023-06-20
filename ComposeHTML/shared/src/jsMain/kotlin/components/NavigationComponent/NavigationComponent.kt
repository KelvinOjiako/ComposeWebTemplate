package components.NavigationComponent

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.root.RootModel

interface NavigationComponent {
    val pagesStack: Value<ChildStack<*, RootModel.Pages>>

    fun onHomeLinkPressed()
    fun onProfileLinkPressed()
    fun onSignUpLinkPressed()
    fun onSignInLinkPressed()
}