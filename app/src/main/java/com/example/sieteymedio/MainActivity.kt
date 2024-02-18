package com.example.sieteymedio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sieteymedio.CardGames.data.Routes
import com.example.sieteymedio.CardGames.ui.CartaMasAlta
import com.example.sieteymedio.CardGames.ui.CartaMasAltaViewModel
import com.example.sieteymedio.CardGames.ui.MenuPrincipal
import com.example.sieteymedio.CardGames.ui.SieteYMedio
import com.example.sieteymedio.CardGames.ui.SieteYMedioViewModel
import com.example.sieteymedio.ui.theme.SieteYMedioTheme


class MainActivity : ComponentActivity() {
    private val viewModel: CartaMasAltaViewModel by viewModels()
    private val viewModelSiete:SieteYMedioViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SieteYMedioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,startDestination = Routes.menuPrincipal.routes){
                        composable(Routes.menuPrincipal.routes){ MenuPrincipal(navController) }
                        composable(Routes.cartaMasAlta.routes){ CartaMasAlta(viewModel=viewModel,navController) }
                        composable(Routes.sieteYMedio.routes){ SieteYMedio(viewModel=viewModelSiete,navController) }
                    }
                }
            }
        }
    }
}
