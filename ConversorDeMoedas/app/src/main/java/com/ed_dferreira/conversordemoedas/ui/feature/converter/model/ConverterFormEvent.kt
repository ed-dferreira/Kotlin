package com.ed_dferreira.conversordemoedas.ui.feature.converter.model

sealed interface ConverterFormEvent {
    data class OnFromCurrencySelected(val curency: String) : ConverterFormEvent
    data class OnToCurrencySelected(val curency: String) : ConverterFormEvent
    data class OnFromCurrencyAmountChanged(val curency: String) : ConverterFormEvent //valor antes de ser convertido
    data object SendConverterForm : ConverterFormEvent
}
// o : é usado como atalho de herança