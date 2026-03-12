package com.ed_dferreira.conversordemoedas.ui.feature.converter

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ed_dferreira.conversordemoedas.ui.feature.converter.model.ConverterFormEvent
import com.ed_dferreira.conversordemoedas.ui.feature.converter.model.ConverterFormState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ConverterViewModel : ViewModel() {
    private val _formState = MutableStateFlow(ConverterFormState())
    val formState = _formState.asStateFlow()

    init { //valores q iram aparecer nos campos
        _formState.update {
            it.copy(
                fromCurrenciesList = listOf("BRL", "USD", "EUR"),
                toCurrenciesList = listOf("USD", "BRL", "EUR"),
                fromCurrencySelected = "BRL",
                toCurrencySelected = "USD",
            )
        }
    }

    fun onFormEvent(event: ConverterFormEvent) {
        when (event) {
            is ConverterFormEvent.OnFromCurrencySelected -> {
                _formState.update {
                    it.copy(fromCurrencySelected = event.curency)
                }
            }
            is ConverterFormEvent.OnToCurrencySelected -> {
                _formState.update {
                    it.copy(toCurrencySelected = event.curency)
                }
            }
            is ConverterFormEvent.OnFromCurrencyAmountChanged -> {
                _formState.update {
                    it.copy(fromCurrencyAmount = event.curency)
                }
            }
            ConverterFormEvent.SendConverterForm -> {
                // Se quer apenas logar, faça fora do .update ou retorne o estado atual
                Log.d("ConverterViewModel", "onFormEvent: ${_formState.value}")
            }
        }
    }
}