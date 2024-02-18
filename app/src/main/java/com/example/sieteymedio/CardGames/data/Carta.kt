package com.example.sieteymedio.CardGames.data

import androidx.annotation.DrawableRes
data class Carta(
    var palo: Palos,
    var nombre:Naipes,
    var puntos: Double,
    @DrawableRes var id:Int
)
