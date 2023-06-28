package com.radzhabov.sportsoccer.main.domain.utils

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash")
    object MainScreen: Screens("main")
}