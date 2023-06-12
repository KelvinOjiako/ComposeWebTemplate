

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.pablichj.templato.component.core.Component
import com.pablichj.templato.component.core.NavItem
import com.pablichj.templato.component.core.navbar.NavBarComponent
import com.pablichj.templato.component.core.setNavItems
import components.interfaces.HomeComponent
import components.interfaces.ProfileComponent

object AppBuilder {

    private lateinit var navBarComponent: NavBarComponent

    fun buildGraph(): Component {

        if (AppBuilder::navBarComponent.isInitialized) {
            return navBarComponent
        }

        val homeComponent = HomeComponent()
        val favoriteComponent = object : Component() {
            @Composable
            override fun Content(modifier: Modifier) {
                Text("Missing Implementation")
            }
        }
        val userProfileComponentContainerz = ProfileComponent()

        val navbarItems = mutableListOf(
            NavItem(
                label = "Home",
                icon = Icons.Default.Home,
                component = homeComponent,
            ),
            NavItem(
                label = "Favorites",
                icon = Icons.Default.Favorite,
                component = favoriteComponent,//TopBarComponent(screenIcon = Icons.Default.Favorite),
            ),
            NavItem(
                label = "Account",
                icon = Icons.Default.AccountCircle,
                component = userProfileComponentContainerz
            )
        )

        return NavBarComponent().also {
            navBarComponent = it
            it.setNavItems(navbarItems, 0)
        }

    }

}
