package components.componentConfigurations

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.backhandler.BackHandler
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.statekeeper.StateKeeper

 data class IndexConfigurations (
     val title: String = "Home",
     val message: String = "Welcome to the app",

): ComponentContext