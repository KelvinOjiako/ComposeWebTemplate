@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE", "EXPOSED_PARAMETER_TYPE")

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.webhistory.DefaultWebHistoryController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.resume
import com.arkivanov.essenty.lifecycle.stop
import components.componentImpl.RootComponentImpl
import components.composables.RootContentComposable
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady



@OptIn(ExperimentalDecomposeApi::class)
fun main() {

    val lifecycle = LifecycleRegistry()

    val root = RootComponentImpl(componentContext = DefaultComponentContext(lifecycle = lifecycle),
        deepLink = RootComponentImpl.DeepLink.Web(path = window.location.pathname),
        webHistoryController = DefaultWebHistoryController()
    )

    lifecycle.resume()


    onWasmReady {
       BrowserViewportWindowCanvasResize(title = "Decompose "){
           RootContentComposable(root)
       }
    }
}



