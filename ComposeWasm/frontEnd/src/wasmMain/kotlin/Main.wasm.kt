import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import coreComponents.NavigationBarComponent

import kotlin.wasm.unsafe.*

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("ImageViewer", canvasElementId = "sample") {
        NavigationBarComponent()
    }
}