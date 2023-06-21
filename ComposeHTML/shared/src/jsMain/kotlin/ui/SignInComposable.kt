package ui

import LoginModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ktorClient.LoginService

@Composable
fun SignInComposable(component: LoginModel, loginService: LoginService ){

    //val userDetails by component.loginDetails.subscribeAsState()
    val userDetails = remember { mutableStateOf(component.loginDetails.value) }
    val loading by component.loading.subscribeAsState()
    val errorDetail by component.error.subscribeAsState()

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))

        Spacer(modifier = Modifier.height(20.dp))



        TextField(
            label = { Text( text = if (userDetails.value.userName.isEmpty())"Username" else "") },
            //value = userDetails.userName,
            value = userDetails.value.userName,
            //onValueChange = { component.onUserNameChanged(userDetails.copy(userName = it).userName)}
            onValueChange = { userDetails.value = userDetails.value.copy(userName = it)}
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            placeholder = { Text(text = "Password") },
            //value = userDetails.password,
            value = userDetails.value.password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { userDetails.value = userDetails.value.copy(password = it)}
        )


        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login")
            }
        }

        val authorizationLink = loginService.getAuthorizationLink()

        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(

            text = AnnotatedString("Login with Google"),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default
            )
        )

    }

}


