package com.example.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {
    AppAndroid()
}

@Composable
fun AppAndroid() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9C0))
            .padding(10.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    Color(0xFFFDF9C0)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {

                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier.size(140.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Inicio de sesión",
                    fontSize = 32.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(25.dp))
                var textNombre by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = textNombre,
                    onValueChange = { newText -> textNombre = newText },
                    label = { Text("Ingresa tu nombre") },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Icono de usuario"
                        )
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))

                var textContra by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                Row() {
                    OutlinedTextField(
                        value = textContra,
                        onValueChange = {newText -> textContra = newText},
                        label = {Text("Contraseña")},
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = Color.Gray,
                            unfocusedBorderColor = Color.Gray
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
    }
}