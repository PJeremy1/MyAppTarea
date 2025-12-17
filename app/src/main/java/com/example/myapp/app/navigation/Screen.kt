package com.example.myapp.app.navigation

sealed class Screen (val route: String) {
    data object AppAndroid: Screen("screen1")
    data object Register: Screen("screen2")
}