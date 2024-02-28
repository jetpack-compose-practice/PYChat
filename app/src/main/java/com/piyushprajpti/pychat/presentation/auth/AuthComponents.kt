package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.ui.theme.TextDT
import com.piyushprajpti.pychat.ui.theme.TextFieldBackgroundDT
import com.piyushprajpti.pychat.ui.theme.TextFieldBackgroundLT
import com.piyushprajpti.pychat.ui.theme.TextFieldLabelDT
import com.piyushprajpti.pychat.ui.theme.TextFieldLabelLT
import com.piyushprajpti.pychat.ui.theme.Typography

@Composable
fun PrimaryActionButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = text,
            color = TextDT,
            style = Typography.titleSmall,
            modifier = Modifier.padding(vertical = 5.dp)
        )
    }
}

@Composable
fun ClickableText(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier
                .clickable { onClick() },
            text = text,
            color = color,
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun HeadlineText(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        style = Typography.headlineSmall,
        textAlign = TextAlign.Center
    )

}

@Composable
fun DescriptionText(text: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        style = Typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: () -> Unit,
    keyboardType: KeyboardType,
    icon: ImageVector,
) {
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        label = { Text(text = label) },

        value = value,

        onValueChange = { onValueChange() },

        shape = RoundedCornerShape(10.dp),

        singleLine = true,

        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = if (isSystemInDarkTheme()) TextFieldBackgroundDT else TextFieldBackgroundLT,
            focusedContainerColor = if (isSystemInDarkTheme()) TextFieldBackgroundDT else TextFieldBackgroundLT,
            unfocusedLabelColor = if (isSystemInDarkTheme()) TextFieldLabelDT else TextFieldLabelLT,
//            unfocusedLeadingIconColor = if (isSystemInDarkTheme()) TextFieldLabelDT else TextFieldLabelLT,
            unfocusedTrailingIconColor = if (isSystemInDarkTheme()) TextFieldLabelDT else TextFieldLabelLT,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary
        ),

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),

        leadingIcon = { Icon(imageVector = icon, contentDescription = "") },

        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

        trailingIcon = {
            if (keyboardType == KeyboardType.Password) {
                val eyeIcon =
                    if (isPasswordVisible.value) Icons.Default.Visibility
                    else Icons.Default.VisibilityOff

                Icon(
                    imageVector = eyeIcon,
                    contentDescription = "Show Password",
                    modifier = Modifier.clickable {
                        isPasswordVisible.value = !isPasswordVisible.value
                    }
                )
            }
        },

        visualTransformation =
        if (isPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation()


    )
}