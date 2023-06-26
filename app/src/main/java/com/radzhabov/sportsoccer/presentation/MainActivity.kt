package com.radzhabov.sportsoccer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.radzhabov.sportsoccer.domain.Screens
import com.radzhabov.sportsoccer.presentation.navigation.AppNavigation
import com.radzhabov.sportsoccer.presentation.theme.SportSoccerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportSoccerTheme {
                val navController = rememberNavController()
                val navigateToMain:() -> Unit = { navController.navigate(Screens.MainScreen.route) }
                AppNavigation(navController, navigateToMain )
            }
        }
    }


}
