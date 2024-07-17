package dev.josegaldamez.creditcard.desingcard.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreditCardViewModel: ViewModel() {

    private var _cardNumber = MutableLiveData<String>()
    val cardNumber: LiveData<String> = _cardNumber

    private var _cardHolder = MutableLiveData<String>()
    val cardHolder: LiveData<String> = _cardHolder

    private var _cardExpiration = MutableLiveData<String>()
    val cardExpiration: LiveData<String> = _cardExpiration


    private var _colorCard = MutableLiveData<String>()
    val colorCard: LiveData<String> = _colorCard


    fun setColorCard(color: String){
        _colorCard.value = color
    }

    fun setCardNumber(number: String){
        if(number.length > 16){
            return
        }

        _cardNumber.value = number
    }

    fun setCardHolder(holder: String){
        _cardHolder.value = holder
    }

    fun setCardExpiration(expiration: String){
        if(expiration.length > 4){
            return
        }

        _cardExpiration.value = expiration
    }



}