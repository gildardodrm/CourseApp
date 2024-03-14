package com.example.pensamientoinnovador.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pensamientoinnovador.screens.*

@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.CoursesScreen.route) {
            CoursesScreen(navController = navController)
        }
        composable(route = AppScreens.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(route = AppScreens.SecondScreen.route) {
            SecondScreen(navController = navController)
        }
        composable(route = AppScreens.ThirdScreen.route) {
            ThirdScreen(navController = navController)
        }
    }
}