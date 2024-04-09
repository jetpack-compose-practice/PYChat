package com.piyushprajpti.pychat

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.piyushprajpti.pychat.presentation.auth.OtpScreen
import com.piyushprajpti.pychat.presentation.auth.RegistrationScreen
import com.piyushprajpti.pychat.presentation.home.ChatScreen
import com.piyushprajpti.pychat.presentation.home.HomeScreen
import com.piyushprajpti.pychat.ui.theme.PYChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        super.onCreate(savedInstanceState)
        setContent {
            PYChatTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                   PYChatApp()
                }
            }
        }
    }
}