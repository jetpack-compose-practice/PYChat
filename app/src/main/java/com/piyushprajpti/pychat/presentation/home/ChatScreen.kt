package com.piyushprajpti.pychat.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.piyushprajpti.pychat.presentation.BackButton
import com.piyushprajpti.pychat.presentation.DefaultMargin
import com.piyushprajpti.pychat.ui.theme.ChatBackgroundDT
import com.piyushprajpti.pychat.ui.theme.ChatBackgroundLT
import com.piyushprajpti.pychat.ui.theme.ChatBarsDT
import com.piyushprajpti.pychat.ui.theme.ChatBarsLT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    name: String,
    onBackClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    val chatMessage = remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = name) },

                navigationIcon = { BackButton(onClick = { onBackClick() }) },

                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search"
                        )
                    }
                },

                scrollBehavior = scrollBehavior,

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (isSystemInDarkTheme()) ChatBarsDT else ChatBarsLT
                )
            )
        },

        bottomBar = {

            BottomAppBar(
                containerColor = if (isSystemInDarkTheme()) ChatBarsDT else ChatBarsLT,
                modifier = Modifier
                    .padding( top = 8.dp, bottom = 8.dp),
            ) {

                TextField(
                    value = chatMessage.value,
                    onValueChange = { chatMessage.value = it },
                    placeholder = { Text(text = "Your Message") },
                    modifier = Modifier
                        .weight(.85f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = if (isSystemInDarkTheme()) ChatBackgroundDT else ChatBackgroundLT,
                        unfocusedContainerColor = if (isSystemInDarkTheme()) ChatBackgroundDT else ChatBackgroundLT,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent

                    )
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = "Send",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.weight(.15f)
                    )
                }
            }
        },

        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isSystemInDarkTheme()) ChatBackgroundDT else ChatBackgroundLT)
                    .padding(it)
                    .padding(horizontal = DefaultMargin),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(vertical = 10.dp)
            ) {
                item {
                    SentMessageBox(message = "Hi there dsfads dsfasdfasdfsd", messageDate = "06:49 PM")
                }

                item {
                    ReceivedMessageBox(
                        message = "yes, nice to talk with you",
                        messageDate = "06:55 PM"
                    )
                }
                item {
                    SentMessageBox(message = "Hi there", messageDate = "06:49 PM")
                }

                item {
                    ReceivedMessageBox(
                        message = "yes, nice to talk with you",
                        messageDate = "06:55 PM"
                    )
                }
                item {
                    SentMessageBox(message = "Hi there", messageDate = "06:49 PM")
                }

                item {
                    ReceivedMessageBox(
                        message = "yes, sd",
                        messageDate = "06:55 PM"
                    )
                }
                item {
                    SentMessageBox(message = "Hi there sjkadfhjdskfjksadhjksdahfjksdhfsdjk sdjkfh sadkjlfh sdakjfhsdjk fsjkhf sjdfh sdkljfhsdk lafhsadkljf sdkjhf aksjdfhsjkda hfsakdjl", messageDate = "06:49 PM")
                }

                item {
                    ReceivedMessageBox(
                        message = "yes, nice to talk with you",
                        messageDate = "06:55 PM"
                    )
                }
            }
        }
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ChatScreenPrev() {
    ChatScreen(name = "Piyush") {

    }
}