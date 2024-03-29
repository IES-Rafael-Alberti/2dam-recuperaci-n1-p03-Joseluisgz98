package com.example.sieteymedio.CardGames.data


import android.content.Context
import com.example.sieteymedio.R


class BarajaCartaAlta {
    companion object{

        //variable mazo que esta compuesto por una array de cartas
        private val mazo: ArrayList<Carta> = ArrayList()

        /**
         *@param context proporciona información sobre el entorno de la aplicación y permite acceder a recursos como strings, drawables
         * funcion en la que creas una baraja
         */
        fun NuevaBaraja(context: Context){
            mazo.clear()
            var puntos:Int
            for (palo in 0..3){
                for (cont in 1..10){
                    when(cont){
                        8->{
                            puntos=10
                        }
                        9->{
                            puntos=11
                        }
                        10->{
                            puntos=12
                        }
                        else->{
                            puntos = cont
                        }
                    }
                    mazo.add(
                        Carta(
                            Palos.values()[palo],
                            Naipes.values()[cont],
                            puntos.toDouble(),
                            getIdDrawable(
                                context,
                                "${Palos.values()[palo].toString().lowercase()}${cont}")
                        )
                    )
                }
            }
        }
        private fun getIdDrawable(context: Context, nombreCarta: String) =
            context.resources.getIdentifier(
                nombreCarta,
                "drawable",
                context.packageName)
        /**
         * funcuion la cual te da una carta y si esta vacia te da una carta boca abajo
         */
        fun darCarta():Carta{
            if (mazo.isEmpty()){
                return (Carta(Palos.PORTADA,Naipes.PORTADA,0.0, R.drawable.bocaabajo))
            }else{
                return mazo.removeAt(mazo.size-1)
            }
        }
        /**
         * Funcion para barajar el mazo
         */
        fun barajar() {
            mazo.shuffle()
        }

    }
}