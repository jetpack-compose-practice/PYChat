package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.ui.theme.TextDT
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
    TextButton(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
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
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        style = Typography.headlineSmall,
        textAlign = TextAlign.Center
    )

}

@Composable
fun DescriptionText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        style = Typography.bodyMedium,
        textAlign = TextAlign.Center
    )
}

@Composable
fun InputField() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape,
        leadingIcon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = "") },
        label = { Text(text = "Your Name") }
    )
}