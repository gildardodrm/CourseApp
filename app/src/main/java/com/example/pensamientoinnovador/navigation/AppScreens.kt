package com.example.pensamientoinnovador.navigation

sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object CoursesScreen: AppScreens("courses_screen")
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
    object ThirdScreen: AppScreens("third_screen")
}