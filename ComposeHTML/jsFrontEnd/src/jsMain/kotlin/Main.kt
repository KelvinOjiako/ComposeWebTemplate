@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE", "EXPOSED_PARAMETER_TYPE")

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.webhistory.DefaultWebHistoryController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import components.root.RootContent
import ui.RootContentComposable
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()
    val componentContext = DefaultComponentContext(lifecycle = lifecycle)

    val root = RootContent(componentContext = componentContext,
        deepLink = RootContent.DeepLink.Web(path = window.location.pathname),
        webHistoryController = DefaultWebHistoryController())

    lifecycle.resume()


    onWasmReady {
       BrowserViewportWindowCanvasResize(title = "Decompose "){
           RootContentComposable(componentContext, root)
       }
    }
}



