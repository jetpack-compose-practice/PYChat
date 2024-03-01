package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.PrimaryMargin

@Composable
fun OtpScreen() {
    Column {
        BackButton(onClick = {})

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PrimaryMargin)
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
                icon = Icons.Default.Password
            )

            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Verify", onClick = {})
        }
    }
}