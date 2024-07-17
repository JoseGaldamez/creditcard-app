package dev.josegaldamez.creditcard.desingcard.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import dev.josegaldamez.creditcard.desingcard.livedata.CreditCardViewModel

@Composable
fun ColorsOptions( creditCardViewModel: CreditCardViewModel){

    var selectedColor by rememberSaveable { mutableStateOf("red") }

    creditCardViewModel.colorCard.observe( LocalLifecycleOwner.current ) { newValue ->
        selectedColor = newValue
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(36.dp)
    ){

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()

        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.Red)
                    .size(54.dp)
                    .clickable {
                        creditCardViewModel.setColorCard("red")
                    }
            ){
                if(selectedColor == "red"){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "selected",
                        tint = Color.White
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.Green)
                    .size(54.dp)
                    .clickable {
                        creditCardViewModel.setColorCard("green")
                    }
            ){
                if(selectedColor == "green"){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "selected",
                        tint = Color.White
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.Blue)
                    .size(54.dp)
                    .clickable {
                        creditCardViewModel.setColorCard("blue")
                    }
            ){
                if(selectedColor == "blue"){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "selected",
                        tint = Color.White
                    )
                }
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(Color.Cyan)
                    .size(54.dp)
                    .clickable {
                        creditCardViewModel.setColorCard("cyan")
                    }
            ){
                if(selectedColor == "cyan"){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "selected",
                        tint = Color.White
                    )
                }
            }

        }

    }

}