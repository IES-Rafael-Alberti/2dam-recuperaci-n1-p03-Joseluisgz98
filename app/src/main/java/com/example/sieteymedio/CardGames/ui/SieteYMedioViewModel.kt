package com.example.sieteymedio.CardGames.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sieteymedio.CardGames.data.BarajaSieteYMedio
import com.example.sieteymedio.CardGames.data.Jugador
import com.example.sieteymedio.R

class SieteYMedioViewModel(application: Application) : AndroidViewModel(application) {
    // Use un contexto privado para operaciones esenciales
    private val context = application.applicationContext

    // Lista de jugadores
    private val jugadores = mutableListOf<Jugador>()

    private val _idCarta1Siete = MutableLiveData<Int>()
    val idCarta1Siete: LiveData<Int> = _idCarta1Siete

    private val _idCarta2Siete = MutableLiveData<Int>()
    val idCarta2Siete: LiveData<Int> = _idCarta2Siete


    init {
        reiniciar()
    }
    fun reiniciar(){
        jugadores.clear()
        jugadores.add(Jugador("Jugador1", mutableListOf(),0.0))
        jugadores.add(Jugador("Jugador2", mutableListOf(),0.0))
        _idCarta1Siete.value = R.drawable.bocaabajo
        _idCarta2Siete.value = R.drawable.bocaabajo
        BarajaSieteYMedio.NuevaBaraja(context)
        BarajaSieteYMedio.barajar()
    }
}