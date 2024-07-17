package dev.josegaldamez.creditcard.desingcard.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.josegaldamez.creditcard.R
import dev.josegaldamez.creditcard.desingcard.livedata.CreditCardViewModel

@Composable
fun CreditCard(creditCardViewModel: CreditCardViewModel) {

    var creditCardNumberValue by rememberSaveable { mutableStateOf("0000 0000 0000 0000") }

    creditCardViewModel.cardNumber.observe( LocalLifecycleOwner.current ){ newValue ->
        creditCardNumberValue = formatCreditCardNumber(newValue)
    }

    var creditCardHolderValue by rememberSaveable { mutableStateOf("NAME") }

    creditCardViewModel.cardHolder.observe( LocalLifecycleOwner.current ){ newValue ->
        creditCardHolderValue = capitalizeText(newValue)
    }

    var creditCardExpirationValue by rememberSaveable { mutableStateOf("00/00") }

    creditCardViewModel.cardExpiration.observe( LocalLifecycleOwner.current ){ newValue ->
        creditCardExpirationValue = formatExpirationDate(newValue)
    }


    var colorSelected by rememberSaveable { mutableStateOf("red") }

    creditCardViewModel.colorCard.observe( LocalLifecycleOwner.current ){ newValue ->
        colorSelected = newValue
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(24.dp)
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = getColorBySelected(colorSelected))
            .padding(16.dp)
        ) {

            Column {

                Text(text = "Nombre del Banco",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(top = 16.dp),
                    painter = painterResource(id = R.drawable.chip ),
                    contentDescription = "Chip")
                
                Spacer(modifier = Modifier.height(30.dp))

                Text(text = creditCardNumberValue,
                    fontSize = 27.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth( fraction = 0.8f )
                ) {

                    Text(text = creditCardHolderValue,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                Text(text = creditCardExpirationValue,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                }


            }

        }
    }

}


fun formatCreditCardNumber(value: String): String {
    var newFormattedValue: String = ""

    if (value.isEmpty()){
        newFormattedValue = "0000 0000 0000 0000"
        return newFormattedValue
    }

    for ( (index, character) in value.withIndex() ){

        newFormattedValue += character;

        if((index + 1) % 4 == 0){
            newFormattedValue += " "
        }

    }


    return newFormattedValue
}


fun capitalizeText(value: String): String {

    return value.uppercase()

}


fun formatExpirationDate(value: String): String {
    var newFormattedValue: String = ""

    if (value.isEmpty()){
        newFormattedValue = "00/00"
        return newFormattedValue
    }

    for ( (index, character) in value.withIndex() ){

        newFormattedValue += character;

        if((index + 1) == 2){
            newFormattedValue += "/"
        }

    }


    return newFormattedValue
}

fun getColorBySelected(color: String): Color {
    return when(color){
        "red" -> Color.Red
        "green" -> Color.Green
        "blue" -> Color.Blue
        "cyan" -> Color.Cyan
        else -> Color.Red
    }
}