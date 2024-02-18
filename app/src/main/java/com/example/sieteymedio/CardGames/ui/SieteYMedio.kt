package com.example.sieteymedio.CardGames.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.example.sieteymedio.R
@Composable
fun SieteYMedio(viewModel: SieteYMedioViewModel,navController: NavHostController){
    val idCarta1Siete: Int by viewModel.idCarta1Siete.observeAsState(initial = R.drawable.bocaabajo)
    val idCarta2Siete: Int by viewModel.idCarta2Siete.observeAsState(initial = R.drawable.bocaabajo)

}