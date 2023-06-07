import com.pablichj.incubator.uistate3.BrowserViewportWindow
import org.jetbrains.skiko.wasm.onWasmReady

fun main(){
    onWasmReady {
        BrowserViewportWindow(){

        }
    }
}