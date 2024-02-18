package com.example.sieteymedio.CardGames.data

sealed class Routes(val routes:String){
    object menuPrincipal: Routes("Menu Principal")
    object cartaMasAlta: Routes("La carta mas alta")
    object sieteYMedio: Routes("El siete y medio")
}
