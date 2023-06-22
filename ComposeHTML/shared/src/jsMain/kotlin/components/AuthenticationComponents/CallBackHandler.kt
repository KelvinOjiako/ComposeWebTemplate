package components.AuthenticationComponents

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.root.RootModel

@Composable
fun CallBackHandler(val pageStack:ChildStack<*, RootModel.Pages>){
    Button(
        onClick = {pageStack.},
    ){
        Text("Navigate to the HomePage")
    }
}