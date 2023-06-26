package com.radzhabov.sportsoccer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.radzhabov.sportsoccer.domain.Screens
import com.radzhabov.sportsoccer.presentation.main.MainScreen
import com.radzhabov.sportsoccer.presentation.splash.SplashScreenWithAnimation

@Composable
fun AppNavigation(
    navController: NavController,
    navigateToMain: () -> Unit
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.SplashScreen.route
    ){
        composable(route = Screens.SplashScreen.route){ SplashScreenWithAnimation(navigateToMain) }

        composable(route = Screens.MainScreen.route ){ MainScreen() }
    }
}