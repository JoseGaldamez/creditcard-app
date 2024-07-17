package dev.josegaldamez.creditcard.desingcard.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.josegaldamez.creditcard.desingcard.livedata.CreditCardViewModel

@Composable
fun DesignCardScreen(){

    val creditCardViewModel = CreditCardViewModel()

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

            CreditCard(creditCardViewModel)
            FormCard(creditCardViewModel)
            ColorsOptions(creditCardViewModel)

        }

    }



}