package ui

import LoginModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import ktorClient.LoginService

@Composable
fun SignInComposable(component: LoginModel, loginService: LoginService ){

    val userDetails by remember { component.loginDetails }

}


