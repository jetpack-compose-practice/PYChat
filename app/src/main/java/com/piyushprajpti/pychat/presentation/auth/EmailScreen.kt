package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.PrimaryMargin

@Composable
fun EmailScreen() {
    Column {
        BackButton(onClick = {})

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PrimaryMargin)
        ) {
            HeadlineText(text = "Enter your Email Address")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(text = "You will receive an OTP on the registered email address")

            Spacer(modifier = Modifier.height(30.dp))

            InputField(
                label = "Email Address",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Email,
                icon = Icons.Default.Email,
            )
            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Send Email", onClick = {})

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Remember your password?")

            ClickableText(
                text = "Login",
                color = MaterialTheme.colorScheme.primary,
                onClick = {}
            )
        }
    }
}