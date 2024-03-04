package com.piyushprajpti.pychat

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.piyushprajpti.pychat.presentation.auth.EmailScreen
import com.piyushprajpti.pychat.presentation.auth.LoginScreen
import com.piyushprajpti.pychat.presentation.auth.OtpScreen
import com.piyushprajpti.pychat.presentation.auth.RegistrationScreen
import com.piyushprajpti.pychat.presentation.auth.WalkthroughScreen

@Composable
fun PYChatApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "auth_graph",
        enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
    ) {

        // 1. auth graph
        navigation(route = "auth_graph", startDestination = Screen.WalkthroughScreen.route) {

            composable(route = Screen.WalkthroughScreen.route) {
                WalkthroughScreen(
                    onStartClick = { navController.navigate(Screen.RegistrationScreen.route) }
                )
            }

            composable(route = Screen.RegistrationScreen.route) {
                RegistrationScreen(
                    onBackClick = { navController.popBackStack() },
                    onRegisterClick = { navController.navigate(Screen.OtpScreen.route) },
                    onLoginClick = { navController.navigate(Screen.LoginScreen.route) }
                )
            }

            composable(route = Screen.LoginScreen.route) {
                LoginScreen(
                    onBackClick = { navController.popBackStack() },
                    onLoginClick = { },
                    onResetPasswordClick = { navController.navigate(Screen.EmailScreen.route) },
                    onRegisterClick = { navController.navigate(Screen.RegistrationScreen.route) }
                )
            }

            composable(route = Screen.EmailScreen.route) {
                EmailScreen(
                    onBackClick = { navController.popBackStack() },
                    onSendEmailClick = { navController.navigate(Screen.OtpScreen.route) },
                    onLoginClick = { navController.navigate(Screen.LoginScreen.route) }
                )
            }

            composable(route = Screen.OtpScreen.route) {
                OtpScreen(
                    onBackClick = { navController.popBackStack() },
                    onVerifyClick = {},
                    onLoginClick = { navController.navigate(Screen.LoginScreen.route) }
                )
            }
        }
    }
}