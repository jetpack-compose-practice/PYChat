package com.piyushprajpti.pychat.presentation.auth

import android.content.Intent
import android.net.Uri
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.R

@Composable
fun WalkthroughScreen(
//    viewModel: LoginViewModel = hiltViewModel(),
    onStartClick: () -> Unit
) {
    val context = LocalContext.current
    val intent = remember {
        Intent(Intent.ACTION_VIEW, Uri.parse("https://todo-4406.web.app/"))
    }

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
                onClick = { context.startActivity(intent) })

            Spacer(modifier = Modifier.height(20.dp))

            PrimaryActionButton(text = "Start Messaging", onClick = { onStartClick() })
        }
    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    device = Devices.PIXEL_4,
//    uiMode = Configuration.UI_MODE_NIGHT_YES
//)
//@Composable
//fun PreviewWrapper1() {
//    PYChatTheme {
//        Surface(color = MaterialTheme.colorScheme.background) {
//            WalkthroughScreen()
//        }
//    }
//}