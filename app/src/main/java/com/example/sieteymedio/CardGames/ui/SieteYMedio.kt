package com.example.sieteymedio.CardGames.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sieteymedio.R
@Composable
fun SieteYMedio(viewModel: SieteYMedioViewModel, navController: NavHostController) {
    val idCarta1Siete: Int by viewModel.idCarta1Siete.observeAsState(initial = R.drawable.bocaabajo)
    val idCarta2Siete: Int by viewModel.idCarta2Siete.observeAsState(initial = R.drawable.bocaabajo)
    val ganadorSiete: Int? by viewModel.ganadorSiete.observeAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.size(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Jugador 1", color = Color.Black)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(10.dp)
            ) {
                Button(onClick = { viewModel.pedirCartaJugador1() },Modifier.padding(10.dp)) {
                    Text(text = "Dar Carta")
                }
                Button(onClick = { viewModel.PlantarseJ1() },Modifier.padding(10.dp)) {
                    Text(text = "Plantarse")
                }
            }
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(228.dp)
            ) {
                Image(
                    painter = painterResource(id = idCarta1Siete),
                    contentDescription = "CartaJugador1",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Jugador 2", color = Color.Black)

            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(228.dp)
            ) {
                Image(
                    painter = painterResource(id = idCarta2Siete),
                    contentDescription = "CartaJugador2",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { viewModel.pedirCartaJugador2() }, Modifier.padding(10.dp)) {
                Text(text = "Dar Carta")
            }
            Button(onClick = { viewModel.PlantarseJ2() }, Modifier.padding(10.dp)) {
                Text(text = "Plantarse")
            }
            Button(onClick = { viewModel.reiniciar() }, Modifier.padding(10.dp)) {
                Text(text = "Reiniciar")
            }
        }

        ganadorSiete?.let {
            Text(text = "Ganador: Jugador $it", color = Color.Red, fontSize = 20.sp)
        }
    }
}

