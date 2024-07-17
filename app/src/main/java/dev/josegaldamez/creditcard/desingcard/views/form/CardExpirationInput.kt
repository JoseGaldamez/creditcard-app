package dev.josegaldamez.creditcard.desingcard.views.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import dev.josegaldamez.creditcard.desingcard.livedata.CreditCardViewModel

@Composable
fun CardExpirationInput(creditCardViewModel: CreditCardViewModel){

    var valueInput by rememberSaveable { mutableStateOf("") }

    creditCardViewModel.cardExpiration.observe( LocalLifecycleOwner.current ){ newValue ->
        valueInput = newValue
    }

    OutlinedTextField(
        placeholder = {
            Text(text = "00/00")
        },
        modifier = Modifier.fillMaxWidth(fraction = 0.8f),
        value = valueInput, onValueChange = {
            creditCardViewModel.setCardExpiration(it)
        })
}