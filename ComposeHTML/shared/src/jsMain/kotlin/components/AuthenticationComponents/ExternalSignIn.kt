package components.AuthenticationComponents

import Wrappers.ExpectedImplementations.WindowInterface
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun ExternalSignIn(url: String, windowObject: WindowInterface){
    Button(onClick = { windowObject.open(url, "_blank") }) {
        Text(text = "Sign in with Google",
            style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Default
            )
        )
    }
}