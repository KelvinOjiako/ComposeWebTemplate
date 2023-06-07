package components

import androidx.compose.runtime.Composable
import com.pablichj.templato.component.core.Component
import com.pablichj.templato.component.core.stack.StackBarItem
import com.pablichj.templato.component.core.stack.StackComponent

@Composable
fun HomePageComponent(){

}

class HomeComponent : StackComponent(DefaultConfig) {
    override fun getStackBarItemFromComponent(component: Component): StackBarItem? {
        TODO("Not yet implemented")
    }

}