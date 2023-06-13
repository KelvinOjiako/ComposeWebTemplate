package components.componentImpl

//import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import components.componentConfigurations.IndexConfigurations
import components.interfaces.IndexComponent
import components.interfaces.RootComponent

class RootContent() : RootComponent {

    private val _pageStack = MutableValue(
        ChildStack(
            configuration = IndexConfigurations() ,
            instance = IndexComponentImpl(),
        )
    )
    override val RootpagesStack: Value<ChildStack<*, RootComponent.Pages>>
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