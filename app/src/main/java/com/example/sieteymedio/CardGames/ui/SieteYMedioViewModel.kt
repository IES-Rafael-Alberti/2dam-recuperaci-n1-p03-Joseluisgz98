package com.example.sieteymedio.CardGames.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sieteymedio.CardGames.data.BarajaCartaAlta
import com.example.sieteymedio.CardGames.data.BarajaSieteYMedio
import com.example.sieteymedio.CardGames.data.Carta
import com.example.sieteymedio.CardGames.data.Jugador
import com.example.sieteymedio.R

class SieteYMedioViewModel(application: Application) : AndroidViewModel(application) {
    // Use un contexto privado para operaciones esenciales
    private val context = application.applicationContext


    private val _carta1Siete = MutableLiveData<Carta>()

    private val _carta2Siete = MutableLiveData<Carta>()

    private val _idCarta1Siete = MutableLiveData<Int>()
    val idCarta1Siete: LiveData<Int> = _idCarta1Siete

    private val _idCarta2Siete = MutableLiveData<Int>()
    val idCarta2Siete: LiveData<Int> = _idCarta2Siete

    private val _ganadorSiete = MutableLiveData<Int>()
    val ganadorSiete: LiveData<Int> = _ganadorSiete

    val _PlantarseJ1 = MutableLiveData<Boolean>(false)

    val _PlantarseJ2 = MutableLiveData<Boolean>(false)

    init {
        reiniciar()
    }

    /**
     * Funcion pora reiniciar la partida
     */
    fun reiniciar(){
        _idCarta1Siete.value = R.drawable.bocaabajo
        _idCarta2Siete.value = R.drawable.bocaabajo
        BarajaSieteYMedio.NuevaBaraja(context)
        BarajaSieteYMedio.barajar()
    }

    /**
     * Pedir carta para el jugador 1
     */
    fun pedirCartaJugador1() {
        _carta1Siete.value = BarajaSieteYMedio.darCarta()
        _idCarta1Siete.value = _carta1Siete.value?.id
    }

    /**
     * Pedir carta para el jugador 2
     */
    fun pedirCartaJugador2(){
        _carta2Siete.value = BarajaSieteYMedio.darCarta()
        _idCarta2Siete.value = _carta2Siete.value?.id
    }
    fun PlantarseJ1(){
        _PlantarseJ1.value = true
        comprobarGanador()
    }
    fun PlantarseJ2(){
        _PlantarseJ2.value = true
        comprobarGanador()
    }

    /**
     * Comprobar si hay ganador
     */
    private fun comprobarGanador() {
        val puntosJugador1 = _carta1Siete.value?.puntos
        val puntosJugador2 = _carta2Siete.value?.puntos
        val plantarseJ1 = _PlantarseJ1.value
        val plantarseJ2 = _PlantarseJ2.value
        _ganadorSiete.value = when {
            (puntosJugador1 != null && puntosJugador2 != null) && (plantarseJ1 == true && plantarseJ2 == true) -> {
                when {
                    puntosJugador1 > puntosJugador2 -> 1
                    puntosJugador1 < puntosJugador2 -> 2
                    else -> null // Representa un empate
                }
            }
            else -> null // Si alguno de los puntos o "plantarse" es nulo, hay un error
        }
    }
}