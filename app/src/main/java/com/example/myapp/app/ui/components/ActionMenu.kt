package com.example.myapp.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.myapp.app.navigation.Screen

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ActionMenu(
    title: String,
    navController: NavController
) {
    // Estado para controlar la visibilidad del menú
    var expanded by remember { mutableStateOf(false) }

    // Barra de herramientas (TopAppBar)
    TopAppBar(
        title = { Text(title) },
        actions = {
            // Botón de menú
            IconButton (onClick = { expanded = true }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Menú"
                )
            }

            // Menú desplegable
            DropdownMenu (
                expanded = expanded,
                onDismissRequest = { expanded = false  }
            ) {
                DropdownMenuItem(
                    text = { Text("Screen 1") },
                    onClick = {
                        // Acción 1
                        expanded = false
                        navController.navigate(Screen.AppAndroid.route)
                    }
                )
                DropdownMenuItem(
                    text = { Text("Screen 2") },
                    onClick = {
                        // Acción 1
                        expanded = false
                        navController.navigate(Screen.Register.route)
                    }
                )

                HorizontalDivider()
                DropdownMenuItem(
                    text = {
                        Text("Back")
                    },
                    onClick = {
                        // Acción 2
                        expanded = false
                        navController.popBackStack()
                    }
                )
            }
        }
    )
}