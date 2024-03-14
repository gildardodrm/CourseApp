package com.example.pensamientoinnovador.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pensamientoinnovador.navigation.AppScreens
import com.example.pensamientoinnovador.ui.theme.BackgroundBlue
import com.example.pensamientoinnovador.ui.theme.PensamientoInnovadorTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreen(navController: NavController) {
    PensamientoInnovadorTheme {
        Scaffold(
            topBar = { FirstDetailsScreenTopBar(navController) },
            content = { FirstDetailsScreenContent(navController) },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstDetailsScreenTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Detalles")
        },
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate(AppScreens.CoursesScreen.route) },
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstDetailsScreenContent(navController: NavController) {
    val context = LocalContext.current

    var dialog = remember { mutableStateOf(false) }
    var nombre by remember { mutableStateOf(TextFieldValue("")) }
    var apellido by remember { mutableStateOf(TextFieldValue("")) }
    var correo by remember { mutableStateOf(TextFieldValue("")) }
    var celular by remember { mutableStateOf(TextFieldValue("")) }

    if (dialog.value) {
        AlertDialog(
            onDismissRequest = { dialog.value = false },
            title = { Text(text = "Rellena tus datos") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text(text = "Nombre") },
                    )
                    TextField(
                        value = apellido,
                        onValueChange = { apellido = it },
                        label = { Text(text = "Apellido") },
                    )
                    TextField(
                        value = correo,
                        onValueChange = { correo = it },
                        label = { Text(text = "Correo Electrónico") },
                    )
                    TextField(
                        value = celular,
                        onValueChange = { celular = it },
                        label = { Text(text = "Número de Celular") },
                    )
                }
            },
            confirmButton = {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Button(onClick = {
                        Toast.makeText(
                            context,
                            "¡Ya estás inscrit@!",
                            Toast.LENGTH_LONG
                        ).show()
                        navController.navigate(AppScreens.CoursesScreen.route) }) {
                        Text(text = "Guardar")
                    }
                }
            }
        )
    } else {  }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 65.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(BackgroundBlue)
                .width(500.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Curso 1",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Descripción detallada del curso 1",
            fontSize = 20.sp
        )
        Text(
            text = "Plataforma: Ejemplo 1",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = { dialog.value = true }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Inscribirse ",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}