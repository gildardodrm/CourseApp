package com.example.pensamientoinnovador.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pensamientoinnovador.R
import com.example.pensamientoinnovador.navigation.AppScreens
import com.example.pensamientoinnovador.ui.theme.*
import com.example.pensamientoinnovador.ui.theme.PensamientoInnovadorTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreen(
    navController: NavController
) {
    PensamientoInnovadorTheme {
        Scaffold(
            topBar = { CoursesScreenTopBar(navController) },
            content = { CoursesScreenContent(navController) },
            bottomBar = { CoursesScreenBottomBar(navController) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreenTopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Cursos")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreenBottomBar(navController: NavController) {
    NavigationBar(
        modifier = Modifier
            .height(85.dp)
            .padding(20.dp)
            .clip(AbsoluteRoundedCornerShape(100.dp, 100.dp, 100.dp, 100.dp)),
        containerColor = Navigation,
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.List,
                    contentDescription = null
                ) },
            selected = false,
            onClick = {  },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                ) },
            selected = false,
            onClick = {  },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoursesScreenContent(
    navController: NavController
) {
    Logo()

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
                .clickable { navController.navigate(AppScreens.FirstScreen.route) }
                .clip(RoundedCornerShape(14.dp))
                .background(BackgroundBlue)
                .width(500.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Curso 1",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Descripción Curso 1...",
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .clickable {
                    navController.navigate(AppScreens.SecondScreen.route)
                }
                .clip(RoundedCornerShape(14.dp))
                .background(BackgroundBlue)
                .width(500.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Curso 2",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Descripción Curso 2...",
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .clickable {
                    navController.navigate(AppScreens.ThirdScreen.route)
                }
                .clip(RoundedCornerShape(14.dp))
                .background(BackgroundBlue)
                .width(500.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Curso 3",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Descripción Curso 3...",
                )
            }
        }
    }
}

@Composable
fun Logo() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.loguito),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .alpha(0.5f)
        )
    }
}