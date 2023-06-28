package com.radzhabov.sportsoccer.project.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.onesignal.OneSignal
import com.radzhabov.sportsoccer.main.domain.utils.Screens
import com.radzhabov.sportsoccer.project.presentation.navigation.AppNavigation
import com.radzhabov.sportsoccer.project.presentation.theme.SportSoccerTheme
import com.radzhabov.sportsoccer.main.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

const val ONESIGNAL_APP_ID = "ed8a725f-48ff-4e6f-8fd9-860caa41b0e1"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        OneSignal.promptForPushNotifications();

        setContent {
            SportSoccerTheme {
                val navController = rememberNavController()
                val navigateToMain:() -> Unit = { navController.navigate(Screens.MainScreen.route) }
                AppNavigation(navController, navigateToMain, mainViewModel)
            }
        }
    }
}
