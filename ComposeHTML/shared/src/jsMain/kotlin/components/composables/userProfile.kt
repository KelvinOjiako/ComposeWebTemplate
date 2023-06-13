package components.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlayerProfile(){
    Column(modifier = Modifier.padding(5.dp)){
        Text("The Kotlin Monk", style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant, modifier = Modifier.padding(3.dp))

        Text("Guardian of Aikai and Wielder of the chess force",
            modifier = Modifier.padding(3.dp))

        Text("Sage Kotlin Art", style = MaterialTheme.typography.subtitle1,
            color = Color.Magenta, modifier = Modifier.padding(3.dp))
    }
}

@Composable
fun ImageProfileComponent(){
    Surface(modifier = Modifier.size(90.dp).padding(4.dp).border(
        BorderStroke(0.367.dp, color = Color.DarkGray),
        shape = CircleShape
    ),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)){

        Icon(Icons.Rounded.Person, "User Profile", modifier = Modifier.padding(3.dp).size(50.dp),
            tint = Color.Red)

    }

}


@Composable
fun UserProfile(){
    var buttonClickState = remember { mutableStateOf(false) }

    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()){

        Card(modifier = Modifier.width(150.dp).height(210.dp).padding(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = Color.LightGray,
            elevation = 2.dp){

            Column(modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){

                ImageProfileComponent()

                Divider()

                PlayerProfile()

                Button({buttonClickState.value = !buttonClickState.value}){
                    Text("Book an Appointment ;)", style = MaterialTheme.typography.button)

                }

                if (buttonClickState.value){

                    Box(Modifier.background(Color.LightGray)) { Content() }
                }
                else{
                    Box(Modifier.background(Color.LightGray)) {  }
                }

            }
        }
    }
}


@Composable
fun Content(){
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(4.dp).background(Color.Magenta)){

        Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(2.dp).background(Color.LightGray),
            shape = RoundedCornerShape(CornerSize(6.dp)), border = BorderStroke(2.dp, Color.Blue)
        ){
            Text("Before the Appoinment, you must hear the tales, the  Chronicles of a soloNinja")
        }

    }
}