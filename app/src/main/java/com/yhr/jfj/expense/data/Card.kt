package com.yhr.jfj.expense.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardName: String,
    val cardNumber: String,
    val cardBalance: Double,
    val cardColor: Brush
)
