@file:Suppress(
        "INVISIBLE_MEMBER",
        "INVISIBLE_REFERENCE",
        "EXPOSED_PARAMETER_TYPE"
)

package Wrappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.ComposeWindow
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLStyleElement
import org.w3c.dom.HTMLTitleElement


var canvas = document.getElementById("ComposeTarget") as HTMLCanvasElement

fun canvasResize(width: Int = window.innerWidth, height: Int = window.innerHeight) {
    canvas.setAttribute("width", "$width")
    canvas.setAttribute("height", "$height")
}

fun composableResize() {
    val clone = canvas.cloneNode(false) as HTMLCanvasElement
    canvas.replaceWith(clone)
    canvas = clone
    ComposeWindow().apply {
        val scale = layer.layer.contentScale
        canvasResize()
        layer.layer.attachTo(clone)
        layer.layer.needRedraw()
        layer.setSize(
                (clone.width / scale).toInt(),
                (clone.height / scale).toInt())

    }


}