package com.radzhabov.sportsoccer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.onesignal.OneSignal
import com.radzhabov.sportsoccer.domain.utils.Screens
import com.radzhabov.sportsoccer.presentation.navigation.AppNavigation
import com.radzhabov.sportsoccer.presentation.theme.SportSoccerTheme

const val ONESIGNAL_APP_ID = "ed8a725f-48ff-4e6f-8fd9-860caa41b0e1"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        // promptForPushNotifications will show the native Android notification permission prompt.
        // We recommend removing the following code and instead using an In-App Message to prompt for notification permission (See step 7)
        OneSignal.promptForPushNotifications();

        setContent {
            SportSoccerTheme {
                val navController = rememberNavController()
                val navigateToMain:() -> Unit = { navController.navigate(Screens.MainScreen.route) }
                AppNavigation(navController, navigateToMain )
            }
        }
    }
}
