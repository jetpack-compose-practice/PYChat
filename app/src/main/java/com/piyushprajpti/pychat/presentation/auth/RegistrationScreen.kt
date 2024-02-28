package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.PrimaryMargin

@Composable
fun RegistrationScreen() {
    Column {

        BackButton(onClick = {})

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(PrimaryMargin),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeadlineText(text = "Welcome Onboard")
                Spacer(modifier = Modifier.height(5.dp))
                DescriptionText(text = "Register for free now")
            }

            InputField(
                label = "Your Name",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Text,
                icon = Icons.Default.Person,
            )

            InputField(
                label = "Username",
                value = "",
                onValueChange = {},
                keyboardType = KeyboardType.Text,
                icon = Icons.Default.Person,
            )

            InputField(
                label = "Email Address",
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

            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Register", onClick = {})

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Already have an Account?")

            ClickableText(text = "Login", color = MaterialTheme.colorScheme.primary, onClick = {})
        }
    }

}