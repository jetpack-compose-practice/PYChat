package com.piyushprajpti.pychat.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.piyushprajpti.pychat.presentation.PrimaryMargin
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
            .padding(PrimaryMargin)
            .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape)
    ) {
        Text(
            text = text,
            color = TextDT,
            style = Typography.titleSmall
        )
    }
}

@Composable
fun ClickableText(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.secondary,
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun NonClickableBoldText(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.secondary,
        style = Typography.headlineSmall,
        textAlign = TextAlign.Center
    )

}