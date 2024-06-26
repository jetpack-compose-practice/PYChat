package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.DefaultMargin
import com.piyushprajpti.pychat.util.Response

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
    onLoginSuccess: () -> Unit,
    onResetPasswordClick: () -> Unit,
    onRegisterClick: () -> Unit
) {

    val emailOrUsername = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val password = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val errorMessage = remember {
        mutableStateOf("")
    }

    fun onLoginClick() {
        viewModel.onLogin(
            emailOrUsername = emailOrUsername.value.text,
            password = password.value.text,
            callBack = {
                when (it) {
                    is Response.Success -> {
                        onLoginSuccess()
                    }

                    is Response.Error -> {
                        errorMessage.value = it.error
                    }
                }
            }
        )
    }

    Column {
        BackButton(onClick = { onBackClick() })

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(DefaultMargin)
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
                value = emailOrUsername.value.text,
                onValueChange = { emailOrUsername.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Email,
                icon = Icons.Outlined.Email,
            )

            InputField(
                label = "Password",
                value = password.value.text,
                onValueChange = { password.value = TextFieldValue(it) },
                keyboardType = KeyboardType.Password,
                icon = Icons.Outlined.Password,
            )

            ClickableText(
                text = "Reset Password",
                color = MaterialTheme.colorScheme.secondary,
                alignment = Alignment.CenterEnd,
                textDecoration = TextDecoration.Underline,
                onClick = { onResetPasswordClick() }
            )

            Spacer(modifier = Modifier.height(4.dp))

            ErrorField(errorMessage = errorMessage.value)

            Spacer(modifier = Modifier.height(35.dp))

            PrimaryActionButton(text = "Login", onClick = { onLoginClick() })

            Spacer(modifier = Modifier.height(40.dp))

            DescriptionText(text = "Don't have an Account?")

            ClickableText(
                text = "Register",
                color = MaterialTheme.colorScheme.primary,
                onClick = { onRegisterClick() }
            )
        }
    }
}