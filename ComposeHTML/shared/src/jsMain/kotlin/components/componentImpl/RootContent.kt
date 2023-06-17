package components.componentImpl

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.webhistory.WebHistoryController
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

import components.interfaces.RootComponent

@OptIn(ExperimentalDecomposeApi::class)
class RootComponentImpl(componentContext: ComponentContext,
                  deepLink: DeepLink = DeepLink.None,
                  webHistoryController: WebHistoryController? = null) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<PageConfig>()

    private val pageStack = childStack(
        source = navigation,
        initialStack = { getInitialStack(deepLink) },
        childFactory = ::child
    )

     override val RootpagesStack = pageStack

    init {
        webHistoryController?.attach(
            navigator = navigation,
            stack = pageStack,
            getPath = ::getPathForConfig,
            getConfiguration = ::getConfigForPath,
        )
    }

    private fun child(pageConfig: PageConfig, componentContext: ComponentContext): RootComponent.Pages =
        when(pageConfig){
           // PageConfig.About -> TODO()
            PageConfig.Home -> RootComponent.Pages.HomePage(HomeComponentImpl())
           // PageConfig.Index -> TODO()
            PageConfig.Profile -> RootComponent.Pages.ProfilePage(ProfileComponentImpl())
           // PageConfig.Settings -> TODO()
            PageConfig.SignIn -> RootComponent.Pages.SignInPage(SignInComponentImpl(componentContext))
            PageConfig.SignUp -> RootComponent.Pages.SignUpPage(SignUpComponentImpl())

            else -> RootComponent.Pages.IndexPage(IndexComponentImpl())
        }

    override fun onHomeLinkPressed() {
        navigation.bringToFront(PageConfig.Home)
    }

    override fun onProfileLinkPressed() {
        navigation.bringToFront(PageConfig.Profile)
    }

    override fun onSignUpLinkPressed() {
        navigation.bringToFront(PageConfig.SignUp)
    }

    override fun onSignInLinkPressed() {
        navigation.bringToFront(PageConfig.SignIn)
    }

    private companion object{
        private const val WEB_PATH_HOME = "home"
        private const val WEB_PATH_SETTINGS = "settings"
        private const val WEB_PATH_PROFILE = "profile"
        private const val WEB_PATH_SIGNIN = "signIn"
        private const val WEB_PATH_SIGNUP = "signUp"
        private const val WEB_PATH_INDEX = "index"
        private const val WEB_PATH_ABOUT = "about"

        private fun getInitialStack(deepLink: DeepLink): List<PageConfig> =
            when (deepLink) {
                is DeepLink.None -> listOf(PageConfig.Home)
                is DeepLink.Web -> listOf(getConfigForPath(deepLink.path))
            }

        private fun getPathForConfig(pageConfig: PageConfig): String =
            when (pageConfig) {
                PageConfig.About -> "/$WEB_PATH_ABOUT"
                PageConfig.Home -> "/$WEB_PATH_HOME"
                PageConfig.Index -> "/$WEB_PATH_INDEX"
                PageConfig.Profile -> "/$WEB_PATH_PROFILE"
                PageConfig.Settings -> "/$WEB_PATH_SETTINGS"
                PageConfig.SignIn -> "/$WEB_PATH_SIGNIN"
                PageConfig.SignUp -> "/$WEB_PATH_SIGNUP"
            }

        private fun getConfigForPath(path: String): PageConfig =
            when (path.removePrefix("/")) {
                WEB_PATH_HOME -> PageConfig.Home
                WEB_PATH_SETTINGS-> PageConfig.Settings
                WEB_PATH_PROFILE -> PageConfig.Profile
                WEB_PATH_SIGNIN -> PageConfig.SignIn
                WEB_PATH_SIGNUP -> PageConfig.SignUp

                else -> PageConfig.Index
            }
    }

    sealed interface PageConfig: Parcelable{
        @Parcelize
        object Home: PageConfig
        @Parcelize
        object Profile: PageConfig
        @Parcelize
        object SignIn: PageConfig
        @Parcelize
        object SignUp: PageConfig
        @Parcelize
        object Settings: PageConfig
        @Parcelize
        object Index: PageConfig
        @Parcelize
        object About: PageConfig
    }
    sealed interface DeepLink {
        object None : DeepLink
        class Web(val path: String) : DeepLink
    }
}