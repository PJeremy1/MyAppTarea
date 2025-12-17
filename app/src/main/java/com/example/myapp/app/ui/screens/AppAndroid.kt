package com.example.myapp.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonPin
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {
    AppAndroid(rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppAndroid(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White) //TODO quité el inner padding .padding(10.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Color(0xFFFFE2A8)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 250.dp, height = 100.dp)
                    .background(Color(0xFF4E9D72)),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logoestirado),
                    contentDescription = "Imagen de ejemplo",
                    modifier = Modifier.size(150.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 250.dp, height = 13.dp)
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(width = 250.dp, height = 30.dp)
                    .background(Color(0xFF4E9D72))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier.padding(30.dp, 0.dp)
            ) {
                Column (
                    modifier = Modifier
                        .background(Color(0xFFF4F4F4))
                        .shadow(elevation = 2.dp)
                        .padding(0.dp, 0.dp, 0.dp, 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.caplogo),
                            contentDescription = "Imagen de ejemplo",
                            modifier = Modifier.size(50.dp)
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.PersonPin,
                        contentDescription = "Icono Login",
                        modifier = Modifier.size(125.dp)
                    )
                    Text(
                        text = "¡BIENVENIDO!",
                        fontSize = 32.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    var textNombre by remember { mutableStateOf("") }
                    OutlinedTextField(
                        shape = RoundedCornerShape(15.dp),
                        value = textNombre,
                        onValueChange = { newText -> textNombre = newText },
                        placeholder = { Text("Nombre de usuario") },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFE6E6E6),
                            unfocusedContainerColor = Color(0xFFE6E6E6),
                            focusedBorderColor = Color(0xFFE6E6E6),
                            unfocusedBorderColor = Color(0xFFE6E6E6)
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Icono de usuario"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 250.dp, height = 10.dp)
                            .background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    var textContra by remember { mutableStateOf("") }
                    var passwordVisible by remember { mutableStateOf(false) }
                    Row() {
                        OutlinedTextField(
                            shape = RoundedCornerShape(15.dp),
                            value = textContra,
                            onValueChange = {newText -> textContra = newText},
                            placeholder = {Text("Contraseña")},
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFE6E6E6),
                                unfocusedContainerColor = Color(0xFFE6E6E6),
                                focusedBorderColor = Color(0xFFE6E6E6),
                                unfocusedBorderColor = Color(0xFFE6E6E6)
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = "Icono de contraseña"
                                )
                            },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(imageVector = image, contentDescription = null)
                                }
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Row() {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(10),
                            colors = ButtonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White,
                                disabledContentColor = Color.Gray,
                                disabledContainerColor = Color.Black
                            ),
                            modifier = Modifier.width(125.dp)
                        ) {
                            Text("Aceptar")
                        }

                        Spacer(modifier = Modifier.width(15.dp))

                        Button(
                            onClick = { /* Acción al hacer clic */ },
                            shape = RoundedCornerShape(10),
                            colors = ButtonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White,
                                disabledContentColor = Color.Gray,
                                disabledContainerColor = Color.Black
                            ),
                            modifier = Modifier.width(125.dp)
                        ) {
                            Text("Registrarse")
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row() {
                        Button(
                            onClick = { textContra = ""; textNombre = "" },
                            shape = RoundedCornerShape(10),
                            colors = ButtonColors(
                                containerColor = Color.DarkGray,
                                contentColor = Color.White,
                                disabledContentColor = Color.Gray,
                                disabledContainerColor = Color.Black
                            )
                        ) {
                            Text("Limpiar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
        }
    }
}