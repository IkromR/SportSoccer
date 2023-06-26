package com.radzhabov.sportsoccer.domain

sealed class Screens(val route: String) {
    object SplashScreen: Screens("splash")
    object MainScreen: Screens("main")
}