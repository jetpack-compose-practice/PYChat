package com.piyushprajpti.pychat.presentation.auth

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.R
import com.piyushprajpti.pychat.ui.theme.PYChatTheme

@Composable
fun WalkthroughScreen(
//    viewModel: LoginViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.8f)
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(if (isSystemInDarkTheme()) R.drawable.illustration_dark else R.drawable.illustration_light),
                contentDescription = "Image",
                modifier = Modifier.size(200.dp),
            )
            Spacer(modifier = Modifier.height(8.dp))
            HeadlineText(text = "Connect easily with your friends and family")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.3f)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            ClickableText(
                text = "Terms & Privacy Policy",
                color = MaterialTheme.colorScheme.secondary,
                onClick = {})

            PrimaryActionButton(text = "Start Messaging", onClick = {})
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewWrapper1() {
    PYChatTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            WalkthroughScreen()
        }
    }
}