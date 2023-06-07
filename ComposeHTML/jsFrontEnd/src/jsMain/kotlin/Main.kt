import androidx.compose.material.MaterialTheme
import com.pablichj.incubator.uistate3.BrowserViewportWindow
import com.pablichj.templato.component.core.BrowserComponentRender
import components.UserProfile
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.skiko.wasm.onWasmReady

fun main(){
    onWasmReady {
        BrowserViewportWindow(){
           MaterialTheme {
               BrowserComponentRender(
                   rootComponent = AppBuilder.buildGraph(),

                   onBackPressEvent = { println("Back pressed event reached root node. Should ste back button invisible")}
               )

           }
        }
    }
}