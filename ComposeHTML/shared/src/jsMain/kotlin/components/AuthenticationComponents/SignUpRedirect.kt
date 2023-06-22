package components.AuthenticationComponents

import Wrappers.ExpectedImplementations.WindowInterface
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import components.root.RootModel

@Composable
fun SignUpRedirect(component: RootModel){
    Button(onClick = { component.onSignUpLinkPressed()}) {
        Text(text = "No account? Sign up",
            style = TextStyle(
                fontSize = 9.sp,
                fontFamily = FontFamily.Default
            )
        )
    }
}