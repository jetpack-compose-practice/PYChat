package com.piyushprajpti.pychat.presentation.auth

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.PrimaryMargin
import com.piyushprajpti.pychat.ui.theme.PYChatTheme

@Composable
fun LoginScreen() {
    Column {
        BackButton(onClick = {})

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PrimaryMargin)
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

            InputField(
                label = "Email or Username",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Email,
                icon = Icons.Default.Email,
            )

            InputField(
                label = "Password",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Password,
                icon = Icons.Default.Password,
            )

            ClickableText(
                text = "Reset Password",
                color = MaterialTheme.colorScheme.secondary,
                alignment = Alignment.CenterEnd,
                textDecoration = TextDecoration.Underline,
                onClick = {})

            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Login", onClick = {})

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Don't have an Account?")

            ClickableText(
                text = "Register",
                color = MaterialTheme.colorScheme.primary,
                onClick = {}
            )
        }
    }
}

@Preview(
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