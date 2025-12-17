package com.example.myapp.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.app.ui.screens.AppAndroid
import com.example.myapp.app.ui.screens.Register

@Composable
fun NavGraph(startDestination: String = Screen.AppAndroid.route) {
    // Cargamos el navController
    val navController = rememberNavController(

    )

    // Creamos un NavHost que arranque con la pantalla de inicio
    NavHost(navController = navController, startDestination = startDestination) {
        // Definimos que para la ruta Screen.Home.route se cargue el composable HomeScreen(navController)
        composable (Screen.AppAndroid.route) {
            AppAndroid(navController)
        }
        // Definimos que para la ruta Screen.Login.route se cargue el composable LoginScreen(navController)
        composable (Screen.Register.route) {
            Register(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview() {
    NavGraph()
}