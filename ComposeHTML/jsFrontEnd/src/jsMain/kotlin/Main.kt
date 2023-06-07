import com.pablichj.incubator.uistate3.BrowserViewportWindow
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.skiko.wasm.onWasmReady

fun main(){
    onWasmReady {
        BrowserViewportWindow(){

            Text("The js COmpose Magic is ON!!!")

        }
    }
}