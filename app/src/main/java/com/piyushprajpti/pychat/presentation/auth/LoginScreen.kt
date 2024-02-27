package com.piyushprajpti.pychat.presentation.auth

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.ui.theme.PYChatTheme

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadlineText(text = "Access Your Account")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(text = "Continue where you left off")
        }

        InputField()
        InputField()

        Spacer(modifier = Modifier.height(12.dp))

        PrimaryActionButton(text = "Login") {

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewWrapper2() {
    PYChatTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            LoginScreen()
        }
    }
}