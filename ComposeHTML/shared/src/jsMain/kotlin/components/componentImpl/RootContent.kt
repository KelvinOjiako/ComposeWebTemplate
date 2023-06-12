package components.componentImpl

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.interfaces.RootComponent

class RootContent(override val pagesStack: Value<ChildStack<*, RootComponent.Pages>>) : RootComponent {
}