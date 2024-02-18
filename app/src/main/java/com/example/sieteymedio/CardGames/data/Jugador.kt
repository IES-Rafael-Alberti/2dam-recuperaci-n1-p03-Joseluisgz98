package com.example.sieteymedio.CardGames.data

data class Jugador(val nombre: String,
                   var mano: MutableList<Carta> = mutableListOf(),
                   var puntos: Double)
