package com.piyushprajpti.pychat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.piyushprajpti.pychat.presentation.auth.WalkthroughScreen
import com.piyushprajpti.pychat.ui.theme.PYChatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PYChatTheme {
                WalkthroughScreen()
            }
        }
    }
}