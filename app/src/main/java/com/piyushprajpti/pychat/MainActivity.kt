package com.piyushprajpti.pychat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.piyushprajpti.pychat.presentation.auth.EmailScreen
import com.piyushprajpti.pychat.presentation.auth.LoginScreen
import com.piyushprajpti.pychat.presentation.auth.RegistrationScreen
import com.piyushprajpti.pychat.presentation.auth.WalkthroughScreen
import com.piyushprajpti.pychat.ui.theme.PYChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PYChatTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                EmailScreen()
                }
            }
        }
    }
}