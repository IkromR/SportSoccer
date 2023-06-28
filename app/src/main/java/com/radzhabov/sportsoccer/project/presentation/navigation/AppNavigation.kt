package com.radzhabov.sportsoccer.project.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.radzhabov.sportsoccer.main.domain.utils.Screens
import com.radzhabov.sportsoccer.main.presentation.MainScreen
import com.radzhabov.sportsoccer.project.presentation.SplashScreenWithAnimation
import com.radzhabov.sportsoccer.main.presentation.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    navController: NavController,
    navigateToMain: () -> Unit,
    mainViewModel: MainViewModel
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.SplashScreen.route
    ){
        composable(route = Screens.SplashScreen.route){ SplashScreenWithAnimation(navigateToMain) }

        composable(route = Screens.MainScreen.route ){ MainScreen(mainViewModel) }
    }
}