package com.piyushprajpti.pychat

sealed class Screen(val route: String) {
    data object WalkthroughScreen : Screen("walkthrough")
    data object RegistrationScreen: Screen("registration")
    data object LoginScreen: Screen("login")
    data object EmailScreen: Screen("email")
    data object OtpScreen: Screen("otp")
    data object HomeScreen: Screen("home")
    data object ChatScreen: Screen("chat")
}
