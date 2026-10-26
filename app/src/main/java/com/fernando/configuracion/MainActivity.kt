package com.fernando.configuracion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fernando.configuracion.ui.theme.ConfiguracionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConfiguracionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    var tipoUsuario by rememberSaveable { mutableIntStateOf(0) }
                    NavHost(
                        navController = navController,
                        startDestination = "configuracion",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("configuracion") {
                            ConfiguracionScreen(
                                onBackClick = { finish() },
                                onTipoUsuarioClick = {
                                    navController.navigate("tipo_usuario")
                                }
                            )
                        }
                        composable("tipo_usuario") {
                            TipoUsuarioScreen(
                                seleccion = tipoUsuario,
                                onSeleccionChange = { tipoUsuario = it },
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}