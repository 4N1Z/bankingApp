package com.example.bankingapp.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardMember: String,
    val cardName: String,
    val balance: Number,
    val color : Brush
//    Brush is used to create the gradient color
)