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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.PrimaryMargin
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = hiltViewModel()
) {

    val name = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val username = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val email = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val password = remember {
        mutableStateOf(TextFieldValue(""))
    }

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
                value = name.value.text,
                onValueChange = { name.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Text,
                icon = Icons.Default.Person,
            )

            InputField(
                label = "Username",
                value = username.value.text,
                onValueChange = { username.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Text,
                icon = Icons.Default.Person,
            )

            InputField(
                label = "Email Address",
                value = email.value.text,
                onValueChange = { email.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Email,
                icon = Icons.Default.Email,
            )

            InputField(
                label = "Password",
                value = password.value.text,
                onValueChange = { password.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Password,
                icon = Icons.Default.Password,
            )

            Spacer(modifier = Modifier.height(40.dp))

            PrimaryActionButton(text = "Register", onClick = {})

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Already have an Account?")

            ClickableText(
                text = "Login",
                color = MaterialTheme.colorScheme.primary,
                onClick = { viewModel.register() })
        }
    }

}