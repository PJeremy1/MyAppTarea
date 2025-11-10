package com.example.myapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun RegisterPreview() {
    Register()
}

@Composable
fun Register() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFFDF9C0)
            )
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Registrarse",
                    fontSize = 50.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(25.dp))

                var textNombre by remember { mutableStateOf("") }
                Row() {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        value = textNombre,
                        onValueChange = { newText -> textNombre = newText },
                        label = { Text("Ingresa tu nombre") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Icono de usuario"
                            )
                        }
                    )
                }

                var textCorreo by remember { mutableStateOf("") }
                Row() {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        value = textCorreo,
                        onValueChange = { newText -> textCorreo = newText },
                        label = { Text("Escriba una dirección de correo") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Mail,
                                contentDescription = "Icono de correo"
                            )
                        }
                    )
                }

                var textCorreoR by remember { mutableStateOf("") }
                Row() {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        value = textCorreoR,
                        onValueChange = { newText -> textCorreoR = newText },
                        label = { Text("Repita el correo") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.MailOutline,
                                contentDescription = "Icono de repetir correo"
                            )
                        }
                    )
                }

                var textContra by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }
                Row() {
                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .padding(20.dp),
                        value = textContra,
                        onValueChange = { newText -> textContra = newText },
                        label = { Text("Escriba una contraseña") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Icono de contraseña"
                            )
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image =
                                if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(imageVector = image, contentDescription = null)
                            }
                        }
                    )
                }

                var textContraR by remember { mutableStateOf("") }
                var passwordVisibleR by remember { mutableStateOf(false) }
                Row() {
                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .padding(20.dp),
                        value = textContraR,
                        onValueChange = { newText -> textContraR = newText },
                        label = { Text("Repita la contraseña") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.LockReset,
                                contentDescription = "Icono de repetir contraseña"
                            )
                        },
                        visualTransformation = if (passwordVisibleR) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            val image =
                                if (passwordVisibleR) Icons.Default.Visibility else Icons.Default.VisibilityOff
                            IconButton(onClick = { passwordVisibleR = !passwordVisibleR }) {
                                Icon(imageVector = image, contentDescription = null)
                            }
                        }
                    )
                }


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

                    Spacer(modifier = Modifier.width(25.dp))

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
                        Text("Volver")
                    }
                }
                
                Spacer(modifier = Modifier.height(10.dp))

                Row() {
                    Button(
                        onClick = {textNombre = ""; textCorreo = ""; textCorreoR = "";
                                  textContra = ""; textContraR = ""},
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