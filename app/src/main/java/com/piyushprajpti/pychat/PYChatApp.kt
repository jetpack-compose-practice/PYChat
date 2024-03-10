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
import com.piyushprajpti.pychat.presentation.home.ChatScreen
import com.piyushprajpti.pychat.presentation.home.HomeScreen

@Composable
fun PYChatApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home_graph",
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
                    onLoginClick = { navController.navigate(Screen.HomeScreen.route) },
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
                    onVerifyClick = { navController.navigate(Screen.HomeScreen.route) },
                    onLoginClick = { navController.navigate(Screen.LoginScreen.route) }
                )
            }
        }

        // 2. home graph
        navigation(route = "home_graph", startDestination = Screen.HomeScreen.route) {
            composable(route = Screen.HomeScreen.route) {
                HomeScreen(onChatCardClick = { navController.navigate(Screen.ChatScreen.route) })
            }

            composable(route = Screen.ChatScreen.route) {
                ChatScreen(name = "Piyush Prajapati")
            }
        }
    }
}