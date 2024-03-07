package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.DefaultMargin

@Composable
fun OtpScreen(
    onBackClick: () -> Unit,
    onVerifyClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column {
        BackButton(onClick = {onBackClick()})

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(DefaultMargin)
        ) {
            HeadlineText(text = "Verify OTP")
            Spacer(modifier = Modifier.height(5.dp))
            DescriptionText(text = "Enter the OTP received on email address")

            Spacer(modifier = Modifier.height(30.dp))

            InputField(
                label = "OTP",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Number,
                icon = Icons.Outlined.Password
            )

            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Verify", onClick = {onVerifyClick()})

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Remember your password?")

            ClickableText(
                text = "Login",
                color = MaterialTheme.colorScheme.primary,
                onClick = {onLoginClick()}
            )
        }
    }
}