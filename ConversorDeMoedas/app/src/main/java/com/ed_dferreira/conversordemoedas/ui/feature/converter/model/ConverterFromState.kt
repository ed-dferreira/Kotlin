package com.ed_dferreira.conversordemoedas.ui.feature.converter.model

import android.icu.util.CurrencyAmount

// todos os estados que a tela tem
data class ConverterFormState(
    val fromCurrenciesList: List<String> = emptyList(),
    val toCurrenciesList: List<String> = emptyList(),
    val fromCurrencySelected: String = "",
    val toCurrencySelected: String = "",
    val fromCurrencyAmount: String = "",
    val toCurrencyAmount: String = ""
)
