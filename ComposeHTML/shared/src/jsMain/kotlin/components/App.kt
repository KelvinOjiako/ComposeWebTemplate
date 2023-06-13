package components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import components.NavigationComponent.NavigationBar
import components.composables.UserProfile
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App(){
    val navigator = rememberNavigator()
    Box { NavigationBar(navigator) }

    Box{

    }

    Box{
        NavHost(navigator = navigator, initialRoute = "nav"){

            scene("home"){
                HomePageComponent()

            }
            scene("profile"){
                UserProfile()

            }
            scene("contact"){
                Text("This is the contact us page")
            }

            scene("nav"){
                Box { NavigationBar(navigator) }
            }



        }

    }



}